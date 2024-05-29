package com.example.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sample.model.DocumentShare;
import com.example.sample.repository.DocumentShareRepository;

@Service
public class DocumentShareService {
	
	@Autowired
	DocumentShareRepository documentSharerepository;
	
	public DocumentShare saveDocuments(DocumentShare document) {
		return documentSharerepository.save(document);
	}
	
	public List<DocumentShare> getDocumentShareList() {
		return documentSharerepository.findAll();
	}
}
