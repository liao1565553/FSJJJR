package com.fsj.service;

import java.util.List;
import java.util.Map;

import com.fsj.entity.Schedulestate;

//进度状态业务逻辑接口
public interface SchedulestateDAO {
	// 查询所有
	public int queryAll(String hql, Map<String, Object> map);

	public List<Schedulestate> querypage(int pageNumber, int pageSize,
			String hql, Map<String, Object> map);

	// 进度状态注册
	public boolean addSchedulestate(Schedulestate schedulestate);

	// 进度状态更新
	public boolean updateSchedulestate(Schedulestate schedulestate);

	// 删除进度状态
	public boolean deleteSchedulestate(int ssid);
}
