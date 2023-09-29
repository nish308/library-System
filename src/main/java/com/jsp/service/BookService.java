package com.jsp.service;

import java.util.List;

import com.jsp.dao.BookDao;
import com.jsp.dto.Book;

public class BookService {
	
	BookDao bookDao = new BookDao();
	
	public void saveBook(Book book) {
		book.setStatus("Available");
		bookDao.saveBook(book);
	}
	
	public Book deleteBookById(int id) {
		Book book = getBookById(id);
		if (book != null) {
			return bookDao.deleteBookById(id);
		}
		return null;
	}
	
	public boolean updateBook(int id, String name) {
		return bookDao.updateBook(id, name);
	}
	
	public Book getBookById(int id) {
		return bookDao.getBookById(id);
	}
	
	public List<Book> getAllBooksById(){
		return bookDao.getAllBooksById();
	}
}
