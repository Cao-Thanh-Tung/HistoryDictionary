package jsonparse;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import model.Festival;

public class FestivalParse {
	private static LinkedList<Festival> FestivalObjectList = new LinkedList<Festival>();
	public static LinkedList<Festival> readFileJson()
	{
		FestivalObjectList.clear();;
		JSONParser jsonParser = new JSONParser();
		try {
			FileReader reader = new FileReader("src\\main\\resources\\storage\\festivals.json");
			Object obj = jsonParser.parse(reader);
			JSONArray FestivalList = (JSONArray) obj;
			FestivalList.forEach(Festival -> parseFestivalObject((JSONObject) Festival));
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
		return FestivalObjectList;
	}
	private static void parseFestivalObject(JSONObject Festival) {
		String name = (String) Festival.get("name");
		String source = (String) Festival.get("source");
		String time = (String) Festival.get("time");
		String story = (String) Festival.get("story");
		String address = (String) Festival.get("address");
		FestivalObjectList.add(new Festival(name, source, "Festival", time, address, story));
	}
}
