package frontend.model;

// Su kien lich su
public class Event extends Model{
	public Event(String name, String source, String time, String story) {
		this.name = name;
		this.source = source;
		this.time = time;
		this.story = story;
	}
	
	private String time;
	public String getTime() {
		return time;
	}
	
	@Override
	public String toString() {
		return name+time+story+this.toLineString();
	}
}
