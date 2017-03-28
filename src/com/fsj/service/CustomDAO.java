package com.fsj.service;

import java.util.List;
import java.util.Map;

import com.fsj.entity.Custom;

//客户业务逻辑接口
public interface CustomDAO {
	// 查询所有
	public int queryAll(String hql, Map<String, Object> map);

	public List<Custom> querypage(int pageNumber, int pageSize, String hql,
			Map<String, Object> map);

	// 客户注册
	public boolean addCustom(Custom custom);

	// 客户更新
	public boolean updateCustom(Custom custom);

	// 删除客户
	public boolean deleteCustom(String phone);
}
