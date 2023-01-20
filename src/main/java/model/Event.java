package model;

// Su kien lich su
public class Event extends RelationshipObject{
	public Event(String name, String time, String dynasty, String story) {
		this.name = name;
		this.time = time;
		this.dynasty = dynasty;
		this.story = story;
	}
	private String name;
	private String time;
	private String dynasty;
	private String story;
	public String getName() {
		return name;
	}
	public String getTime() {
		return time;
	}
	public String getDynasty() {
		return dynasty;
	}
	public String getStory() {
		return story;
	}
	
	@Override
	public String toString() {
		return name+time+dynasty+story+this.toLineString();
	}
}
