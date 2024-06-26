package com.student.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.student.sms.entity.Student;
import com.student.sms.service.StudentService;

@Controller
public class StudentController {
	private final StudentService studentService;
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	
	//Handler method to handle list students and return mode and view
	@GetMapping("/students")
	public String listStudent(ModelMap model) {
		model.addAttribute("students", studentService.getAllStudent());
		return "students";
	}
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		// create student object to hold student form data
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}
	
	@PostMapping("/students")
	public String saveStudents(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {
		//get student from database by id
		Student existStudent = studentService.getStudentById(id);
		existStudent.setId(id);
		existStudent.setFirstName(student.getFirstName());
		existStudent.setLastName(student.getLastName());
		existStudent.setEmail(student.getEmail());
		
		//save updated student object
		studentService.updateStudent(existStudent);
		return "redirect:/students";
	}
	
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}
}
