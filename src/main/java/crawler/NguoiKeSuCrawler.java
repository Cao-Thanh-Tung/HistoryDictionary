package crawler;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import model.Event;
import model.Festival;
import model.Model;
import model.Period;
import model.Person;
import model.Place;
import service.ServiceWriteJson;

public class NguoiKeSuCrawler {
	public static List<String> links = new LinkedList<String>();
	public static String rootURL = "https://nguoikesu.com";
	public static List<Event> listEvent = new LinkedList<Event>();
	public static List<Festival> listFestival = new LinkedList<Festival>();
	public static List<Period> listPeriod = new LinkedList<Period>();
	public static List<Person> listPerson = new LinkedList<Person>();
	public static List<Place> listPlace = new LinkedList<Place>();
	public static void main(String[] args) throws IOException {
		System.out.println("Bat dau:");
		Document doc = Jsoup.connect(rootURL).timeout(0).get();
		String tmplink="";
		Elements listATag = doc.select("a");
		for (Element aTag : listATag) {
			tmplink = aTag.attr("href");
			if(!tmplink.contains("http") && (tmplink.contains("/dong-lich-su") || tmplink.contains("/tu-lieu") || tmplink.contains("/nhan-vat") || tmplink.contains("/dia-danh")) && !tmplink.contains(".") && !tmplink.contains("#") && !tmplink.contains("?") && links.indexOf(tmplink) == -1) {			
				System.out.println(tmplink);
				links.add(tmplink);
			}
		}
		int nextIndex = 0;
		while(nextIndex < links.size()) {			
			String link = links.get(nextIndex);
			try {
			doc = Jsoup.connect(rootURL+link).timeout(0).get();
			listATag = doc.select("a");
			for (Element aTag : listATag) {
				tmplink = aTag.attr("href");
				if(!tmplink.contains("http") && (tmplink.contains("/dong-lich-su") || tmplink.contains("/tu-lieu") || tmplink.contains("/nhan-vat") || tmplink.contains("/dia-danh")) && !tmplink.contains(".") && !tmplink.contains("#") && !tmplink.contains("?") && links.indexOf(tmplink) == -1) {			
					links.add(tmplink);
				}
			}
			}catch(IOException e) {
				
			}
			nextIndex = nextIndex+1;
			System.out.println(nextIndex);
		}
		
		int c = 0;
		for(String link:links) {
			c++;
			System.out.println(c);
			if(link.contains("/nhan-vat/")) {
//				try {
//					doc = Jsoup.connect(rootURL+link).timeout(0).get();
//					Elements infobox = doc.select("table.infobox");
//					System.out.println(infobox);
//					}catch(IOException e) {
//						
//					};
				try {
					doc = Jsoup.connect(rootURL+link).get();
					Element title = doc.getElementsByTag("title").get(0);
					String name = title.text();
					name = name.replace("- Người Kể Sử", "");
					Person place = new Person(name, link);
					Elements scriptTags = doc.select("script[data-type*=gsd]");
					if(scriptTags.size() == 2) {
						Element scriptTag = scriptTags.get(1);
						String jsonString = scriptTag.data();
						JSONParser parser = new JSONParser();
						JSONObject json = (JSONObject) parser.parse(jsonString);
						String description = (String) json.get("description");
						place.setDescription(description);
					}
					listPerson.add(place);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(link.contains("/dia-danh/")) {
				try {
					doc = Jsoup.connect(rootURL+link).get();
					Element title = doc.getElementsByTag("title").get(0);
					String name = title.text();
					name = name.replace("- Người Kể Sử", "");
					Place place = new Place(name, link);
					Elements scriptTags = doc.select("script[data-type*=gsd]");
					if(scriptTags.size() == 2) {
						Element scriptTag = scriptTags.get(1);
						String jsonString = scriptTag.data();
						JSONParser parser = new JSONParser();
						JSONObject json = (JSONObject) parser.parse(jsonString);
						String description = (String) json.get("description");
						place.setDescription(description);
					}
					listPlace.add(place);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(link.contains("/tu-lieu/quan-su/")) {
				try {
					doc = Jsoup.connect(rootURL+link).get();
					Element title = doc.getElementsByTag("title").get(0);
					String name = title.text();
					name = name.replace("- Người Kể Sử", "");
					Event place = new Event(name, link);
					Elements scriptTags = doc.select("script[data-type*=gsd]");
					if(scriptTags.size() == 2) {
						Element scriptTag = scriptTags.get(1);
						String jsonString = scriptTag.data();
						JSONParser parser = new JSONParser();
						JSONObject json = (JSONObject) parser.parse(jsonString);
						String description = (String) json.get("description");
						place.setDescription(description);
					}
					listEvent.add(place);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(link.contains("/dong-lich-su/")) {
				try {
					doc = Jsoup.connect(rootURL+link).get();
					Element title = doc.getElementsByTag("title").get(0);
					String name = title.text();
					name = name.replace("- Người Kể Sử", "");
					Period place = new Period(name, link);
					Elements scriptTags = doc.select("script[data-type*=gsd]");
					if(scriptTags.size() == 2) {
						Element scriptTag = scriptTags.get(1);
						String jsonString = scriptTag.data();
						JSONParser parser = new JSONParser();
						JSONObject json = (JSONObject) parser.parse(jsonString);
						String description = (String) json.get("description");
						place.setDescription(description);
					}
					listPeriod.add(place);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
		System.out.println(links.size());
		ServiceWriteJson.writeJsonToFile(listEvent, "src\\main\\resources\\storage\\event.json");
		ServiceWriteJson.writeJsonToFile(listPeriod, "src\\main\\resources\\storage\\period.json");
		ServiceWriteJson.writeJsonToFile(listPerson, "src\\main\\resources\\storage\\person.json");
		ServiceWriteJson.writeJsonToFile(listPlace, "src\\main\\resources\\storage\\place.json");
		System.out.println("Ket thuc");
	}
}