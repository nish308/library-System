package com.jsp.controller;

import com.jsp.dto.LibrarianDto;
import com.jsp.service.LibraryService;

public class LibrarianSave {
	public static void main(String[] args) {
		
		LibraryService libraryService = new LibraryService();
		LibrarianDto librarianDto = new LibrarianDto();
		librarianDto.setName("Vishal");
		librarianDto.setEmail("vishal@mail.com");
		librarianDto.setPassword("vishal@1452");
		librarianDto.setStatus("authorized");
		libraryService.saveLibrarian(librarianDto);
	}
}
