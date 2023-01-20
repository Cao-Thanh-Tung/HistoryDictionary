package model;

public class HistoricalSite extends RelationshipObject{
	public HistoricalSite(String name, String address, String story) {
		this.name = name;
		this.address = address;
		this.story = story;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getStory() {
		return story;
	}
	private String name;
	private String address;
	private String story;
	@Override
	public String toString() {
		return name+address+story+this.toLineString();
	}
}
