package com.tang.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 图书分类持久化类
 * @author TangXW
 *
 */

@Entity
@Table(name="booktype")
public class BookType {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bookTypeId;
	
	@Column(nullable=false)
	private String typeName;
	
	public BookType(){
		
	}

	public BookType(int bookTypeId, String typeName) {
		this.bookTypeId = bookTypeId;
		this.typeName = typeName;
	}
	
	public BookType(String typeName) {
		this.typeName = typeName;
	}

	public int getBookTypeId() {
		return bookTypeId;
	}

	public void setBookTypeId(int bookTypeId) {
		this.bookTypeId = bookTypeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	
}
