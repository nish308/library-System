package com.jsp.controller;

import com.jsp.dto.AdminDto;
import com.jsp.service.Service;

public class AdminSave {
	public static void main(String[] args) {
		
		Service service = new Service();
		AdminDto admin = new AdminDto();
		admin.setName("nishant");
		admin.setEmail("nish@mail.com");
		admin.setPassword("nish#123");
		service.saveAdmin(admin);
	}
}
