package com.student.sms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.student.sms.entity.Student;
import com.student.sms.repository.StudentRepository;
import com.student.sms.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepos;
	public StudentServiceImpl(StudentRepository studentRepos) {
		super();
		this.studentRepos = studentRepos;
	}


	@Override
	public List<Student> getAllStudent() {
		return studentRepos.findAll();
	}


	@Override
	public Student saveStudent(Student student) {
		return studentRepos.save(student);
	}


	@Override
	public Student getStudentById(Long id) {
		 return studentRepos.findById(id).get();
		
	}


	@Override
	public Student updateStudent(Student student) {
		return studentRepos.save(student);

	}


	@Override
	public void deleteStudentById(Long id) {
		studentRepos.deleteById(id);
		
	}

}
