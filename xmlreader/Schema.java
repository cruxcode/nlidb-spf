package xml_reader;
import java.util.*;
public class Schema {
	ArrayList<Table> tables = new ArrayList<Table>(50);
	public Schema() {}
	public void add_table(Table table1) {
		tables.add(new Table(table1.columns));
	}
}
