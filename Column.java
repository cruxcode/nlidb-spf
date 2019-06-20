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
    public Object clone()throws CloneNotSupportedException{  
    	return super.clone();  
    	}
}
