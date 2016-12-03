package com.tang.dao;

import java.util.List;

import com.tang.model.BookType;

public interface BookTypeDao {
	// 查找全部
	List<BookType> findAll();
	
	// 根据id查找
	BookType getType(int typeid);
}
