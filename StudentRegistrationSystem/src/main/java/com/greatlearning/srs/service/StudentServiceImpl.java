package com.greatlearning.srs.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greatlearning.srs.entity.Student;
import com.greatlearning.srs.repository.StudentRepository;

@Repository
public class StudentServiceImpl 
	implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public List<Student> findAll() {
		
		return studentRepository.findAll();
	}
	
	
	public void save(Student theStudent) {

		studentRepository.save(theStudent);

	}


	public Student findById(int id) {

		return studentRepository.findById(id).get();
	}


	@Override
	public void deleteById(int theId) {
		
		studentRepository.deleteById(theId);
		
	}
	

}

