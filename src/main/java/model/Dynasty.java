package model;
// Trieu dai
public class Dynasty extends RelationshipObject{
	public Dynasty(String source, String name, String time, String history) {
		this.source = source;
		this.name = name;
		this.time = time;
		this.history = history;
	}
	private String source;
	private String name;
	private String time;
	private String history;
	
	public String getSource() {
		return source;
	}
	public String getName() {
		return name;
	}
	public String getTime() {
		return time;
	}
	public String getHistory() {
		return history;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return history+source+name+time+this.toLineString();
	}
	
}
