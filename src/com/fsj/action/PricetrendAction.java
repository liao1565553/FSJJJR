package com.fsj.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import com.fsj.entity.Pricetrend;
import com.fsj.entity.Pager;
import com.fsj.service.PricetrendDAO;
import com.fsj.service.impl.PricetrendDAOImpl;

//价格走势Action动作类
public class PricetrendAction extends SuperAction {

	private static final long serialVersionUID = 1L;

	// 保存总页数
	public Pager<Pricetrend> getPageCount(String hql, Map<String, Object> map) {
		// 定义业务逻辑类的对象
		Pager<Pricetrend> pager = new Pager<Pricetrend>();
		PricetrendDAO pricetrenddao = new PricetrendDAOImpl();
		pager.setRowCount(pricetrenddao.queryAll(hql, map));// 总记录数
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

	// 实现查询所有价格走势的操作（可选查询条件：记录日期，记录级别，所属房屋）
	public String query() {
		StringBuffer hql = new StringBuffer();
		hql.append("select count(ptid) from Pricetrend as pricetrend where 1=1 ");

		Map<String, Object> map = new HashMap<String, Object>();

		if (request.getParameter("recorddate") != null
				&& request.getParameter("recorddate").length() > 0) {
			try {
				map.put("recorddate", new SimpleDateFormat("yyyy-MM-dd")
						.parse(request.getParameter("recorddate")));
				hql.append("and pricetrend.recorddate like :recorddate ");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (request.getParameter("grade") != null
				&& request.getParameter("grade").length() > 0) {
			map.put("grade", request.getParameter("grade"));
			hql.append("and pricetrend.grade like :grade ");
		}
		if (request.getParameter("house") != null
				&& request.getParameter("house").length() > 0) {
			map.put("house", Integer.parseInt(request.getParameter("house")));
			hql.append("and pricetrend.house.hid like :house ");
		}

		String queryHql = hql.substring(19);

		// 定义业务逻辑类的对象
		Pager<Pricetrend> pager = getPageCount(hql.toString(), map);
		PricetrendDAO pricetrenddao = new PricetrendDAOImpl();
		pager.setPageNo(getPageNumber());
		pager.setResult(pricetrenddao.querypage(pager.getPageNo(),
				pager.getPageSize(), queryHql, map));
		// 将传出的集合数据list放入session中，首先判断list数据
		if (pager.getResult() != null && pager.getResult().size() > 0) {
			// 在session中保存list信息到list中，将来可以调用
			session.setAttribute("pager", pager);
		}
		return "query";
	}

	// 添加价格走势操作
	public String add() throws Exception {
		Pricetrend pricetrend = new Pricetrend();
		PricetrendDAO pricetrenddao = new PricetrendDAOImpl();
		pricetrenddao.addPricetrend(setAll(pricetrend));
		return "operationsuccess";
	}

	// 更新价格走势操作
	public String save() throws Exception {
		Pricetrend pricetrend = new Pricetrend();
		PricetrendDAO pricetrenddao = new PricetrendDAOImpl();
		pricetrenddao.updatePricetrend(setAll(pricetrend));
		return "operationsuccess";
	}

	// 删除价格走势操作
	public String delete() {
		// 定义价格走势业务逻辑类的对象
		PricetrendDAO pricetrenddao = new PricetrendDAOImpl();
		int ptid = Integer.parseInt(request.getParameter("ptid")); // 获得传过来的要删除价格走势的id值
		pricetrenddao.deletePricetrend(ptid);
		return "operationsuccess";
	}

	// 持久化类
	public Pricetrend setAll(Pricetrend pricetrend) throws Exception {
		return pricetrend;
	}

}
