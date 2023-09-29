package com.jsp.controller;

import com.jsp.service.Service;
import com.jsp.dto.LibrarianDto;
import com.jsp.service.LibraryService;

public class Authorized {
	public static void main(String[] args) {
		Service service = new Service();
		boolean res = service.approveLibrarianById(2, 1);
		System.out.println(res);
	}
}
