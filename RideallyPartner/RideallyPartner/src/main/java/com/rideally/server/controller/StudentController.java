package com.rideally.server.controller;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.rideally.server.model.Student;
import com.rideally.server.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService serv ;
	
	
	@GetMapping("/getDate")
	public Date getStudent() {
		return new Date();
		}
//	<?> This means Generic
	@PostMapping("/v1/student")
	public ResponseEntity<?> createStudent(@RequestBody Student s) {
		Student s1 = serv.CreateStudent(s);
		return ResponseEntity.status(HttpStatus.OK).body("data exits");
	}
	
	@GetMapping("/v1/student")
	public Iterable<Student> fetchStudent() {
		return serv.getStudents();
	}
	
	@GetMapping("/v1/student/{id}")
	public Student fetchStudentById(@PathVariable int id  ) {
		return serv.getStudentById(id);
	}
	
	@PutMapping("/v1/student/{id}")
	public Student updateStudent(@RequestBody Student s) {
		return serv.updateStudent(s);
	}
	
	@DeleteMapping("/v1/student/{id}")
	public boolean deleteStudent(@PathVariable int id) {
		return serv.deleteStudent(id);
	}
	
//	Get data by email id 
	
	@GetMapping("/v1/student/email/{emailId}")
	public Student fetchStudentByEmail(@PathVariable String emailId) {
		return serv.getStudentByEmail(emailId);
	}
	
	@DeleteMapping("/v1/student/email/{emailId}")
	public boolean deleteStudentByEmail(@PathVariable String emailId) {
		return serv.deleteStudentByEmail(emailId);
	}
	
//	Based on email id update the age 
	@PutMapping("/v1/student/emailId/{emailId}")
	public String updateStudentage(@PathVariable String emailId, @RequestBody String age) {
		return serv.updateStudentAge(emailId, age);
	}
}
