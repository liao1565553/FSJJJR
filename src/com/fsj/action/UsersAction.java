package com.fsj.action;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fsj.entity.Action;
import com.fsj.entity.Managergroup;
import com.fsj.entity.Pager;
import com.fsj.entity.Users;
import com.fsj.service.UsersDAO;
import com.fsj.service.impl.UsersDAOImpl;

//用户Action动作类
public class UsersAction extends SuperAction {

	private static final long serialVersionUID = 1L;

	// 保存总页数
	public Pager<Users> getPageCount(String hql, Map<String, Object> map) {
		// 定义业务逻辑类的对象
		Pager<Users> pager = new Pager<Users>();
		UsersDAO usersdao = new UsersDAOImpl();
		pager.setRowCount(usersdao.queryAll(hql, map));// 总记录数
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

	// 实现查询所有用户的操作（可选查询条件：电话，真实姓名，性别，职位，部门）
	public String query() {
		if (check("Users_query")) {
			StringBuffer hql = new StringBuffer();
			hql.append("select count(phone) from Users as users where 1=1 ");

			Map<String, Object> map = new HashMap<String, Object>();

			if (request.getParameter("phone") != null
					&& request.getParameter("phone").length() > 0) {
				map.put("phone", "%" + request.getParameter("phone") + "%");
				hql.append("and users.phone like :phone ");
			}
			if (request.getParameter("realname") != null
					&& request.getParameter("realname").length() > 0) {
				map.put("realname", "%" + request.getParameter("realname")
						+ "%");
				hql.append("and users.realname like :realname ");
			}
			if (request.getParameter("sex") != null
					&& request.getParameter("sex").length() > 0) {
				map.put("sex", request.getParameter("sex"));
				hql.append("and users.sex like :sex ");
			}
			if (request.getParameter("job") != null
					&& request.getParameter("job").length() > 0) {
				map.put("job", "%" + request.getParameter("job") + "%");
				hql.append("and users.job like :job ");
			}
			if (request.getParameter("department") != null
					&& request.getParameter("department").length() > 0) {
				map.put("department",
						Integer.parseInt(request.getParameter("department")));
				hql.append("and users.department.did like :department ");
			}

			String queryHql = hql.substring(20);
			// 定义业务逻辑类的对象
			Pager<Users> pager = getPageCount(hql.toString(), map);
			UsersDAO usersdao = new UsersDAOImpl();
			pager.setPageNo(getPageNumber());
			pager.setResult(usersdao.querypage(pager.getPageNo(),
					pager.getPageSize(), queryHql, map));
			// 将传出的集合数据list放入session中，首先判断list数据
			if (pager.getResult() != null && pager.getResult().size() > 0) {
				// 在session中保存list信息到list中，将来可以调用
				session.setAttribute("pager", pager);
			}
			return "query";
		} else {
			return "noaction";
		}
	}

	// 添加用户操作
	public String add() throws Exception {
		if (check("Users_add")) {
			Users users = new Users();
			UsersDAO usersdao = new UsersDAOImpl();
			usersdao.addUsers(setAll(users));
			return "operationsuccess";
		} else {
			return "noaction";
		}
	}

	// 更新用户操作
	public String save() throws Exception {
		if (check("Users_save")) {
			Users users = new Users();
			UsersDAO usersdao = new UsersDAOImpl();
			usersdao.updateUsers(setAll(users));
			return "operationsuccess";
		} else {
			return "noaction";
		}
	}

	// 删除用户操作
	public String delete() {
		if (check("Users_save")) {
			// 定义用户业务逻辑类的对象
			UsersDAO usersdao = new UsersDAOImpl();
			String phone = request.getParameter("phone"); // 获得传过来的要删除用户的id值
			usersdao.deleteUsers(phone);
			return "operationsuccess";
		} else {
			return "noaction";
		}
	}

	// 持久化类
	public Users setAll(Users users) throws Exception {
		users.setPhone(request.getParameter("phone"));
		users.setIsflag(Boolean.parseBoolean(request.getParameter("isflag")));
		users.setUidcard(request.getParameter("uidcard"));
		users.setUsername(request.getParameter("username"));
		users.setPassword(request.getParameter("password"));
		users.setSex(request.getParameter("sex"));
		// u.setMoney(Integer.parseInt(request.getParameter("money")));
		// yyyy-MM-dd HH:mm:ss
		// yyyy-MM-dd
		users.setRegistrationtime(new Date(System.currentTimeMillis()));
		return users;
	}

	// 权限校验
	public boolean check(String s) {
		boolean flag = false;
		try {
			for (Managergroup m : ((Users) session.getAttribute("users"))
					.getManagergroup()) {
				for (Action a : m.getAction()) {
					if (s.equals(a.getName())) {
						flag = true;
					}
				}
			}
		} catch (Exception e) {

		}
		return flag;
	}

}
