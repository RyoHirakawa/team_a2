package com.example.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sample.model.SchoolClass;
import com.example.sample.repository.SchoolClassRepository;

@Service
public class SchoolClassService {
	@Autowired
	private SchoolClassRepository schoolClassRepository;
	
	public java.util.List<SchoolClass> findAll() {
		return schoolClassRepository.findAll();
	}
	
	public java.util.List<SchoolClass> findByYear(int year) {
        return schoolClassRepository.findByYear(year);
    }
	
	public java.util.List<Integer> findAllYears() {
        return schoolClassRepository.findAllYears();
    }
}
