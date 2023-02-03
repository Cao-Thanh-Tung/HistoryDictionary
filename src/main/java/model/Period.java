package model;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import crawler.Crawler;


public class Period extends Model{
	// Tom tat giai doan lich su
	// Cac doi vua
    public Period() {
    }
    public Period(String name, String href) {
        this.setName(name);
        this.setHref(href);
    }
    /**
     * Tìm và lưu danh sách nhân vật lịch sử có liên quan đến thời kỳ lịch sử
     * @throws IOException
     */
    @Override
    public void setInfo() throws IOException {
        Document document = Jsoup.connect(Crawler.URI + this.getHref()).get();
        Elements periodElements = document.getElementsByAttributeValue("class", "readmore");
        if (!periodElements.isEmpty()) {
            for (Element periodE : periodElements) {
                try {
                    Element subPeriod = periodE.getElementsByAttributeValue("class", "btn btn-secondary").get(0);
                    Document subDoc = Jsoup.connect(Crawler.URI + subPeriod.attr("href")).get();
                    Element content = subDoc.getElementsByClass("com-content-article__body").get(0);
                    Elements listHref = content.getElementsByTag("a");
                    for (Element hrefNode : listHref) {

                        // Nếu là link thông tin nhân vật
                        if (hrefNode.attr("href").contains("/nhan-vat/")) {
                            Person person = new Person(hrefNode.text(), this.getHref());
                            boolean isExisted = false;
                            for (Person p : this.getPersonRelated()) {
                                if(p.getHref().equals(person.getHref())) {
                                    isExisted = true;
                                    break;
                                }
                            }
                            if (!isExisted) this.addModelRelated(person);
                        }

                        // Nếu là link thông tin địa danh
                        if (hrefNode.attr("href").contains("/dia-danh/")) {
                            Place place = new Place(hrefNode.text(), hrefNode.attr("href"));
                            boolean isExisted = false;
                            for (Place p : this.getPlaceRelated()) {
                                if(p.getHref().equals(place.getHref())) {
                                    isExisted = true;
                                    break;
                                }
                            }
                            if (!isExisted) this.addModelRelated(place);
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Không tìm thấy thông tin nhân vật, địa danh nào. " + e);
                }
                    }

            }
        }
    

    public String toJson() {

        return null;
    }
    
	public static LinkedList<Period> readFileJson()
	{
		LinkedList<Period> periodObjectList = new LinkedList<Period>();
		JSONParser jsonParser = new JSONParser();
		try {
			FileReader reader = new FileReader("src\\main\\resources\\storage\\period.json");
			Object obj = jsonParser.parse(reader);
			JSONArray periodList = (JSONArray) obj;
			for(Object period: periodList) {
				periodObjectList.add(parsePeriodObject((JSONObject)period));
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
		return periodObjectList;
	}
	private static Period parsePeriodObject(JSONObject period) {
		String name = (String) period.get("name");
		String href = (String) period.get("href");

		return new Period(name, href);
	}
}

