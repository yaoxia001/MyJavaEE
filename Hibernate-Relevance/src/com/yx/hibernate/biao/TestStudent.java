package com.yx.hibernate.biao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class TestStudent {
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

	private void test() {
		session = getSession();
		Transaction t = session.beginTransaction();// 开始事务
		/*Student s = new Student("jack", 25, "qinghua");*/ //不知道为什么这段代码添加不了数据
		Student s=new Student();
		s.setName("jack");
		s.setAge(25);
		s.setSchool("清华大学");
		session.save(s);
		t.commit();
		session.close();
	}

	public static void main(String[] args) {
		TestStudent t = new TestStudent();
		t.test();
		sessionFactory.close();
	}
}
