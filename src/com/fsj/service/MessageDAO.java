package com.fsj.service;

import java.util.List;
import java.util.Map;

import com.fsj.entity.Message;

//消息业务逻辑接口
public interface MessageDAO {
	// 查询所有
	public int queryAll(String hql, Map<String, Object> map);

	public List<Message> querypage(int pageNumber, int pageSize, String hql,
			Map<String, Object> map);

	// 消息注册
	public boolean addMessage(Message message);

	// 消息更新
	public boolean updateMessage(Message message);

	// 删除消息
	public boolean deleteMessage(int mid);
}
