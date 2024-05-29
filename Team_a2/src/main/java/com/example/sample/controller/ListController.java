package com.example.sample.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sample.enums.Gender;
import com.example.sample.model.SchoolClass;
import com.example.sample.model.Student;
import com.example.sample.repository.SchoolClassRepository;
import com.example.sample.service.SchoolClassService;
import com.example.sample.service.StudentService;


@Controller
@RequestMapping("/list")
public class ListController {
	
	@Autowired
	private SchoolClassRepository schoolClassRepository;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private SchoolClassService schoolClassService;
	
	@GetMapping("")
	public String list() {
		return "list/top";
	}
	
	@GetMapping("/class")
	public String showClass(Model model) {
		java.util.List<SchoolClass> schoolClasses = schoolClassService.findAll();
		java.util.List<Integer> years = schoolClassService.findAllYears(); 
		years.sort((a, b) -> b.compareTo(a)); //降順ソート
		model.addAttribute("schoolClasses", schoolClasses);
		model.addAttribute("years", years);
		return "list/class/showClass";
	}
	
	@GetMapping("/class/{year}")
	public String showClassByYear(@PathVariable int year, Model model) {
		System.out.println(year + "年度");
		java.util.List<SchoolClass> schoolClasses = schoolClassService.findByYear(year);
		model.addAttribute("schoolClasses", schoolClasses);
		model.addAttribute("year", year);
		System.out.println(schoolClasses.toString());
		return "list/class/showClassByYear";
	}
	
	@GetMapping("/class/create")
	public String createSchoolClass() {	
		System.out.println("list/class/createへのアクセス");
		return "list/class/createClass";
	}
	
	@PostMapping("/class/save")
    public String saveSchoolClass(SchoolClass schoolClass) {
		System.out.println(schoolClass);
        schoolClassRepository.save(schoolClass);
        System.out.println("saveまで実行");
        return "redirect:/list/class/create";
    }	
	
	@GetMapping("/student")
	public String showStudent(Model model) {
//		java.util.List<Student> students = studentService.getAll();
//		model.addAttribute();
		return "/list/student/showStudent";
	}
	
	@GetMapping("/student/all")
	public String showAllStudent(Model model) {
		List<Student> allStudents = studentService.getAllStudents();
		model.addAttribute("students", allStudents);
		return "/list/student/showAllStudent";
	}
	@GetMapping("/student/create")
	public String createStudent() {
		return "/list/student/createStudent";
	}
	@PostMapping("/student/save")
	public String saveStudent(
			@RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam Date birthdate,
            @RequestParam Gender gender,
            Model model
			) {	
		Student student = new Student(firstName, lastName, birthdate, gender);
		System.out.println("save");
		System.out.println(firstName);
		System.out.println(lastName);		
		studentService.save(student);
		return "redirect:/list/student/create";
	}
	public String getMethodName(@RequestParam String param) {
		return new String();
	}
	
	
}