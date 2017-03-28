package com.fsj.entity;

import java.io.Serializable;
import java.util.Date;

// 价格走势类
public class Pricetrend implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ptid;// 走势编号（主键）
	private Date recorddate;// 记录日期
	private String grade;// 记录级别（日，月，年）
	private String price;// 价格
	private Users users;// 录入用户
	private House house;// 所属房屋

	public Pricetrend() {
		super();
	}

	public Pricetrend(int ptid, Date recorddate, String grade, String price,
			Users users, House house) {
		super();
		this.ptid = ptid;
		this.recorddate = recorddate;
		this.grade = grade;
		this.price = price;
		this.users = users;
		this.house = house;
	}

	public int getPtid() {
		return ptid;
	}

	public void setPtid(int ptid) {
		this.ptid = ptid;
	}

	public Date getRecorddate() {
		return recorddate;
	}

	public void setRecorddate(Date recorddate) {
		this.recorddate = recorddate;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

}
