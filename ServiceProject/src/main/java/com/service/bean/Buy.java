package com.service.bean;

import java.util.Date;

public class Buy {
	private int stu_phone;
	private String cou_id;
	private float buy_price;
	private Date buy_date;
	private byte buy_state;
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
	public float getBuy_price() {
		return buy_price;
	}
	public void setBuy_price(float buy_price) {
		this.buy_price = buy_price;
	}
	public Date getBuy_date() {
		return buy_date;
	}
	public void setBuy_date(Date buy_date) {
		this.buy_date = buy_date;
	}
	public byte getBuy_state() {
		return buy_state;
	}
	public void setBuy_state(byte buy_state) {
		this.buy_state = buy_state;
	}
	
}
