package crawler;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import model.Event;
import model.Model;
import model.Period;
import model.Person;
import model.Place;

public class NguoiKeSuCrawler implements ICrawler {
	public List<String> links = new LinkedList<String>();
	public String rootURL = "https://nguoikesu.com";
	public List<Model> listModel = new LinkedList<Model>();
	@Override
	public List<Model> crawl() {
		System.out.println("Bat dau:");
		Document doc;
		try {
			doc = Jsoup.connect(rootURL).timeout(0).get();
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
					try {
						doc = Jsoup.connect(rootURL+link).get();
						Element title = doc.getElementsByTag("title").get(0);
						String name = title.text();
						name = name.replace("- Ng?????i K??? S???", "");
						Person person = new Person(name, link);
						setPersonInfo(doc, person);
						setRelated(doc, person);
						Elements scriptTags = doc.select("script[data-type*=gsd]");
						if(scriptTags.size() == 2) {
							Element scriptTag = scriptTags.get(1);
							String jsonString = scriptTag.data();
							JSONParser parser = new JSONParser();
							JSONObject json = (JSONObject) parser.parse(jsonString);
							String description = (String) json.get("description");
							person.setDescription(description);
						}
						listModel.add(person);
					} catch (Exception e) {
						// TODO Auto-generated catch block
//						e.printStackTrace();
					}
				}else if(link.contains("/dia-danh/")) {
					try {
						doc = Jsoup.connect(rootURL+link).get();
						Element title = doc.getElementsByTag("title").get(0);
						String name = title.text();
						name = name.replace("- Ng?????i K??? S???", "");
						Place place = new Place(name, link);
						setPlaceInfo(doc, place);
						setRelated(doc, place);
						Elements scriptTags = doc.select("script[data-type*=gsd]");
						if(scriptTags.size() == 2) {
							Element scriptTag = scriptTags.get(1);
							String jsonString = scriptTag.data();
							JSONParser parser = new JSONParser();
							JSONObject json = (JSONObject) parser.parse(jsonString);
							String description = (String) json.get("description");
							place.setDescription(description);
						}
						listModel.add(place);
					} catch (Exception e) {
						// TODO Auto-generated catch block
//						e.printStackTrace();
					}
				}else if(link.contains("/tu-lieu/quan-su/")) {
					try {
						doc = Jsoup.connect(rootURL+link).get();
						Element title = doc.getElementsByTag("title").get(0);
						String name = title.text();
						name = name.replace("- Ng?????i K??? S???", "");
						Event event = new Event(name, link);
						setEventInfo(doc,event);
						setRelated(doc, event);
						Elements scriptTags = doc.select("script[data-type*=gsd]");
						if(scriptTags.size() == 2) {
							Element scriptTag = scriptTags.get(1);
							String jsonString = scriptTag.data();
							JSONParser parser = new JSONParser();
							JSONObject json = (JSONObject) parser.parse(jsonString);
							String description = (String) json.get("description");
							event.setDescription(description);
						}
						listModel.add(event);
					} catch (Exception e) {
						// TODO Auto-generated catch block
//						e.printStackTrace();
					}
				}else if(link.contains("/dong-lich-su/")) {
					try {
						doc = Jsoup.connect(rootURL+link).get();
						Element title = doc.getElementsByTag("title").get(0);
						String name = title.text();
						name = name.replace("- Ng?????i K??? S???", "");
						Period period = new Period(name, link);
						setRelated(doc, period);
						Elements scriptTags = doc.select("script[data-type*=gsd]");
						if(scriptTags.size() == 2) {
							Element scriptTag = scriptTags.get(1);
							String jsonString = scriptTag.data();
							JSONParser parser = new JSONParser();
							JSONObject json = (JSONObject) parser.parse(jsonString);
							String description = (String) json.get("description");
							period.setDescription(description);
						}
						listModel.add(period);
					} catch (Exception e) {
						// TODO Auto-generated catch block
//						e.printStackTrace();
					}
				}
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(links.size());
		System.out.println("Ket thuc");
		return listModel;
	}
	
	private void setPersonInfo(Document document, Person person) {
		Elements infobox = document.select("table.infobox tbody");
        if(infobox.size() != 0) {
        	Element a= infobox.get(0);
        	Elements b = a.select("th:contains(Tr??? v??)");
        	if(b.size() != 0) {
        		Element c = b.get(0);
        		Element d = c.nextElementSibling();
        		String n = d.text();
        		System.out.println(n);
        		person.setReignTime(n);
        	}
        	b = a.select("th:contains(Ti???n nhi???m)");
        	if(b.size() != 0) {
        		Element c = b.get(0);
        		Element d = c.nextElementSibling();
        		String n = d.text();
        		System.out.println(n);
        		person.setPredecessor(n);
        	}
        	b = a.select("th:contains(K??? nhi???m)");
        	if(b.size() != 0) {
        		Element c = b.get(0);
        		Element d = c.nextElementSibling();
        		String n = d.text();
        		System.out.println(n);
        		person.setSuccessor(n);
        	}
        	b = a.select("th:contains(Nhi???p ch??nh)");
        	if(b.size() != 0) {
        		Element c = b.get(0);
        		Element d = c.nextElementSibling();
        		String n = d.text();
        		System.out.println(n);
        		person.setNhiepChinh(n);
        	}
        	b = a.select("th:contains(T??n th???t)");
        	if(b.size() != 0) {
        		Element c = b.get(0);
        		Element d = c.nextElementSibling();
        		String n = d.text();
        		System.out.println(n);
        		person.setRealName(n);
        	}
        	b = a.select("th:contains(Ni??n hi???u)");
        	if(b.size() != 0) {
        		Element c = b.get(0);
        		Element d = c.nextElementSibling();
        		String n = d.text();
        		System.out.println(n);
        		person.setNienHieu(n);
        	}
        	b = a.select("th:contains(Th???y hi???u)");
        	if(b.size() != 0) {
        		Element c = b.get(0);
        		Element d = c.nextElementSibling();
        		String n = d.text();
        		System.out.println(n);
        		person.setThuyHieu(n);
        	}
        	b = a.select("th:contains(Mi???u hi???u)");
        	if(b.size() != 0) {
        		Element c = b.get(0);
        		Element d = c.nextElementSibling();
        		String n = d.text();
        		System.out.println(n);
        		person.setMieuHieu(n);
        	}
        	b = a.select("th:contains(Tri???u ?????i)");
        	if(b.size() != 0) {
        		Element c = b.get(0);
        		Element d = c.nextElementSibling();
        		String n = d.text();
        		System.out.println(n);
        		person.setPeriod(n);
        	}
        	b = a.select("th:contains(Th??n ph???)");
        	if(b.size() != 0) {
        		Element c = b.get(0);
        		Element d = c.nextElementSibling();
        		String n = d.text();
        		System.out.println(n);
        		person.setFather(n);
        	}
        	b = a.select("th:contains(Th??n m???u)");
        	if(b.size() != 0) {
        		Element c = b.get(0);
        		Element d = c.nextElementSibling();
        		String n = d.text();
        		System.out.println(n);
        		person.setMother(n);
        	}
        	b = a.select("th:contains(Sinh)");
        	if(b.size() != 0) {
        		Element c = b.get(0);
        		Element d = c.nextElementSibling();
        		String n = d.text();
        		System.out.println(n);
        		person.setBirth(n);
        	}
        	b = a.select("th:contains(M???t)");
        	if(b.size() != 0) {
        		Element c = b.get(0);
        		Element d = c.nextElementSibling();
        		String n = d.text();
        		System.out.println(n);
        		person.setDeath(n);
        	}
        	b = a.select("th:contains(An t??ng)");
        	if(b.size() != 0) {
        		Element c = b.get(0);
        		Element d = c.nextElementSibling();
        		String n = d.text();
        		System.out.println(n);
        		person.setAnTang(n);
        	}
        	b = a.select("th:contains(T??n gi??o)");
        	if(b.size() != 0) {
        		Element c = b.get(0);
        		Element d = c.nextElementSibling();
        		String n = d.text();
        		System.out.println(n);
        		person.setTonGiao(n);
        	}
        }
	}
	
	private void setPlaceInfo(Document document, Place place) {

		Elements infobox = document.select("table.infobox tbody");
        if(infobox.size() != 0) {
        	Element a= infobox.get(0);
        	Elements b = a.select("th:contains(T???a ?????)");
        	if(b.size() != 0) {
        		Element c = b.get(0);
        		Element d = c.nextElementSibling();
        		String n = d.text();
        		System.out.println(n);
        		place.setToaDo(n);
        	}
        	b = a.select("th:contains(V??? tr??)");
        	if(b.size() != 0) {
        		Element c = b.get(0);
        		Element d = c.nextElementSibling();
        		String n = d.text();
        		System.out.println(n);
        		place.setViTri(n);
        	}
        	b = a.select("th:contains(?????a ch???)");
        	if(b.size() != 0) {
        		Element c = b.get(0);
        		Element d = c.nextElementSibling();
        		String n = d.text();
        		System.out.println(n);
        		place.setViTri(n);
        	}
        	b = a.select("th:contains(?????a ??i???m)");
        	if(b.size() != 0) {
        		Element c = b.get(0);
        		Element d = c.nextElementSibling();
        		String n = d.text();
        		System.out.println(n);
        		place.setViTri(n);
        	}
        	b = a.select("th:contains(Di???n t??ch)");
        	if(b.size() != 0) {
        		Element c = b.get(0);
        		Element d = c.nextElementSibling();
        		String n = d.text();
        		System.out.println(n);
        		place.setDienTich(n);;
        	}
        	b = a.select("th:contains(Chi???u cao)");
        	if(b.size() != 0) {
        		Element c = b.get(0);
        		Element d = c.nextElementSibling();
        		String n = d.text();
        		System.out.println(n);
        		place.setChieuCao(n);
        	}
        	b = a.select("th:contains(X??y d???ng)");
        	if(b.size() != 0) {
        		Element c = b.get(0);
        		Element d = c.nextElementSibling();
        		String n = d.text();
        		System.out.println(n);
        		place.setThoiGianXayDung(n);
        	}
        	b = a.select("th:contains(D??n s???)");
        	if(b.size() != 0) {
        		Element c = b.get(0);
        		Element d = c.nextElementSibling();
        		String n = d.text();
        		System.out.println(n);
        		place.setDanSo(n);
        	}
        	b = a.select("th:contains(M???t ?????)");
        	if(b.size() != 0) {
        		Element c = b.get(0);
        		Element d = c.nextElementSibling();
        		String n = d.text();
        		System.out.println(n);
        		place.setMatDo(n);
        	}
        	b = a.select("th:contains(Qu???c gia)");
        	if(b.size() != 0) {
        		Element c = b.get(0);
        		Element d = c.nextElementSibling();
        		String n = d.text();
        		System.out.println(n);
        		place.setQuocGia(n);
        	}
        	b = a.select("th:contains(T???nh)");
        	if(b.size() != 0) {
        		Element c = b.get(0);
        		Element d = c.nextElementSibling();
        		String n = d.text();
        		System.out.println(n);
        		place.setTinh(n);
        	}
        	b = a.select("th:contains(Huy???n)");
        	if(b.size() != 0) {
        		Element c = b.get(0);
        		Element d = c.nextElementSibling();
        		String n = d.text();
        		System.out.println(n);
        		place.setHuyen(n);
        	}
        	b = a.select("th:contains(M?? h??nh ch??nh)");
        	if(b.size() != 0) {
        		Element c = b.get(0);
        		Element d = c.nextElementSibling();
        		String n = d.text();
        		System.out.println(n);
        		place.setMaHanhchinh(n);
        	}
        	b = a.select("th:contains(L??? h???i)");
        	if(b.size() != 0) {
        		Element c = b.get(0);
        		Element d = c.nextElementSibling();
        		String n = d.text();
        		System.out.println(n);
        		place.setLehoi(n);
        	}
        	b = a.select("th:contains(Ngu???n)");
        	if(b.size() != 0) {
        		Element c = b.get(0);
        		Element d = c.nextElementSibling();
        		String n = d.text();
        		System.out.println(n);
        		place.setNguon(n);
        	}
        	b = a.select("th:contains(Ph??? l??u)");
        	if(b.size() != 0) {
        		Element c = b.get(0);
        		Element d = c.nextElementSibling();
        		String n = d.text();
        		System.out.println(n);
        		place.setPhuLuu(n);
        	}
        	b = a.select("th:contains(Chi???u d??i)");
        	if(b.size() != 0) {
        		Element c = b.get(0);
        		Element d = c.nextElementSibling();
        		String n = d.text();
        		System.out.println(n);
        		place.setChieudai(n);
        	}
        	b = a.select("th:contains(L??u l?????ng)");
        	if(b.size() != 0) {
        		Element c = b.get(0);
        		Element d = c.nextElementSibling();
        		String n = d.text();
        		System.out.println(n);
        		place.setLuuLuong(n);
        	}
        	b = a.select("th:contains(????? s??u)");
        	if(b.size() != 0) {
        		Element c = b.get(0);
        		Element d = c.nextElementSibling();
        		String n = d.text();
        		System.out.println(n);
        		place.setDoSau(n);
        	}
        }
        }
    private void setEventInfo(Document document, Event event) {
		Elements infobox = document.select("div.infobox table tbody");
//		System.out.println(infobox);
        if(infobox.size() != 0) {
        	Element a= infobox.get(0);
        	Elements b = a.select("b:contains(Th???i gian)");
        	if(b.size() != 0) {
        		Element c = b.get(0);
        		Element e = c.parent();
        		Element d = e.nextElementSibling();
        		String n = d.text();
        		System.out.println(n);
        		event.setThoiGian(n);
        	}
        	b = a.select("th:contains(T???n th???t)");

        	if(b.size() != 0) {
        		Element c = b.get(0);
        		Element e = c.parent();
        		Element d = e.nextElementSibling();
        		String n = d.text();
        		System.out.println(n);
        		event.setTonThat(n);
        	}
        	b = a.select("b:contains(?????a ??i???m)");
        	if(b.size() != 0) {
        		Element c = b.get(0);
        		Element e = c.parent();
        		Element d = e.nextElementSibling();
        		String n = d.text();
        		System.out.println(n);
        		event.setDiaDiem(n);
        	}
        	b = a.select("b:contains(K???t qu???)");
        	if(b.size() != 0) {
        		Element c = b.get(0);
        		Element e = c.parent();
        		Element d = e.nextElementSibling();
        		String n = d.text();
        		System.out.println(n);
        		event.setKetQua(n);
        	}
        	b = a.select("th:contains(Tham chi???n)");
        	if(b.size() != 0) {
        		Element c = b.get(0);
        		Element e = c.parent();
        		Element d = e.nextElementSibling();
        		String n = d.text();
        		System.out.println(n);
        		event.setThamChien(n);
        	}
        	b = a.select("th:contains(Ch??? huy)");
        	if(b.size() != 0) {
        		Element c = b.get(0);
        		Element e = c.parent();
        		Element d = e.nextElementSibling();
        		String n = d.text();
        		System.out.println(n);
        		event.setChiHuy(n);
        	}
        	b = a.select("th:contains(L???c l?????ng)");
        	if(b.size() != 0) {
        		Element c = b.get(0);
        		Element e = c.parent();
        		Element d = e.nextElementSibling();
        		String n = d.text();
        		System.out.println(n);
        		event.setLucLuong(n);
        	}
        }
    }
    
    private void setRelated(Document doc, Model model) {
    	Element content = doc.getElementById("content");
    	Elements listATag = doc.select("a");
    	List<String> listEvent = new LinkedList<String>();
    	List<String> listPerson = new LinkedList<String>();
    	List<String> listPeriod = new LinkedList<String>();
    	List<String> listPlace = new LinkedList<String>();
		for (Element aTag : listATag) {
			String tmplink = aTag.attr("href");
			if(tmplink.contains("/dong-lich-su")) {			
				listPeriod.add(aTag.text());
			}else if(tmplink.contains("/tu-lieu")) {
				listEvent.add(aTag.text());
			}else if(tmplink.contains("/nhan-vat")) {
				listPerson.add(aTag.text());
			}else if(tmplink.contains("/dia-danh")) {
				listPlace.add(aTag.text());
			}
		}
		model.setPeriodRelated(listPeriod);
		model.setPersonRelated(listPerson);
		model.setPlaceRelated(listPlace);
		model.setEventRelated(listPlace);
    }


}
