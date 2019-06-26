package ccg;

import java.util.ArrayList;
public class Nodes {
	String name,symbol;
	Nodes parent = null;
	ArrayList<Nodes> children = new ArrayList<Nodes>();
	public Nodes(String name, Nodes parent) {
		this.name = name;
		this.parent = parent;
		
	}
	public Nodes() {}
	public void add_child(String cname) {
		children.add(new Nodes(cname,this));
	}
}
