package com.fsj.entity;

import java.io.Serializable;
import java.util.Set;

//部门类
public class Department implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int did;// 编号
	private String name;// 名称
	private String introduction;// 简介
	private Set<Users> users;// 包含用户

	public Department() {
		super();
	}

	public Department(int did, String name, String introduction,
			Set<Users> users) {
		super();
		this.did = did;
		this.name = name;
		this.introduction = introduction;
		this.users = users;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
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

}
