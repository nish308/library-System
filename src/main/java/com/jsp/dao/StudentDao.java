package com.jsp.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.jsp.dto.Student;

public class StudentDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("nish");
	
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public Student saveStudent(Student student) {
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		return student;
	}

	// done
	public Student deleteStudentById(int id) {
		Student student = entityManager.find(Student.class, id);
		entityTransaction.begin();
		entityManager.remove(student);
		entityTransaction.commit();
		return student;
	}

	public Student updateStudentNameById(int id, String newname) {
		Student student = entityManager.find(Student.class, id);
		student.setStudent_name(newname);
		entityTransaction.begin();
		entityManager.merge(student);
		entityTransaction.commit();
		return student;
	}

	public Student updateStudentMailById(int id, String newmail) {
		Student student = entityManager.find(Student.class, id);
		student.setEmail(newmail);
		entityTransaction.begin();
		entityManager.merge(student);
		entityTransaction.commit();
		return student;
	}

	// done
	public Student getStudentById(int id) {
		Student student = entityManager.find(Student.class, id);
		return student;
	}

	// done
	public List<Student> getAllStudents() {
		String sql = "SELECT s FROM Student s";
		Query query = entityManager.createQuery(sql);
		List<Student> students = query.getResultList();
		return students;
	}

}
