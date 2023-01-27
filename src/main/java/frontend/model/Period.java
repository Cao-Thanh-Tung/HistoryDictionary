package frontend.model;
// Trieu dai
public class Period extends Model{
	public Period(String name, String source, String time, String story) {
		this.source = source;
		this.name = name;
		this.time = time;
		this.story = story;
	}
	private String time;
	public String getTime() {
		return time;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return story+source+name+time+this.toLineString();
	}
	
}
