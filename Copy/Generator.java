package rasa;
import java.util.*;

public class Generator {
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
			last = "ptype";
			
			TrackColumn.put(PName, ptype);
			TrackType.put(PType, ptype);
			
			for(int j=0; j<ColumnList.size(); j++) {
				String VarType = ColumnList.get(j).VarType;
				String Name = ColumnList.get(j).Name;
				String Type = ColumnList.get(j).Type;
				
				if(VarType=="category") {
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
					String  ctype = "numeric";
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
						String comm_ancc = Hierarchy.CommonAncestor(ctype, (String)TrackConstant.get(ValueList.get(k)));
						const_file.ConstGenerator(ValueList.get(k), comm_ancc);
						TrackConstant.put(ValueList.get(k), comm_ancc);
					}
					
					for(int l=0; l<Prefix.size(); l++) {
						String prefix = Prefix.get(l) + " " + ValueList.get(l);
						prefix.replace(' ', '_');
						
						if(TrackConstant.get(prefix) == null)
						{
							const_file.ConstGenerator(prefix, ctype);
							TrackConstant.put(prefix, ctype);
						}
						
						else
						{
							String comm_ancc = Hierarchy.CommonAncestor(ctype, (String)TrackConstant.get(prefix));
							const_file.ConstGenerator(prefix, comm_ancc);
							TrackConstant.put(prefix, comm_ancc);
						}
					}
					
					for(int l=0; l<Postfix.size(); l++) {
						String postfix = ValueList.get(l) + " " + Postfix.get(l);
						postfix.replace(' ', '_');
						
						if(TrackConstant.get(postfix) == null)
						{
							const_file.ConstGenerator(postfix, ctype);
							TrackConstant.put(postfix, ctype);
						}
						
						else
						{
							String comm_ancc = Hierarchy.CommonAncestor(ctype, (String)TrackConstant.get(postfix));
							const_file.ConstGenerator(postfix, comm_ancc);
							TrackConstant.put(postfix, comm_ancc);
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
						prefix.replace(' ', '_');
						ctype = (String)TrackConstant.get(prefix);
						prefix = org_prefix;
						
						np_file.NpGenerator(prefix, ctype, Name, PosTag);
					}
					
					for(int l=0; l<Postfix.size(); l++) {
						String postfix = ValueList.get(l) + " " + Postfix.get(l);

						String org_postfix = postfix;
						postfix.replace(' ', '_');
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
					s3 = (pred_file.pred_dict.get(s.RelationList.get(i).ColumnList.get(j).name)).get(1);
					s4 = s.RelationList.get(i).ColumnList.get(j).AdjectiveList.get(k).type;
					if(s4=="general") {
						seed_file.Adjectives(s1,s2,s3,pred_file.pred_dict.get("greater").get(0),pred_file.pred_dict.get("argmax").get(0));
						seed_file.Adjectives(s1,s2,pred_file.pred_dict.get("greater").get(0),pred_file.pred_dict.get("argmax").get(0));
					}else {
						seed_file.Adjectives(s1,s2,s3,pred_file.pred_dict.get("greater").get(0),pred_file.pred_dict.get("argmax").get(0));
					}
				}
			}
		}
	}
    public void Column_Seed(Schema s, Seed seed_file, Predicate pred_file) {
		String s1,s2,s3,s4;
		for(int i=0;i<s.RelationList.size();i++) {
			for(int j=0;j<s.RelationList.get(i).ColumnList.size();j++) {
				s1 = s.RelationList.get(i).ColumnList.get(j).Name;
				s2 = s.RelationList.get(i).ColumnList.get(j).Name;
				s3 = s.RelationList.get(i).ColumnList.get(j).Name;
				
                //incomplete
			}
		}
		
	}
    
}
