package com.yx.hibernate.utill;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionDemo {
	private Session session = null;
	private static SessionFactory sessionFactory = null;

	/**
	 * 获取session
	 * 
	 * @return
	 */
	public Session getSession() {
		// 读取配置文件，创建sessionFactory对象
		sessionFactory = new Configuration().configure().buildSessionFactory();
		// 创建session对象
		session = sessionFactory.openSession();
		return session;
	}

	/**
	 * 关闭session
	 */
	public void closeSession() {
		if (session != null)
			session.close();
		if (sessionFactory != null)
			sessionFactory.close();
	}

}
