package com.tang.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tang.dao.BookDao;
import com.tang.daoimpl.BookDaoImpl;
import com.tang.daoimpl.BookTypeDaoImpl;
import com.tang.model.Book;
import com.tang.model.BookType;

public class BookAction extends ActionSupport{
	private BookDao service = new BookDaoImpl();
	private List<Book> bookList = new ArrayList<Book>();
	private Book book = new Book();
	
	/**
	 * 展示全部图书
	 * @return
	 */
	public String show(){
		bookList = service.findAll();
		
		return SUCCESS;
	}
	
	/**
	 * 删除图书
	 * @return
	 */
	public String delete(){
		int bookid = Integer.parseInt(ServletActionContext.getRequest()
				.getParameter("bookid"));
		service.delete(bookid);
		return SUCCESS;
	}
	
	public String preModify(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int bookid = Integer.parseInt(request.getParameter("bookid"));
		Book book = service.getBook(bookid);
		List<BookType> bookTypeList = new BookTypeDaoImpl().findAll();
		request.setAttribute("book", book);
		request.setAttribute("bookTypeList", bookTypeList);
		return SUCCESS;
	}
	
	public String modify(){
		BookType bookType = new BookTypeDaoImpl().getType(book.getBookType().getBookTypeId());
		book.setBookType(bookType);
		service.modifyBook(book);
		return SUCCESS;
	}
	
	public String preAdd(){
		List<BookType> bookTypeList = new BookTypeDaoImpl().findAll();
		ActionContext ctx = ActionContext.getContext();
		ctx.put("bookTypeList", bookTypeList);
		return SUCCESS;
	}
	
	public String add(){
		BookType bookType = new BookTypeDaoImpl().getType(book.getBookType().getBookTypeId());
		book.setBookType(bookType);
		service.add(book);
		return SUCCESS;
	}
	
	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	
	
	
	
}
