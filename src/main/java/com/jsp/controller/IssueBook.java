package com.jsp.controller;

import com.jsp.service.LibraryService;

public class IssueBook {
	public static void main(String[] args) {
		
		LibraryService libraryService = new LibraryService();
		boolean res = libraryService.issueBookById(2, 1, 2);
		System.out.println(res);
	}
}
