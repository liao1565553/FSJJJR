package com.fsj.service;

import java.util.List;
import java.util.Map;

import com.fsj.entity.House;

//房屋业务逻辑接口
public interface HouseDAO {
	// 查询所有
	public int queryAll(String hql, Map<String, Object> map);

	public List<House> querypage(int pageNumber, int pageSize, String hql,
			Map<String, Object> map);

	// 房屋注册
	public boolean addHouse(House house);

	// 房屋更新
	public boolean updateHouse(House house);

	// 删除房屋
	public boolean deleteHouse(int hid);
}
