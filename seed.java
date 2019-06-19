public class MyClass {
    public static void PredicateGenerator(Schema s){
        String name, ptype, ctype;
        for(int i=0;i<s.tables.size();i++){
            for(int j=0;j<s.tables.get(i).columns.size();j==){
                name = s.tables.get(i).columns.get(j).name;
                ctype = s.tables.get(i).columns.get(j).type;
                ptype = s.tables.get(i).primary.type;
                predicate(name,ptype,ctype);
            }
        }
    }
    public static void SeedGenerator(Schema s){
        String s1,s2,s3,s4; 
        for(int i=0;i<s.tables.size();i++){
            for(int j=0;j<s.tables.get(i).columns.size();j++){
                for(int k=0;k<s.tables.get(i).columns.get(j).adj.size();k++){
                    s1 = s.tables.get(i).columns.get(j).adj.get(k).name;
                    s2 = s.tables.get(i).columns.get(j).adj.get(k).level;
                    s3 = (preds.get(s.tables.get(i).columns.get(j).name)).get(1******);
                    adj(s1,s2,s3);
                }
                for(int k=0;k<s.tables.get(i).columns.get(j).verbs.size();k++){
                    
                }
                for(int k=0;k<s.tables.get(i).columns.get(j).prepositions.size();k++){
                    
                }
                for(int k=0;k<s.tables.get(i).columns.get(j).verbs.size();k++){
                    
                }
                
            }
        }
    }
    
    public static void main(String args[]) {
        
        for(int i=0;i<schema.size();i++){
            
        }
        
        System.out.println("Sum of x+y = " + z);
    }
}
