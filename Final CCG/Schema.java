package ccg;
import java.util.*;

public class Schema {
	ArrayList<Relation> RelationList = new ArrayList<Relation>();
	Dictionary TrackType = new Hashtable();
	Dictionary TrackColumn = new Hashtable();
	Dictionary TrackConstant = new Hashtable();
	Nodes Hierarchy = new Nodes();
}


class Column {
	String Name;
	String PosTag;
	String Type;
	String VarType;
	ArrayList<String> ValueList = new ArrayList<String>();
	ArrayList<String> Prefix = new ArrayList<String>();
	ArrayList<String> Postfix = new ArrayList<String>();
	ArrayList<String> Synonym = new ArrayList<String>();
	ArrayList<Verb> VerbList = new ArrayList<Verb>();
	ArrayList<Adjective> AdjectiveList = new ArrayList<Adjective>();
	ArrayList<Preposition> PrepositionList = new ArrayList<Preposition>();
	
}

class Adjective {
	String name, level, type, adjtype;
}

class Preposition {
	String name;

}

class Relation {
	Column PrimaryDetails = new Column();
	ArrayList<Column> ColumnList = new ArrayList<Column>();
}

class Verb {
	String VerbName;
	String VerbType;
}