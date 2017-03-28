package com.fsj.entity;

import java.io.Serializable;
import java.util.Set;

// 权限分栏类
public class Actiongroup implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int agid;// 权限分栏编号
	private String name;// 权限分栏名称
	private String introduction;// 权限分栏简介
	private Set<Action> action;// 包含权限

	public Actiongroup() {
		super();
	}

	public Actiongroup(int agid, String name, String introduction,
			Set<Action> action) {
		super();
		this.agid = agid;
		this.name = name;
		this.introduction = introduction;
		this.action = action;
	}

	public int getAgid() {
		return agid;
	}

	public void setAgid(int agid) {
		this.agid = agid;
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

	public Set<Action> getAction() {
		return action;
	}

	public void setAction(Set<Action> action) {
		this.action = action;
	}

}
