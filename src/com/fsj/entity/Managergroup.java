package com.fsj.entity;

import java.io.Serializable;
import java.util.Set;

// 用户管理组类
public class Managergroup implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int mgid;// 用户管理组编号
	private String name;// 用户管理组名称
	private String introduction;// 管理组简介
	private Set<Users> users;// 管理组成员（多对多）
	private Set<Action> action;// 管理组包含权限（多对多）

	public Managergroup() {
		super();
	}

	public Managergroup(int mgid, String name, String introduction,
			Set<Users> users, Set<Action> action) {
		super();
		this.mgid = mgid;
		this.name = name;
		this.introduction = introduction;
		this.users = users;
		this.action = action;
	}

	public int getMgid() {
		return mgid;
	}

	public void setMgid(int mgid) {
		this.mgid = mgid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Set<Users> getUsers() {
		return users;
	}

	public void setUsers(Set<Users> users) {
		this.users = users;
	}

	public Set<Action> getAction() {
		return action;
	}

	public void setAction(Set<Action> action) {
		this.action = action;
	}

}
