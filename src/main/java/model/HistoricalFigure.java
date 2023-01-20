package model;

public class HistoricalFigure extends RelationshipObject {
	public HistoricalFigure(String name, String position, String time, String story) {
		this.name = name;
		this.position = position;
		this.time = time;
		this.story = story;
	}
	private String name;
	private String position;
	private String time;
	private String story;
	public String getName() {
		return name;
	}
	public String getPosition() {
		return position;
	}
	public String getTime() {
		return time;
	}
	public String getStory() {
		return story;
	}
	
	@Override
	public String toString() {
		return name+position+time+story+this.toLineString();
	}
}
