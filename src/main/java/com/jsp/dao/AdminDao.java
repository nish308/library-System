package com.jsp.dao;

import java.util.List;
import javax.persistence.Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import com.jsp.dto.AdminDto;

public class AdminDao {
	
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("nish");
	
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	//To Save Admin data
	public void saveAdmin(AdminDto admin) {
		entityTransaction.begin();
		entityManager.persist(admin);
		entityTransaction.commit();
	}
	
//	To delete the admin
	public void deleteAdmin(int id) {
		AdminDto admin = entityManager.find(AdminDto.class, id);
		if(admin != null) {
		entityTransaction.begin();
		entityManager.remove(admin);
		entityTransaction.commit();
		System.out.println("Admin Deleted...");
		}
		else {
			System.out.println("Id not found!");
		}
	}
	
	//To get user by id
	public boolean getById(int id, String email, String password) {
		AdminDto admin = entityManager.find(AdminDto.class, id);
		if(admin != null) {
			System.out.println(admin.getAdminid());
			System.out.println(admin.getEmail());
			System.out.println(admin.getPassword());
			
			return true;
		}
		return false;
		
	}
	
	//To Update the admin
	public boolean updateAdmin(int id, String password) {
		AdminDto admin = entityManager.find(AdminDto.class, id);
		admin.setPassword(password);
		entityTransaction.begin();
		entityManager.merge(admin);
		entityTransaction.commit();
		return true;
	}
	
	public AdminDto getAdminById(int id) {

		AdminDto admin = entityManager.find(AdminDto.class, id);
		System.out.println("=========================");
		System.out.print(admin.getAdminid() + " " + "| ");
		System.out.print(admin.getName() + " " + "| ");
		System.out.print(admin.getEmail() + " " + "| ");
		System.out.println(admin.getPassword() + " " + "| ");
		System.out.println("=========================");
		return admin;
	}

	public List<AdminDto> getAllAdmins() {

		String sql = "SELECT a FROM AdminDto a";
		Query query = entityManager.createQuery(sql);
		List<AdminDto> admins = query.getResultList();
		for (AdminDto a : admins) {
			System.out.println("=========================");
			System.out.print(a.getAdminid() + " " + "| ");
			System.out.print(a.getName() + " " + "| ");
			System.out.print(a.getEmail() + " " + "| ");
			System.out.println(a.getPassword() + " " + "| ");
			System.out.println("=========================");
		}
		return admins;
	}
}
