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
    
    public void ColGenerator(String name, String ctype, String ptype, String pred_type){
        
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
                str = name + " :- " + "S/PP" + " : " + "(lambda $0:e (" + pred + " $0))";
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
    public static ArrayList<String> seed_adj = new ArrayList<String>(); 
    public static void Adjectives(String adj, String level, String pred, String greater, String max){
        String entry = "";
        if(level == "0"){
            entry += adj + " :- NP/NP : (lambda $0:e (" + pred + " $0))";
            System.out.println(entry);
        }else if(level == "1"){
            entry += adj + " :- PP/NP : (lambda $0:e (lambda $1:e (" + greater + " (" + pred + " $1) (" + pred + " $0))))";
            System.out.println(entry);
        }else{
            entry += adj + " :- NP/N : (lambda $0:<e,t> (" + max + " $0 " + pred + "))";
            System.out.println(entry);
        }
        seed_adj.add(entry);
    }

    public static void Adjectives(String adj, String level, String greater, String max){
        String entry = "";
        if(level.equlas("1")){
            entry += adj + " :- (PP\NP)/NP : (lambda $0:e (lambda $1:e (" + greater + " (" + pred + " $1) (" + pred + " $0))))";
            System.out.println(entry);
        }else if(level.equals("2")){
            entry += adj + " :- (NP/N)/N : (lambda $0:<e,e> (lambda $1:<e,t> (" + max + " $1 $0" + ")))";
            seed_adj.add(entry);
            System.out.println(entry);
            entry = adj + " :- (NP/N)/N : (lambda $0:<e,t> (lambda $1:<e,e> (" + max + " $0 $1" + ")))";
            seed_adj.add(entry);
            System.out.println(entry);
        }
    }
    public static ArrayList<String> seed_prep = new ArrayList<String>();
    public static void Preposition(String prep, String pred) {
    	String entry = "";
    	entry += prep + " :- PP/NP : (lambda $0:e (" + pred + " $0))";//returns pkey, may be not required
    	seed_prep.add(entry);
        entry += prep + " :- PP/NP : (lambda $0:e (lambda $1:pkey(" + pred + " $1 $0)))";//here type 4 will be used
        seed_prep.add(entry);
    }
}
    
    