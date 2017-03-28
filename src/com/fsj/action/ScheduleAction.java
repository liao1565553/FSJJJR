package com.fsj.action;

import java.util.HashMap;
import java.util.Map;

import com.fsj.entity.Schedule;
import com.fsj.entity.Pager;
import com.fsj.service.ScheduleDAO;
import com.fsj.service.impl.ScheduleDAOImpl;

//进度Action动作类
public class ScheduleAction extends SuperAction {

	private static final long serialVersionUID = 1L;

	// 保存总页数
	public Pager<Schedule> getPageCount(String hql, Map<String, Object> map) {
		// 定义业务逻辑类的对象
		Pager<Schedule> pager = new Pager<Schedule>();
		ScheduleDAO scheduledao = new ScheduleDAOImpl();
		pager.setRowCount(scheduledao.queryAll(hql, map));// 总记录数
		// 将传出的集合数据list放入session中，首先判断list数据
		if (pager.getRowCount() > 0) {
			// 在session中保存
			int t1 = pager.getRowCount() % pager.getPageSize();
			int t2 = pager.getRowCount() / pager.getPageSize();
			pager.setPageCount(t1 == 0 ? t2 : t2 + 1);
		} else {
			pager.setPageCount(0);
		}
		return pager;
	}

	// 获取当前页数
	public int getPageNumber() {
		String number = request.getParameter("pageNumber");
		if (number == null) {
			return 1;
		} else {
			int pageNumber = Integer.parseInt(number); // 获得传过来的pageNumber值
			return pageNumber;
		}
	}

	// 实现查询所有进度的操作（可选查询条件：进度状态）
	public String query() {
		StringBuffer hql = new StringBuffer();
		hql.append("select count(sid) from Schedule as schedule where 1=1 ");

		Map<String, Object> map = new HashMap<String, Object>();

		if (request.getParameter("schedulestate") != null
				&& request.getParameter("schedulestate").length() > 0) {
			map.put("schedulestate",
					Integer.parseInt(request.getParameter("schedulestate")));
			hql.append("and schedule.schedulestate.ssid like :schedulestate ");
		}

		String queryHql = hql.substring(18);

		// 定义业务逻辑类的对象
		Pager<Schedule> pager = getPageCount(hql.toString(), map);
		ScheduleDAO scheduledao = new ScheduleDAOImpl();
		pager.setPageNo(getPageNumber());
		pager.setResult(scheduledao.querypage(pager.getPageNo(),
				pager.getPageSize(), queryHql, map));
		// 将传出的集合数据list放入session中，首先判断list数据
		if (pager.getResult() != null && pager.getResult().size() > 0) {
			// 在session中保存list信息到list中，将来可以调用
			session.setAttribute("pager", pager);
		}
		return "query";
	}

	// 添加进度操作
	public String add() throws Exception {
		Schedule schedule = new Schedule();
		ScheduleDAO scheduledao = new ScheduleDAOImpl();
		scheduledao.addSchedule(setAll(schedule));
		return "operationsuccess";
	}

	// 更新进度操作
	public String save() throws Exception {
		Schedule schedule = new Schedule();
		ScheduleDAO scheduledao = new ScheduleDAOImpl();
		scheduledao.updateSchedule(setAll(schedule));
		return "operationsuccess";
	}

	// 删除进度操作
	public String delete() {
		// 定义进度业务逻辑类的对象
		ScheduleDAO scheduledao = new ScheduleDAOImpl();
		int sid = Integer.parseInt(request.getParameter("sid")); // 获得传过来的要删除进度的id值
		scheduledao.deleteSchedule(sid);
		return "operationsuccess";
	}

	// 持久化类
	public Schedule setAll(Schedule schedule) throws Exception {
		return schedule;
	}

}
