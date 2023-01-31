package controller;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.Event;
import model.Festival;
import model.Model;
import model.Person;
import model.Period;
import model.Place;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class ServiceSearch extends Service<LinkedList<Model>> {
    private String keyword;
    private LinkedList<Period> periodList;
    private LinkedList<Event> eventList;
    private LinkedList<Festival> festivalList;
    private LinkedList<Person> personList;
    private LinkedList<Place> placeList;
    private boolean typeFilter[] = new boolean[6]; 
    public ServiceSearch() {
    	periodList = Period.readFileJson();
    	eventList = Event.readFileJson();
    	festivalList = Festival.readFileJson();
    	personList = Person.readFileJson();
    	placeList = Place.readFileJson();
    }
    
	@Override
    protected Task<LinkedList<Model>> createTask() {
        return new Task<LinkedList<Model>>() {
            @Override
            protected LinkedList<Model> call() throws Exception {
                //DO YOU HARD STUFF HERE
            	Thread.sleep(300);
                return find(keyword, typeFilter);
            }
        };
    }
    
    private LinkedList<Model> find(String keyword, boolean filter[]){
    	LinkedList<Model> matchedList = new LinkedList<Model>();
    	if(filter[0]) {
    		for(Model i: periodList) {
    			if(matched(keyword, i.getName())) {
    				matchedList.add(i);
    			}
    		};
    		for(Model i: eventList) {
    			if(matched(keyword, i.getName())) {
    				matchedList.add(i);
    			}
    		};
    		for(Model i: festivalList) {
    			if(matched(keyword, i.getName())) {
    				matchedList.add(i);
    			}
    		};    		
    		for(Model i: personList) {
    			if(matched(keyword, i.getName())) {
    				matchedList.add(i);
    			}
    		};
    		for(Model i: placeList) {
    			if(matched(keyword, i.getName())) {
    				matchedList.add(i);
    			}
    		};
    	}else {
        	if(filter[1]) {
        		for(Model i: periodList) {
        			if(matched(keyword, i.getName())) {
        				matchedList.add(i);
        			}
        		}
        	}
        	if(filter[2]) {
        		for(Model i: eventList) {
        			if(matched(keyword, i.getName())) {
        				matchedList.add(i);
        			}
        		};
        	}
        	if(filter[3]) {
        		for(Model i: festivalList) {
        			if(matched(keyword, i.getName())) {
        				matchedList.add(i);
        			}
        		};    	
        	}
        	if(filter[4]) {
        		for(Model i: personList) {
        			if(matched(keyword, i.getName())) {
        				matchedList.add(i);
        			}
        		};
        	}if(filter[5]) {
        		for(Model i: placeList) {
        			if(matched(keyword, i.getName())) {
        				matchedList.add(i);
        			}
        		};
        	}
    	}
    	return matchedList;

    }
    private boolean matched(String keyword, String title) {
        Pattern pattern = Pattern.compile(keyword, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(title);
        boolean matchFound = matcher.find();
        if(matchFound) {
          return true;
        } else {
          return false;
        }
    }
    public void search(String keyword, boolean all, boolean period, boolean event, boolean fes, boolean people, boolean place) {
    	typeFilter[0] = all;
    	typeFilter[1] = period;
    	typeFilter[2] = event;
    	typeFilter[3] = fes;
    	typeFilter[4] = people;
    	typeFilter[5] = place;
    	this.keyword = keyword;
    	this.restart();
    }
}
