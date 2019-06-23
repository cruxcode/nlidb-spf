package hreader;
import java.util.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
public class reader {
	public static Nodes Hierarchy = new Nodes() ;
	public static Nodes a = new Nodes();
	public static Nodes b = new Nodes();
	
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
	
	
	
	public static void search(String s, Nodes x) {
		
		if(x==null) {
			return;
		}else if(s.equals(x.name)) {
			b = x;
			//System.out.println(s.equals(x.name));
		}else {
			//System.out.println(s.equals(x.name));
			for(int i=0;i<x.children.size();i++) {
				search(s,x.children.get(i));
			}
		}
	}
	
	
	public static void traversing_up(Nodes x, ArrayList<String> s) {
		if(x == null) {
			return;
		}else {
			s.add(x.name);
			traversing_up(x.parent,s);
		}
	}
	
	public static ArrayList<String> p = new ArrayList<String>();
	public static ArrayList<String> q = new ArrayList<String>();
	
	public static String common_parent(String s1, String s2, Nodes x) {
		search(s1,x);
		a = b;
		search(s2,x);
		traversing_up(a,p);
		traversing_up(b,q);
		int len;
		if(p.size()<q.size()) {
			len = p.size();
		}else {
			len = q.size();
		}
		String s = x.name;
		for(int i=0;i<len;i++) {
			if((p.get(p.size()-1-i)).equals(q.get(q.size()-1-i))) {
				s = p.get(p.size()-1-i);
			}
		}
		return(s);
		
		
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
		//tree_traverser(Hierarchy);
		//search("wqq",Hierarchy);
		//System.out.println(b.name);
		
		System.out.println(common_parent("Rust","earth",Hierarchy));
		
	}
}
