package com.orderSystem.entiry;

import java.util.Date;
import java.util.Set;

public class Forder {
    private Integer fid;

    private String name;

    private String phone;

    private String remark;

    private Date date;

    private Double total;

    private String post;

    private String address;

    private Integer status;

    private Integer uid;
    
    private Set<Sorder> sorderSet;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post == null ? null : post.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    

	@Override
	public String toString() {
		return "Forder [fid=" + fid + ", name=" + name + ", phone=" + phone
				+ ", remark=" + remark + ", date=" + date + ", total=" + total
				+ ", post=" + post + ", address=" + address + ", status="
				+ status + ", uid=" + uid + ", sorderSet=" + sorderSet + "]";
	}

	public Forder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Forder(Set<Sorder> sorderSet) {
		super();
		this.sorderSet = sorderSet;
	}
    
	
    
}