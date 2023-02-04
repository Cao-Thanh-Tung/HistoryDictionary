package crawler;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class WikipediaCrawler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Document doc;
		try {
			doc = Jsoup.connect("https://vi.wikipedia.org/wiki/Lịch_sử_Việt_Nam").get();
			Element content = doc.getElementById("mw-content-text");
			String text = content.text();
			System.out.println(text);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
