package model;

public class HistoricalSite extends HistoryObject{
	public HistoricalSite(String name, String source, String type, String address, String story) {
		this.name = name;
		this.source = source;
		this.type = type;
		this.address = address;
		this.story = story;
	}

	public String getAddress() {
		return address;
	}

	private String address;
	@Override
	public String toString() {
		return name+address+story+this.toLineString();
	}
}
