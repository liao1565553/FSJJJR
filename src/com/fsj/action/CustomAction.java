package com.fsj.action;

import java.util.HashMap;
import java.util.Map;

import com.fsj.entity.Custom;
import com.fsj.entity.Pager;
import com.fsj.service.CustomDAO;
import com.fsj.service.impl.CustomDAOImpl;

//客户Action动作类
public class CustomAction extends SuperAction {

	private static final long serialVersionUID = 1L;

	// 保存总页数
	public Pager<Custom> getPageCount(String hql, Map<String, Object> map) {
		// 定义业务逻辑类的对象
		Pager<Custom> pager = new Pager<Custom>();
		CustomDAO customdao = new CustomDAOImpl();
		pager.setRowCount(customdao.queryAll(hql, map));// 总记录数
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

	// 实现查询所有客户的操作（可选查询条件：电话，姓名）
	public String query() {
		StringBuffer hql = new StringBuffer();
		hql.append("select count(phone) from Custom as custom where 1=1 ");

		Map<String, Object> map = new HashMap<String, Object>();

		if (request.getParameter("phone") != null
				&& request.getParameter("phone").length() > 0) {
			map.put("phone", "%" + request.getParameter("phone") + "%");
			hql.append("and custom.phone like :phone ");
		}
		if (request.getParameter("name") != null
				&& request.getParameter("name").length() > 0) {
			map.put("name", "%" + request.getParameter("name") + "%");
			hql.append("and custom.name like :name ");
		}

		String queryHql = hql.substring(20);

		// 定义业务逻辑类的对象
		Pager<Custom> pager = getPageCount(hql.toString(), map);
		CustomDAO customdao = new CustomDAOImpl();
		pager.setPageNo(getPageNumber());
		pager.setResult(customdao.querypage(pager.getPageNo(),
				pager.getPageSize(), queryHql, map));
		// 将传出的集合数据list放入session中，首先判断list数据
		if (pager.getResult() != null && pager.getResult().size() > 0) {
			// 在session中保存list信息到list中，将来可以调用
			session.setAttribute("pager", pager);
		}
		return "query";
	}

	// 添加客户操作
	public String add() throws Exception {
		Custom custom = new Custom();
		CustomDAO customdao = new CustomDAOImpl();
		customdao.addCustom(setAll(custom));
		return "operationsuccess";
	}

	// 更新客户操作
	public String save() throws Exception {
		Custom custom = new Custom();
		CustomDAO customdao = new CustomDAOImpl();
		customdao.updateCustom(setAll(custom));
		return "operationsuccess";
	}

	// 删除客户操作
	public String delete() {
		// 定义客户业务逻辑类的对象
		CustomDAO customdao = new CustomDAOImpl();
		String phone = request.getParameter("phone"); // 获得传过来的要删除客户的id值
		customdao.deleteCustom(phone);
		return "operationsuccess";
	}

	// 持久化类
	public Custom setAll(Custom custom) throws Exception {
		return custom;
	}

}
