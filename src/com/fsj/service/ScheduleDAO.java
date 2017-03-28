package com.fsj.service;

import java.util.List;
import java.util.Map;

import com.fsj.entity.Schedule;

//进度业务逻辑接口
public interface ScheduleDAO {
	// 查询所有
	public int queryAll(String hql, Map<String, Object> map);

	public List<Schedule> querypage(int pageNumber, int pageSize, String hql,
			Map<String, Object> map);

	// 进度注册
	public boolean addSchedule(Schedule schedule);

	// 进度更新
	public boolean updateSchedule(Schedule schedule);

	// 删除进度
	public boolean deleteSchedule(int sid);
}
