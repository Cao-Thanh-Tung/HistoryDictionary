package model;

import java.util.List;

public abstract class RelationshipObject {

	protected List<String> events; // cac su kien lien quan
	protected List<String> historicalSites;	// cac dia diem di tich lich su lien quan
	protected List<String> historicalFigures;	// cac nhan vat lich su lien quan
	protected List<String> festivals;			// cac le hoi lien quan
	protected List<String> dynasties;			// cac trieu dai lien quan
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
