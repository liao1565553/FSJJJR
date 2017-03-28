package com.fsj.service;

import java.util.List;
import java.util.Map;

import com.fsj.entity.Users;

//用户业务逻辑接口
public interface UsersDAO {
	// 用户登录方法
	public List<Users> usersLogin(String hql);

	// 查询所有
	public int queryAll(String hql, Map<String, Object> map);

	public List<Users> querypage(int pageNumber, int pageSize, String hql,
			Map<String, Object> map);

	// 用户注册
	public boolean addUsers(Users users);

	// 用户更新
	public boolean updateUsers(Users users);

	// 删除用户
	public boolean deleteUsers(String phone);
}
