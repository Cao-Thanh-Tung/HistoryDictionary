package model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Event extends Model {
	public Event(String name, String href) {
		this.setName(name);
		this.setHref(href);
	}
	public static LinkedList<Event> readFileJson()
	{
		LinkedList<Event> eventObjectList = new LinkedList<Event>();
		JSONParser jsonParser = new JSONParser();
		try {
			FileReader reader = new FileReader("src\\main\\resources\\storage\\event.json");
			Object obj = jsonParser.parse(reader);
			JSONArray eventList = (JSONArray) obj;
			for(Object event: eventList) {
				eventObjectList.add(parseEventObject((JSONObject) event));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eventObjectList;
	}
	private static Event parseEventObject(JSONObject Event) {
		String name = (String) Event.get("name");
		String href = (String) Event.get("href");
		return new Event(name, href);
	}
}
