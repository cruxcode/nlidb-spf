package rasa;
import java.util.*;

public class Schema {
	ArrayList<Relation> RelationList = new ArrayList<Relation>();
	Dictionary TrackType = new Hashtable();
	Dictionary TrackColumn = new Hashtable();
	Dictionary TrackConstant = new Hashtable();
}
//public String nextPerm(String last) {
//	String next = "";
//	
//	int carry = 1;
//	for(int i=last.length()-1; i>=0; i--) {
//		int num = last.charAt(i)-96+carry;
//		carry = num/26;
//		next = (char)(num%26 + 96) + next;
//	}
//	if(carry != 0) {
//		next = (char)(carry + 96) + next;
//	}
//	return next;
//}
//public void predicate(Schema schema, Predicate pred_file)
//{
//	ArrayList<Relation> RelationList = schema.RelationList;
//	Dictionary TrackType = new Hashtable();
//	Dictionary TrackColumn = new Hashtable();
//	String last = "";
//	
//	for(int i=0; i<RelationList.size(); i++) {
//		
//		ArrayList<Column> ColumnList = RelationList.get(i).ColumnList;
//		Column PrimaryDetails = RelationList.get(i).PrimaryDetails;
//		
//		
//		String PVarType = PrimaryDetails.VarType;
//		String PName = PrimaryDetails.Name;
//		String PType = PrimaryDetails.Type;
//		
//		String ptype = "";
//		if(TrackType.get(PType)!=null) {
//			ptype = (String) TrackType.get(PType);
//		}
//		else {
//			ptype = nextPerm(last);
//		}
//		last = "ptype";
//		
//		TrackColumn.put(PName, ptype);
//		TrackType.put(PType, ptype);
//		
//		for(int j=0; j<ColumnList.size(); j++) {
//			String VarType = ColumnList.get(j).VarType;
//			String Name = ColumnList.get(j).Name;
//			String Type = ColumnList.get(j).Type;
//			
//			if(VarType=="category") {
//				String ctype = "";
//				if(TrackType.get(Type)!=null) {
//					ctype = (String) TrackType.get(Type);
//				}
//				else {
//					ctype = nextPerm(last);
//				}
//				last = ctype;
//				
//				TrackColumn.put(Name, ctype);
//				TrackType.put(Type, ctype);
//				
//				pred_file.PredGenerator(Name, ctype, ptype, "type1");
//				pred_file.PredGenerator(Name, ctype, ptype, "type2");
//				pred_file.PredGenerator(Name, ctype, ptype, "type3");
//				
//			}
//			
//			else {
//				String  ctype = "numeric";
//				TrackColumn.put(Name, ctype);
//				TrackType.put(Type, ctype);
//				
//				pred_file.PredGenerator(Name, ctype, ptype, "type2");
//				pred_file.PredGenerator(Name, ctype, ptype, "type3");
//			}
//			
//		}
//	}
//	
//	schema.TrackColumn = TrackColumn;
//	schema.TrackType = TrackType;
//}



//public void constant(Schema schema, Constant const_file) {
//	ArrayList<Relation> RelationList = schema.RelationList;
//	Dictionary TrackType = new Hashtable();
//	Dictionary TrackColumn = new Hashtable();
//	
//	for(int i=0; i<RelationList.size(); i++) {
//		
//		ArrayList<Column> ColumnList = RelationList.get(i).ColumnList;
//		Column PrimaryDetails = RelationList.get(i).PrimaryDetails;
//		
//		for(int j=0; j<ColumnList.size(); j++) {
//			
//			ArrayList<String> ValueList = ColumnList.get(j).ValueList;
//			ArrayList<String> Prefix = ColumnList.get(j).Prefix;
//			ArrayList<String> Postfix = ColumnList.get(j).Postfix;
//			String Name = ColumnList.get(j).Name;
//			
//			for(int k=0; k<ValueList.size(); k++) {
//				
//				String ctype = (String)TrackColumn.get(Name);
//				const_file.ConstGenerator(ValueList.get(k), ctype);
//				
//				for(int l=0; l<Prefix.size(); l++) {
//					String prefix = ValueList.get(l) + " " + Prefix.get(l);
//					prefix.replace(' ', '_');
//					const_file.ConstGenerator(prefix, ctype);
//				}
//				
//				for(int l=0; l<Postfix.size(); l++) {
//					String postfix = ValueList.get(l) + " " + Postfix.get(l);
//					postfix.replace(' ', '_');
//					const_file.ConstGenerator(postfix, ctype);
//				}
//				
//			}
//			
//		}
//		
//	}
//}




//public void constant(Schema schema, NpList np_file) {
//	ArrayList<Relation> RelationList = schema.RelationList;
//	Dictionary TrackType = new Hashtable();
//	Dictionary TrackColumn = new Hashtable();
//	
//	for(int i=0; i<RelationList.size(); i++) {
//		
//		ArrayList<Column> ColumnList = RelationList.get(i).ColumnList;
//		Column PrimaryDetails = RelationList.get(i).PrimaryDetails;
//		
//		for(int j=0; j<ColumnList.size(); j++) {
//			
//			ArrayList<String> ValueList = ColumnList.get(j).ValueList;
//			ArrayList<String> Prefix = ColumnList.get(j).Prefix;
//			ArrayList<String> Postfix = ColumnList.get(j).Postfix;
//			String Name = ColumnList.get(j).Name;
//			String PosTag = ColumnList.get(j).PosTag;
//			
//			for(int k=0; k<ValueList.size(); k++) {
//				
//				String ctype = (String)TrackColumn.get(Name);
//				np_file.NpGenerator(ValueList.get(k), ctype, PosTag);
//				
//				for(int l=0; l<Prefix.size(); l++) {
//					String prefix = ValueList.get(l) + " " + Prefix.get(l);
//					//prefix.replace(' ', '_');
//					np_file.NpGenerator(prefix, ctype, PosTag);
//				}
//				
//				for(int l=0; l<Postfix.size(); l++) {
//					String postfix = ValueList.get(l) + " " + Postfix.get(l);
//					//postfix.replace(' ', '_');
//					np_file.NpGenerator(postfix, ctype, PosTag);
//				}
//				
//			}
//			
//		}
//		
//	}
//}