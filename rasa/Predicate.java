package rasa;
import java.util.*;

class Predicate{
    
   // Dictionary pred_dict = new Hashtable(); //For Seed File
    ArrayList<String> predicate = new ArrayList();
    
    public void PredGenerator(String name, String ctype, String ptype, String pred_type){
        
        String pred = name + ":";
        switch(pred_type)
        {
            case "type1":
                pred += "<" + ctype + "," + "t" + ">";
                this.predicate.add(pred);
                break;
                
            case "type2":
                pred = name + ":";
                for(int i=0;i<1;i++)
                {
                    pred = pred + "<" + ptype + ",";  
                }
                pred = pred + ctype;
                for(int i=0;i<1;i++){
                    pred = pred + ">";
                }
                this.predicate.add(pred);
                break;
                
            case "type3":
                int p_size = 1;
                pred = name + ":";
                for(int i=0; i<p_size; i++)
                {
                    String s = "<" + ptype + ",";
                    pred += s;
                }
                pred += "<" + ctype + ",t" + ">";
                for(int i=0; i<p_size; i++)
                {
                    pred += ">";
                }
                this.predicate.add(pred);
                break;
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

class Seed {
	public void VerbGenerator(String verb_name, String verb_type, String col_name, String ctype, String ptype, String pred_type) {
		
	}
}
