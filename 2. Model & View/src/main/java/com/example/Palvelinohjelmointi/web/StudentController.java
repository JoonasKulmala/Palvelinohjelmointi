package com.example.Palvelinohjelmointi.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Palvelinohjelmointi.domain.Student;

@Controller
public class StudentController {
	
	// ENDPOINT CHANGED FROM "/hello" TO "/students" IN EXERCISE 2
	@RequestMapping("/studentlist")
	public String students(Model model) {
		
		// Hard coded Student objects
		Student student1 = new Student();
		student1.setFirstName("Kate");
		student1.setLastName("Cole");
		Student student2 = new Student();
		student2.setFirstName("Dan");
		student2.setLastName("Brown");
		Student student3 = new Student();
		student3.setFirstName("Mike");
		student3.setLastName("Mars");
		
		List<Student> students = new ArrayList<Student>();
		students.add(student1);
		students.add(student2);
		students.add(student3);
		
		model.addAttribute("students", students);
		return "studentlist";
	}

}
