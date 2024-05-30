package com.example.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sample.model.Template;
import com.example.sample.repository.TemplateRepository;

@Service
public class TemplateService {

	@Autowired
	TemplateRepository templateRepository;
	
	public List<Template> getTemplateList() {
		return templateRepository.findAll();
	}
}
