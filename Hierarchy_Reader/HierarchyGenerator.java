package hreader;
import java.util.*;
public class HierarchyGenerator {
	public static ArrayList<String> s = new ArrayList<String>();
	public static void hGenerator(Nodes x) {
		for(int i=0;i<x.children.size();i++) {
			s.add("("+x.children.get(i).name+","+x.name+")"+"       // "+x.children.get(i).name);
		}
		for(int i=0;i<x.children.size();i++) {
			hGenerator(x.children.get(i));
		}
	}

}
