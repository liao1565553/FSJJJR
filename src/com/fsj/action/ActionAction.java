package com.fsj.action;

import java.util.HashMap;
import java.util.Map;

import com.fsj.entity.Action;
import com.fsj.entity.Pager;
import com.fsj.service.ActionDAO;
import com.fsj.service.impl.ActionDAOImpl;

//权限Action动作类
public class ActionAction extends SuperAction {

	private static final long serialVersionUID = 1L;

	// 保存总页数
	public Pager<Action> getPageCount(String hql, Map<String, Object> map) {
		// 定义业务逻辑类的对象
		Pager<Action> pager = new Pager<Action>();
		ActionDAO actiondao = new ActionDAOImpl();
		pager.setRowCount(actiondao.queryAll(hql, map));// 总记录数
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

	// 实现查询所有权限的操作（可选查询条件：名称）
	public String query() {
		StringBuffer hql = new StringBuffer();
		hql.append("select count(aid) from Action as action where 1=1 ");

		Map<String, Object> map = new HashMap<String, Object>();

		if (request.getParameter("name") != null
				&& request.getParameter("name").length() > 0) {
			map.put("name", "%" + request.getParameter("name") + "%");
			hql.append("and action.name like :name ");
		}

		String queryHql = hql.substring(18);

		// 定义业务逻辑类的对象
		Pager<Action> pager = getPageCount(hql.toString(), map);
		ActionDAO actiondao = new ActionDAOImpl();
		pager.setPageNo(getPageNumber());
		pager.setResult(actiondao.querypage(pager.getPageNo(),
				pager.getPageSize(), queryHql, map));
		// 将传出的集合数据list放入session中，首先判断list数据
		if (pager.getResult() != null && pager.getResult().size() > 0) {
			// 在session中保存list信息到list中，将来可以调用
			session.setAttribute("pager", pager);
		}
		return "query";
	}

	// 添加权限操作
	public String add() throws Exception {
		Action action = new Action();
		ActionDAO actiondao = new ActionDAOImpl();
		actiondao.addAction(setAll(action));
		return "operationsuccess";
	}

	// 更新权限操作
	public String save() throws Exception {
		Action action = new Action();
		ActionDAO actiondao = new ActionDAOImpl();
		actiondao.updateAction(setAll(action));
		return "operationsuccess";
	}

	// 删除权限操作
	public String delete() {
		// 定义权限业务逻辑类的对象
		ActionDAO actiondao = new ActionDAOImpl();
		int aid = Integer.parseInt(request.getParameter("aid")); // 获得传过来的要删除权限的id值
		actiondao.deleteAction(aid);
		return "operationsuccess";
	}

	// 持久化类
	public Action setAll(Action action) throws Exception {
		return action;
	}

	// 权限校验
	public boolean check() {
		boolean flag = false;
		return flag;
	}

}
