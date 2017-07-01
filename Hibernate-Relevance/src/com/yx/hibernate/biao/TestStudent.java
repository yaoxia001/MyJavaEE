package com.yx.hibernate.biao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class TestStudent {
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

	private void test() {
		session = getSession();
		Transaction t = session.beginTransaction();// ��ʼ����
		/*Student s = new Student("jack", 25, "qinghua");*/ //��֪��Ϊʲô��δ�����Ӳ�������
		Student s=new Student();
		s.setName("jack");
		s.setAge(25);
		s.setSchool("�廪��ѧ");
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
