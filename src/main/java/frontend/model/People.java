package frontend.model;

public class People extends Model {
	public People(String name, String source, String position, String time, String story) {
		this.name = name;
		this.source = source;
		this.position = position;
		this.time = time;
		this.story = story;
	}
	private String position;
	private String time;
	public String getPosition() {
		return position;
	}
	public String getTime() {
		return time;
	}
	@Override
	public String toString() {
		return name+position+time+story+this.toLineString();
	}
}
