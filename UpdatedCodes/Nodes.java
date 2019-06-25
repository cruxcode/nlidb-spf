package hreader;

import java.util.ArrayList;
public class Nodes {
	String name,symbol;
	Nodes parent = null;
	ArrayList<Nodes> children = new ArrayList<Nodes>();
	public Nodes(String name, String symbol, Nodes parent) {
		this.name = name;
		this.parent = parent;
		this.symbol = symbol;
	}
	public Nodes() {}
	public void add_child(String cname, String symbol) {
		children.add(new Nodes(cname,symbol,this));
	}
}
