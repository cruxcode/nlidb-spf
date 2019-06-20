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
				
				
				RelObj.PrimaryDetails = ColObj;
				
				
				
				Node ColumnNode = relElement.getElementsByTagName("ColumnList").item(0);
				Element ColumnElement = (Element) ColumnNode;
				NodeList ColumnList = ColumnElement.getElementsByTagName("column");
				
				ArrayList<Column> ColList = new ArrayList<Column>();
				for(int j=0; j<ColumnList.getLength(); j++) {
					
					Column ColObj1 = new Column();
					Node column = ColumnList.item(j);
					Element colElement1 = (Element) column;
					
					ColObj1.Name = colElement1.getElementsByTagName("Name").item(0).getTextContent();
					ColObj1.PosTag = colElement1.getElementsByTagName("PosTag").item(0).getTextContent();
					ColObj1.Type = colElement1.getElementsByTagName("Type").item(0).getTextContent();
					ColObj1.VarType = colElement1.getElementsByTagName("VarType").item(0).getTextContent();
					
					
					Node ValueNode1 = colElement1.getElementsByTagName("ValueList").item(0);
					Element ValueElement1 = (Element) ValueNode1;
					NodeList ValueList1 = ValueElement1.getElementsByTagName("value");
					
					ArrayList<String> ValList1 = new ArrayList<String>();
					for(int k=0; k<ValueList1.getLength(); k++) {
						
						Node value = ValueList1.item(k);
						ValList1.add(value.getTextContent());
					}
					ColObj1.ValueList = ValList1;
					
					
					Node PrefixNode1 = colElement1.getElementsByTagName("Prefix").item(0);
					Element PrefixElement1 = (Element) PrefixNode1;
					NodeList PrefixList1 = PrefixElement1.getElementsByTagName("prefix");
					
					ArrayList<String> PreList1 = new ArrayList<String>();
					for(int k=0; k<PrefixList1.getLength(); k++) {
						
						Node prefix = PrefixList1.item(k);
						PreList1.add(prefix.getTextContent());
					}
					ColObj1.Prefix = PreList1;
					
					
					Node PostNode1 = colElement1.getElementsByTagName("Postfix").item(0);
					Element PostfixElement1 = (Element) PostNode1;
					NodeList PostfixList1 = PostfixElement1.getElementsByTagName("postfix");
					
					ArrayList<String> PostList1 = new ArrayList<String>();
					for(int k=0; k<PostfixList1.getLength(); k++) {
						
						Node postfix = PostfixList1.item(k);
						PostList1.add(postfix.getTextContent());
					}
					ColObj1.Postfix = PostList1;
					
					
					Node SynonymNode1 = colElement1.getElementsByTagName("Synonym").item(0);
					Element SynonymElement1 = (Element) SynonymNode1;
					NodeList SynonymList1 = SynonymElement1.getElementsByTagName("synonym");
					
					ArrayList<String> SynList1 = new ArrayList<String>();
					for(int k=0; k<SynonymList1.getLength(); k++) {
						
						Node synonym = SynonymList1.item(k);
						SynList1.add(synonym.getTextContent());
					}
					ColObj1.Synonym = SynList1;
					
					Node VerbNode1 = colElement1.getElementsByTagName("VerbList").item(0);
					Element VerbElement1 = (Element) VerbNode1;
					NodeList VerbList1 = VerbElement1.getElementsByTagName("verb");
					
					ArrayList<Verb> VerList1 = new ArrayList<Verb>();
					for(int k=0; k<VerbList1.getLength(); k++)
					{
						Verb VerbObj = new Verb();
						Node verb = VerbList1.item(k);
						Element verbElement = (Element) verb;
						
						VerbObj.VerbName = verbElement.getElementsByTagName("VerbName").item(0).getTextContent();
						VerbObj.VerbType = verbElement.getElementsByTagName("VerbType").item(0).getTextContent();
						
						VerList1.add(VerbObj);
					}
					ColObj1.VerbList = VerList1;
					
					
					Node AdjectiveNode1 = colElement1.getElementsByTagName("AdjectiveList").item(0);
					Element AdjectiveElement1 = (Element) AdjectiveNode1;
					NodeList AdjectiveList1 = AdjectiveElement1.getElementsByTagName("adjective");
					
					ArrayList<Adjective> AdjList1 = new ArrayList<Adjective>();
					for(int k=0; k<AdjectiveList1.getLength(); k++)
					{
						Adjective AdjObj = new Adjective();
						Node adjective = AdjectiveList1.item(k);
						Element adjectiveElement = (Element) adjective;
						
						//VerbObj.VerbName = verbElement.getElementsByTagName("VerbName").item(0).getTextContent();
						//VerbObj.VerbType = verbElement.getElementsByTagName("VerbType").item(0).getTextContent();
						
						AdjList1.add(AdjObj);
					}
					ColObj1.AdjectiveList = AdjList1;
					
					
					Node PrepositionNode1 = colElement1.getElementsByTagName("PrepositionList").item(0);
					Element PrepositionElement1 = (Element) PrepositionNode1;
					NodeList PrepositionList1 = PrepositionElement1.getElementsByTagName("preposition");
					
					ArrayList<Preposition> PrepList1 = new ArrayList<Preposition>();
					for(int k=0; k<PrepositionList1.getLength(); k++)
					{
						Preposition PrepObj = new Preposition();
						Node preposition = PrepositionList1.item(k);
						Element prepositionElement = (Element) preposition;
						
						//VerbObj.VerbName = verbElement.getElementsByTagName("VerbName").item(0).getTextContent();
						//VerbObj.VerbType = verbElement.getElementsByTagName("VerbType").item(0).getTextContent();
						
						PrepList1.add(PrepObj);
					}
					ColObj1.PrepositionList = PrepList1;
					
					
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