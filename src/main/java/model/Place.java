package model;



import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import crawler.Crawler;

public class Place extends Model{
    private String national;
    private String location;
    private String coordinates;
    private String area;

    public Place(String name, String href) {
        this.setName(name);
        this.setHref(href);
    }
    
    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public void setInfo() throws IOException {
        Document document = Jsoup.connect(Crawler.URI + this.getHref()).timeout(0).get();
        HashMap<String, String> infoKV = new HashMap<>();
        try {
            Element infoElement = document.getElementsByClass("infobox").get(1);
            Elements trElements = infoElement.getElementsByTag("tr");
            for (Element tr : trElements) {
                infoKV.put(tr.getElementsByTag("th").text().trim(),
                        tr.getElementsByTag("td").text().trim());
            }
        } catch (Exception e) {
            System.out.println("Không có thông tin địa danh "+ this.getName() + ". " + e);
        }
        this.setNational(infoKV.get("Quốc gia"));
//        if (!infoKV.get("Vị trí").isEmpty()) this.setLocation(infoKV.get("Vị trí"));
//        if (!infoKV.get("Địa điểm").isEmpty()) this.setLocation(infoKV.get("Địa điểm"));
//        if (!infoKV.get("Khu vực").isEmpty()) this.setLocation(infoKV.get("Khu vực"));
//        if (!infoKV.get("Địa chỉ").isEmpty()) this.setLocation(infoKV.get("Địa chỉ"));
        this.setCoordinates(infoKV.get("Tọa độ"));
        this.setArea(infoKV.get("Diện tích"));
    }
    
	public static LinkedList<Place> readFileJson()
	{
		LinkedList<Place> placeObjectList = new LinkedList<Place>();
		JSONParser jsonParser = new JSONParser();
		try {
			FileReader reader = new FileReader("src\\main\\resources\\storage\\place.json");
			Object obj = jsonParser.parse(reader);
			JSONArray placeList = (JSONArray) obj;
			for(Object place: placeList) {
				placeObjectList.add(parsePlaceObject((JSONObject)place));
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
		return placeObjectList;
	}
	private static Place parsePlaceObject(JSONObject place) {
		String name = (String) place.get("name");
		String href = (String) place.get("href");
		return new Place(name, href);
	}
}
