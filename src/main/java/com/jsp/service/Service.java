package com.jsp.service;

import java.util.List;

import com.jsp.dao.AdminDao;
import com.jsp.dao.LibraryDao;
import com.jsp.dto.AdminDto;
import com.jsp.dto.LibrarianDto;

public class Service {
	
	AdminDao adminDao = new AdminDao();
	LibraryDao librarianDao=new LibraryDao();
	
	public void saveAdmin(AdminDto admin) {
		adminDao.saveAdmin(admin);
	}
	
	public void deleteAdmin(int id) {
		adminDao.deleteAdmin(id);
	}
	
	public boolean updateAdmin(int id, String password) {
		return adminDao.updateAdmin(id, password);
	}
	
	public boolean getById(int id, String email, String password) {
		return adminDao.getById(id, email, password);
	}
	
	public AdminDto getAdminById(int id) {
		return adminDao.getAdminById(id);
	}

	public List<AdminDto> getAllAdmins() {
		return adminDao.getAllAdmins();
	}
	
	public boolean approveLibrarianById(int id, int adminid) {
		LibrarianDto librarian = librarianDao.getLibrarianById(id);
		AdminDto admin=adminDao.getAdminById(adminid);
		if(librarian!=null && admin!=null) {
			librarian.setStatus("authorized");
			librarian.setAdminDto(admin);
			return librarianDao.approve(librarian); 
		}
		return false;
	}
}
