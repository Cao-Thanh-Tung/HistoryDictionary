package frontend.model;

public class Festival extends Model{
	public Festival(String name, String source, String time, String address, String story) {
		this.name = name;
		this.source = source;
		this.time = time;
		this.address = address;
		this.story = story;
	}
	private String time;
	private String address;
	
	@Override
	public String toString() {
		return name+time+address+story+this.toLineString();
	}
	
}
