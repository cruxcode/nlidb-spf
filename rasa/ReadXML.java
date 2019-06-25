package rasa;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.*;

public class ReadXML {
	
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
			
			//VerbObj.VerbName = verbElement.getElementsByTagName("VerbName").item(0).getTextContent();
			//VerbObj.VerbType = verbElement.getElementsByTagName("VerbType").item(0).getTextContent();
			
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
			
			//VerbObj.VerbName = verbElement.getElementsByTagName("VerbName").item(0).getTextContent();
			//VerbObj.VerbType = verbElement.getElementsByTagName("VerbType").item(0).getTextContent();
			
			PrepList.add(PrepObj);
		}
		ColObj.PrepositionList = PrepList;
		
		return ColObj;
	}
	

	public static void main(String argv[]) {
		  
		Schema SchemaObj = new Schema();

	    try {

			File fXmlFile = new File("src/rasa/Schema.xml");
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
			
			
	    }
	    
	    catch (Exception e){
	    	e.printStackTrace();
	    }
	    
	    
	    System.out.println(SchemaObj.RelationList.get(0).ColumnList.get(0).Prefix.size());
	    
	}
	  
}