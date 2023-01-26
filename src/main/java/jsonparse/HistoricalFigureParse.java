package jsonparse;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import model.HistoricalFigure;

public class HistoricalFigureParse {
	private static LinkedList<HistoricalFigure> HistoricalFigureObjectList = new LinkedList<HistoricalFigure>();
	public static LinkedList<HistoricalFigure> readFileJson()
	{
		HistoricalFigureObjectList.clear();;
		JSONParser jsonParser = new JSONParser();
		try {
			FileReader reader = new FileReader("src\\main\\resources\\storage\\historicalFigures.json");
			Object obj = jsonParser.parse(reader);
			JSONArray HistoricalFigureList = (JSONArray) obj;
			HistoricalFigureList.forEach(HistoricalFigure -> parseHistoricalFigureObject((JSONObject) HistoricalFigure));
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
		return HistoricalFigureObjectList;
	}
	private static void parseHistoricalFigureObject(JSONObject HistoricalFigure) {
		String name = (String) HistoricalFigure.get("name");
		String source = (String) HistoricalFigure.get("source");
		String position = (String) HistoricalFigure.get("position");
		String time = (String) HistoricalFigure.get("time");
		String story = (String) HistoricalFigure.get("story");
		HistoricalFigureObjectList.add(new HistoricalFigure(name, source, "HistoricalFigure",position ,time, story));
	}
}
