package model;

import java.util.LinkedList;
import java.util.List;

public abstract class Model {
	private static int _id = 0;
    private String href;
    private String name;
    private int id;
    private String description;
    private List<Model> objectRelated = new LinkedList<Model>();
    public Model() {
    	this.id = _id;
    	_id++;
    }
    public String getName() {
        return name;
    }
    public void addAllModelRelated(List<Model> items) {
    	objectRelated.addAll(items);
    }
    public void addModelRelated(Model item) {
    	objectRelated.add(item);
    }
    public List<Model> getModelRelated(){
    	return this.objectRelated;
    }
    public List<Event> getEventRelated(){
    	List<Event> eventList = new LinkedList<Event>();
    	for(Model item:objectRelated) {
    		if(item instanceof Event) {
    			eventList.add((Event)item);
    		}
    	}
    	return eventList;
    }
    public List<Festival> getFestivalRelated(){
    	List<Festival> festivalList = new LinkedList<Festival>();
    	for(Model item:objectRelated) {
    		if(item instanceof Festival) {
    			festivalList.add((Festival)item);
    		}
    	}
    	return festivalList;
    }
    public List<Place> getPlaceRelated(){
    	List<Place> placeList = new LinkedList<Place>();
    	for(Model item:objectRelated) {
    		if(item instanceof Place) {
    			placeList.add((Place)item);
    		}
    	}
    	return placeList;
    }
    public List<Period> getPeriodRelated(){
    	List<Period> periodList = new LinkedList<Period>();
    	for(Model item:objectRelated) {
    		if(item instanceof Period) {
    			periodList.add((Period)item);
    		}
    	}
    	return periodList;
    }
    public List<Person> getPersonRelated(){
    	List<Person> personList = new LinkedList<Person>();
    	for(Model item:objectRelated) {
    		if(item instanceof Person) {
    			personList.add((Person)item);
    		}
    	}
    	return personList;
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
}
