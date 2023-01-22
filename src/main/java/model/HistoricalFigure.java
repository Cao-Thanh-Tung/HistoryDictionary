package model;

public class HistoricalFigure extends HistoryObject {
	public HistoricalFigure(String name, String source, String type, String position, String time, String story) {
		this.name = name;
		this.source = source;
		this.type = type;
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
