package com.jsp.service;

import java.util.List;

import com.jsp.dao.StudentDao;
import com.jsp.dto.Student;

public class StudentService {
	
	StudentDao studentDao = new StudentDao();

	// done
	public Student saveStudent(Student student) {
		return studentDao.saveStudent(student);
	}

	// done
	public Student deleteStudentById(int id) {
		Student student = getStudentById(id);
		if (student != null) {
			return studentDao.deleteStudentById(id);
		}
		return null;
	}

	public Student updateStudentNameById(int id, String newname) {
		Student student = getStudentById(id);
		if (student != null) {
			return studentDao.updateStudentNameById(id, newname);
		}
		return null;
	}

	public Student updateStudentMailById(int id, String newmail) {
		Student student = getStudentById(id);
		if (student != null) {
			return studentDao.updateStudentMailById(id, newmail);
		}
		return null;
	}

	public Student getStudentById(int id) {
		return studentDao.getStudentById(id);
	}

	public List<Student> getAllStudents() {
		return studentDao.getAllStudents();
	}

}
