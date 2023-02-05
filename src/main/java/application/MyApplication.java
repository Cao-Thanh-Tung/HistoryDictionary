package application;
import crawler.MainCrawler;
import screen.MainScreen;

public class MyApplication {

	public static void main(String[] args) {
		MainCrawler.crawl();
		MainScreen.launch(args);
	}

}
