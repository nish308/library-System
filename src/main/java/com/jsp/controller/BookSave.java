package com.jsp.controller;

import com.jsp.dto.Book;
import com.jsp.service.BookService;
import com.jsp.service.LibraryService;

public class BookSave {
	public static void main(String[] args) {
		BookService bookService = new BookService();
		Book book = new Book();
		LibraryService libraryService = new LibraryService();
		book.setBook_name("Chemistry");
		book.setStatus("available");
		
//		bookService.getBookById(1);
//		bookService.getAllBooksById();
		
		libraryService.saveBook(book, 1);
//		libraryService.deleteBook(2);
	}
}
