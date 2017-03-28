package com.fsj.action;

import java.util.HashMap;
import java.util.Map;

import com.fsj.entity.Recommended;
import com.fsj.entity.Pager;
import com.fsj.service.RecommendedDAO;
import com.fsj.service.impl.RecommendedDAOImpl;

//被推荐详情Action动作类
public class RecommendedAction extends SuperAction {

	private static final long serialVersionUID = 1L;

	// 保存总页数
	public Pager<Recommended> getPageCount(String hql, Map<String, Object> map) {
		// 定义业务逻辑类的对象
		Pager<Recommended> pager = new Pager<Recommended>();
		RecommendedDAO recommendeddao = new RecommendedDAOImpl();
		pager.setRowCount(recommendeddao.queryAll(hql, map));// 总记录数
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

	// 实现查询所有被推荐详情的操作（可选查询条件：被推荐人，推荐人，推荐是否成功）
	public String query() {
		StringBuffer hql = new StringBuffer();
		hql.append("select count(*) from Recommended as recommended where 1=1 ");

		Map<String, Object> map = new HashMap<String, Object>();

		if (request.getParameter("custom") != null
				&& request.getParameter("custom").length() > 0) {
			map.put("custom", "%" + request.getParameter("custom") + "%");
			hql.append("and recommended.custom.phone like :custom ");
		}
		if (request.getParameter("users") != null
				&& request.getParameter("users").length() > 0) {
			map.put("users", "%" + request.getParameter("users") + "%");
			hql.append("and recommended.users.phone like :users ");
		}
		if (request.getParameter("isflag") != null
				&& request.getParameter("isflag").length() > 0) {
			map.put("isflag",
					Boolean.parseBoolean(request.getParameter("isflag")));
			hql.append("and recommended.isflag like :isflag ");
		}

		String queryHql = hql.substring(16);

		// 定义业务逻辑类的对象
		Pager<Recommended> pager = getPageCount(hql.toString(), map);
		RecommendedDAO recommendeddao = new RecommendedDAOImpl();
		pager.setPageNo(getPageNumber());
		pager.setResult(recommendeddao.querypage(pager.getPageNo(),
				pager.getPageSize(), queryHql, map));
		// 将传出的集合数据list放入session中，首先判断list数据
		if (pager.getResult() != null && pager.getResult().size() > 0) {
			// 在session中保存list信息到list中，将来可以调用
			session.setAttribute("pager", pager);
		}
		return "query";
	}

	// 添加被推荐详情操作
	public String add() throws Exception {
		Recommended recommended = new Recommended();
		RecommendedDAO recommendeddao = new RecommendedDAOImpl();
		recommendeddao.addRecommended(setAll(recommended));
		return "operationsuccess";
	}

	// 更新被推荐详情操作
	public String save() throws Exception {
		Recommended recommended = new Recommended();
		RecommendedDAO recommendeddao = new RecommendedDAOImpl();
		recommendeddao.updateRecommended(setAll(recommended));
		return "operationsuccess";
	}

	// 删除被推荐详情操作
	public String delete() {
		// 定义被推荐详情业务逻辑类的对象
		RecommendedDAO recommendeddao = new RecommendedDAOImpl();
		int rcustom = Integer.parseInt(request.getParameter("rcustom"));
		int rusers = Integer.parseInt(request.getParameter("rusers"));
		recommendeddao.deleteRecommended(rcustom, rusers);
		return "operationsuccess";
	}

	// 持久化类
	public Recommended setAll(Recommended recommended) throws Exception {
		return recommended;
	}

}
