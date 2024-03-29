package rasa;
import java.util.*;

class Predicate{
    
	Map<String, ArrayList<String>> pred_dict = new HashMap<String, ArrayList<String>>(); //For Seed File
    ArrayList<String> predicate = new ArrayList();
    
    public void PredGenerator(String name, String ctype, String ptype, String cat_type){
        
        String pred1 = name + ":";
        String pred2 = name + ":";
        String pred3 = name + ":";
        
        ArrayList<String> track_name = new ArrayList<String>();
        
        if(cat_type=="category")
        {
        	pred1 += "<" + ctype + "," + "t" + ">";
            this.predicate.add(pred1);
            
            
            pred2 = name + ":";
            for(int i=0;i<1;i++)
            {
                pred2 = pred2 + "<" + ptype + ",";  
            }
            pred2 = pred2 + ctype;
            for(int i=0;i<1;i++){
                pred2 = pred2 + ">";
            }
            this.predicate.add(pred2);
            
            
            int p_size = 1;
            pred3 = name + ":";
            for(int i=0; i<p_size; i++)
            {
                String s = "<" + ptype + ",";
                pred3 += s;
            }
            pred3 += "<" + ctype + ",t" + ">";
            for(int i=0; i<p_size; i++)
            {
                pred3 += ">";
            }
            this.predicate.add(pred3);
            
            track_name.add(pred1);
            track_name.add(pred2);
            track_name.add(pred3);
            
            pred_dict.put(name, track_name);
        }
        
        else
        {            
            pred2 = name + ":";
            for(int i=0;i<1;i++)
            {
                pred2 = pred2 + "<" + ptype + ",";  
            }
            pred2 = pred2 + ctype;
            for(int i=0;i<1;i++){
                pred2 = pred2 + ">";
            }
            this.predicate.add(pred2);
            
            
            int p_size = 1;
            pred3 = name + ":";
            for(int i=0; i<p_size; i++)
            {
                String s = "<" + ptype + ",";
                pred3 += s;
            }
            pred3 += "<" + ctype + ",t" + ">";
            for(int i=0; i<p_size; i++)
            {
                pred3 += ">";
            }
            this.predicate.add(pred3);
            
            track_name.add(pred2);
            track_name.add(pred3);
            
            pred_dict.put(name, track_name);
        }
        
    }
}

class Constant{
    
    ArrayList<String> consts = new ArrayList<String>();
    
    public void ConstGenerator(String value, String c_type)
    {
    	String str = value + ":" + c_type;
    	this.consts.add(str);
    }
    
}

class NpList{
    
    ArrayList<String> np_list = new ArrayList<String>();
    
    public void NpGenerator(String value, String col_value, String c_type, String pos_tag)
    {
		String str = value + " :- " + pos_tag + " : " + col_value + ":" + c_type;
		this.np_list.add(str);
    }
}

class Seed{
    
    ArrayList<String> seed_verb = new ArrayList();
    ArrayList<String> seed_col = new ArrayList();
    
    public void VerbGenerator(String verb_name, String verb_type, String col_name, String col_pred1, String col_pred2){
        
        switch(verb_type)
        {
            case "intransitive":
                break;
                
            case "transitive":
                String str = verb_name + " :- " + "(S\\NP)/NP" + " : " + "(lambda $0:e (lambda $1:e (" + col_name + ":" + col_pred2 + " $0 $1)))";
                seed_verb.add(str);
                
                str = verb_name + " :- " + "NP/NP" + " : " + "(lambda $0:e (" + col_name + ":" + col_pred1 + " $0))";
                seed_verb.add(str);
                break;
                
            case "ditransitive":
                break;
        }
    }
    
    public void ColGenerator(String name, String ctype, ArrayList<String> ptype, String pred_type){
        
        String str="", pred=name + ":";
        switch(pred_type)
        {
            // state -> (S/(S\NP)) ??????????????????
            case "type1":
                pred += "<" + ctype + "," + "t" + ">";
                str = name + " :- " + "N" + " : " + pred;
                seed_col.add(str);
                break;
                
            case "type2":
                pred = name + ":";
                for(int i=0;i<ptype.size();i++)
                {
                    pred = pred + "<" + ptype.get(i) + ",";  
                }
                pred = pred + ctype;
                for(int i=0;i<ptype.size();i++){
                    pred = pred + ">";
                }
                
                str = name + " :- " + "NP/NP" + " : " + "(lambda $0:e (" + pred + " $0))";
                seed_col.add(str);
                break;
            
            // density -> N, S/NP   <lo,i> ????????????????????????????
            case "type3":
                int p_size = ptype.size();
                pred = name + ":";
                for(int i=0; i<p_size; i++)
                {
                    String s = "<" + ptype.get(i) + ",";
                    pred += s;
                }
                pred += "<" + ctype + ",t" + ">";
                for(int i=0; i<p_size; i++)
                {
                    pred += ">";
                }
                
                str = name + " :- " + "(S\\NP)/NP" + " : " + "(lambda $0:e (lambda $1:e (" + pred + " $1 $0)))";
                seed_col.add(str);
                break;
        }
    }
}