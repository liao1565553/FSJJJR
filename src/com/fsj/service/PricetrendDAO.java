package com.fsj.service;

import java.util.List;
import java.util.Map;

import com.fsj.entity.Pricetrend;

//价格走势业务逻辑接口
public interface PricetrendDAO {
	// 查询所有
	public int queryAll(String hql, Map<String, Object> map);

	public List<Pricetrend> querypage(int pageNumber, int pageSize, String hql,
			Map<String, Object> map);

	// 价格走势注册
	public boolean addPricetrend(Pricetrend pricetrend);

	// 价格走势更新
	public boolean updatePricetrend(Pricetrend pricetrend);

	// 删除价格走势
	public boolean deletePricetrend(int ptid);
}
