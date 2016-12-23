package com.service.bean;

import java.util.Date;

public class Comment {
	private int stu_phone;
	private String cou_id;
	private String com_text;
	private Date com_date;
	private float com_star;
	public int getStu_phone() {
		return stu_phone;
	}
	public void setStu_phone(int stu_phone) {
		this.stu_phone = stu_phone;
	}
	public String getCou_id() {
		return cou_id;
	}
	public void setCou_id(String cou_id) {
		this.cou_id = cou_id;
	}
	public String getCom_text() {
		return com_text;
	}
	public void setCom_text(String com_text) {
		this.com_text = com_text;
	}
	public Date getCom_date() {
		return com_date;
	}
	public void setCom_date(Date com_date) {
		this.com_date = com_date;
	}
	public float getCom_star() {
		return com_star;
	}
	public void setCom_star(float com_star) {
		this.com_star = com_star;
	}
	
}
