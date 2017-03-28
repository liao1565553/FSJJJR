package com.fsj.action;

import java.util.HashMap;
import java.util.Map;

import com.fsj.entity.House;
import com.fsj.entity.Pager;
import com.fsj.service.HouseDAO;
import com.fsj.service.impl.HouseDAOImpl;

//房屋Action动作类
public class HouseAction extends SuperAction {

	private static final long serialVersionUID = 1L;

	// 保存总页数
	public Pager<House> getPageCount(String hql, Map<String, Object> map) {
		// 定义业务逻辑类的对象
		Pager<House> pager = new Pager<House>();
		HouseDAO housedao = new HouseDAOImpl();
		pager.setRowCount(housedao.queryAll(hql, map));// 总记录数
		// 将传出的集合数据list放入session中，首先判断list数据
		if (pager.getRowCount() > 0) {
			// 在session中保存
			int t1 = pager.getRowCount() % pager.getPageSize();
			int t2 = pager.getRowCount() / pager.getPageSize();
			pager.setPageCount(t1 == 0 ? t2 : t2 + 1);
		} else {
			pager.setPageCount(0);
		}
		return pager;
	}

	// 获取当前页数
	public int getPageNumber() {
		String number = request.getParameter("pageNumber");
		if (number == null) {
			return 1;
		} else {
			int pageNumber = Integer.parseInt(number); // 获得传过来的pageNumber值
			return pageNumber;
		}
	}

	// 实现查询所有房屋的操作（可选查询条件：标题，户型，销售状态，装修程度，其他信息（租赁或出售））
	public String query() {
		StringBuffer hql = new StringBuffer();
		hql.append("select count(hid) from House as house where 1=1 ");

		Map<String, Object> map = new HashMap<String, Object>();

		if (request.getParameter("title") != null
				&& request.getParameter("title").length() > 0) {
			map.put("title", "%" + request.getParameter("title") + "%");
			hql.append("and house.title like :title ");
		}
		if (request.getParameter("type") != null
				&& request.getParameter("type").length() > 0) {
			map.put("type", "%" + request.getParameter("type") + "%");
			hql.append("and house.type like :type ");
		}
		if (request.getParameter("salestate") != null
				&& request.getParameter("salestate").length() > 0) {
			map.put("salestate", "%" + request.getParameter("salestate") + "%");
			hql.append("and house.salestate like :salestate ");
		}
		if (request.getParameter("decorationdegree") != null
				&& request.getParameter("decorationdegree").length() > 0) {
			map.put("decorationdegree",
					"%" + request.getParameter("decorationdegree") + "%");
			hql.append("and house.decorationdegree like :decorationdegree ");
		}
		if (request.getParameter("otherInfo") != null
				&& request.getParameter("otherInfo").length() > 0) {
			map.put("otherInfo", "%" + request.getParameter("otherInfo") + "%");
			hql.append("and house.otherInfo like :otherInfo ");
		}

		String queryHql = hql.substring(18);

		// 定义业务逻辑类的对象
		Pager<House> pager = getPageCount(hql.toString(), map);
		HouseDAO housedao = new HouseDAOImpl();
		pager.setPageNo(getPageNumber());
		pager.setResult(housedao.querypage(pager.getPageNo(),
				pager.getPageSize(), queryHql, map));
		// 将传出的集合数据list放入session中，首先判断list数据
		if (pager.getResult() != null && pager.getResult().size() > 0) {
			// 在session中保存list信息到list中，将来可以调用
			session.setAttribute("pager", pager);
		}
		return "query";
	}

	// 添加房屋操作
	public String add() throws Exception {
		House house = new House();
		HouseDAO housedao = new HouseDAOImpl();
		housedao.addHouse(setAll(house));
		return "operationsuccess";
	}

	// 更新房屋操作
	public String save() throws Exception {
		House house = new House();
		HouseDAO housedao = new HouseDAOImpl();
		housedao.updateHouse(setAll(house));
		return "operationsuccess";
	}

	// 删除房屋操作
	public String delete() {
		// 定义房屋业务逻辑类的对象
		HouseDAO housedao = new HouseDAOImpl();
		int hid = Integer.parseInt(request.getParameter("hid")); // 获得传过来的要删除房屋的id值
		housedao.deleteHouse(hid);
		return "operationsuccess";
	}

	// 持久化类
	public House setAll(House house) throws Exception {
		return house;
	}

}
