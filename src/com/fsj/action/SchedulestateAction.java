package com.fsj.action;

import java.util.HashMap;
import java.util.Map;

import com.fsj.entity.Schedulestate;
import com.fsj.entity.Pager;
import com.fsj.service.SchedulestateDAO;
import com.fsj.service.impl.SchedulestateDAOImpl;

//进度状态Action动作类
public class SchedulestateAction extends SuperAction {

	private static final long serialVersionUID = 1L;

	// 保存总页数
	public Pager<Schedulestate> getPageCount(String hql, Map<String, Object> map) {
		// 定义业务逻辑类的对象
		Pager<Schedulestate> pager = new Pager<Schedulestate>();
		SchedulestateDAO schedulestatedao = new SchedulestateDAOImpl();
		pager.setRowCount(schedulestatedao.queryAll(hql, map));// 总记录数
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

	// 实现查询所有进度状态的操作（可选查询条件：进度状态名称）
	public String query() {
		StringBuffer hql = new StringBuffer();
		hql.append("select count(ssid) from Schedulestate as schedulestate where 1=1 ");

		Map<String, Object> map = new HashMap<String, Object>();

		if (request.getParameter("statename") != null
				&& request.getParameter("statename").length() > 0) {
			map.put("statename", "%" + request.getParameter("statename") + "%");
			hql.append("and schedulestate.statename like :statename ");
		}

		String queryHql = hql.substring(18);

		// 定义业务逻辑类的对象
		Pager<Schedulestate> pager = getPageCount(hql.toString(), map);
		SchedulestateDAO schedulestatedao = new SchedulestateDAOImpl();
		pager.setPageNo(getPageNumber());
		pager.setResult(schedulestatedao.querypage(pager.getPageNo(),
				pager.getPageSize(), queryHql, map));
		// 将传出的集合数据list放入session中，首先判断list数据
		if (pager.getResult() != null && pager.getResult().size() > 0) {
			// 在session中保存list信息到list中，将来可以调用
			session.setAttribute("pager", pager);
		}
		return "query";
	}

	// 添加进度状态操作
	public String add() throws Exception {
		Schedulestate schedulestate = new Schedulestate();
		SchedulestateDAO schedulestatedao = new SchedulestateDAOImpl();
		schedulestatedao.addSchedulestate(setAll(schedulestate));
		return "operationsuccess";
	}

	// 更新进度状态操作
	public String save() throws Exception {
		Schedulestate schedulestate = new Schedulestate();
		SchedulestateDAO schedulestatedao = new SchedulestateDAOImpl();
		schedulestatedao.updateSchedulestate(setAll(schedulestate));
		return "operationsuccess";
	}

	// 删除进度状态操作
	public String delete() {
		// 定义进度状态业务逻辑类的对象
		SchedulestateDAO schedulestatedao = new SchedulestateDAOImpl();
		int ssid = Integer.parseInt(request.getParameter("ssid")); // 获得传过来的要删除进度状态的id值
		schedulestatedao.deleteSchedulestate(ssid);
		return "operationsuccess";
	}

	// 持久化类
	public Schedulestate setAll(Schedulestate schedulestate) throws Exception {
		return schedulestate;
	}

}
