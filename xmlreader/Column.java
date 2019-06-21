package xml_reader;
import java.util.*;
public class Column implements Cloneable {
	String name,postag,type,vartype;
    ArrayList<String> prefix = new ArrayList<String>();
    ArrayList<String> postfix = new ArrayList<String>();
    ArrayList<String> synonym = new ArrayList<String>();
    ArrayList<Adjective> adjectives = new ArrayList<Adjective>();
    ArrayList<Verb> verbs = new ArrayList<Verb>();
    ArrayList<Preposition> prepositions = new ArrayList<Preposition>();
    public Column() {}
    public Column(String name,String postag, String type,String vartype, ArrayList<String> prefix,
    		ArrayList<String> postfix, ArrayList<String> synonym, ArrayList<Adjective> adjectives,
    		ArrayList<Verb> verbs, ArrayList<Preposition> prepositions) {
    	this.name = name;
    	this.postag = postag;
    	this.type = type;
    	this.vartype = vartype;
    	for(int i=0;i<prefix.size();i++) {
    		this.prefix.add(prefix.get(i));
    	}
    	for(int i=0;i<postfix.size();i++) {
    		this.postfix.add(postfix.get(i));
    	}
    	for(int i=0;i<synonym.size();i++) {
    		this.synonym.add(synonym.get(i));
    	}
    	for(int i=0;i<adjectives.size();i++) {
    		this.adjectives.add(new Adjective(adjectives.get(i).name,adjectives.get(i).level,adjectives.get(i).type));
    	}
    	for(int i=0;i<verbs.size();i++) {
    		this.verbs.add(new Verb(verbs.get(i).name,verbs.get(i).type,verbs.get(i).object));
    	}
    	for(int i=0;i<prepositions.size();i++) {
    		this.prepositions.add(new Preposition(prepositions.get(i).name,prepositions.get(i).level,prepositions.get(i).type));
    	}
    }
    public void add_adj(Adjective adj) {
    	adjectives.add(new Adjective(adj.name,adj.level,adj.type));
    }
    public void add_verb(Verb verb) {
    	verbs.add(new Verb(verb.name,verb.type,verb.object));
    }
    public void add_prep(Preposition pre) {
    	prepositions.add(new Preposition(pre.name,pre.level,pre.type));
    }
    
    @Override
    public Object clone()throws CloneNotSupportedException{  
    	return super.clone();  
    	}
}
