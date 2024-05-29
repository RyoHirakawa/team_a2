package com.example.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.sample.model.SchoolClass;
import com.example.sample.repository.SchoolClassRepository;

@Controller
@RequestMapping("/list")
public class ListController {
	
	@Autowired
	private SchoolClassRepository schoolClassRepository;
	
	@GetMapping("")
	public String list() {
		return "list/top";
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
}