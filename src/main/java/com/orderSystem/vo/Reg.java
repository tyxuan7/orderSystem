package com.orderSystem.vo;

public class Reg {
	
	private int code;
	
	private String msg;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Reg() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reg(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	
	
}
