package frontend.jsonparse;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import frontend.model.Period;


public class PeriodParse {
	private static LinkedList<Period> periodObjectList = new LinkedList<Period>();
	public static LinkedList<Period> readFileJson()
	{
		periodObjectList.clear();;
		JSONParser jsonParser = new JSONParser();
		try {
			FileReader reader = new FileReader("src\\main\\resources\\storage\\period.json");
			Object obj = jsonParser.parse(reader);
			JSONArray periodList = (JSONArray) obj;
			periodList.forEach(period -> parsePeriodObject((JSONObject) period));
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
		return periodObjectList;
	}
	private static void parsePeriodObject(JSONObject period) {
		String name = (String) period.get("name");
		String source = (String) period.get("source");
		String time = (String) period.get("time");
		String story = (String) period.get("story");
		periodObjectList.add(new Period(name, source, time, story));
	}
}
