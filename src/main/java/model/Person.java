package model;

public class Person extends Model{
    private String period;		// trieu dai
    private String birth;		// thoi gian sinh
    private String death;		// thoi gian mat
    private String reignTime;	//	thoi gian tai vi
    private String predecessor;	// nguoi tien nhiem
    private String successor;	// nguoi ke nhiem
    private String realName;	// ten that	
    private String nienHieu;	
    private String tenHuy;
    private String thuyHieu;
    private String mieuHieu;
    private String father;		// cha
    private String mother;		// me
    private String childrens;	// hau due
    private String anTang;		//noi chon cat
    private String tonGiao;		
    private String nhiepChinh;	// nguoi nhiep chinh
    private String theThiep;
    private String role;		// vai tro

    public Person(String name, String href) {
        this.setName(name);
        this.setHref(href);
    }


    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getDeath() {
        return death;
    }

    public void setDeath(String death) {
        this.death = death;
    }

    public String getReignTime() {
        return reignTime;
    }

    public void setReignTime(String reignTime) {
        this.reignTime = reignTime;
    }

    public String getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(String predecessor) {
        this.predecessor = predecessor;
    }

    public String getSuccessor() {
        return successor;
    }

    public void setSuccessor(String successor) {
        this.successor = successor;
    }


    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getNienHieu() {
		return nienHieu;
	}

	public void setNienHieu(String nienHieu) {
		this.nienHieu = nienHieu;
	}

	public String getTenHuy() {
		return tenHuy;
	}

	public void setTenHuy(String tenHuy) {
		this.tenHuy = tenHuy;
	}

	public String getMieuHieu() {
		return mieuHieu;
	}

	public void setMieuHieu(String mieuHieu) {
		this.mieuHieu = mieuHieu;
	}

	public String getThuyHieu() {
		return thuyHieu;
	}

	public void setThuyHieu(String thuyHieu) {
		this.thuyHieu = thuyHieu;
	}

	public String getMother() {
		return mother;
	}

	public void setMother(String mother) {
		this.mother = mother;
	}

	public String getFather() {
		return father;
	}

	public void setFather(String father) {
		this.father = father;
	}

	public String getChildrens() {
		return childrens;
	}

	public void setChildrens(String childrens) {
		this.childrens = childrens;
	}

	public String getAnTang() {
		return anTang;
	}

	public void setAnTang(String anTang) {
		this.anTang = anTang;
	}

	public String getTonGiao() {
		return tonGiao;
	}

	public void setTonGiao(String tonGiao) {
		this.tonGiao = tonGiao;
	}

	public String getNhiepChinh() {
		return nhiepChinh;
	}

	public void setNhiepChinh(String nhiepChinh) {
		this.nhiepChinh = nhiepChinh;
	}

	public String getTheThiep() {
		return theThiep;
	}

	public void setTheThiep(String theThiep) {
		this.theThiep = theThiep;
	}
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

