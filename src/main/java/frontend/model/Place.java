package frontend.model;

public class Place extends Model{
	public Place(String name, String source, String address, String story) {
		this.name = name;
		this.source = source;
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
