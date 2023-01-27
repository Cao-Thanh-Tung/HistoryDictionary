package frontend.jsonparse;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import frontend.model.People;

public class PeopleParse {
	private static LinkedList<People> peopleObjectList = new LinkedList<People>();
	public static LinkedList<People> readFileJson()
	{
		peopleObjectList.clear();;
		JSONParser jsonParser = new JSONParser();
		try {
			FileReader reader = new FileReader("src\\main\\resources\\storage\\people.json");
			Object obj = jsonParser.parse(reader);
			JSONArray peopleList = (JSONArray) obj;
			peopleList.forEach(people -> parsePeopleObject((JSONObject) people));
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
		return peopleObjectList;
	}
	private static void parsePeopleObject(JSONObject people) {
		String name = (String) people.get("name");
		String source = (String) people.get("source");
		String position = (String) people.get("position");
		String time = (String) people.get("time");
		String story = (String) people.get("story");
		peopleObjectList.add(new People(name, source,position ,time, story));
	}
}
