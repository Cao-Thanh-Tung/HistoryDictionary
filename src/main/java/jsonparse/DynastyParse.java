package jsonparse;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import model.Dynasty;


public class DynastyParse {
	private static LinkedList<Dynasty> dynastyObjectList = new LinkedList<Dynasty>();
	public static LinkedList<Dynasty> readFileJson()
	{
		dynastyObjectList.clear();;
		JSONParser jsonParser = new JSONParser();
		try {
			FileReader reader = new FileReader("src\\main\\resources\\storage\\dynasty.json");
			Object obj = jsonParser.parse(reader);
			JSONArray dynastyList = (JSONArray) obj;
			dynastyList.forEach(dynasty -> parseDynastyObject((JSONObject) dynasty));
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
		return dynastyObjectList;
	}
	private static void parseDynastyObject(JSONObject dynasty) {
		String name = (String) dynasty.get("name");
		String source = (String) dynasty.get("source");
		String time = (String) dynasty.get("time");
		String story = (String) dynasty.get("story");
		dynastyObjectList.add(new Dynasty(name, source, "Dynasty", time, story));
	}
}
