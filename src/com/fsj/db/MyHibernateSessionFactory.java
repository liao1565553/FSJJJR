package com.fsj.db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MyHibernateSessionFactory {
	private static SessionFactory sessionFactory;// 会话工厂属性

	// 构造方法私有化、保证单例模式
	private MyHibernateSessionFactory() {

	}

	// 公有的静态方法，获得会话工厂对象
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			// 创建配置对象,读取hibernate.cfg.xml文件，完成初始化；
			Configuration config = new Configuration().configure();
			// 创建服务注册对象(低版本hibernate写法)
			ServiceRegistryBuilder builder = new ServiceRegistryBuilder()
					.applySettings(config.getProperties());
			ServiceRegistry serviceRegistry = builder.buildServiceRegistry();
			// 创建SessionFactory对象
			sessionFactory = config.buildSessionFactory(serviceRegistry);
			return sessionFactory;
		} else {
			return sessionFactory;
		}

	}

}
