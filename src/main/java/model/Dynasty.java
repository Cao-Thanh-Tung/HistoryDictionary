package model;
// Trieu dai
public class Dynasty extends HistoryObject{
	public Dynasty(String name, String source, String type, String time, String story) {
		this.source = source;
		this.type = type;
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
