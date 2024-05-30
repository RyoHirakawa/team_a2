package com.example.sample.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sample.model.SchoolClass;
import com.example.sample.model.Student;
import com.example.sample.service.SchoolClassService;
import com.example.sample.service.StudentService;

@Controller
@RequestMapping("/list")
public class ListController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private SchoolClassService schoolClassService;

	@GetMapping("")
	public String list() {
		return "list/top";
	}

//	@GetMapping("/class")
//	public String showClass(Model model) {
//		java.util.List<SchoolClass> schoolClasses = schoolClassService.findAll();
//		java.util.List<Integer> years = schoolClassService.findAllYears();
//		years.sort((a, b) -> b.compareTo(a));//降順ソート
//		model.addAttribute("schoolClasses", schoolClasses);		
//		return "list/class/showClass";
//	}
	
	@GetMapping("/class/all")
	public String showAllClass(Model model) {
		java.util.List<SchoolClass> schoolClasses = schoolClassService.findAll();
		
		model.addAttribute("schoolClasses", schoolClasses);
		return "list/class/showAllClass";
	}

//	@GetMapping("/class/{year}")
//	public String showClassByYear(@PathVariable int year, Model model) {
//		java.util.List<SchoolClass> schoolClasses = schoolClassService.findByYear(year);
//		model.addAttribute("schoolClasses", schoolClasses);
//		model.addAttribute("year", year);
//		return "list/class/showClassByYear";
//	}

	@GetMapping("/class/create")
	public String createSchoolClass() {		
		return "list/class/createClass";
	}

	@PostMapping("/class/save")
	public String saveSchoolClass(SchoolClass schoolClass) {
		schoolClassService.save(schoolClass);
		return "redirect:/list/class/create";
	}

	@GetMapping("/class/detail/{id}")
	public String showClassById(@PathVariable Long id, Model model) {
		
		SchoolClass schoolClass = schoolClassService.getSchoolClassById(id).orElse(null);
		
		if (schoolClass != null) {			
			List<Student> students = studentService.getStudentBySchoolClassId(id);
			model.addAttribute("students", students);
			model.addAttribute("schoolClass", schoolClass);
			return "/list/class/showClassById";
		} else {
			// 学校クラスが見つからない場合の処理
			return "error";
		}
	}
	
//	@GetMapping("/student")
//	public String showStudent(Model model) {
		//		java.util.List<Student> students = studentService.getAll();
		//		model.addAttribute();
//		return "/list/student/showStudent";
//	}

	@GetMapping("/student/all")
	public String showAllStudent(Model model) {
		List<Student> allStudents = studentService.getAllStudents();
		model.addAttribute("students", allStudents);
		return "/list/student/showAllStudent";
	}

	@GetMapping("/student/create")
	public String createStudent(Model model) {		
		List<SchoolClass> schoolClasses = schoolClassService.getAllSchoolClasses();
		model.addAttribute("schoolClasses", schoolClasses);		
		return "/list/student/createStudent";
	}

	@PostMapping("/student/save")
	public String saveStudent(Student student) {		
		studentService.save(student);
		return "redirect:/list/student/create";
	}
	
	@PostMapping("/student/delete")
	public String deleteStudent(@RequestParam("studentId") Long studentId) {
		studentService.deleteStudent(studentId);
		return "redirect:/list/student/all";
	}

	public String getMethodName(@RequestParam String param) {
		return new String();
	}

	@GetMapping("/student/edit/{id}")
	public String editStudent(@PathVariable Long id, Model model) {
		java.util.Optional<Student> studentOptional = studentService.getStudentById(id);
		System.out.println(studentOptional.toString());
		if (studentOptional.isPresent()) {
			Student student = studentOptional.get();
			Iterable<SchoolClass> schoolClasses = schoolClassService.getAllSchoolClasses();
			model.addAttribute("student", student);
			model.addAttribute("schoolClasses", schoolClasses);
			return "/list/student/editStudent";
		} else {
			return "error";
		}

	}

	@PostMapping("/student/edit/{id}")
	public String saveEditStudent(@PathVariable Long id, @ModelAttribute("editedStudent") Student editedStudent) {
		System.out.println("生徒情報を更新");
		Optional<Student> studentOptional = studentService.getStudentById(id);

		System.out.println(studentOptional);
		if (studentOptional.isPresent()) {
			Student student = studentOptional.get();

			// 生徒の情報を更新
			student.setFirstName(editedStudent.getFirstName());
			student.setLastName(editedStudent.getLastName());
			student.setBirthdate(editedStudent.getBirthdate());
			student.setGender(editedStudent.getGender());
			student.setGrade(editedStudent.getGrade());
			// その他の情報も必要に応じて更新

			// 学校クラスを更新			
			student.setSchoolClass(editedStudent.getSchoolClass());

			// 更新を保存
			studentService.save(student);

			return "redirect:/list/student/all";
		} else {
			// 学生が見つからない場合の処理
			return "error";
		}
	}

}