	package com.jsp.service;

import java.util.List;

import com.jsp.dao.BookDao;
import com.jsp.dao.LibraryDao;
import com.jsp.dao.StudentDao;
import com.jsp.dto.Book;
import com.jsp.dto.LibrarianDto;
import com.jsp.dto.Student;

public class LibraryService {
	
	StudentDao studentDao = new StudentDao();
	LibraryDao libraryDao = new LibraryDao();
	BookDao bookDao = new BookDao();
	
	public void saveBook(Book book, int id) {
		LibrarianDto librarian = libraryDao.getLibrarianById(id);
		if(librarian != null && librarian.getId() == 1 && librarian.getStatus().equalsIgnoreCase("authorized")) {
			bookDao.saveBook(book);
		}
	}
	
	public void deleteBook(int id) {
		LibrarianDto librarian = libraryDao.getLibrarianById(id);
		if(librarian != null && librarian.getStatus().equalsIgnoreCase("authorized")) {
			bookDao.deleteBook(id);
		}
	}
	
	public LibrarianDto saveLibrarian(LibrarianDto librarian) {
		librarian.setStatus("unauthorized");
		libraryDao.saveLibrarian(librarian);
		return librarian;
	}
	
	public boolean approve(LibrarianDto librarian) {
		return libraryDao.approve(librarian);
	}
	
	public boolean updateLibrarian(int id, String password) {
		return libraryDao.updateLibrarian(id, password);
	}
	
	public LibrarianDto getLibrarianById(int id) {
		return libraryDao.getLibrarianById(id);
	}

	public List<LibrarianDto> getAllLibrarians() {
		return libraryDao.getAllLibrarians();
	}
	
	public boolean issueBookById(int bookid, int libid, int studid) {
		Book book = bookDao.getBookById(bookid);
		Student student = studentDao.getStudentById(studid);
		LibrarianDto librarian = libraryDao.getLibrarianById(libid);
		if (librarian != null && book != null && student != null) {
			book.setStatus("Issued");
			book.setStudent(student);
			book.setLibrarian(librarian);
			return bookDao.issue(book);
		}
		return false;
	}

}
