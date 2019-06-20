package xml_reader;
import java.util.*;
public class Table implements Cloneable {
	//Column primary_key = new Column();
    ArrayList<Column> columns = new ArrayList<Column>(100);
    public Object clone()throws CloneNotSupportedException{  
    	return super.clone();  
    	}
}
