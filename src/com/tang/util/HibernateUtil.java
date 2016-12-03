package com.tang.util;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * 获取hibernate session
 * 用ThreadLocal隔离多个线程数据共享
 * @author TangXW
 *
 */
public class HibernateUtil {
	public static final SessionFactory sessionFactory;
	
	// ThreadLoacl可以隔离多个线程共享，所以不需要线程同步
	public static ThreadLocal<Session> session = new ThreadLocal<Session>();
	
	static{
		try{
			// 默认配置
			Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
			// 用cfg创建SessionFactory
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(cfg.getProperties()).build();
			
			sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		}catch(Throwable ex){
			System.err.println("初始化SessionFactory失败" + ex);
			throw new ExceptionInInitializerError(ex);
		}
		
	}
	
	/**
	 * 获得当前Session
	 */
	public static Session currentSession() throws HibernateException{
		Session s = session.get();
		
		// 如果没有，则创建，放入ThreadLocal中
		if(s == null){
			s = sessionFactory.openSession();
			session.set(s);
		}
		
		return s;
		
	}
	
	/**
	 * 关闭Session，同时将ThreadLocal中Session设置为null
	 * @throws HibernateException
	 */
	public static void closeSession() throws HibernateException{
		Session s = session.get();
		if(s != null){
			s.close();
		}
		session.set(null);
	}
	
}
