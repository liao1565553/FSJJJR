package com.fsj.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fsj.db.MyHibernateSessionFactory;
import com.fsj.entity.Pricetrend;
import com.fsj.service.PricetrendDAO;

//价格走势业务逻辑接口的实现类
public class PricetrendDAOImpl implements PricetrendDAO {
	@Override
	public int queryAll(String hql, Map<String, Object> map) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try {
			// 获得会话
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			// 开启事物对象
			tx = session.beginTransaction();
			// 进行查询操作
			Query query = session.createQuery(hql);

			Iterator it = map.keySet().iterator();
			while (it.hasNext()) {
				Object key = it.next();
				query.setParameter(key.toString(), map.get(key));
			}

			// 定义返回，查询到的记录集
			Number i = (Number) query.list().get(0);
			tx.commit();
			return i.intValue();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();// 撤销事务
			}
			ex.printStackTrace();
			return 0;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	@Override
	public List<Pricetrend> querypage(int pageNumber, int pageSize, String hql,
			Map<String, Object> map) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		List<Pricetrend> listpage = null;
		try {
			// 获得会话
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			// 开启事物对象
			tx = session.beginTransaction();
			Query query = session.createQuery(hql);

			Iterator it = map.keySet().iterator();
			while (it.hasNext()) {
				Object key = it.next();
				query.setParameter(key.toString(), map.get(key));
			}

			query.setFirstResult((pageNumber - 1) * pageSize);
			query.setMaxResults(pageSize);
			// 定义返回，查询到的记录集
			listpage = query.list();
			tx.commit();
			return listpage;
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();// 撤销事务
			}
			ex.printStackTrace();
			return listpage;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	@Override
	public boolean addPricetrend(Pricetrend pricetrend) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try {
			// 获得会话
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			// 开启事物对象
			tx = session.beginTransaction();
			// 保存数据
			session.save(pricetrend);
			tx.commit();
			return true;
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();// 撤销事务
			}
			ex.printStackTrace();
			return false;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	@Override
	public boolean updatePricetrend(Pricetrend pricetrend) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try {
			// 获得会话
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			// 开启事物对象
			tx = session.beginTransaction();
			// 保存数据
			session.update(pricetrend);
			tx.commit();
			return true;
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();// 撤销事务
			}
			ex.printStackTrace();
			return false;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	@Override
	public boolean deletePricetrend(int ptid) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try {
			// 获得会话
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			// 开启事物对象
			tx = session.beginTransaction();
			// 获得指定编号的价格走势
			Pricetrend pricetrend = (Pricetrend) session.get(Pricetrend.class,
					ptid);
			// 删除该价格走势
			session.delete(pricetrend);
			// 提交事物
			tx.commit();
			return true;
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();// 撤销事务
			}
			ex.printStackTrace();
			return false;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

}
