package com.fsj.action;

import java.util.HashMap;
import java.util.Map;

import com.fsj.entity.Actiongroup;
import com.fsj.entity.Pager;
import com.fsj.service.ActiongroupDAO;
import com.fsj.service.impl.ActiongroupDAOImpl;

//权限分栏Action动作类
public class ActiongroupAction extends SuperAction {

	private static final long serialVersionUID = 1L;

	// 保存总页数
	public Pager<Actiongroup> getPageCount(String hql, Map<String, Object> map) {
		// 定义业务逻辑类的对象
		Pager<Actiongroup> pager = new Pager<Actiongroup>();
		ActiongroupDAO actiongroupdao = new ActiongroupDAOImpl();
		pager.setRowCount(actiongroupdao.queryAll(hql, map));// 总记录数
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

	// 实现查询所有权限分栏的操作（可选查询条件：名称）
	public String query() {
		StringBuffer hql = new StringBuffer();
		hql.append("select count(agid) from Actiongroup as actiongroup where 1=1 ");

		Map<String, Object> map = new HashMap<String, Object>();

		if (request.getParameter("name") != null
				&& request.getParameter("name").length() > 0) {
			map.put("name", "%" + request.getParameter("name") + "%");
			hql.append("and actiongroup.name like :name ");
		}

		String queryHql = hql.substring(19);

		// 定义业务逻辑类的对象
		Pager<Actiongroup> pager = getPageCount(hql.toString(), map);
		ActiongroupDAO actiongroupdao = new ActiongroupDAOImpl();
		pager.setPageNo(getPageNumber());
		pager.setResult(actiongroupdao.querypage(pager.getPageNo(),
				pager.getPageSize(), queryHql, map));
		// 将传出的集合数据list放入session中，首先判断list数据
		if (pager.getResult() != null && pager.getResult().size() > 0) {
			// 在session中保存list信息到list中，将来可以调用
			session.setAttribute("pager", pager);
		}
		return "query";
	}

	// 添加权限分栏操作
	public String add() throws Exception {
		Actiongroup actiongroup = new Actiongroup();
		ActiongroupDAO actiongroupdao = new ActiongroupDAOImpl();
		actiongroupdao.addActiongroup(setAll(actiongroup));
		return "operationsuccess";
	}

	// 更新权限分栏操作
	public String save() throws Exception {
		Actiongroup actiongroup = new Actiongroup();
		ActiongroupDAO actiongroupdao = new ActiongroupDAOImpl();
		actiongroupdao.updateActiongroup(setAll(actiongroup));
		return "operationsuccess";
	}

	// 删除权限分栏操作
	public String delete() {
		// 定义权限分栏业务逻辑类的对象
		ActiongroupDAO actiongroupdao = new ActiongroupDAOImpl();
		int agid = Integer.parseInt(request.getParameter("agid")); // 获得传过来的要删除权限分栏的id值
		actiongroupdao.deleteActiongroup(agid);
		return "operationsuccess";
	}

	// 持久化类
	public Actiongroup setAll(Actiongroup actiongroup) throws Exception {
		return actiongroup;
	}

}
