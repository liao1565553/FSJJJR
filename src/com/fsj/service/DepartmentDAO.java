package com.fsj.service;

import java.util.List;
import java.util.Map;

import com.fsj.entity.Department;

//部门业务逻辑接口
public interface DepartmentDAO {
	// 查询所有
	public int queryAll(String hql, Map<String, Object> map);

	public List<Department> querypage(int pageNumber, int pageSize, String hql,
			Map<String, Object> map);

	// 部门注册
	public boolean addDepartment(Department department);

	// 部门更新
	public boolean updateDepartment(Department department);

	// 删除部门
	public boolean deleteDepartment(int did);
}
