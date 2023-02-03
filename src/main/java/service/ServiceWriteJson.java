package service;

import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;

import model.Event;
import model.Festival;
import model.Model;
import model.Period;
import model.Person;
import model.Place;

public class ServiceWriteJson {
	public static void main(String[] args) {
		List listObject = new LinkedList();
		listObject.add(new Person("a","b"));
		listObject.add(new Person("d","c"));
		writeJsonToFile(listObject, "src\\main\\resources\\storage\\person.json");
	}
	public static void writeJsonToFile(List listObject, String srcStorage) {
		try {
            FileWriter fw = new FileWriter(srcStorage);
            int count = 0;
            fw.write("[");
            for(Object model: listObject) { 
            	fw.write(convertToJsonString(model));
            	if(count < listObject.size()-1) {
            		fw.write(",");
            	}
            	fw.write("\n");
            	count++;
            }
           
            fw.write("]");
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Success...");
	}
	public static String convertToJsonString(Object model) {
		String json="";
		if(model instanceof Event) {
			json = parseEventToJson((Event) model);
		}else if(model instanceof Festival) {
			json = parseFestivalToJson((Festival) model);
		}else if(model instanceof Period) {
			json = parsePeriodToJson((Period) model);
		}else if(model instanceof Person) {
			json = parsePersonToJson((Person) model);
		}else {
			json = parsePlaceToJson((Place) model); 
		}
		return json;
	}
	private static String parseEventToJson(Event event) {
		String json = "{\n"
				+ createPair("name",event.getName())+",\n"
				+ createPair("href", event.getHref())+",\n"
				+ createPair("description", event.getDescription())+"\n"
				+ "}";
		return json;
	}
	private static String parseFestivalToJson(Festival festival) {
		return "";
	}
	private static String parsePeriodToJson(Period period) {
		String json = "{\n"
				+ createPair("name",period.getName())+",\n"
				+ createPair("href", period.getHref())+",\n"
				+ createPair("description", period.getDescription())+"\n"
				+ "}";
		return json;
	}
	private static String parsePersonToJson(Person person) {
		String json = "{\n"
				+ createPair("name",person.getName())+",\n"
				+ createPair("href", person.getHref())+",\n"
				+ createPair("realName",person.getRealName())+",\n"
				+ createPair("aliases", person.getAliases())+",\n"
				+ createPair("period", person.getPeriod())+",\n"	
				+ createPair("birth", person.getBirth())+",\n"	
				+ createPair("death", person.getDeath())+",\n"	
				+ createPair("reignTime", person.getReignTime())+",\n"	
				+ createPair("predecessor", person.getPredecessor())+",\n"	
				+ createPair("successor", person.getSuccessor())+",\n"	
				+ createPair("role", person.getRole())+",\n"
				+ createPair("description", person.getDescription())+"\n"
				+ "}";
		return json;
	}
	private static String parsePlaceToJson(Place place) {
		String json = "{\n"
				+ createPair("name",place.getName())+",\n"
				+ createPair("href", place.getHref())+",\n"
				+ createPair("description", place.getDescription())+"\n"
				+ "}";
		return json;
	}
	private static String createPair(String key, String value) {
		if(value != null) {			
			return "\t\""+key+"\": "+ "\""+value+"\"";
		}else {			
			return "\t\""+key+"\": null";
		}
	}
}
