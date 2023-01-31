package model;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import crawler.Crawler;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Person extends Model{
    private String period;
    private String birth;
    private String death;
    private String reignTime;
    private String predecessor;
    private String successor;
    private String aliases;
    private String realName;

    private List<Person> personList = new ArrayList<Person>();

    public Person() {
    }

    public Person(String name, String href, String period) {
        this.setPeriod(period);
        this.setName(name);
        this.setHref(href);
    }


    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getDeath() {
        return death;
    }

    public void setDeath(String death) {
        this.death = death;
    }

    public String getReignTime() {
        return reignTime;
    }

    public void setReignTime(String reignTime) {
        this.reignTime = reignTime;
    }

    public String getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(String predecessor) {
        this.predecessor = predecessor;
    }

    public String getSuccessor() {
        return successor;
    }

    public void setSuccessor(String successor) {
        this.successor = successor;
    }

    public String getAliases() {
        return aliases;
    }

    public void setAliases(String aliases) {
        this.aliases = aliases;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
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
            System.out.println("Không có thông tin nhân vật "+ this.getName() + ". " + e);
        }
        this.setBirth(infoKV.get("Sinh"));
        this.setDeath(infoKV.get("Mất"));
        this.setAliases(infoKV.get("Niên hiệu"));
        this.setPredecessor(infoKV.get("Tiền nhiệm"));
        this.setSuccessor(infoKV.get("Kế nhiệm"));
        this.setReignTime(infoKV.get("Trị vì"));
        this.setRealName(infoKV.get("Tên thật"));
    }
    
	public static LinkedList<Person> readFileJson()
	{
		LinkedList<Person>personObjectList = new LinkedList<Person>();
		JSONParser jsonParser = new JSONParser();
		try {
			FileReader reader = new FileReader("src\\main\\resources\\storage\\person.json");
			Object obj = jsonParser.parse(reader);
			JSONArray personList = (JSONArray) obj;
			for(Object person:personList) {
				personObjectList.add(parsePersonObject((JSONObject) person));
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
		return personObjectList;
	}
	private static Person parsePersonObject(JSONObject person) {
		String name = (String) person.get("name");
		String href = (String) person.get("href");
		String period = (String) person.get("period");
		return new Person(name, href, period);
	}
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

