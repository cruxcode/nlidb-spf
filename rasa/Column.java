package rasa;
import java.util.*;

public class Column {
	ArrayList<String> ValueList = new ArrayList<String>();
	String Name;
	String PosTag;
	String Type;
	String VarType;
	ArrayList<String> Prefix = new ArrayList<String>();
	ArrayList<String> Postfix = new ArrayList<String>();
	ArrayList<String> Synonym = new ArrayList<String>();
	ArrayList<Verb> VerbList = new ArrayList<Verb>();
	ArrayList<Adjective> AdjectiveList = new ArrayList<Adjective>();
	ArrayList<Preposition> PrepositionList = new ArrayList<Preposition>();
	
}
