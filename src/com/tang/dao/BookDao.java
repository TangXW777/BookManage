package com.tang.dao;

import java.util.List;

import com.tang.model.Book;

public interface BookDao {
	// 查找全部图书
	List<Book> findAll();
	
	// 删除图书
	void delete(int bookid);
	
	// 根据id查书
	Book getBook(int bookid);
	
	// 修改图书
	void modifyBook(Book book);
	
	// 增加图书
	void add(Book book);
}
