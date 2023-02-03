package model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Festival extends Model {
	public Festival(String name, String href) {
		this.setName(name);
		this.setHref(href);
	}
	public static LinkedList<Festival> readFileJson()
	{
		LinkedList<Festival> festivalObjectList = new LinkedList<Festival>();
		JSONParser jsonParser = new JSONParser();
		try {
			FileReader reader = new FileReader("src\\main\\resources\\storage\\festival.json");
			Object obj = jsonParser.parse(reader);
			JSONArray festivalList = (JSONArray) obj;
			for(Object festival: festivalList) {
				festivalObjectList.add(parseFestivalObject((JSONObject)festival));
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
		return festivalObjectList;
	}
	private static Festival parseFestivalObject(JSONObject Festival) {
		String name = (String) Festival.get("name");
		String href = (String) Festival.get("href");
		return new Festival(name, href);
	}
}
