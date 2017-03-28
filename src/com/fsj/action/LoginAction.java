package com.fsj.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.fsj.entity.Users;
import com.fsj.service.UsersDAO;
import com.fsj.service.impl.UsersDAOImpl;
import com.opensymphony.xwork2.ModelDriven;

//用户Action动作类
public class LoginAction extends SuperAction implements ModelDriven<Users> {

	private static final long serialVersionUID = 1L;
	private Users users = new Users();

	// 经纪人登录操作
	public String login() {
		UsersDAO usersdao = new UsersDAOImpl();
		String hql = "from Users where phone=" + users.getPhone()
				+ " and password=" + users.getPassword();
		List<Users> lu = usersdao.usersLogin(hql);
		if (lu != null && lu.get(0).getJob().equals("经纪人")) {
			// 在session中保存登录成功的用户信息
			// user=null;
			session.setAttribute("users", lu.get(0));
			return "login";
		} else {
			return "failure";
		}
	}

	// 管理员登录操作
	public void loginAdmin() {
		UsersDAO usersdao = new UsersDAOImpl();
		String hql = "from Users as users left outer join fetch users.managergroup as um left outer join fetch um.action where users.phone="
				+ users.getPhone()
				+ " and users.password="
				+ users.getPassword();
		List<Users> lu = usersdao.usersLogin(hql);
		if (lu != null && !lu.get(0).getJob().equals("经纪人")) {
			// 在session中保存登录成功的用户信息
			// user=null;
			session.setAttribute("users", lu.get(0));
			PrintWriter out;
			try {
				out = response.getWriter();
				out.print("123");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//return "loginAdmin";
		} else {
			//return "failure";
		}
	}

	// 用户登出操作
	public String logout() {
		if (session.getAttribute("users") != null) {
			// 在session中清除登录成功的用户名
			session.removeAttribute("users");
			// 返回注销成功界面，要在structs.xml文件中说明
		}
		return "logout";
	}

	@Override
	public Users getModel() {
		return this.users;
	}

}
