package hreader;

import java.util.ArrayList;

public class Common_Parent {
	public static Nodes a = new Nodes();
	public static Nodes b = new Nodes();
	public static void tree_traverser(Nodes x) {
		System.out.println(x.name);
		for(int i=0;i<x.children.size();i++) {
			tree_traverser(x.children.get(i));
		}
	}
	public static void search(String s, Nodes x) {
		
		if(x==null) {
			return;
		}else if(s.equals(x.name)) {
			b = x;
			//System.out.println(s.equals(x.name));
		}else {
			//System.out.println(s.equals(x.name));
			for(int i=0;i<x.children.size();i++) {
				search(s,x.children.get(i));
			}
		}
	}
	public static void traversing_up(Nodes x, ArrayList<String> s) {
		if(x == null) {
			return;
		}else {
			s.add(x.name);
			traversing_up(x.parent,s);
		}
	}
	public static ArrayList<String> p = new ArrayList<String>();
	public static ArrayList<String> q = new ArrayList<String>();
	
	public static String common_parent(String s1, String s2, Nodes x) {
		search(s1,x);
		a = b;
		search(s2,x);
		traversing_up(a,p);
		traversing_up(b,q);
		int len;
		if(p.size()<q.size()) {
			len = p.size();
		}else {
			len = q.size();
		}
		String s = x.name;
		for(int i=0;i<len;i++) {
			if((p.get(p.size()-1-i)).equals(q.get(q.size()-1-i))) {
				s = p.get(p.size()-1-i);
			}
		}
		return(s);
		
		
	}
}
