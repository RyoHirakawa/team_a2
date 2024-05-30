package com.example.sample.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.sample.model.SchoolClass;
import com.example.sample.repository.SchoolClassRepository;

@Service
public class SchoolClassService {
	@Autowired
	private SchoolClassRepository schoolClassRepository;
		
	
	public List<SchoolClass> findAll() {
		return schoolClassRepository.findAll();
	}
	
	public List<SchoolClass> findByYear(int year) {	
        return schoolClassRepository.findByYear(year);
    }
	
	public List<Integer> findAllYears() {
        return schoolClassRepository.findAllYears();
    }
	
	public List<SchoolClass> getAllSchoolClasses() {
        return schoolClassRepository.findAll();
    }

    public Optional<SchoolClass> getSchoolClassById(Long id) {
        return schoolClassRepository.findById(id);
    }
}

