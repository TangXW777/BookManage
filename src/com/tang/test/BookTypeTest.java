package com.tang.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tang.model.BookType;
import com.tang.util.HibernateUtil;

/**
 * 创建图书类型表
 * @author TangXW
 *
 */
public class BookTypeTest {
	private Session sess = null;
	private Transaction tx = null;
	@Before
	public void bookTypeBefore(){
		sess = HibernateUtil.currentSession();
	}
	
	@After
	public void bookTypeAfter(){
		HibernateUtil.closeSession();
	}
	
	/**
	 * 测试数据表创建
	 */
	@Test
	public void bookTypeTest(){
		tx = sess.beginTransaction();
		BookType bookType1 = new BookType();
		bookType1.setTypeName("IT");
		
		BookType bookType2 = new BookType();
		bookType2.setTypeName("经济");
		
		sess.save(bookType1);
		sess.save(bookType2);
		tx.commit();
	}
}
