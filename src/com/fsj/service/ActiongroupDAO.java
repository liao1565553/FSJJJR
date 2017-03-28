package com.fsj.service;

import java.util.List;
import java.util.Map;

import com.fsj.entity.Actiongroup;

//权限分栏业务逻辑接口
public interface ActiongroupDAO {
	// 查询所有
	public int queryAll(String hql, Map<String, Object> map);

	public List<Actiongroup> querypage(int pageNumber, int pageSize,
			String hql, Map<String, Object> map);

	// 权限分栏注册
	public boolean addActiongroup(Actiongroup actiongroup);

	// 权限分栏更新
	public boolean updateActiongroup(Actiongroup actiongroup);

	// 删除权限分栏
	public boolean deleteActiongroup(int agid);
}
