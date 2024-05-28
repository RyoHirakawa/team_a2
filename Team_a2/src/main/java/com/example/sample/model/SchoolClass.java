package com.example.sample.model;

import java.util.Set;

import com.example.sample.enums.Grade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class SchoolClass {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; //e.g. 1, 2, 3, ... or  A, B, C, ... or else...
    
    private Grade grade; //FIRST, SECOND, THIRD

    @OneToMany(mappedBy = "classes")
    private Set<Student> students;

}
