package service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import model.Event;
import model.Festival;
import model.Period;
import model.Person;
import model.Place;

public class ServiceReadJson {
	public static LinkedList<Event> readFileJsonToEventList()
	{
		LinkedList<Event> eventObjectList = new LinkedList<Event>();
		JSONParser jsonParser = new JSONParser();
		try {
			FileReader reader = new FileReader("src\\main\\resources\\storage\\event.json");
			Object obj = jsonParser.parse(reader);
			JSONArray eventList = (JSONArray) obj;
			for(Object event: eventList) {
				eventObjectList.add(parseEventObject((JSONObject) event));
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
		return eventObjectList;
	}
	private static Event parseEventObject(JSONObject eventJson) {
		String name = (String) eventJson.get("name");
		String href = (String) eventJson.get("href");
		
		Event event = new Event(name, href);
		String thoiGian = (String) eventJson.get("thoiGian");
		String diaDiem = (String) eventJson.get("diaDiem");
		String ketQua = (String) eventJson.get("ketQua");
		String thamChien = (String) eventJson.get("thamChien");
		String chiHuy = (String) eventJson.get("chiHuy");
		String lucLuong = (String) eventJson.get("lucLuong");
		String tonThat = (String) eventJson.get("tonThat");
		String description = (String) eventJson.get("description");
		event.setThoiGian(thoiGian);
		event.setDiaDiem(diaDiem);
		event.setKetQua(ketQua);
		event.setThamChien(thamChien);
		event.setChiHuy(chiHuy);
		event.setLucLuong(lucLuong);
		event.setTonThat(tonThat);
		event.setDescription(description);
		return event;
	}
	
	public static LinkedList<Festival> readFileJsonToFestivalList()
	{
		LinkedList<Festival> festivalObjectList = new LinkedList<Festival>();
		JSONParser jsonParser = new JSONParser();
		try {
			FileReader reader = new FileReader("src\\main\\resources\\storage\\festival.json");
			Object obj = jsonParser.parse(reader);
			JSONArray festivalList = (JSONArray) obj;
			for(Object festival: festivalList) {
				festivalObjectList.add(parseFestivalObject((JSONObject)festival));
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
		return festivalObjectList;
	}
	private static Festival parseFestivalObject(JSONObject festivalJson) {
		String name = (String) festivalJson.get("name");
		String href = (String) festivalJson.get("href");
		Festival festival = new Festival(name, href);
		String ngayBatDau = (String) festivalJson.get("ngayBatDau");
		String viTri = (String) festivalJson.get("viTri");
		String lanDauToChuc = (String) festivalJson.get("lanDauToChuc");
		String nhanVatLienQuan = (String) festivalJson.get("nhanVatLienQuan");
		String ghiChu = (String) festivalJson.get("ghiChu");
		festival.setNgayBatDau(ngayBatDau);
		festival.setViTri(viTri);
		festival.setLanDauToChuc(lanDauToChuc);
		festival.setNhanVatLienQuan(nhanVatLienQuan);
		festival.setGhiChu(ghiChu);
		return festival;
	}
	public static LinkedList<Period> readFileJsonToPeriodList()
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
	private static Period parsePeriodObject(JSONObject periodJson) {
		String name = (String) periodJson.get("name");
		String href = (String) periodJson.get("href");
		Period period = new Period(name, href);
		String time = (String) periodJson.get("time");
		String description = (String) periodJson.get("description");
		period.setDescription(description);
		period.setTime(time);
		return period;
	}
	
	public static LinkedList<Person> readFileJsonToPersonList()
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
	private static Person parsePersonObject(JSONObject personJson) {
		String name = (String) personJson.get("name");
		String href = (String) personJson.get("href");
		Person person = new Person(name, href);
		String period = (String) personJson.get("period");
		String birth = (String) personJson.get("birth");
		String death = (String) personJson.get("death");
		String reignTime = (String) personJson.get("reignTime");
		String predecessor = (String) personJson.get("predecessor");
		String successor = (String) personJson.get("successor");
		String realName = (String) personJson.get("realName");
		String tenHuy = (String) personJson.get("tenHuy");
		String thuyHieu = (String) personJson.get("thuyHieu");
		String nienHieu = (String) personJson.get("nienHieu");
		String father = (String) personJson.get("father");
		String mother = (String) personJson.get("mother");
		String chidrens = (String) personJson.get("childrens");
		String anTang = (String) personJson.get("anTang");
		String tonGiao = (String) personJson.get("tonGiao");
		String nhiepChinh = (String) personJson.get("nhiepChinh");
		String theThiep = (String) personJson.get("theThiep");
		String role = (String) personJson.get("role");
		String description = (String) personJson.get("description");
		person.setPeriod(period);
		person.setBirth(birth);
		person.setDeath(death);
		person.setReignTime(reignTime);
		person.setPredecessor(predecessor);
		person.setSuccessor(successor);
		person.setRealName(realName);
		person.setTenHuy(tenHuy);
		person.setThuyHieu(thuyHieu);
		person.setNienHieu(nienHieu);
		person.setFather(father);
		person.setMother(mother);
		person.setChildrens(chidrens);
		person.setAnTang(anTang);
		person.setTonGiao(tonGiao);
		person.setNhiepChinh(nhiepChinh);
		person.setTheThiep(theThiep);
		person.setRole(role);
		person.setDescription(description);
		return person;
	}
	
	public static LinkedList<Place> readFileJsonToPlaceList()
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
	private static Place parsePlaceObject(JSONObject placeJson) {
		String name = (String) placeJson.get("name");
		String href = (String) placeJson.get("href");
		Place place = new Place(name, href);
		String toaDo = (String) placeJson.get("toaDo");
		String viTri = (String) placeJson.get("viTri");
		String dienTich = (String) placeJson.get("dienTich");
		String chieuCao = (String) placeJson.get("chieuCao");
		String thoiGianXayDung = (String) placeJson.get("thoiGianXayDung");
		String danSo = (String) placeJson.get("danSo");
		String matDo = (String) placeJson.get("matDo");
		String quocGia = (String) placeJson.get("quocGia");
		String tinh = (String) placeJson.get("tinh");
		String huyen = (String) placeJson.get("huyen");
		String maHanhChinh = (String) placeJson.get("maHanhChinh");
		String lehoi = (String) placeJson.get("leHoi");
		String nguon = (String) placeJson.get("Nguon");
		String phuLuu = (String) placeJson.get("phuLuu");
		String chieuDai = (String) placeJson.get("chieuDai");
		String luuLuong = (String) placeJson.get("luuLuong");
		String doSau = (String) placeJson.get("doSau");
		String description = (String) placeJson.get("description");
		place.setToaDo(toaDo);
		place.setViTri(viTri);
		place.setDienTich(dienTich);
		place.setChieuCao(chieuCao);
		place.setThoiGianXayDung(thoiGianXayDung);
		place.setDanSo(danSo);
		place.setMatDo(matDo);
		place.setQuocGia(quocGia);
		place.setTinh(tinh);
		place.setHuyen(huyen);
		place.setMaHanhchinh(maHanhChinh);
		place.setLehoi(lehoi);
		place.setNguon(nguon);
		place.setPhuLuu(phuLuu);
		place.setChieudai(chieuDai);
		place.setLuuLuong(luuLuong);
		place.setDoSau(doSau);
		place.setDescription(description);
		return place;
	}
}
