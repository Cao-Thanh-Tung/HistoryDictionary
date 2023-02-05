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
				+ createPair("description", event.getDescription())+",\n"
				+ createPair("thoiGian", event.getThoiGian())+",\n"
				+ createPair("diaDiem", event.getDiaDiem())+",\n"
				+ createPair("ketQua", event.getKetQua())+",\n"
				+ createPair("thamChien", event.getThamChien())+",\n"
				+ createPair("chiHuy", event.getChiHuy())+",\n"
				+ createPair("lucLuong", event.getLucLuong())+",\n"
				+ createPair("tonThat", event.getTonThat())+",\n"
				+ createPair("eventRelated", event.getEventRelated())+",\n"
				+ createPair("festivalRelated", event.getFestivalRelated())+",\n"
				+ createPair("periodRelated", event.getPeriodRelated())+",\n"
				+ createPair("personRelated", event.getPersonRelated())+",\n"
				+ createPair("placeRelated", event.getPlaceRelated())+"\n"
				+ "}";
		return json;
	}
	private static String parseFestivalToJson(Festival festival) {
		String json = "{\n"
				+ createPair("name",festival.getName())+",\n"
				+ createPair("href", festival.getHref())+",\n"
				+ createPair("description", festival.getDescription())+",\n"
				+ createPair("ngayBatDau", festival.getNgayBatDau())+",\n"
				+ createPair("viTri", festival.getViTri())+",\n"
				+ createPair("lanDauToChuc", festival.getLanDauToChuc())+",\n"
				+ createPair("nhanVatLienQuan", festival.getNhanVatLienQuan())+",\n"
				+ createPair("ghiChu", festival.getGhiChu())+",\n"
				+ createPair("eventRelated", festival.getEventRelated())+",\n"
				+ createPair("festivalRelated", festival.getFestivalRelated())+",\n"
				+ createPair("periodRelated", festival.getPeriodRelated())+",\n"
				+ createPair("personRelated", festival.getPersonRelated())+",\n"
				+ createPair("placeRelated", festival.getPlaceRelated())+"\n"
				+ "}";
		return json;
	}
	private static String parsePeriodToJson(Period period) {
		String json = "{\n"
				+ createPair("name",period.getName())+",\n"
				+ createPair("href", period.getHref())+",\n"
				+ createPair("description", period.getDescription())+",\n"
				+ createPair("time", period.getTime())+",\n"
				+ createPair("eventRelated", period.getEventRelated())+",\n"
				+ createPair("festivalRelated", period.getFestivalRelated())+",\n"
				+ createPair("periodRelated", period.getPeriodRelated())+",\n"
				+ createPair("personRelated", period.getPersonRelated())+",\n"
				+ createPair("placeRelated", period.getPlaceRelated())+"\n"
				+ "}";
		return json;
	}
	private static String parsePersonToJson(Person person) {
		String json = "{\n"
				+ createPair("name",person.getName())+",\n"
				+ createPair("href", person.getHref())+",\n"
				+ createPair("realName",person.getRealName())+",\n"
				+ createPair("tenHuy", person.getTenHuy())+",\n"
				+ createPair("mieuHieu", person.getMieuHieu())+",\n"
				+ createPair("nienHieu", person.getNienHieu())+",\n"
				+ createPair("thuyHieu", person.getThuyHieu())+",\n"
				+ createPair("anTang", person.getAnTang())+",\n"
				+ createPair("father", person.getFather())+",\n"
				+ createPair("mother", person.getMother())+",\n"
				+ createPair("theThiep", person.getTheThiep())+",\n"
				+ createPair("children", person.getChildrens())+",\n"
				+ createPair("period", person.getPeriod())+",\n"	
				+ createPair("birth", person.getBirth())+",\n"	
				+ createPair("death", person.getDeath())+",\n"	
				+ createPair("reignTime", person.getReignTime())+",\n"	
				+ createPair("nhiepChinh", person.getNhiepChinh())+",\n"
				+ createPair("predecessor", person.getPredecessor())+",\n"	
				+ createPair("successor", person.getSuccessor())+",\n"	
				+ createPair("role", person.getRole())+",\n"
				+ createPair("tonGiao", person.getTonGiao())+",\n"
				+ createPair("description", person.getDescription())+",\n"
				+ createPair("eventRelated", person.getEventRelated())+",\n"
				+ createPair("festivalRelated", person.getFestivalRelated())+",\n"
				+ createPair("periodRelated", person.getPeriodRelated())+",\n"
				+ createPair("personRelated", person.getPersonRelated())+",\n"
				+ createPair("placeRelated", person.getPlaceRelated())+"\n"
				+ "}";
		return json;
	}
	private static String parsePlaceToJson(Place place) {
		String json = "{\n"
				+ createPair("name",place.getName())+",\n"
				+ createPair("href", place.getHref())+",\n"
				+ createPair("description", place.getDescription())+",\n"
				+ createPair("toaDo", place.getToaDo())+",\n"
				+ createPair("viTri", place.getViTri())+",\n"
				+ createPair("dienTich", place.getDienTich())+",\n"
				+ createPair("chieuCao", place.getChieuCao())+",\n"
				+ createPair("thoiGianXayDung", place.getThoiGianXayDung())+",\n"
				+ createPair("danSo", place.getDanSo())+",\n"
				+ createPair("matDo", place.getMatDo())+",\n"
				+ createPair("quocGia", place.getQuocGia())+",\n"
				+ createPair("tinh", place.getTinh())+",\n"
				+ createPair("huyen", place.getHuyen())+",\n"
				+ createPair("maHanhChinh", place.getMaHanhchinh())+",\n"
				+ createPair("leHoi", place.getLehoi())+",\n"
				+ createPair("nguon", place.getNguon())+",\n"
				+ createPair("phuLuu", place.getPhuLuu())+",\n"
				+ createPair("chieuDai", place.getChieudai())+",\n"
				+ createPair("luuLuong", place.getLuuLuong())+",\n"
				+ createPair("doSau", place.getDoSau())+",\n"
				+ createPair("eventRelated", place.getEventRelated())+",\n"
				+ createPair("festivalRelated", place.getFestivalRelated())+",\n"
				+ createPair("periodRelated", place.getPeriodRelated())+",\n"
				+ createPair("personRelated", place.getPersonRelated())+",\n"
				+ createPair("placeRelated", place.getPlaceRelated())+"\n"
				+ "}";
		return json;
	}
	private static String createPair(String key, String value) {
		if(value != null) {	
			String newValue = value.replace("\"","\\\"");
			return "\t\""+key+"\": "+ "\""+newValue+"\"";
		}else {			
			return "\t\""+key+"\": null";
		}
	}
}
