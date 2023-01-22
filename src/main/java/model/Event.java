package model;

// Su kien lich su
public class Event extends HistoryObject{
	public Event(String name, String source, String type, String time, String dynasty, String story) {
		this.name = name;
		this.source = source;
		this.type = type;
		this.time = time;
		this.dynasty = dynasty;
		this.story = story;
	}
	
	private String time;
	private String dynasty;
	public String getTime() {
		return time;
	}
	public String getDynasty() {
		return dynasty;
	}
	
	@Override
	public String toString() {
		return name+time+dynasty+story+this.toLineString();
	}
}
