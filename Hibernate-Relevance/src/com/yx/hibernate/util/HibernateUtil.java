package com.yx.hibernate.util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class HibernateUtil
{
	public static final SessionFactory sessionFactory;

	static
	{
		try
		{
			// ʹ��Ĭ�ϵ�hibernate.cfg.xml�����ļ�����Configurationʵ��
			Configuration cfg = new Configuration()
					//.addAnnotatedClass(org.crazyit.app.unidirection.N1nojointable.Person.class)
					//.addAnnotatedClass(org.crazyit.app.unidirection.N1nojointable.Address.class)
					//.addAnnotatedClass(org.crazyit.app.unidirection.N1jointable.Person.class)
					//.addAnnotatedClass(org.crazyit.app.unidirection.N1jointable.Address.class)
					//.addAnnotatedClass(org.crazyit.app.unidirection.oneone.fk.Person.class)
					//.addAnnotatedClass(org.crazyit.app.unidirection.oneone.fk.Address.class)
					//.addAnnotatedClass(org.crazyit.app.unidirection.oneone.jointable.Person.class)
					//.addAnnotatedClass(org.crazyit.app.unidirection.oneone.jointable.Address.class)
					//.addAnnotatedClass(org.crazyit.app.unidirection.oneN.noJointable.Person.class)
					//.addAnnotatedClass(org.crazyit.app.unidirection.oneN.noJointable.Address.class)
					//.addAnnotatedClass(org.crazyit.app.unidirection.oneN.Jointable.Person.class)
					//.addAnnotatedClass(org.crazyit.app.unidirection.oneN.Jointable.Address.class)
					.configure();
			//AnnotationConfiguration cfg = new AnnotationConfiguration().configure();
			// ��Configurationʵ��������SessionFactoryʵ��
			//ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				//.applySettings(cfg.getProperties()).build();
			//sessionFactory = cfg.buildSessionFactory(serviceRegistry); version 4.X
			sessionFactory = cfg.buildSessionFactory();	//version5.x
		}
		catch (Throwable ex)
		{
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	// ThreadLocal���Ը������̵߳����ݹ�����˲�����Ҫ���߳�ͬ��
	public static final ThreadLocal<Session> session
		= new ThreadLocal<Session>();

	public static Session currentSession()
		throws HibernateException
	{
		Session s = session.get();
		// ������̻߳�û��Session,�򴴽�һ���µ�Session
		if (s == null)
		{
			s = sessionFactory.openSession();
			// ����õ�Session�����洢��ThreadLocal����session��
			session.set(s);
		}
		return s;
	}

	public static void closeSession()
		throws HibernateException
	{
		Session s = session.get();
		if (s != null)
			s.close();
		session.set(null);
	}
}