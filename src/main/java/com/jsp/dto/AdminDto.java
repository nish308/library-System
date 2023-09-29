package com.jsp.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class AdminDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminid;
	private String name;
	private String email;
	private String password;
	
//	@OneToOne
//	private LibrarianDto librarianDto; 
//	
//	public LibrarianDto getLibrarianDto() {
//		return librarianDto;
//	}
//	public void setLibrarianDto(LibrarianDto librarianDto) {
//		this.librarianDto = librarianDto;
//	}
	
	public int getAdminid() {
		return adminid;
	}
	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
