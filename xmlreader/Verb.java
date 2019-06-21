package xml_reader;

public class Verb implements Cloneable{
	String name,type,object;
	public Verb() {}
	public Verb(String name, String type, String object){
		this.name = name;
		this.type = type;
		this.object = object;
	}
	@Override
	public Object clone()throws CloneNotSupportedException{  
		return super.clone();  
		}
}
