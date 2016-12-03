package com.tang.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tang.model.Book;
import com.tang.model.BookType;
import com.tang.util.HibernateUtil;

/**
 * 创建图书表
 * @author TangXW
 *
 */
public class BookTest {
	private Session sess = null;
	private Transaction tx = null;
	@Before
	public void bookBefore(){
		sess = HibernateUtil.currentSession();
	}
	
	@After
	public void bookAfter(){
		HibernateUtil.closeSession();
	}
	
	/**
	 * 测试数据表创建
	 */
	@Test
	public void bookTest(){
		tx = sess.beginTransaction();
		Book book = new Book();
		book.setBookname("javaweb实战");
		book.setAuthor("LiXinghua");
		BookType bookType = (BookType) sess.get(BookType.class, 1);
		book.setBookType(bookType);
		book.setPublish("北京出版社");
		book.setPrice(66.5);
		sess.save(book);
		tx.commit();
	}
}
