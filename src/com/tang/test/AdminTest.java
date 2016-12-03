package com.tang.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tang.model.Admin;
import com.tang.util.HibernateUtil;

/**
 * 用户测试类
 * @author TangXW
 *
 */
public class AdminTest {
	private Session sess = null;
	private Transaction tx = null;
	@Before
	public void adminBefore(){
		sess = HibernateUtil.currentSession();
	}
	
	@After
	public void adminAfter(){
		HibernateUtil.closeSession();
	}
	
	/**
	 * 测试数据表创建
	 */
	@Test
	public void adminTest(){
		Admin admin = new Admin("tang", "123");
		tx = sess.beginTransaction();
		sess.save(admin);
		tx.commit();
	}
}
