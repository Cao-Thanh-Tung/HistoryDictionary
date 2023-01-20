package model;

public class Festival extends RelationshipObject{
	public Festival(String name, String time, String address, String story) {
		this.name = name;
		this.time = time;
		this.address = address;
		this.story = story;
	}
	private String name;
	private String time;
	private String address;
	private String story;
	
	@Override
	public String toString() {
		return name+time+address+story+this.toLineString();
	}
	
}
