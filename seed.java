﻿public class MyClass {
    public static void PredicateGenerator(Schema s){
        String name, ptype, ctype;
        for(int i=0;i<s.tables.size();i++){
            for(int j=0;j<s.tables.get(i).columns.size();j++){
                name = s.tables.get(i).columns.get(j).name;
                ctype = s.tables.get(i).columns.get(j).type;
                ptype = s.tables.get(i).primary.type;
                predicate(name,ptype,ctype);
            }
        }
    }
    public static void SeedGenerator(Schema s){
        String s1,s2,s3,s4;
        int i1,i2,i3;
        for(int i=0;i<s.tables.size();i++){
            for(int j=0;j<s.tables.get(i).columns.size();j++){
                for(int k=0;k<s.tables.get(i).columns.get(j).adjectives.size();k++){
                    s1 = s.tables.get(i).columns.get(j).adjectives.get(k).name;
                    i1 = s.tables.get(i).columns.get(j).adjectives.get(k).level;
                    s3 = (preds.get(s.tables.get(i).columns.get(j).name)).get(1******);//undecided
                    adj(s1,i1,s3);
                }
                for(int k=0;k<s.tables.get(i).columns.get(j).verbs.size();k++){
                    
                }
                for(int k=0;k<s.tables.get(i).columns.get(j).prepositions.size();k++){
                    
                }
                for(int k=0;k<s.tables.get(i).columns.get(j).xyz.size();k++){
                    
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
