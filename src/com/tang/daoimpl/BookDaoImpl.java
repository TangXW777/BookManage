package com.tang.daoimpl;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tang.dao.BookDao;
import com.tang.model.Book;
import com.tang.util.HibernateUtil;

public class BookDaoImpl implements BookDao{

	// 查找全部图书
	public List<Book> findAll() {
		List<Book> list = null;
		Session sess = HibernateUtil.currentSession();
		// Transaction tx = sess.beginTransaction();
		String hql = " from Book";
		list = sess.createQuery(hql).list();
		HibernateUtil.closeSession();
		return list;
	}

	// 删除图书
	public void delete(int bookid) {
		Session sess = HibernateUtil.currentSession();
		Transaction tx = sess.beginTransaction();
		Book book = (Book) sess.get(Book.class, bookid);
		sess.delete(book);
		tx.commit();
		HibernateUtil.closeSession();
	}
	
	// 获得某本图书
	public Book getBook(int bookid) {
		Session sess = HibernateUtil.currentSession();
		Book book = (Book) sess.get(Book.class, bookid);
		HibernateUtil.closeSession();
		return book;
	}
	
	// 修改图书
	public void modifyBook(Book book) {
		Session sess = HibernateUtil.currentSession();
		Transaction tx = sess.beginTransaction();
		sess.update(book);
		tx.commit();
		HibernateUtil.closeSession();
	}

	public void add(Book book) {
		Session sess = HibernateUtil.currentSession();
		Transaction tx = sess.beginTransaction();
		sess.save(book);
		tx.commit();
		HibernateUtil.closeSession();
	}

}
