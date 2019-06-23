package hreader;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
public class reader {
	public static Nodes Hierarchy = new Nodes() ;
	public static void tree_reader(Element n, Nodes x, int q) {
			NodeList a = n.getElementsByTagName("Level"+Integer.toString(q));
			//System.out.println(a.getLength());
			for(int i=0;i<a.getLength();i++) {
				Node b = a.item(i);
				Element b1 = (Element) b;
				x.add_child(b1.getElementsByTagName("Name").item(0).getTextContent());
				//System.out.println(b1.getElementsByTagName("Name").item(0).getTextContent());
				if(b.getNodeType() == Node.ELEMENT_NODE) {
					tree_reader((Element) b,x.children.get(x.children.size()-1),q+1);
				}
			}
			//System.out.println("hi"+a.getLength());
		
	}
	public static void tree_traverser(Nodes x) {
		System.out.println(x.name);
		for(int i=0;i<x.children.size();i++) {
			tree_traverser(x.children.get(i));
		}
	}
	public static void main(String[] args) {
		try {

			File fXmlFile = new File("C:\\Users\\nikun\\Desktop\\Project\\Schema.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			NodeList n = doc.getElementsByTagName("Hierarchy");
			if(n.item(0).getNodeType() == Node.ELEMENT_NODE) {
				Element hnode = (Element) n.item(0);
				NodeList root = hnode.getElementsByTagName("RootNode");
				
				if(n.item(0).getNodeType() == Node.ELEMENT_NODE) {
					Element rnode = (Element) root.item(0);
					Hierarchy.name = rnode.getElementsByTagName("Name").item(0).getTextContent();
					//System.out.println(rnode.getElementsByTagName("Name").item(0).getTextContent());
					tree_reader(rnode,Hierarchy,1);
				}
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		tree_traverser(Hierarchy);
		
	}
}
