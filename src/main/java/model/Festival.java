package model;

public class Festival extends HistoryObject{
	public Festival(String name, String source, String type, String time, String address, String story) {
		this.name = name;
		this.source = source;
		this.type = type;
		this.time = time;
		this.address = address;
		this.story = story;
	}
	private String time;
	private String address;
	
	@Override
	public String toString() {
		return name+time+address+story+this.toLineString();
	}
	
}
