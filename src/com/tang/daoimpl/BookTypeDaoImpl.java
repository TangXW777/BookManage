package com.tang.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tang.dao.BookTypeDao;
import com.tang.model.BookType;
import com.tang.util.HibernateUtil;

public class BookTypeDaoImpl implements BookTypeDao{

	public List<BookType> findAll() {
		Session sess = HibernateUtil.currentSession();
		// Transaction tx = sess.beginTransaction();
		String hql = "from BookType";
		List bookTypeList = sess.createQuery(hql).list();
		HibernateUtil.closeSession();
		return bookTypeList;
	}

	public BookType getType(int typeid) {
		Session sess = HibernateUtil.currentSession();
		BookType bookType = (BookType) sess.get(BookType.class, typeid);
		HibernateUtil.closeSession();
		return bookType;
	}
	
}
