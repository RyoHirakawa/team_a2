package com.example.sample.model;

import java.util.Set;

import com.example.sample.enums.Grade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data

public class SchoolClass {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; //e.g. 1, 2, 3, ... or  A, B, C, ... or else...
    
    private Grade grade; //FIRST, SECOND, THIRD: １年, ２年, ３年
    
    private int year; //何年度のクラスか

    @OneToMany(mappedBy = "classes")
    private Set<Student> students;
    
    public SchoolClass() {
    	
    }
    
    public SchoolClass(String name, Grade grade, int year) {
    	this.name = name;
    	this.grade = grade;
    	this.year = year;
    }
}
