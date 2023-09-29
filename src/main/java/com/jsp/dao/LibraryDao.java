package com.jsp.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.jsp.dto.LibrarianDto;

public class LibraryDao {
	
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("nish");
	
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	//To Save Librarian Data
	public void saveLibrarian(LibrarianDto library) {
		entityTransaction.begin();
		entityManager.persist(library);
		entityTransaction.commit();
	}
	
	//To update The Librarian Data
	public boolean updateLibrarian(int id, String password) {
		LibrarianDto library = entityManager.find(LibrarianDto.class, id);
		library.setPassword(password);
		entityTransaction.begin();
		entityManager.merge(library);
		entityTransaction.commit();
		return true;
	}
	
	public LibrarianDto getLibrarianById(int id) {

		LibrarianDto librarian = entityManager.find(LibrarianDto.class, id);
		System.out.println("===================================");
		System.out.print(librarian.getId() + " " + "| ");
		System.out.print(librarian.getName() + " " + "| ");
		System.out.print(librarian.getEmail() + " " + "| ");
		System.out.println(librarian.getStatus() + " " + "| ");
		System.out.println("===================================");
		return librarian;
	}
	
	public boolean approve(LibrarianDto librarian) {
		entityTransaction.begin();
		entityManager.merge(librarian);
		entityTransaction.commit();
		return true;
	}

	public List<LibrarianDto> getAllLibrarians() {

		String sql = "SELECT l FROM Librarian l";
		Query query = entityManager.createQuery(sql);
		List<LibrarianDto> librarian = query.getResultList();
		for (LibrarianDto l : librarian) {
			System.out.println("===================================");
			System.out.print(l.getId() + " " + "| ");
			System.out.print(l.getName() + " " + "| ");
			System.out.print(l.getEmail() + " " + "| ");
			System.out.println(l.getStatus() + " " + "| ");
			System.out.println("===================================");
		}
		return librarian;
	}
}
