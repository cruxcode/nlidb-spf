package ccg;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {
	
	
	public static Column read_column(Column ColObj,Element colElement)
	{
		ColObj.Name = colElement.getElementsByTagName("Name").item(0).getTextContent();
		ColObj.PosTag = colElement.getElementsByTagName("PosTag").item(0).getTextContent();
		ColObj.Type = colElement.getElementsByTagName("Type").item(0).getTextContent();
		ColObj.VarType = colElement.getElementsByTagName("VarType").item(0).getTextContent();
		
		
		Node ValueNode = colElement.getElementsByTagName("ValueList").item(0);
		Element ValueElement = (Element) ValueNode;
		NodeList ValueList = ValueElement.getElementsByTagName("value");
		
		ArrayList<String> ValList = new ArrayList<String>();
		for(int k=0; k<ValueList.getLength(); k++) {
			
			Node value = ValueList.item(k);
			ValList.add(value.getTextContent());
		}
		ColObj.ValueList = ValList;
		
	
		Node PrefixNode = colElement.getElementsByTagName("Prefix").item(0);
		Element PrefixElement = (Element) PrefixNode;
		NodeList PrefixList = PrefixElement.getElementsByTagName("prefix");
		
		ArrayList<String> PreList = new ArrayList<String>();
		for(int k=0; k<PrefixList.getLength(); k++) {
			
			Node prefix = PrefixList.item(k);
			PreList.add(prefix.getTextContent());
		}
		ColObj.Prefix = PreList;
		
		
		Node PostNode = colElement.getElementsByTagName("Postfix").item(0);
		Element PostfixElement = (Element) PostNode;
		NodeList PostfixList = PostfixElement.getElementsByTagName("postfix");
		
		ArrayList<String> PostList = new ArrayList<String>();
		for(int k=0; k<PostfixList.getLength(); k++) {
			
			Node postfix = PostfixList.item(k);
			PostList.add(postfix.getTextContent());
		}
		ColObj.Postfix = PostList;
		
		
		Node SynonymNode = colElement.getElementsByTagName("Synonym").item(0);
		Element SynonymElement = (Element) SynonymNode;
		NodeList SynonymList = SynonymElement.getElementsByTagName("synonym");
		
		ArrayList<String> SynList = new ArrayList<String>();
		for(int k=0; k<SynonymList.getLength(); k++) {
			
			Node synonym = SynonymList.item(k);
			SynList.add(synonym.getTextContent());
		}
		ColObj.Synonym = SynList;
		
		Node VerbNode = colElement.getElementsByTagName("VerbList").item(0);
		Element VerbElement = (Element) VerbNode;
		NodeList VerbList = VerbElement.getElementsByTagName("verb");
		
		ArrayList<Verb> VerList = new ArrayList<Verb>();
		for(int k=0; k<VerbList.getLength(); k++)
		{
			Verb VerbObj = new Verb();
			Node verb = VerbList.item(k);
			Element verbElement = (Element) verb;
			
			VerbObj.VerbName = verbElement.getElementsByTagName("VerbName").item(0).getTextContent();
			VerbObj.VerbType = verbElement.getElementsByTagName("VerbType").item(0).getTextContent();
			
			VerList.add(VerbObj);
		}
		ColObj.VerbList = VerList;
		
		
		Node AdjectiveNode = colElement.getElementsByTagName("AdjectiveList").item(0);
		Element AdjectiveElement = (Element) AdjectiveNode;
		NodeList AdjectiveList = AdjectiveElement.getElementsByTagName("adjective");
		
		ArrayList<Adjective> AdjList = new ArrayList<Adjective>();
		for(int k=0; k<AdjectiveList.getLength(); k++)
		{
			Adjective AdjObj = new Adjective();
			Node adjective = AdjectiveList.item(k);
			Element adjectiveElement = (Element) adjective;
			
			AdjObj.name = adjectiveElement.getElementsByTagName("AdjName").item(0).getTextContent();
			AdjObj.type = adjectiveElement.getElementsByTagName("AdjType").item(0).getTextContent();
			AdjObj.level = adjectiveElement.getElementsByTagName("AdjLevel").item(0).getTextContent();
			//AdjObj.adjtype = adjectiveElement.getElementsByTagName("Max").item(0).getTextContent();
			
			AdjList.add(AdjObj);
		}
		ColObj.AdjectiveList = AdjList;
		
		
		Node PrepositionNode = colElement.getElementsByTagName("PrepositionList").item(0);
		Element PrepositionElement = (Element) PrepositionNode;
		NodeList PrepositionList = PrepositionElement.getElementsByTagName("preposition");
		
		ArrayList<Preposition> PrepList = new ArrayList<Preposition>();
		for(int k=0; k<PrepositionList.getLength(); k++)
		{
			Preposition PrepObj = new Preposition();
			Node preposition = PrepositionList.item(k);
			Element prepositionElement = (Element) preposition;
			
			PrepObj.name = prepositionElement.getElementsByTagName("PrepName").item(0).getTextContent();
			
			PrepList.add(PrepObj);
		}
		ColObj.PrepositionList = PrepList;
		
		return ColObj;
	}
	public static void tree_reader(Element n, Nodes x, int q, Schema s) {
		NodeList a = n.getElementsByTagName("Level"+Integer.toString(q));
		//System.out.println(a.getLength());
		for(int i=0;i<a.getLength();i++) {
			Node b = a.item(i);
			Element b1 = (Element) b;
			x.add_child(b1.getElementsByTagName("Name").item(0).getTextContent());
			//System.out.println(b1.getElementsByTagName("Name").item(0).getTextContent());
			if(b.getNodeType() == Node.ELEMENT_NODE) {
				tree_reader((Element) b,x.children.get(x.children.size()-1),q+1,s);
			}
		}
		//System.out.println("hi"+a.getLength());
	
	}
	

	public static void main(String argv[]) {
		  
		Schema SchemaObj = new Schema();

	    try {

			File fXmlFile = new File("src/ccg/Schema.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			
			
			
			Node RelationNode = doc.getElementsByTagName("RelationList").item(0);
			Element RelationElement = (Element) RelationNode;
			NodeList RelationList = RelationElement.getElementsByTagName("relation");
			
	
			
			ArrayList<Relation> RelList = new ArrayList<Relation>();
			for (int i = 0; i < RelationList.getLength(); i++) {
				
				Relation RelObj = new Relation();
				Node relation = RelationList.item(i);
				Element relElement = (Element) relation;
				
				
				Column ColObj = new Column();
				Node PrimaryDetails = relElement.getElementsByTagName("PrimaryDetails").item(0);
				Element colElement = (Element) PrimaryDetails;
				ColObj = read_column(ColObj, colElement);
				RelObj.PrimaryDetails = ColObj;
				
				
				
				Node ColumnNode = relElement.getElementsByTagName("ColumnList").item(0);
				Element ColumnElement = (Element) ColumnNode;
				NodeList ColumnList = ColumnElement.getElementsByTagName("column");
				
				ArrayList<Column> ColList = new ArrayList<Column>();
				for(int j=0; j<ColumnList.getLength(); j++) {
					
					Column ColObj1 = new Column();
					Node column = ColumnList.item(j);
					Element colElement1 = (Element) column;
					ColObj1 = read_column(ColObj1, colElement1);
					ColList.add(ColObj1);
				}
				RelObj.ColumnList = ColList;
				
				
				RelList.add(RelObj);
			}
			
			SchemaObj.RelationList = RelList;



			
			NodeList n = doc.getElementsByTagName("Hierarchy");
			if(n.item(0).getNodeType() == Node.ELEMENT_NODE) {
				Element hnode = (Element) n.item(0);
				NodeList root = hnode.getElementsByTagName("RootNode");
				
				if(n.item(0).getNodeType() == Node.ELEMENT_NODE) {
					Element rnode = (Element) root.item(0);
					SchemaObj.Hierarchy.name = rnode.getElementsByTagName("Name").item(0).getTextContent();
					//System.out.println(rnode.getElementsByTagName("Name").item(0).getTextContent());
					tree_reader(rnode,SchemaObj.Hierarchy,1,SchemaObj);
				}
				
			}
			
			
	    }
	    
	    catch (Exception e){
	    	e.printStackTrace();
	    }
	    

	Predicate pred_file = new Predicate();
	Constant const_file = new Constant();
	NpList np_file = new NpList();
	Seed seed_file = new Seed();
	Hierar hierar_file = new Hierar();
	   
	Generator genObj = new Generator();

	genObj.predicate(SchemaObj, pred_file);
	SchemaObj.TrackType.put("entity", "e");
	SchemaObj.TrackType.put("integer", "i");
	SchemaObj.TrackType.put("truth", "t");
	genObj.symbol_giver(SchemaObj.Hierarchy, SchemaObj);
	genObj.hGenerator(SchemaObj.Hierarchy, hierar_file.hierar_list); 
	genObj.constant(SchemaObj, const_file);
	genObj.nplist(SchemaObj, np_file);
	genObj.seed_verb(SchemaObj, seed_file, pred_file);
	genObj.Adjective_seed(SchemaObj, seed_file, pred_file);
	genObj.Column_Seed(SchemaObj, seed_file, pred_file);
	genObj.Synonym_Seed(SchemaObj, seed_file, pred_file);
	genObj.Preposition_seed(SchemaObj, seed_file, pred_file);
	seed_file.comseed();
	System.out.println(SchemaObj.TrackType);

	genObj.generate_file("src/ccg/geo.pred.ont.txt", pred_file.predicate);
	genObj.generate_file("src/ccg/geo.consts.ont.txt", const_file.consts);
	genObj.generate_file("src/ccg/geo.np-list.ont.txt", np_file.np_list);
	genObj.generate_file("src/ccg/geo.seed.ont.txt", seed_file.complete_seed);
	genObj.generate_file("src/ccg/geo.hierar.ont.txt", hierar_file.hierar_list);
	    
	}
	  
}

