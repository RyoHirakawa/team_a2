package com.example.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sample.model.Template;
import com.example.sample.repository.TemplateRepository;
import com.example.sample.service.TemplateService;

@Controller
@RequestMapping("/template")
public class TemplateController {

	@Autowired
	TemplateService templateService;
	
	@Autowired
	TemplateRepository templateRepository;
	
	@GetMapping("/")
	public String getAllTemplates(Model model) {
		model.addAttribute("templates", templateService.getTemplateList());
		return "all-templates";
	}
	
	@GetMapping("/search")
	public String getSearchResult(@RequestParam String category, Model model) {
		List<Template> template = templateRepository.findByCategory(category);
		model.addAttribute("category", category);
		model.addAttribute("templates", template);
		return "search-template";
	}
	
}
