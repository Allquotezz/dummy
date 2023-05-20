package com.rideally.server.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rideally.server.model.Student;
import com.rideally.server.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepo;
	public Student CreateStudent(Student s) {
		return studentRepo.save(s);
	}
	public Iterable<Student> getStudents() {
		return studentRepo.findAll();
	}
	
	public Student getStudentById(int id) {
		Optional<Student> stu = studentRepo.findById(id);
		if(stu.isPresent()) {
			return stu.get();
		}else {
			return null;
		}	
	}
	
	public Student updateStudent(Student s) {
		return studentRepo.save(s);
	}
	
	public boolean deleteStudent (int id) {
		if(studentRepo.existsById(id)) {
			 studentRepo.deleteById(id);
			 return true;
		}else {
			 return false; 
		}
	}
	
	public Student getStudentByEmail(String emailId ) {
		return studentRepo.findByEmailId(emailId);
	}
	
	public boolean deleteStudentByEmail(String emailId) {
		  studentRepo.deleteUsersByEmailId(emailId);;
		  return true;
	}
	
	public String updateStudentAge(String emailId, String s) {
		studentRepo.updateUserByAge(emailId, s);
		return s;
	}
}
