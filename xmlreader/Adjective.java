package xml_reader;

public class Adjective implements Cloneable {
	String name,level,type;
	public Adjective() {}
	public Adjective(String name, String level, String type) {
		this.name = name;
		this.level = level;
		this.type = type;
	}
	@Override
	public Object clone()throws CloneNotSupportedException{  
		return super.clone();  
		}
}
