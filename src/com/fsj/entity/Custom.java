package com.fsj.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Custom implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String phone;// 电话（主键）
	private boolean isflag;// 是否被推荐
	private Date registtime;// 登记日期
	private String name;// 姓名
	private String sex;// 性别
	private String age;// 年龄
	private String family;// 家庭结构
	private String marry;// 婚姻状况
	private String edulevel;// 教育程度
	private String hobby;// 兴趣爱好
	private String salarylevel;// 收入层次
	private String housetype;// 居住业态
	private String housetimes;// 置业次数
	private String carprice;// 车辆价位
	private String fromarea;// 来自区域
	private String address;// 居住区域
	private String workspace;// 工作区域
	private String trade;// 工作业态
	private String firmtype;// 公司性质
	private String job;// 职业身份
	private String productneed;// 产品需求
	private String houseneed;// 户型需求
	private String areaneed;// 面积需求
	private String budget;// 购房预算
	private String attention;// 项目关注点（多选，逗号隔开）
	private String wantarea;// 意向购房区域
	private String informationsources;// 信息来源
	private Users users;// 录入人
	private Set<Recommended> recommended;// 被推荐详情
	private Set<Schedule> schedule;// 进度

	public Custom() {
		super();
	}

	public Custom(String phone, boolean isflag, Date registtime, String name,
			String sex, String age, String family, String marry,
			String edulevel, String hobby, String salarylevel,
			String housetype, String housetimes, String carprice,
			String fromarea, String address, String workspace, String trade,
			String firmtype, String job, String productneed, String houseneed,
			String areaneed, String budget, String attention, String wantarea,
			String informationsources, Users users,
			Set<Recommended> recommended, Set<Schedule> schedule) {
		super();
		this.phone = phone;
		this.isflag = isflag;
		this.registtime = registtime;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.family = family;
		this.marry = marry;
		this.edulevel = edulevel;
		this.hobby = hobby;
		this.salarylevel = salarylevel;
		this.housetype = housetype;
		this.housetimes = housetimes;
		this.carprice = carprice;
		this.fromarea = fromarea;
		this.address = address;
		this.workspace = workspace;
		this.trade = trade;
		this.firmtype = firmtype;
		this.job = job;
		this.productneed = productneed;
		this.houseneed = houseneed;
		this.areaneed = areaneed;
		this.budget = budget;
		this.attention = attention;
		this.wantarea = wantarea;
		this.informationsources = informationsources;
		this.users = users;
		this.recommended = recommended;
		this.schedule = schedule;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isIsflag() {
		return isflag;
	}

	public void setIsflag(boolean isflag) {
		this.isflag = isflag;
	}

	public Date getRegisttime() {
		return registtime;
	}

	public void setRegisttime(Date registtime) {
		this.registtime = registtime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getMarry() {
		return marry;
	}

	public void setMarry(String marry) {
		this.marry = marry;
	}

	public String getEdulevel() {
		return edulevel;
	}

	public void setEdulevel(String edulevel) {
		this.edulevel = edulevel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getSalarylevel() {
		return salarylevel;
	}

	public void setSalarylevel(String salarylevel) {
		this.salarylevel = salarylevel;
	}

	public String getHousetype() {
		return housetype;
	}

	public void setHousetype(String housetype) {
		this.housetype = housetype;
	}

	public String getHousetimes() {
		return housetimes;
	}

	public void setHousetimes(String housetimes) {
		this.housetimes = housetimes;
	}

	public String getCarprice() {
		return carprice;
	}

	public void setCarprice(String carprice) {
		this.carprice = carprice;
	}

	public String getFromarea() {
		return fromarea;
	}

	public void setFromarea(String fromarea) {
		this.fromarea = fromarea;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWorkspace() {
		return workspace;
	}

	public void setWorkspace(String workspace) {
		this.workspace = workspace;
	}

	public String getTrade() {
		return trade;
	}

	public void setTrade(String trade) {
		this.trade = trade;
	}

	public String getFirmtype() {
		return firmtype;
	}

	public void setFirmtype(String firmtype) {
		this.firmtype = firmtype;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getProductneed() {
		return productneed;
	}

	public void setProductneed(String productneed) {
		this.productneed = productneed;
	}

	public String getHouseneed() {
		return houseneed;
	}

	public void setHouseneed(String houseneed) {
		this.houseneed = houseneed;
	}

	public String getAreaneed() {
		return areaneed;
	}

	public void setAreaneed(String areaneed) {
		this.areaneed = areaneed;
	}

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getAttention() {
		return attention;
	}

	public void setAttention(String attention) {
		this.attention = attention;
	}

	public String getWantarea() {
		return wantarea;
	}

	public void setWantarea(String wantarea) {
		this.wantarea = wantarea;
	}

	public String getInformationsources() {
		return informationsources;
	}

	public void setInformationsources(String informationsources) {
		this.informationsources = informationsources;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Set<Recommended> getRecommended() {
		return recommended;
	}

	public void setRecommended(Set<Recommended> recommended) {
		this.recommended = recommended;
	}

	public Set<Schedule> getSchedule() {
		return schedule;
	}

	public void setSchedule(Set<Schedule> schedule) {
		this.schedule = schedule;
	}

}
