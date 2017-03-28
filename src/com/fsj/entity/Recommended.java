package com.fsj.entity;

import java.io.Serializable;
import java.util.Set;

// 被推荐详情类
public class Recommended implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Custom custom;// 被推荐人（主键1）
	private Users users;// 推荐人（主键2）
	private boolean isflag;// 推荐是否成功
	private Set<Schedule> schedule;// 具体进度流程
	private Set<House> house;// 推荐的房屋（多对多）

	public Recommended() {
		super();
	}

	public Recommended(Custom custom, Users users, boolean isflag,
			Set<Schedule> schedule, Set<House> house) {
		super();
		this.custom = custom;
		this.users = users;
		this.isflag = isflag;
		this.schedule = schedule;
		this.house = house;
	}

	public Custom getCustom() {
		return custom;
	}

	public void setCustom(Custom custom) {
		this.custom = custom;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public boolean isIsflag() {
		return isflag;
	}

	public void setIsflag(boolean isflag) {
		this.isflag = isflag;
	}

	public Set<Schedule> getSchedule() {
		return schedule;
	}

	public void setSchedule(Set<Schedule> schedule) {
		this.schedule = schedule;
	}

	public Set<House> getHouse() {
		return house;
	}

	public void setHouse(Set<House> house) {
		this.house = house;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((custom == null) ? 0 : custom.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recommended other = (Recommended) obj;
		if (custom == null) {
			if (other.custom != null)
				return false;
		} else if (!custom.equals(other.custom))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}

}
