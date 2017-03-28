package com.fsj.action;

import java.util.HashMap;
import java.util.Map;

import com.fsj.entity.Managergroup;
import com.fsj.entity.Pager;
import com.fsj.service.ManagergroupDAO;
import com.fsj.service.impl.ManagergroupDAOImpl;

//用户管理组Action动作类
public class ManagergroupAction extends SuperAction {

	private static final long serialVersionUID = 1L;

	// 保存总页数
	public Pager<Managergroup> getPageCount(String hql, Map<String, Object> map) {
		// 定义业务逻辑类的对象
		Pager<Managergroup> pager = new Pager<Managergroup>();
		ManagergroupDAO managergroupdao = new ManagergroupDAOImpl();
		pager.setRowCount(managergroupdao.queryAll(hql, map));// 总记录数
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

	// 实现查询所有用户管理组的操作（可选查询条件：名称）
	public String query() {
		StringBuffer hql = new StringBuffer();
		hql.append("select count(mgid) from Managergroup as managergroup where 1=1 ");

		Map<String, Object> map = new HashMap<String, Object>();

		if (request.getParameter("name") != null
				&& request.getParameter("name").length() > 0) {
			map.put("name", "%" + request.getParameter("name") + "%");
			hql.append("and managergroup.name like :name ");
		}

		String queryHql = hql.substring(19);

		// 定义业务逻辑类的对象
		Pager<Managergroup> pager = getPageCount(hql.toString(), map);
		ManagergroupDAO managergroupdao = new ManagergroupDAOImpl();
		pager.setPageNo(getPageNumber());
		pager.setResult(managergroupdao.querypage(pager.getPageNo(),
				pager.getPageSize(), queryHql, map));
		// 将传出的集合数据list放入session中，首先判断list数据
		if (pager.getResult() != null && pager.getResult().size() > 0) {
			// 在session中保存list信息到list中，将来可以调用
			session.setAttribute("pager", pager);
		}
		return "query";
	}

	// 添加用户管理组操作
	public String add() throws Exception {
		Managergroup managergroup = new Managergroup();
		ManagergroupDAO managergroupdao = new ManagergroupDAOImpl();
		managergroupdao.addManagergroup(setAll(managergroup));
		return "operationsuccess";
	}

	// 更新用户管理组操作
	public String save() throws Exception {
		Managergroup managergroup = new Managergroup();
		ManagergroupDAO managergroupdao = new ManagergroupDAOImpl();
		managergroupdao.updateManagergroup(setAll(managergroup));
		return "operationsuccess";
	}

	// 删除用户管理组操作
	public String delete() {
		// 定义用户管理组业务逻辑类的对象
		ManagergroupDAO managergroupdao = new ManagergroupDAOImpl();
		int mgid = Integer.parseInt(request.getParameter("mgid")); // 获得传过来的要删除用户管理组的id值
		managergroupdao.deleteManagergroup(mgid);
		return "operationsuccess";
	}

	// 持久化类
	public Managergroup setAll(Managergroup managergroup) throws Exception {
		return managergroup;
	}

}
