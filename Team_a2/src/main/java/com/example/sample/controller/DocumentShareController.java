package com.example.sample.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sample.model.DocumentShare;
import com.example.sample.repository.DocumentShareRepository;
import com.example.sample.service.DocumentShareService;

@Controller
@RequestMapping("/documents")
public class DocumentShareController {

	@Autowired
	DocumentShareService service;

	@Autowired
	DocumentShareRepository repository;

	@GetMapping("/")
	public String getImagesByCategory(Model model) {
		List<DocumentShare> documents = repository.findAllByOrderByCategoryAsc();
		Map<String, List<DocumentShare>> documentsByCategory = documents.stream()
				.collect(Collectors.groupingBy(DocumentShare::getCategory));
		model.addAttribute("documentsByCategory", documentsByCategory);
		return "category";
	}

	@GetMapping("/search")
	public String searchByCategory(@RequestParam String category, Model model) {
		List<DocumentShare> documents = repository.findByCategory(category);
		model.addAttribute("documents", documents);
		model.addAttribute("category", category);
		return "shareFiles";
	}

	@GetMapping("/addDocumentShare")
	public String showAddDocumentShareForm(Model model) {
		model.addAttribute("documentShare", new DocumentShare());
		return "addDocumentShare";
	}

	@GetMapping("/documentShareList")
	public String showTable(Model model) {
		model.addAttribute("documentShares", service.getDocumentShareList());
		return "documentShareList";
	}

	@PostMapping("/documentShareList")
	public String showTables(@Validated DocumentShare documentShare, Model model) {
		repository.save(documentShare);
		return "redirect:/documents/documentShareList";
	}

}
