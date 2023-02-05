package model;

import java.util.LinkedList;
import java.util.List;

public abstract class Model {
	private static int _id = 0;
    private String href;
    private String name;
    private int id;
    private String description;
    private List<String> eventRelated = new LinkedList<String>();
    private List<String> festivalRelated = new LinkedList<String>();
    private List<String> periodRelated = new LinkedList<String>();
    private List<String> personRelated = new LinkedList<String>();
    private List<String> placeRelated = new LinkedList<String>();
    
    public Model() {
    	this.id = _id;
    	_id++;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
    public void setInfo() throws Exception {}
	public int getId() {
		return id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFestivalRelated() {
		String rs = "";
		for(String i: festivalRelated) {
			rs = rs + i+", ";
		}
		return rs;
	}
	public void setFestivalRelated(List<String> festivalRelated) {
		this.festivalRelated = festivalRelated;
	}
	public String getEventRelated() {
		String rs = "";
		for(String i: eventRelated) {
			rs = rs + i+", ";
		}
		return rs;
	}
	public void setEventRelated(List<String> eventRelated) {
		this.eventRelated = eventRelated;
	}
	public String getPeriodRelated() {
		String rs = "";
		for(String i: periodRelated) {
			rs = rs + i+", ";
		}
		return rs;
	}
	public void setPeriodRelated(List<String> periodRelated) {
		this.periodRelated = periodRelated;
	}
	public String getPersonRelated() {
		String rs = "";
		for(String i: personRelated) {
			rs = rs + i+", ";
		}
		return rs;
	}
	public void setPersonRelated(List<String> personRelated) {
		this.personRelated = personRelated;
	}
	public String getPlaceRelated() {
		String rs = "";
		for(String i: placeRelated) {
			rs = rs + i+", ";
		}
		return rs;
	}
	public void setPlaceRelated(List<String> placeRelated) {
		this.placeRelated = placeRelated;
	}
}
