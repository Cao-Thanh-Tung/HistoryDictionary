package frontend.model;

import java.util.List;

public abstract class Model {
	protected String name;
	protected String source;
	protected String story;
	protected List<String> events; // cac su kien lien quan
	protected List<String> historicalSites;	// cac dia diem di tich lich su lien quan
	protected List<String> historicalFigures;	// cac nhan vat lich su lien quan
	protected List<String> festivals;			// cac le hoi lien quan
	protected List<String> dynasties;			// cac trieu dai lien quan
	public String getName() {
		return this.name;
	};
	public String getSource() {
		return this.source;
	}
	public String getStory() {
		return this.story;
	}
	protected String toLineString() {
		String tmp = "";
		for(String i: events) {
			tmp += i;
		}
		for(String i: historicalSites) {
			tmp += i;
		}
		for(String i: historicalFigures) {
			tmp += i;
		}
		for(String i: festivals) {
			tmp += i;
		}
		for(String i: dynasties) {
			tmp += i;
		}
		return tmp;
	}
}
