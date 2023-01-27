package frontend.jsonparse;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import frontend.model.Event;

public class EventParse {
	private static LinkedList<Event> EventObjectList = new LinkedList<Event>();
	public static LinkedList<Event> readFileJson()
	{
		EventObjectList.clear();;
		JSONParser jsonParser = new JSONParser();
		try {
			FileReader reader = new FileReader("src\\main\\resources\\storage\\event.json");
			Object obj = jsonParser.parse(reader);
			JSONArray EventList = (JSONArray) obj;
			EventList.forEach(Event -> parseEventObject((JSONObject) Event));
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
		return EventObjectList;
	}
	private static void parseEventObject(JSONObject Event) {
		String name = (String) Event.get("name");
		String source = (String) Event.get("source");
		String time = (String) Event.get("time");
		String story = (String) Event.get("story");
		EventObjectList.add(new Event(name, source, time, story));
	}
}
