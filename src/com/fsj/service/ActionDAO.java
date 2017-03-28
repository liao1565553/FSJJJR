package com.fsj.service;

import java.util.List;
import java.util.Map;

import com.fsj.entity.Action;

//权限业务逻辑接口
public interface ActionDAO {
	// 查询所有
	public int queryAll(String hql, Map<String, Object> map);

	public List<Action> querypage(int pageNumber, int pageSize, String hql,
			Map<String, Object> map);

	// 权限注册
	public boolean addAction(Action action);

	// 权限更新
	public boolean updateAction(Action action);

	// 删除权限
	public boolean deleteAction(int aid);
}
