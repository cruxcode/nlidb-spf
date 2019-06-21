package xml_reader;

public class Preposition implements Cloneable {
	String name,level,type;
	public Preposition(String name,String level,String type) {
		this.name = name;
		this.level = level;
		this.type = type;
	}
	public Preposition() {}
	@Override
	public Object clone()throws CloneNotSupportedException{  
		return super.clone();  
		}
	
}
