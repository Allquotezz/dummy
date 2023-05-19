package com.rideally.server.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.rideally.server.model.Student;

import jakarta.transaction.Transactional;

@Repository
public interface StudentRepository extends CrudRepository<Student,Integer > {
	
	
	public Student findByEmailId(String emailId);
	
//	public long removeByEmailId(String emailId);
	@Modifying
	@Transactional
	@Query("delete from Student s where s.emailId = :emailId")
	void deleteUsersByEmailId(@Param("emailId") String emailId);
	@Modifying
	@Transactional
	@Query("update Student s set s.age= :age where s.emailId = :emailId")
	void updateUserByAge(@Param("emailId") String emailId, @Param("age") String s);
	
}
