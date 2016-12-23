package com.service.bean;

import java.util.Date;

public class Browse {
	private int stu_phone;
	private String cou_id;
	private Date bro_date;
	private byte bro_concerned;
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
	public Date getBro_date() {
		return bro_date;
	}
	public void setBro_date(Date bro_date) {
		this.bro_date = bro_date;
	}
	public byte getBro_concerned() {
		return bro_concerned;
	}
	public void setBro_concerned(byte bro_concerned) {
		this.bro_concerned = bro_concerned;
	}
}
