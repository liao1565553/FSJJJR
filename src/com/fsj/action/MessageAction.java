package com.fsj.action;

import java.util.HashMap;
import java.util.Map;

import com.fsj.entity.Message;
import com.fsj.entity.Pager;
import com.fsj.service.MessageDAO;
import com.fsj.service.impl.MessageDAOImpl;

//消息Action动作类
public class MessageAction extends SuperAction {

	private static final long serialVersionUID = 1L;

	// 保存总页数
	public Pager<Message> getPageCount(String hql, Map<String, Object> map) {
		// 定义业务逻辑类的对象
		Pager<Message> pager = new Pager<Message>();
		MessageDAO messagedao = new MessageDAOImpl();
		pager.setRowCount(messagedao.queryAll(hql, map));// 总记录数
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

	// 实现查询所有消息的操作（可选查询条件：消息状态）
	public String query() {
		StringBuffer hql = new StringBuffer();
		hql.append("select count(mid) from Message as message where 1=1 ");

		Map<String, Object> map = new HashMap<String, Object>();

		if (request.getParameter("state") != null
				&& request.getParameter("state").length() > 0) {
			map.put("state", "%" + request.getParameter("state") + "%");
			hql.append("and message.state like :state ");
		}

		String queryHql = hql.substring(18);

		// 定义业务逻辑类的对象
		Pager<Message> pager = getPageCount(hql.toString(), map);
		MessageDAO messagedao = new MessageDAOImpl();
		pager.setPageNo(getPageNumber());
		pager.setResult(messagedao.querypage(pager.getPageNo(),
				pager.getPageSize(), queryHql, map));
		// 将传出的集合数据list放入session中，首先判断list数据
		if (pager.getResult() != null && pager.getResult().size() > 0) {
			// 在session中保存list信息到list中，将来可以调用
			session.setAttribute("pager", pager);
		}
		return "query";
	}

	// 添加消息操作
	public String add() throws Exception {
		Message message = new Message();
		MessageDAO messagedao = new MessageDAOImpl();
		messagedao.addMessage(setAll(message));
		return "operationsuccess";
	}

	// 更新消息操作
	public String save() throws Exception {
		Message message = new Message();
		MessageDAO messagedao = new MessageDAOImpl();
		messagedao.updateMessage(setAll(message));
		return "operationsuccess";
	}

	// 删除消息操作
	public String delete() {
		// 定义消息业务逻辑类的对象
		MessageDAO messagedao = new MessageDAOImpl();
		int mid = Integer.parseInt(request.getParameter("mid")); // 获得传过来的要删除消息的id值
		messagedao.deleteMessage(mid);
		return "operationsuccess";
	}

	// 持久化类
	public Message setAll(Message message) throws Exception {
		return message;
	}

}
