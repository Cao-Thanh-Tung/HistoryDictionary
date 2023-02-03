package crawler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;

import model.Period;
import model.Person;
import model.Place;

public class Crawler {
    public static final ObjectMapper mapper = new ObjectMapper();
    public static final ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
    public static final ObjectReader reader = mapper.reader();
    public static final String URI = "https://nguoikesu.com";
    public static final String TIMELINE_HREF = "/dong-lich-su";

    public static void main(String[] args) throws IOException {
        writer.writeValue(new File("src/main/resources/storage/person.json"), new ArrayList<Person>());
        writer.writeValue(new File("src/main/resources/storage/place.json"), new ArrayList<Place>());
        writer.writeValue(new File("src/main/resources/storage/period.json"), new ArrayList<Period>());
        // Tạo document từ url dòng lịch sử
        Document document = Jsoup.connect(URI + TIMELINE_HREF).get();
        System.out.println(document);
        Element mainContext = document.getElementById("Mod88");
        mainContext = mainContext.getElementsByClass("module-ct").first();

        // Crawler các thời kỳ lịch sử
        List<Period> periods = new ArrayList<>();
        Elements periodEs = mainContext.getElementsByTag("li");
        System.out.println(periodEs);
        for (Element periodE:periodEs) {
            String source = periodE.getElementsByTag("a").attr("source");
            String name = periodE.getElementsByTag("a").text();
            Period period = new Period(name,source);
            System.out.println(source);
            period.setInfo();
            
			
            
            System.out.println("=>" + period.getName());
            for (Person person:period.getPersonRelated()) {
                person.setInfo();
            }
            List<Person> listPerson = Arrays.asList(reader.readValue(new File("src/main/resources/storage/person.json"), Person[].class));
            List<Person> people = new ArrayList<>(listPerson);
            people.addAll(period.getPersonRelated());
            writer.writeValue(new File("src/main/resources/storage/person.json"), people);
            for (Place place:period.getPlaceRelated()) {
                place.setInfo();
            }
            List<Place> listPlace = Arrays.asList(reader.readValue(new File("src/main/resources/storage/place.json"), Place[].class));
            List<Place> places = new ArrayList<>(listPlace);
            places.addAll(period.getPlaceRelated());
            writer.writeValue(new File("src/main/resources/storage/place.json"), places);
            periods.add(period);
        	

        }
        writer.writeValue(new File("src/main/resources/storage/period.json"), periods);
    }
}
