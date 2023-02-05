package crawler;

import java.util.LinkedList;
import java.util.List;

import model.Event;
import model.Festival;
import model.Model;
import model.Period;
import model.Person;
import model.Place;
import service.ServiceWriteJson;

public class MainCrawler {
	public static void main(String[] args) {
		crawl();
	}
	public static void crawl() {
		List<Model> modelCrawledList = new LinkedList<Model>();
		List<ICrawler> crawlerList= new LinkedList<ICrawler>();
		crawlerList.add(new NguoiKeSuCrawler());
		crawlerList.add(new WikipediaCrawler());		
		for(ICrawler crawler: crawlerList) {
			modelCrawledList.addAll(crawler.crawl());
		}
		
		List<Event> eventCrawledList = new LinkedList<Event>();
		List<Festival> festivalCrawledList = new LinkedList<Festival>();
		List<Period> periodCrawledList = new LinkedList<Period>();
		List<Person> personCrawledList = new LinkedList<Person>();
		List<Place> placeCrawledList = new LinkedList<Place>();
		for(Model model: modelCrawledList) {
			if(model instanceof Event) {
				eventCrawledList.add((Event)model);
			}else if(model instanceof Festival) {
				festivalCrawledList.add((Festival)model);
			}else if(model instanceof Period) {
				periodCrawledList.add((Period)model);
			}else if(model instanceof Person) {
				personCrawledList.add((Person) model);
			}else {
				placeCrawledList.add((Place) model);
			}
		}

		for(int i = 0; i < periodCrawledList.size(); i++) {
			Period a = periodCrawledList.get(i);
			String nameA = a.getName();
			for(int j = i; j <  periodCrawledList.size(); j++) {
				Period b = periodCrawledList.get(j);
				String nameB = b.getName();
				if(nameA.equalsIgnoreCase(nameB)) {
					if(a.getDescription() == null) {
						a.setDescription(b.getDescription());
					}
					if(a.getTime() == null) {
						a.setTime(b.getTime());
					}
					periodCrawledList.remove(b);
					j--;
				}
			}
		}
		
		ServiceWriteJson.writeJsonToFile(personCrawledList, "src\\main\\resources\\storage\\person.json");
		ServiceWriteJson.writeJsonToFile(eventCrawledList, "src\\main\\resources\\storage\\event.json");
		ServiceWriteJson.writeJsonToFile(placeCrawledList, "src\\main\\resources\\storage\\place.json");
		ServiceWriteJson.writeJsonToFile(festivalCrawledList, "src\\main\\resources\\storage\\festival.json");
		ServiceWriteJson.writeJsonToFile(periodCrawledList, "src\\main\\resources\\storage\\period.json");
		
	}
}
