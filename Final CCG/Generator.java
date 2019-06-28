package ccg;

import java.io.IOException;
import java.util.*;

public class Generator {
	public String lastsymb = "";
	
	public static void generate_file(String FileName, ArrayList<String> arr) {
		try {
			FileGenerator.list_to_file(FileName, arr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String nextPerm(String last) {
		
		String next = "";
		
		int carry = 1;
		for(int i=last.length()-1; i>=0; i--) {
			int num = last.charAt(i)-96+carry;
			carry = num/26;
			next = (char)(num%26 + 96) + next;
		}
		if(carry != 0) {
			next = (char)(carry + 96) + next;
		}

        if(next.equals("t"))
			next = "u";
		if(next.equals("e"))
			next = "f";
		if(next.equals("i"))
			next = "j";
		
		lastsymb = next;
		//System.out.println("aa "+lastsymb);
		
		return next;
	}
	public void predicate(Schema schema, Predicate pred_file)
	{
		ArrayList<Relation> RelationList = schema.RelationList;
		Dictionary TrackType = schema.TrackType;
		Dictionary TrackColumn = schema.TrackColumn;
		Dictionary TrackConstant = schema.TrackConstant;
		String last = "";
		
		for(int i=0; i<RelationList.size(); i++) {
			
			ArrayList<Column> ColumnList = RelationList.get(i).ColumnList;
			Column PrimaryDetails = RelationList.get(i).PrimaryDetails;
			
			
			String PVarType = PrimaryDetails.VarType;
			String PName = PrimaryDetails.Name;
			String PType = PrimaryDetails.Type;
			
			String ptype = "";
			if(TrackType.get(PType)!=null) {
				ptype = (String) TrackType.get(PType);
			}
			else {
				ptype = nextPerm(last);
			}
			last = ptype;
			
			TrackColumn.put(PName, ptype);
			TrackType.put(PType, ptype);
			
			pred_file.PredGenerator(PName, ptype, ptype, "category");
			
			for(int j=0; j<ColumnList.size(); j++) {
				String VarType = ColumnList.get(j).VarType;
				String Name = ColumnList.get(j).Name;
				if(Name.equals(PName))
					continue;
				String Type = ColumnList.get(j).Type;
				
				if(VarType.equals("category")) {
					//System.out.println(VarType);
					String ctype = "";
					if(TrackType.get(Type)!=null) {
						ctype = (String) TrackType.get(Type);
					}
					else {
						ctype = nextPerm(last);
					}
					last = ctype;
					
					TrackColumn.put(Name, ctype);
					TrackType.put(Type, ctype);
					
					pred_file.PredGenerator(Name, ctype, ptype, "category");
				}
				
				else {
					String  ctype = "i";
					TrackColumn.put(Name, ctype);
					TrackType.put(Type, ctype);
					
					pred_file.PredGenerator(Name, ctype, ptype, "numeric");
				}
				
			}
		}
		
		schema.TrackColumn = TrackColumn;
		schema.TrackType = TrackType;
		schema.TrackConstant = TrackConstant;
	}



	public void constant(Schema schema, Constant const_file) {
		ArrayList<Relation> RelationList = schema.RelationList;
		Dictionary TrackType = schema.TrackType;
		Dictionary TrackColumn = schema.TrackColumn;
		Dictionary TrackConstant = schema.TrackConstant;
		
		for(int i=0; i<RelationList.size(); i++) {
			
			ArrayList<Column> ColumnList = RelationList.get(i).ColumnList;
			Column PrimaryDetails = RelationList.get(i).PrimaryDetails;
			
			for(int j=0; j<ColumnList.size(); j++) {
				
				ArrayList<String> ValueList = ColumnList.get(j).ValueList;
				ArrayList<String> Prefix = ColumnList.get(j).Prefix;
				ArrayList<String> Postfix = ColumnList.get(j).Postfix;
				String Name = ColumnList.get(j).Name;
				
				for(int k=0; k<ValueList.size(); k++) {
					
					String ctype = (String)TrackColumn.get(Name);
					if(TrackConstant.get(ValueList.get(k)) == null)
					{
						const_file.ConstGenerator(ValueList.get(k), ctype);
						TrackConstant.put(ValueList.get(k), ctype);
					}
					
					else
					{
						String comm_ancc = Hierar.CommonAncestor(ctype, (String)TrackConstant.get(ValueList.get(k)));
						const_file.ConstGenerator(ValueList.get(k), ctype);
						TrackConstant.put(ValueList.get(k), ctype);
					}
					
					for(int l=0; l<Prefix.size(); l++) {
						String prefix = Prefix.get(l) + " " + ValueList.get(l);
						prefix = prefix.replace(" ", "_");
						
						if(TrackConstant.get(prefix) == null)
						{
							const_file.ConstGenerator(prefix, ctype);
							TrackConstant.put(prefix, ctype);
						}
						
						else
						{
							String comm_ancc = Hierar.CommonAncestor(ctype, (String)TrackConstant.get(prefix));
							const_file.ConstGenerator(prefix, ctype);
							TrackConstant.put(prefix, ctype);
						}
					}
					
					for(int l=0; l<Postfix.size(); l++) {
						String postfix = ValueList.get(l) + " " + Postfix.get(l);
						postfix = postfix.replace(" ", "_");
						
						if(TrackConstant.get(postfix) == null)
						{
							const_file.ConstGenerator(postfix, ctype);
							TrackConstant.put(postfix, ctype);
						}
						
						else
						{
							String comm_ancc = Hierar.CommonAncestor(ctype, (String)TrackConstant.get(postfix));
							const_file.ConstGenerator(postfix, ctype);
							TrackConstant.put(postfix, ctype);
						}
					}
					
				}
				
			}
			
		}
		
		schema.TrackColumn = TrackColumn;
		schema.TrackType = TrackType;
		schema.TrackConstant = TrackConstant;
	}




	public void nplist(Schema schema, NpList np_file) {
		ArrayList<Relation> RelationList = schema.RelationList;
		Dictionary TrackType = schema.TrackType;
		Dictionary TrackColumn = schema.TrackColumn;
		Dictionary TrackConstant = schema.TrackConstant;
		
		for(int i=0; i<RelationList.size(); i++) {
			
			ArrayList<Column> ColumnList = RelationList.get(i).ColumnList;
			Column PrimaryDetails = RelationList.get(i).PrimaryDetails;
			
			for(int j=0; j<ColumnList.size(); j++) {
				
				ArrayList<String> ValueList = ColumnList.get(j).ValueList;
				ArrayList<String> Prefix = ColumnList.get(j).Prefix;
				ArrayList<String> Postfix = ColumnList.get(j).Postfix;
				String Name = ColumnList.get(j).Name;
				String PosTag = ColumnList.get(j).PosTag;
				
				for(int k=0; k<ValueList.size(); k++) {
					
					String ctype = (String)TrackConstant.get(ValueList.get(k));
					np_file.NpGenerator(ValueList.get(k), ctype, Name, PosTag);
					
					for(int l=0; l<Prefix.size(); l++) {
						String prefix = Prefix.get(l) + " " + ValueList.get(l);
						
						String org_prefix = prefix;
						prefix = prefix.replace(' ', '_');
						ctype = (String)TrackConstant.get(prefix);
						prefix = org_prefix;
						
						np_file.NpGenerator(prefix, ctype, Name, PosTag);
					}
					
					for(int l=0; l<Postfix.size(); l++) {
						String postfix = ValueList.get(l) + " " + Postfix.get(l);

						String org_postfix = postfix;
						postfix = postfix.replace(' ', '_');
						ctype = (String)TrackConstant.get(postfix);
						postfix = org_postfix;
						
						np_file.NpGenerator(postfix, ctype, Name, PosTag);
					}
					
				}
				
			}
			
		}
		
		schema.TrackColumn = TrackColumn;
		schema.TrackType = TrackType;
		schema.TrackConstant = TrackConstant;
	}
	
	
	public void seed_verb(Schema schema, Seed seed_file, Predicate pred_file){
	    ArrayList<Relation> RelationList = schema.RelationList;
		Dictionary TrackType = schema.TrackType;
		Dictionary TrackColumn = schema.TrackColumn;
		Dictionary TrackConstant = schema.TrackConstant;
		
		for(int i=0; i<RelationList.size(); i++){
		    
		    ArrayList<Column> ColumnList = RelationList.get(i).ColumnList;
			Column PrimaryDetails = RelationList.get(i).PrimaryDetails;
			
			for(int j=0; j<ColumnList.size(); j++){
			    
			    ArrayList<Verb> VerbList = ColumnList.get(j).VerbList;
			    String ColName = ColumnList.get(j).Name;
			    String VarType = ColumnList.get(j).VarType;
			    
			    for(int k=0; k<VerbList.size(); k++){
			        
			        String VerbName = VerbList.get(k).VerbName;
			        String VerbType = VerbList.get(k).VerbType;
			        
			        if(VarType=="category")
			        	seed_file.VerbGenerator(VerbName, VerbType, ColName, pred_file.pred_dict.get(ColName).get(1), pred_file.pred_dict.get(ColName).get(2));
			        
			        else
			        	seed_file.VerbGenerator(VerbName, VerbType, ColName, pred_file.pred_dict.get(ColName).get(0), pred_file.pred_dict.get(ColName).get(1));
			        
			    }
			}
		}
		
		schema.TrackColumn = TrackColumn;
		schema.TrackType = TrackType;
		schema.TrackConstant = TrackConstant;
	}
	public void Adjective_seed(Schema s, Seed seed_file, Predicate pred_file) {
		String s1,s2,s3,s4;
		for(int i=0;i<s.RelationList.size();i++) {
			for(int j=0;j<s.RelationList.get(i).ColumnList.size();j++) {
				for(int k=0;k<s.RelationList.get(i).ColumnList.get(j).AdjectiveList.size();k++) {
					s1 = s.RelationList.get(i).ColumnList.get(j).AdjectiveList.get(k).name;
					s2 = s.RelationList.get(i).ColumnList.get(j).AdjectiveList.get(k).level;
					s3 = (pred_file.pred_dict.get(s.RelationList.get(i).ColumnList.get(j).Name)).get(1);
					s4 = s.RelationList.get(i).ColumnList.get(j).AdjectiveList.get(k).type;
					if(s4.equals("general")) {
						seed_file.Adjectives(s1,s2,s3,">:<i,<i,t>>","argmax:<<e,t>,<<e,i>,e>>");
						seed_file.Adjectives(s1,s2,">:<i,<i,t>>","argmax:<<e,t>,<<e,i>,e>>");
					}else {
						seed_file.Adjectives(s1,s2,s3,">:<i,<i,t>>","argmax:<<e,t>,<<e,i>,e>>");
					}
				}
			}
		}
	}
	public void Column_Seed(Schema s, Seed seed_file, Predicate pred_file) {
		String s1,s2,s3;
		ArrayList<String> s4 = new ArrayList<String>();
		for(int i=0;i<s.RelationList.size();i++) {
			for(int j=0;j<s.RelationList.get(i).ColumnList.size();j++) {
				s4.clear();
				s1 = s.RelationList.get(i).ColumnList.get(j).Name;
				s2 = s.RelationList.get(i).ColumnList.get(j).Type;
				s3 = s.RelationList.get(i).PrimaryDetails.Type;
				s2 = s.TrackType.get(s2).toString();
				s3 = s.TrackType.get(s3).toString();
				s4.add(s3);
				seed_file.ColGenerator(s1,s2,s4,"type2");
				seed_file.ColGenerator(s1,s2,s4,"type3");
				if((s.RelationList.get(i).ColumnList.get(j).VarType).equals("category")) {
					seed_file.ColGenerator(s1,s2,s4,"type1");
				}
				
                
			}
		}
		
	}
	public void Synonym_Seed(Schema s, Seed seed_file, Predicate pred_file) {
		String s1,s2,s3;
		ArrayList<String> s4 = new ArrayList<String>();
		for(int i=0;i<s.RelationList.size();i++) {
			for(int j=0;j<s.RelationList.get(i).ColumnList.size();j++) {
				for(int k=0;k<s.RelationList.get(i).ColumnList.get(j).Synonym.size();k++) {
					s4.clear();
					s1 = s.RelationList.get(i).ColumnList.get(j).Synonym.get(k);
					s2 = s.RelationList.get(i).ColumnList.get(j).Type;
					s3 = s.RelationList.get(i).PrimaryDetails.Type;
					s2 = s.TrackType.get(s2).toString();
					s3 = s.TrackType.get(s3).toString();
					s4.add(s3);
					//System.out.println(s4);
					seed_file.ColGenerator(s1,s2,s4,"type2");
					seed_file.ColGenerator(s1,s2,s4,"type3");
					if((s.RelationList.get(i).ColumnList.get(j).VarType).equals("Category")) {
						seed_file.ColGenerator(s1,s2,s4,"type1");
					}
				
				}   
			}
		}
		
	}
	public void Preposition_seed(Schema s, Seed seed_file, Predicate pred_file) {
		String s1,s2,s3,s4,s5;
		for(int i=0;i<s.RelationList.size();i++) {
			for(int j=0;j<s.RelationList.get(i).ColumnList.size();j++) {
				for(int k=0;k<s.RelationList.get(i).ColumnList.get(j).PrepositionList.size();k++) {
					s1 = s.RelationList.get(i).ColumnList.get(j).PrepositionList.get(k).name;
					s2 = s.TrackType.get(s.RelationList.get(i).PrimaryDetails.Type).toString();
					s3 = s.TrackType.get(s.RelationList.get(i).ColumnList.get(j).Type).toString();
					s4 = "pkeyReturner:<" + s3 + "," + s2 + ">";
					s5 = "setReturner:<" + s2 + ",<" + s3 + ",t>>";
					seed_file.Preposition(s1,s4,s5,s2);
					
				}
			}
		}
	}
	
	public void symbol_giver(Nodes x, Schema s) {
		String name = x.name;
		
		if(s.TrackType.get(name)!=null){
		    x.symbol = s.TrackType.get(name).toString();
		}else{
			//System.out.println(lastsymb);
		    x.symbol = nextPerm(lastsymb);
		    lastsymb = x.symbol;
		    s.TrackType.put(name, lastsymb);
		}
		for(int i=0;i<x.children.size();i++) {
			symbol_giver(x.children.get(i),s);
		}
	}

	public void hGenerator(Nodes x, ArrayList<String> hierar_list) {
		for(int i=0;i<x.children.size();i++) {
			hierar_list.add("("+x.children.get(i).symbol+","+x.symbol+")"+"       // "+x.children.get(i).name);
		}
		for(int i=0;i<x.children.size();i++) {
			hGenerator(x.children.get(i),hierar_list);
		}
	}

	
}
