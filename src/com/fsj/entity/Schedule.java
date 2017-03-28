package com.fsj.entity;

import java.io.Serializable;
import java.util.Date;

// 进度类
public class Schedule implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int sid;// 进度编号（主键）
	private Date updatetime;// 更新时间
	private String remarks;// 备注
	private Users users;// 更新人
	private House house;// 进度对应房屋
	private Schedulestate schedulestate;// 进度所处状态
	private Custom custom;// 进度对应客户
	private Recommended recommended;// 进度对应被推荐详情

	public Schedule() {
		super();
	}

	public Schedule(int sid, Date updatetime, String remarks, Users users,
			House house, Schedulestate schedulestate, Custom custom,
			Recommended recommended) {
		super();
		this.sid = sid;
		this.updatetime = updatetime;
		this.remarks = remarks;
		this.users = users;
		this.house = house;
		this.schedulestate = schedulestate;
		this.custom = custom;
		this.recommended = recommended;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	public Schedulestate getSchedulestate() {
		return schedulestate;
	}

	public void setSchedulestate(Schedulestate schedulestate) {
		this.schedulestate = schedulestate;
	}

	public Custom getCustom() {
		return custom;
	}

	public void setCustom(Custom custom) {
		this.custom = custom;
	}

	public Recommended getRecommended() {
		return recommended;
	}

	public void setRecommended(Recommended recommended) {
		this.recommended = recommended;
	}

}
