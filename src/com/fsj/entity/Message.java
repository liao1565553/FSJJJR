package com.fsj.entity;

import java.io.Serializable;
import java.util.Date;

// 消息类
public class Message implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int mid;// 消息编号（主键）
	private String content;// 消息内容
	private Date pushtime;// 推送时间
	private String state;// 消息状态
	private Users users;// 所属用户

	public Message() {
		super();
	}

	public Message(int mid, String content, Date pushtime, String state,
			Users users) {
		super();
		this.mid = mid;
		this.content = content;
		this.pushtime = pushtime;
		this.state = state;
		this.users = users;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPushtime() {
		return pushtime;
	}

	public void setPushtime(Date pushtime) {
		this.pushtime = pushtime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

}
