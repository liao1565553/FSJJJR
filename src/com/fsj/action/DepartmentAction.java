package com.fsj.action;

import java.util.HashMap;
import java.util.Map;

import com.fsj.entity.Department;
import com.fsj.entity.Pager;
import com.fsj.service.DepartmentDAO;
import com.fsj.service.impl.DepartmentDAOImpl;

//部门Action动作类
public class DepartmentAction extends SuperAction {

	private static final long serialVersionUID = 1L;

	// 保存总页数
	public Pager<Department> getPageCount(String hql, Map<String, Object> map) {
		// 定义业务逻辑类的对象
		Pager<Department> pager = new Pager<Department>();
		DepartmentDAO departmentdao = new DepartmentDAOImpl();
		pager.setRowCount(departmentdao.queryAll(hql, map));// 总记录数
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

	// 实现查询所有部门的操作（可选查询条件：名称）
	public String query() {
		StringBuffer hql = new StringBuffer();
		hql.append("select count(did) from Department as department where 1=1 ");

		Map<String, Object> map = new HashMap<String, Object>();

		if (request.getParameter("name") != null
				&& request.getParameter("name").length() > 0) {
			map.put("name", "%" + request.getParameter("name") + "%");
			hql.append("and department.name like :name ");
		}

		String queryHql = hql.substring(18);

		// 定义业务逻辑类的对象
		Pager<Department> pager = getPageCount(hql.toString(), map);
		DepartmentDAO departmentdao = new DepartmentDAOImpl();
		pager.setPageNo(getPageNumber());
		pager.setResult(departmentdao.querypage(pager.getPageNo(),
				pager.getPageSize(), queryHql, map));
		// 将传出的集合数据list放入session中，首先判断list数据
		if (pager.getResult() != null && pager.getResult().size() > 0) {
			// 在session中保存list信息到list中，将来可以调用
			session.setAttribute("pager", pager);
		}
		return "query";
	}

	// 添加部门操作
	public String add() throws Exception {
		Department department = new Department();
		DepartmentDAO departmentdao = new DepartmentDAOImpl();
		departmentdao.addDepartment(setAll(department));
		return "operationsuccess";
	}

	// 更新部门操作
	public String save() throws Exception {
		Department department = new Department();
		DepartmentDAO departmentdao = new DepartmentDAOImpl();
		departmentdao.updateDepartment(setAll(department));
		return "operationsuccess";
	}

	// 删除部门操作
	public String delete() {
		// 定义部门业务逻辑类的对象
		DepartmentDAO departmentdao = new DepartmentDAOImpl();
		int did = Integer.parseInt(request.getParameter("did")); // 获得传过来的要删除部门的id值
		departmentdao.deleteDepartment(did);
		return "operationsuccess";
	}

	// 持久化类
	public Department setAll(Department department) throws Exception {
		return department;
	}

}
