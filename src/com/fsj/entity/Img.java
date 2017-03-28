package com.fsj.entity;

import java.io.Serializable;

// 图片类
public class Img implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int iid;// 图片编号（主键）
	private String absolutepath;// 绝对路径
	private String relativepath;// 相对路径
	private String filename;// 文件名称
	private String suffixname;// 后缀名
	private String filetype;// 文件类型
	private Users users;// 用户图片
	private House house;// 房屋图片

	public Img() {
		super();
	}

	public Img(int iid, String absolutepath, String relativepath,
			String filename, String suffixname, String filetype, Users users,
			House house) {
		super();
		this.iid = iid;
		this.absolutepath = absolutepath;
		this.relativepath = relativepath;
		this.filename = filename;
		this.suffixname = suffixname;
		this.filetype = filetype;
		this.users = users;
		this.house = house;
	}

	public int getIid() {
		return iid;
	}

	public void setIid(int iid) {
		this.iid = iid;
	}

	public String getAbsolutepath() {
		return absolutepath;
	}

	public void setAbsolutepath(String absolutepath) {
		this.absolutepath = absolutepath;
	}

	public String getRelativepath() {
		return relativepath;
	}

	public void setRelativepath(String relativepath) {
		this.relativepath = relativepath;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getSuffixname() {
		return suffixname;
	}

	public void setSuffixname(String suffixname) {
		this.suffixname = suffixname;
	}

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
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
