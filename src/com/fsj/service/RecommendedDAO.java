package com.fsj.service;

import java.util.List;
import java.util.Map;

import com.fsj.entity.Recommended;

//被推荐详情业务逻辑接口
public interface RecommendedDAO {
	// 查询所有
	public int queryAll(String hql, Map<String, Object> map);

	public List<Recommended> querypage(int pageNumber, int pageSize,
			String hql, Map<String, Object> map);

	// 被推荐详情注册
	public boolean addRecommended(Recommended recommended);

	// 被推荐详情更新
	public boolean updateRecommended(Recommended recommended);

	// 删除被推荐详情
	public boolean deleteRecommended(int rcustom, int rusers);
}
