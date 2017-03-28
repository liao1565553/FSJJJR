package com.fsj.service;

import java.util.List;
import java.util.Map;

import com.fsj.entity.Img;

//图片业务逻辑接口
public interface ImgDAO {
	// 查询所有
	public int queryAll(String hql, Map<String, Object> map);

	public List<Img> querypage(int pageNumber, int pageSize, String hql,
			Map<String, Object> map);

	// 图片注册
	public boolean addImg(Img img);

	// 图片更新
	public boolean updateImg(Img img);

	// 删除图片
	public boolean deleteImg(int iid);
}
