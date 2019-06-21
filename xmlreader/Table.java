package xml_reader;
import java.util.*;
public class Table implements Cloneable {
	//Column primary_key = new Column();
    ArrayList<Column> columns = new ArrayList<Column>(100);
    public Table() {} 
    public Table(ArrayList<Column> columns) {
    	for(int i=0;i<columns.size();i++) {
    		this.columns.add(new Column(columns.get(i).name,columns.get(i).postag,columns.get(i).type,columns.get(i).vartype,
    				columns.get(i).prefix,columns.get(i).postfix,columns.get(i).synonym,columns.get(i).adjectives,columns.get(i).verbs,columns.get(i).prepositions));
    	}
    }
    public void add_column(Column column1) {
    	columns.add(new Column(column1.name,column1.postag,column1.type,column1.vartype,column1.prefix,column1.postfix
    			,column1.synonym,column1.adjectives,column1.verbs,column1.prepositions));
    }
    @Override
    public Object clone()throws CloneNotSupportedException{  
    	return super.clone();  
    	}
}
