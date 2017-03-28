package com.fsj.entity;

import java.io.Serializable;
import java.util.Set;

// 进度类型类
public class Schedulestate implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ssid;// 进度状态编号
	private String statename;// 状态名称
	private String introduction;// 状态简介
	private Set<Schedule> schedule;// 包含进度

	public Schedulestate() {
		super();
	}

	public Schedulestate(int ssid, String statename, String introduction,
			Set<Schedule> schedule) {
		super();
		this.ssid = ssid;
		this.statename = statename;
		this.introduction = introduction;
		this.schedule = schedule;
	}

	public int getSsid() {
		return ssid;
	}

	public void setSsid(int ssid) {
		this.ssid = ssid;
	}

	public String getStatename() {
		return statename;
	}

	public void setStatename(String statename) {
		this.statename = statename;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Set<Schedule> getSchedule() {
		return schedule;
	}

	public void setSchedule(Set<Schedule> schedule) {
		this.schedule = schedule;
	}

}
