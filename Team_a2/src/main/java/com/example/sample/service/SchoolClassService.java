package com.example.sample.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.sample.model.Student;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Service
public class SchoolClassService {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	enum Grade {
		FIRST, SECOND, THIRD
	};
	
	private Grade grade;
	
	private String name;
	
	@ManyToMany(mappedBy = "")
	private Set<Student> students;
	
//	@ManyToOne
//	@JoinColumn(name = "teahcer_id")
//	private Teacher teacher;
}
