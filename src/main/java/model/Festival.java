package model;

public class Festival extends Model {
	private String ngayBatDau;
	private String viTri;
	private String lanDauToChuc;
	private String nhanVatLienQuan;
	private String ghiChu;
	public Festival(String name, String href) {
		this.setName(name);
		this.setHref(href);
	}
	public String getNgayBatDau() {
		return ngayBatDau;
	}
	public void setNgayBatDau(String ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}
	public String getViTri() {
		return viTri;
	}
	public void setViTri(String viTri) {
		this.viTri = viTri;
	}
	public String getLanDauToChuc() {
		return lanDauToChuc;
	}
	public void setLanDauToChuc(String lanDauToChuc) {
		this.lanDauToChuc = lanDauToChuc;
	}
	public String getNhanVatLienQuan() {
		return nhanVatLienQuan;
	}
	public void setNhanVatLienQuan(String nhanVatLienQuan) {
		this.nhanVatLienQuan = nhanVatLienQuan;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
}
