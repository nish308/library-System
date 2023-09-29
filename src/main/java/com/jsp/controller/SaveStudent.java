package com.jsp.controller;

import com.jsp.dto.Student;
import com.jsp.service.StudentService;

public class SaveStudent {
	public static void main(String[] args) {
		StudentService studentService = new StudentService();
		Student student = new Student();

		student.setStudent_name("student6");
		student.setEmail("s6@mail.com");

		studentService.saveStudent(student);
	}
}
