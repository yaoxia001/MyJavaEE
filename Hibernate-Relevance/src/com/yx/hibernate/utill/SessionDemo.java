package com.yx.hibernate.utill;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionDemo {
	private Session session = null;
	private static SessionFactory sessionFactory = null;

	/**
	 * ��ȡsession
	 * 
	 * @return
	 */
	public Session getSession() {
		// ��ȡ�����ļ�������sessionFactory����
		sessionFactory = new Configuration().configure().buildSessionFactory();
		// ����session����
		session = sessionFactory.openSession();
		return session;
	}

	/**
	 * �ر�session
	 */
	public void closeSession() {
		if (session != null)
			session.close();
		if (sessionFactory != null)
			sessionFactory.close();
	}

}
