package com.fsj.service;

import java.util.List;
import java.util.Map;

import com.fsj.entity.Managergroup;

//用户管理组业务逻辑接口
public interface ManagergroupDAO {
	// 查询所有
	public int queryAll(String hql, Map<String, Object> map);

	public List<Managergroup> querypage(int pageNumber, int pageSize,
			String hql, Map<String, Object> map);

	// 用户管理组注册
	public boolean addManagergroup(Managergroup managergroup);

	// 用户管理组更新
	public boolean updateManagergroup(Managergroup managergroup);

	// 删除用户管理组
	public boolean deleteManagergroup(int mgid);
}
