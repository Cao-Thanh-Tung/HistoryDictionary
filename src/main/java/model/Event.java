package model;

public class Event extends Model {
	private String thoiGian;
	private String diaDiem;
	private String ketQua;
	private String thamChien;
	private String chiHuy;
	private String lucLuong;
	private String tonThat;
	
	public Event(String name, String href) {
		this.setName(name);
		this.setHref(href);
	}

	public String getThoiGian() {
		return thoiGian;
	}


	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}


	public String getDiaDiem() {
		return diaDiem;
	}


	public void setDiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
	}


	public String getKetQua() {
		return ketQua;
	}


	public void setKetQua(String ketQua) {
		this.ketQua = ketQua;
	}


	public String getThamChien() {
		return thamChien;
	}


	public void setThamChien(String thamChien) {
		this.thamChien = thamChien;
	}


	public String getChiHuy() {
		return chiHuy;
	}


	public void setChiHuy(String chiHuy) {
		this.chiHuy = chiHuy;
	}


	public String getLucLuong() {
		return lucLuong;
	}


	public void setLucLuong(String lucLuong) {
		this.lucLuong = lucLuong;
	}


	public String getTonThat() {
		return tonThat;
	}


	public void setTonThat(String tonThat) {
		this.tonThat = tonThat;
	}
}
