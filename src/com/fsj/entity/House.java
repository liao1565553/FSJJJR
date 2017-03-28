package com.fsj.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

//房屋信息类
public class House implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int hid;
	private boolean oldflag;// 是否二手房
	private String title;// 标题（名字）
	private String type;// 户型
	private String salestate;// 销售状态
	private Date opendate;// 开盘日期
	private int unitprice;// 单位价格
	private int totalprice;// 总价
	private String decorationdegree;// 装修程度
	private String floortype;// 楼层类型
	private String coordinate;// 楼盘坐标
	private String estateaddress;// 楼盘地址
	private double roomrate;// 得房率
	private double greeningrate;// 绿化率
	private double volumerate;// 容积率
	private double builtuparea;// 建筑面积
	private double coversarea;// 占地面积
	private String parkingspace;// 停车位
	private int propertyfee;// 物业费
	private String propertycompany;// 物业公司
	private String propertyaddress;// 物业地址
	private String developers;// 楼盘开发商
	private String otherInfo;// 其他信息（租赁或出售）
	private String introduction;// 介绍
	private Date releasetime;// 上传时间
	private int households;// 户数
	private int commission;// 佣金
	private String approve;// 审核（区分现场和门店，门店可选择性共享到经纪人平台）
	private String phone;// 联系方式
	private String salesaddress;// 售楼地址
	private Set<Img> img;// 资源图片
	private Set<Schedule> schedule;// 包含进度
	private Set<Pricetrend> pricetrend;// 房屋价格走势
	private Set<Users> users;// 收藏用户（多对多）
	private Set<Recommended> recommended;// 被推荐人（多对多）

	public House() {
		super();
	}

	public House(int hid, boolean oldflag, String title, String type,
			String salestate, Date opendate, int unitprice, int totalprice,
			String decorationdegree, String floortype, String coordinate,
			String estateaddress, double roomrate, double greeningrate,
			double volumerate, double builtuparea, double coversarea,
			String parkingspace, int propertyfee, String propertycompany,
			String propertyaddress, String developers, String otherInfo,
			String introduction, Date releasetime, int households,
			int commission, String approve, String phone, String salesaddress,
			Set<Img> img, Set<Schedule> schedule, Set<Pricetrend> pricetrend,
			Set<Users> users, Set<Recommended> recommended) {
		super();
		this.hid = hid;
		this.oldflag = oldflag;
		this.title = title;
		this.type = type;
		this.salestate = salestate;
		this.opendate = opendate;
		this.unitprice = unitprice;
		this.totalprice = totalprice;
		this.decorationdegree = decorationdegree;
		this.floortype = floortype;
		this.coordinate = coordinate;
		this.estateaddress = estateaddress;
		this.roomrate = roomrate;
		this.greeningrate = greeningrate;
		this.volumerate = volumerate;
		this.builtuparea = builtuparea;
		this.coversarea = coversarea;
		this.parkingspace = parkingspace;
		this.propertyfee = propertyfee;
		this.propertycompany = propertycompany;
		this.propertyaddress = propertyaddress;
		this.developers = developers;
		this.otherInfo = otherInfo;
		this.introduction = introduction;
		this.releasetime = releasetime;
		this.households = households;
		this.commission = commission;
		this.approve = approve;
		this.phone = phone;
		this.salesaddress = salesaddress;
		this.img = img;
		this.schedule = schedule;
		this.pricetrend = pricetrend;
		this.users = users;
		this.recommended = recommended;
	}

	public int getHid() {
		return hid;
	}

	public void setHid(int hid) {
		this.hid = hid;
	}

	public boolean isOldflag() {
		return oldflag;
	}

	public void setOldflag(boolean oldflag) {
		this.oldflag = oldflag;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSalestate() {
		return salestate;
	}

	public void setSalestate(String salestate) {
		this.salestate = salestate;
	}

	public Date getOpendate() {
		return opendate;
	}

	public void setOpendate(Date opendate) {
		this.opendate = opendate;
	}

	public int getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(int unitprice) {
		this.unitprice = unitprice;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public String getDecorationdegree() {
		return decorationdegree;
	}

	public void setDecorationdegree(String decorationdegree) {
		this.decorationdegree = decorationdegree;
	}

	public String getFloortype() {
		return floortype;
	}

	public void setFloortype(String floortype) {
		this.floortype = floortype;
	}

	public String getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(String coordinate) {
		this.coordinate = coordinate;
	}

	public String getEstateaddress() {
		return estateaddress;
	}

	public void setEstateaddress(String estateaddress) {
		this.estateaddress = estateaddress;
	}

	public double getRoomrate() {
		return roomrate;
	}

	public void setRoomrate(double roomrate) {
		this.roomrate = roomrate;
	}

	public double getGreeningrate() {
		return greeningrate;
	}

	public void setGreeningrate(double greeningrate) {
		this.greeningrate = greeningrate;
	}

	public double getVolumerate() {
		return volumerate;
	}

	public void setVolumerate(double volumerate) {
		this.volumerate = volumerate;
	}

	public double getBuiltuparea() {
		return builtuparea;
	}

	public void setBuiltuparea(double builtuparea) {
		this.builtuparea = builtuparea;
	}

	public double getCoversarea() {
		return coversarea;
	}

	public void setCoversarea(double coversarea) {
		this.coversarea = coversarea;
	}

	public String getParkingspace() {
		return parkingspace;
	}

	public void setParkingspace(String parkingspace) {
		this.parkingspace = parkingspace;
	}

	public int getPropertyfee() {
		return propertyfee;
	}

	public void setPropertyfee(int propertyfee) {
		this.propertyfee = propertyfee;
	}

	public String getPropertycompany() {
		return propertycompany;
	}

	public void setPropertycompany(String propertycompany) {
		this.propertycompany = propertycompany;
	}

	public String getPropertyaddress() {
		return propertyaddress;
	}

	public void setPropertyaddress(String propertyaddress) {
		this.propertyaddress = propertyaddress;
	}

	public String getDevelopers() {
		return developers;
	}

	public void setDevelopers(String developers) {
		this.developers = developers;
	}

	public String getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Date getReleasetime() {
		return releasetime;
	}

	public void setReleasetime(Date releasetime) {
		this.releasetime = releasetime;
	}

	public int getHouseholds() {
		return households;
	}

	public void setHouseholds(int households) {
		this.households = households;
	}

	public int getCommission() {
		return commission;
	}

	public void setCommission(int commission) {
		this.commission = commission;
	}

	public String getApprove() {
		return approve;
	}

	public void setApprove(String approve) {
		this.approve = approve;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSalesaddress() {
		return salesaddress;
	}

	public void setSalesaddress(String salesaddress) {
		this.salesaddress = salesaddress;
	}

	public Set<Img> getImg() {
		return img;
	}

	public void setImg(Set<Img> img) {
		this.img = img;
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

	public Set<Users> getUsers() {
		return users;
	}

	public void setUsers(Set<Users> users) {
		this.users = users;
	}

	public Set<Recommended> getRecommended() {
		return recommended;
	}

	public void setRecommended(Set<Recommended> recommended) {
		this.recommended = recommended;
	}

}
