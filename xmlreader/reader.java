package xml_reader;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class reader {
	public static Schema schema = new Schema();
	public static Column column1 = new Column();
	public static Table table1 = new Table();
	public static Verb verb1 = new Verb();
	public static Adjective adj1 = new Adjective();
	public static Preposition prep1 = new Preposition();
	public static void main(String[] args) {
		try {

			File fXmlFile = new File("C:\\Users\\nikun\\Desktop\\Project\\Schema.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			NodeList n = doc.getElementsByTagName("Attribute_File");
			if (n.item(0).getNodeType() == Node.ELEMENT_NODE) {
				Element eAttr = (Element) n.item(0);
				NodeList rlist = eAttr.getElementsByTagName("Relation");
				for (int temp = 0; temp < rlist.getLength(); temp++) {
					
					Node nrel = rlist.item(temp);
					if(nrel.getNodeType() == Node.ELEMENT_NODE) {
						Element erel = (Element) nrel;
						NodeList clist = erel.getElementsByTagName("Column");
						for(int temp1 = 0; temp1<clist.getLength();temp1++) {
							Node ncol = clist.item(temp1);
							if(ncol.getNodeType() == Node.ELEMENT_NODE) {
								Element ecol = (Element) ncol;
								//System.out.println(ecol.getElementsByTagName("vartype").item(0).getTextContent());
								column1.name = ecol.getElementsByTagName("name").item(0).getTextContent();
								column1.postag = ecol.getElementsByTagName("postag").item(0).getTextContent();
								column1.type = ecol.getElementsByTagName("type").item(0).getTextContent();
								column1.vartype = ecol.getElementsByTagName("vartype").item(0).getTextContent(); 
								NodeList prelist = ecol.getElementsByTagName("prefix");
								NodeList poslist = ecol.getElementsByTagName("postfix");
								NodeList verlist = ecol.getElementsByTagName("verb");
								NodeList preplist = ecol.getElementsByTagName("preposition");
								NodeList adjlist = ecol.getElementsByTagName("adjective");
								NodeList synlist = ecol.getElementsByTagName("synonym");
								for(int temp2=0;temp2<prelist.getLength();temp2++) {
									Node npre = prelist.item(temp2);
									if(npre.getNodeType() == Node.ELEMENT_NODE) {
										Element epre = (Element) npre;
										column1.prefix.add(epre.getElementsByTagName("name").item(0).getTextContent());
										//System.out.println(epre.getElementsByTagName("name").item(0).getTextContent());
									}
								}
								for(int temp2=0;temp2<poslist.getLength();temp2++) {
									Node npos = poslist.item(temp2);
									if(npos.getNodeType() == Node.ELEMENT_NODE) {
										Element epos = (Element) npos;
										column1.postfix.add(epos.getElementsByTagName("name").item(0).getTextContent());
									}
								}
								for(int temp2=0;temp2<synlist.getLength();temp2++) {
									Node nsyn = synlist.item(temp2);
									if(nsyn.getNodeType() == Node.ELEMENT_NODE) {
										Element esyn = (Element) nsyn;
										column1.synonym.add(esyn.getElementsByTagName("name").item(0).getTextContent());
									}
								}
								for(int temp2=0;temp2<verlist.getLength();temp2++) {
									Node nver = verlist.item(temp2);
									if(nver.getNodeType() == Node.ELEMENT_NODE) {
										Element ever = (Element) nver;
										verb1.name = ever.getElementsByTagName("name").item(0).getTextContent();
										verb1.type = ever.getElementsByTagName("type").item(0).getTextContent();
										verb1.object = ever.getElementsByTagName("object").item(0).getTextContent();
										//System.out.println(ever.getElementsByTagName("name").item(0).getTextContent());
										//System.out.println(ever.getElementsByTagName("type").item(0).getTextContent());
										//System.out.println(ever.getElementsByTagName("object").item(0).getTextContent());
										column1.add_verb(verb1);
										
									}
								}
								for(int temp2=0;temp2<adjlist.getLength();temp2++) {
									Node nadj = adjlist.item(temp2);
									if(nadj.getNodeType() == Node.ELEMENT_NODE) {
										Element eadj = (Element) nadj;
										adj1.name = eadj.getElementsByTagName("name").item(0).getTextContent();
										adj1.level = eadj.getElementsByTagName("level").item(0).getTextContent();
										adj1.type = eadj.getElementsByTagName("type").item(0).getTextContent();
										column1.add_adj(adj1);
									}
								}
								for(int temp2=0;temp2<preplist.getLength();temp2++) {
									Node nprep = preplist.item(temp2);
									if(nprep.getNodeType() == Node.ELEMENT_NODE) {
										Element eprep = (Element) nprep;
										prep1.name = eprep.getElementsByTagName("name").item(0).getTextContent();
										prep1.level = eprep.getElementsByTagName("level").item(0).getTextContent();
										prep1.type = eprep.getElementsByTagName("type").item(0).getTextContent();
										column1.add_prep(prep1);
									}
								} 
								table1.add_column(column1);
								//System.out.println("aa"+table1.columns.get(0).name);
								column1.prefix.clear();
								column1.postfix.clear();
								column1.adjectives.clear();
								column1.verbs.clear();
								column1.prepositions.clear();
								column1.synonym.clear();

							}
						}
						schema.add_table(table1);
						//System.out.println("bb"+schema.tables.get(0).columns.get(0).name);
						table1.columns.clear();
						
					}
				}
			}
			
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("bb1"+schema.tables.get(0).columns.get(0).postag);
	
	}
	
}
