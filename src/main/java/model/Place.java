package model;

public class Place extends Model{
    private String toaDo;
    private String viTri;
    private String dienTich;
    private String chieuCao;		// cho cong trinh
    private String thoiGianXayDung;	// cho cong trinh
    private String danSo;
    private String matDo;
    private String quocGia;
    private String tinh;
    private String huyen;
    private String maHanhchinh;
    private String lehoi;
    private String nguon;		// cho song
    private String phuLuu;		// cho song
    private String chieudai;	// cho song
    private String luuLuong;	// cho song
    private String doSau;		// cho bien
    public Place(String name, String href) {
        this.setName(name);
        this.setHref(href);
    }

	public String getToaDo() {
		return toaDo;
	}

	public void setToaDo(String toaDo) {
		this.toaDo = toaDo;
	}

	public String getDienTich() {
		return dienTich;
	}

	public void setDienTich(String dienTich) {
		this.dienTich = dienTich;
	}

	public String getDanSo() {
		return danSo;
	}

	public void setDanSo(String danSo) {
		this.danSo = danSo;
	}

	public String getMatDo() {
		return matDo;
	}

	public void setMatDo(String matDo) {
		this.matDo = matDo;
	}

	public String getQuocGia() {
		return quocGia;
	}

	public void setQuocGia(String quocGia) {
		this.quocGia = quocGia;
	}

	public String getTinh() {
		return tinh;
	}

	public void setTinh(String tinh) {
		this.tinh = tinh;
	}

	public String getHuyen() {
		return huyen;
	}

	public void setHuyen(String huyen) {
		this.huyen = huyen;
	}

	public String getMaHanhchinh() {
		return maHanhchinh;
	}

	public void setMaHanhchinh(String maHanhchinh) {
		this.maHanhchinh = maHanhchinh;
	}

	public String getViTri() {
		return viTri;
	}

	public void setViTri(String viTri) {
		this.viTri = viTri;
	}

	public String getChieuCao() {
		return chieuCao;
	}

	public void setChieuCao(String chieuCao) {
		this.chieuCao = chieuCao;
	}

	public String getThoiGianXayDung() {
		return thoiGianXayDung;
	}

	public void setThoiGianXayDung(String thoiGianXayDung) {
		this.thoiGianXayDung = thoiGianXayDung;
	}

	public String getLehoi() {
		return lehoi;
	}

	public void setLehoi(String lehoi) {
		this.lehoi = lehoi;
	}

	public String getNguon() {
		return nguon;
	}

	public void setNguon(String nguon) {
		this.nguon = nguon;
	}

	public String getPhuLuu() {
		return phuLuu;
	}

	public void setPhuLuu(String phuLuu) {
		this.phuLuu = phuLuu;
	}

	public String getChieudai() {
		return chieudai;
	}

	public void setChieudai(String chieudai) {
		this.chieudai = chieudai;
	}

	public String getLuuLuong() {
		return luuLuong;
	}

	public void setLuuLuong(String luuLuong) {
		this.luuLuong = luuLuong;
	}

	public String getDoSau() {
		return doSau;
	}

	public void setDoSau(String doSau) {
		this.doSau = doSau;
	}
}
