package com.student.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.student.sms.entity.Student;
import com.student.sms.repository.StudentRepository;

@SpringBootApplication
public class StudetentManagementSystemApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StudetentManagementSystemApplication.class, args);
	}

	@Autowired
	private final StudentRepository studentRepos;
	
	public StudetentManagementSystemApplication(StudentRepository studentRepos) {
		super();
		this.studentRepos = studentRepos;
	}

	@Override
	public void run(String... args) throws Exception {
//	   Student student1 = new Student("Ujwal","Singh","ujwal@gmail.com");
//	   Student student2 = new Student("Pankaj","Sharam","pankaj@gmail.com");
//	   Student student3 = new Student("Mihir","Shinde","mihir@gmail.com");
//	   Student student4 = new Student("Shubham","Patil","shubham@gmail.com");
//	   studentRepos.save(student1);
//	   studentRepos.save(student2);
//	   studentRepos.save(student3);
//	   studentRepos.save(student4);
	   
		
	}

}
