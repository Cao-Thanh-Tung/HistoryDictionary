package crawler;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import model.Festival;
import model.Model;
import model.Period;

public class WikipediaCrawler implements ICrawler {
	@Override
	public List<Model> crawl() {
		crawlerFestival();
		crawlerPeriod();
		return modelList;
	}
	private List<Model> modelList = new LinkedList<Model>(); 
    private void crawlerFestival() {
        String url = "https://vi.wikipedia.org/wiki/L%E1%BB%85_h%E1%BB%99i_Vi%E1%BB%87t_Nam#Danh_s%C3%A1ch_m%E1%BB%99t_s%E1%BB%91_l%E1%BB%85_h%E1%BB%99i";
        try {
            Document doc = Jsoup.connect(url).get();
            Elements elements = doc.getElementsByTag("tbody").get(1).getElementsByTag("tr");
            elements.remove(0);

            for(Element element : elements){
            	Festival festival = new Festival("","https://vi.wikipedia.org/wiki/L%E1%BB%85_h%E1%BB%99i_Vi%E1%BB%87t_Nam#Danh_s%C3%A1ch_m%E1%BB%99t_s%E1%BB%91_l%E1%BB%85_h%E1%BB%99i"); 
                Elements festivalInfo = element.getElementsByTag("td");
                int length = festivalInfo.size();
    
                for(int i = 0; i < length; i++){
                	
                    String str = festivalInfo.get(i).text();
                    if(str != "") { 
                    	if(i == 0) {
                    		festival.setNgayBatDau(str);
                    	}else if(i == 1) {
                    		festival.setViTri(str);
                    	}else if(i == 2) {
                    		festival.setName(str);
                    	}else if(i == 3) {
                    		festival.setLanDauToChuc(str);
                    	}else if(i == 4) {
                    		festival.setNhanVatLienQuan(str);
                    	}else if(i == 5) {
                    		festival.setGhiChu(str);
                    	}
                    
                    }
                    
                }
                modelList.add(festival);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void crawlerPeriod() {
    	
        String url = "https://vi.wikipedia.org/wiki/L%E1%BB%8Bch_s%E1%BB%AD_Vi%E1%BB%87t_Nam";
        try {
            Document doc = Jsoup.connect(url).get();
            Elements elements = doc.getElementsByClass("mw-headline");
            int len = elements.size();
            for (int i = 0; i < len-13; i++) {
            	Period period = new Period("", url);
                Element e = elements.get(i);
                String s = e.text();
                int startIndex = s.indexOf("(");
                if(startIndex == -1) {
                    period.setName(s) ;
                }else {
                    String name = s.substring(0, startIndex);
                    period.setName(name);
                    int endIndex = s.indexOf(")") + 1;
                    String time = s.substring(startIndex, endIndex);
                    period.setTime(time);
                }
                modelList.add(period);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
