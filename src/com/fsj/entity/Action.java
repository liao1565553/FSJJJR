package com.fsj.entity;

import java.io.Serializable;
import java.util.Set;

// 权限类
public class Action implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int aid;// 权限编号
	private String name;// 权限名称
	private String introduction;// 权限简介
	private Actiongroup actiongroup;// 所属权限栏
	private Set<Managergroup> managergroup;// 拥有的管理组（多对多）

	public Action() {
		super();
	}

	public Action(int aid, String name, String introduction,
			Actiongroup actiongroup, Set<Managergroup> managergroup) {
		super();
		this.aid = aid;
		this.name = name;
		this.introduction = introduction;
		this.actiongroup = actiongroup;
		this.managergroup = managergroup;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
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

	public Actiongroup getActiongroup() {
		return actiongroup;
	}

	public void setActiongroup(Actiongroup actiongroup) {
		this.actiongroup = actiongroup;
	}

	public Set<Managergroup> getManagergroup() {
		return managergroup;
	}

	public void setManagergroup(Set<Managergroup> managergroup) {
		this.managergroup = managergroup;
	}

}
