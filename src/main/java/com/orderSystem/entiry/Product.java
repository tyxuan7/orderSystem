package com.orderSystem.entiry;

import java.util.Date;

public class Product {
    private Integer pid;

    private String pname;

    private Double sprice;

    private Double cprice;

    private String pic;

    private String pdesc;

    private Boolean isHot;

    private Date pdate;

    private Integer number;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public Double getSprice() {
        return sprice;
    }

    public void setSprice(Double sprice) {
        this.sprice = sprice;
    }

    public Double getCprice() {
        return cprice;
    }

    public void setCprice(Double cprice) {
        this.cprice = cprice;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc == null ? null : pdesc.trim();
    }

    public Boolean getIsHot() {
        return isHot;
    }

    public void setIsHot(Boolean isHot) {
        this.isHot = isHot;
    }

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", sprice="
				+ sprice + ", cprice=" + cprice + ", pic=" + pic + ", pdesc="
				+ pdesc + ", isHot=" + isHot + ", pdate=" + pdate + ", number="
				+ number + "]";
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Integer pid, String pname, Double sprice, Double cprice,
			String pic, String pdesc, Boolean isHot, Date pdate, Integer number) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.sprice = sprice;
		this.cprice = cprice;
		this.pic = pic;
		this.pdesc = pdesc;
		this.isHot = isHot;
		this.pdate = pdate;
		this.number = number;
	}
    
    
}