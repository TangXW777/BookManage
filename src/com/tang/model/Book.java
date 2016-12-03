package com.tang.model;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * 图书持久化类
 * @author TangXW
 *
 */
@Entity
@Table(name="book")
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bookid;
	private String bookname;
	private String author;
	
	@ManyToOne(targetEntity=BookType.class, fetch=FetchType.EAGER)
	@JoinColumn(name="booktype_id", nullable=false, referencedColumnName="bookTypeId")
	@Cascade(CascadeType.SAVE_UPDATE)
	private BookType bookType;  // 图书分类
	
	private String publish;  // 出版社
	private double price;
	
	public Book(){
		
	}
	
	public Book(int bookid, String bookname, String author, BookType bookType,
			String publish, double price) {
		this.bookid = bookid;
		this.bookname = bookname;
		this.author = author;
		this.bookType = bookType;
		this.publish = publish;
		this.price = price;
	}
	
	public Book(String bookname, String author, BookType bookType,
			String publish, double price) {
		this.bookname = bookname;
		this.author = author;
		this.bookType = bookType;
		this.publish = publish;
		this.price = price;
	}


	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public BookType getBookType() {
		return bookType;
	}
	public void setBookType(BookType bookType) {
		this.bookType = bookType;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	} 
	
	
}
