package com.yx.hibernate.guanlian;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yx.hibernate.util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		Test test=new Test();
		test.testPerson();
		HibernateUtil.sessionFactory.close();

	}

	private void testPerson() {
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		Person p = new Person();
		p.setAge(22);
		p.setName("hibernate");
		Address a1 = new Address("anhui");
		p.setAddress(a1);
		session.persist(a1);
		Address a2 = new Address("hulan");
		session.persist(a2);
		session.save(p);
		tx.commit();
		HibernateUtil.closeSession();
	}

}
