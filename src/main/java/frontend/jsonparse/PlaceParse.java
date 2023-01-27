package frontend.jsonparse;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import frontend.model.Place;

public class PlaceParse {
	private static LinkedList<Place> HistoricalSiteObjectList = new LinkedList<Place>();
	public static LinkedList<Place> readFileJson()
	{
		HistoricalSiteObjectList.clear();;
		JSONParser jsonParser = new JSONParser();
		try {
			FileReader reader = new FileReader("src\\main\\resources\\storage\\place.json");
			Object obj = jsonParser.parse(reader);
			JSONArray HistoricalSiteList = (JSONArray) obj;
			HistoricalSiteList.forEach(HistoricalSite -> parseHistoricalSiteObject((JSONObject) HistoricalSite));
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
		return HistoricalSiteObjectList;
	}
	private static void parseHistoricalSiteObject(JSONObject HistoricalSite) {
		String name = (String) HistoricalSite.get("name");
		String source = (String) HistoricalSite.get("source");
		String address = (String) HistoricalSite.get("address");
		String story = (String) HistoricalSite.get("story");
		HistoricalSiteObjectList.add(new Place(name, source, address, story));
	}
}