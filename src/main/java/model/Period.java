package model;

public class Period extends Model{
	private String time;
    public Period(String name, String href) {
        this.setName(name);
        this.setHref(href);
    }
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}

