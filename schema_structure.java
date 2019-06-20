
// Structure of all classes


public class Verb {
    String name,type;
}
public class Adjective{
    String name;
    int level;
    int type;//general or specific
}
public class Prepositon{
    
}
public class Column{
    String name,postag,type,vartype;
    ArrayList<String> prefix = new ArrayList<String>();
    ArrayList<String> postfix = new ArrayList<String>();
    ArrayList<String> synonym = new ArrayList<String>();
    ArrayList<Adjective> adjectives = new ArrayList<Adjective>();
    ArrayList<Verb> verbs = new ArrayList<Verb>();
    ArrayList<Preposition> prepositions = new ArrayList<Preposition>();
}
public class Table{
    Column primary_key = new Column();
    ArrayList<Column> columns = new ArrayList<Column>();
}
public class Schema{
    ArrayList<Table> tables = new ArrayList<Table>();
    // heirarchy
}  
