package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.Book;

public class BookDao {
	
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("nish");
	
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public void saveBook(Book book) {
		entityTransaction.begin();
		entityManager.persist(book);
		entityTransaction.commit();
	}
	
	public boolean updateBook(int id, String name) {
		Book book = entityManager.find(Book.class, id);
		entityTransaction.begin();
		entityManager.merge(book);
		entityTransaction.commit();
		
		return true;
	}
	
	public Book deleteBookById(int id) {
		Book book = entityManager.find(Book.class, id);
		entityTransaction.begin();
		entityManager.remove(book);
		entityTransaction.commit();
		return book;
	}
	
	public Book getBookById(int id) {
		Book book = entityManager.find(Book.class, id);
		System.out.println("===================================");
		System.out.print(book.getBook_id() + " ");
		System.out.print(book.getBook_name() + " ");
		System.out.println("===================================");
		return book;
	}
	
	public List<Book> getAllBooksById(){
		String sql = "select b from Book b";
		Query query = entityManager.createQuery(sql);
		List<Book>books = query.getResultList();
		for (Book b : books) {
			System.out.println("======================");
			System.out.println(b.getBook_id() + " ");
			System.out.println(b.getBook_name() + " ");			
		}
		return books;
	}
	
	public void deleteBook(int id) {
		Book book = entityManager.find(Book.class, id);
		if(book != null) {
			entityTransaction.begin();
			entityManager.remove(book);
			entityTransaction.commit();
			System.out.println("Book Deleted...");
		}
		else {
			System.out.println("Book Id Not Found");
		}
	}
	
	public boolean issue(Book book) {
		entityTransaction.begin();
		entityManager.merge(book);
		entityTransaction.commit();
		return true;
	}
}
