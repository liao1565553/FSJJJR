package com.fsj.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

// 用户类
public class Users implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String phone;// 电话号码（主键）
	private boolean isflag;// 审核是否通过
	private String uidcard;// 用户身份证号
	private String email;// 邮箱
	private String realname;// 真实姓名
	private String username;// 用户名
	private String password;// 密码
	private String sex;// 性别
	private String address;// 地址
	private String job;// 职位
	private int money;// 可领金额
	private int integral;// 积分
	private Date registrationtime;// 注册时间
	private Department department;// 部门
	private Users pusers;// 所属上级
	private Set<Users> susers;// 包含下属
	private Set<Img> img;// 头像以及身份证图片
	private Set<Message> message;// 消息推送
	private Set<Custom> custom;// 录入客户
	private Set<Recommended> recommended;// 被推荐人
	private Set<Schedule> schedule;// 跟进人更新进度
	private Set<Pricetrend> pricetrend;// 管理员记录价格
	private Set<House> house;// 收藏的房屋（多对多）
	private Set<Managergroup> managergroup;// 用户所属组（多对多）

	public Users() {
		super();
	}

	public Users(String phone, boolean isflag, String uidcard, String email,
			String realname, String username, String password, String sex,
			String address, String job, int money, int integral,
			Date registrationtime, Department department, Users pusers,
			Set<Users> susers, Set<Img> img, Set<Message> message,
			Set<Custom> custom, Set<Recommended> recommended,
			Set<Schedule> schedule, Set<Pricetrend> pricetrend,
			Set<House> house, Set<Managergroup> managergroup) {
		super();
		this.phone = phone;
		this.isflag = isflag;
		this.uidcard = uidcard;
		this.email = email;
		this.realname = realname;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.address = address;
		this.job = job;
		this.money = money;
		this.integral = integral;
		this.registrationtime = registrationtime;
		this.department = department;
		this.pusers = pusers;
		this.susers = susers;
		this.img = img;
		this.message = message;
		this.custom = custom;
		this.recommended = recommended;
		this.schedule = schedule;
		this.pricetrend = pricetrend;
		this.house = house;
		this.managergroup = managergroup;
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

	public String getUidcard() {
		return uidcard;
	}

	public void setUidcard(String uidcard) {
		this.uidcard = uidcard;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getIntegral() {
		return integral;
	}

	public void setIntegral(int integral) {
		this.integral = integral;
	}

	public Date getRegistrationtime() {
		return registrationtime;
	}

	public void setRegistrationtime(Date registrationtime) {
		this.registrationtime = registrationtime;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Users getPusers() {
		return pusers;
	}

	public void setPusers(Users pusers) {
		this.pusers = pusers;
	}

	public Set<Users> getSusers() {
		return susers;
	}

	public void setSusers(Set<Users> susers) {
		this.susers = susers;
	}

	public Set<Img> getImg() {
		return img;
	}

	public void setImg(Set<Img> img) {
		this.img = img;
	}

	public Set<Message> getMessage() {
		return message;
	}

	public void setMessage(Set<Message> message) {
		this.message = message;
	}

	public Set<Custom> getCustom() {
		return custom;
	}

	public void setCustom(Set<Custom> custom) {
		this.custom = custom;
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

	public Set<Pricetrend> getPricetrend() {
		return pricetrend;
	}

	public void setPricetrend(Set<Pricetrend> pricetrend) {
		this.pricetrend = pricetrend;
	}

	public Set<House> getHouse() {
		return house;
	}

	public void setHouse(Set<House> house) {
		this.house = house;
	}

	public Set<Managergroup> getManagergroup() {
		return managergroup;
	}

	public void setManagergroup(Set<Managergroup> managergroup) {
		this.managergroup = managergroup;
	}

}
