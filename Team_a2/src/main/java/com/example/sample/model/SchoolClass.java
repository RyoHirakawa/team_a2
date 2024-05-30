package com.example.sample.model;

import com.example.sample.enums.Grade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data

public class SchoolClass {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; //e.g. 1, 2, 3, ... or  A, B, C, ... or else...
    
    private Grade grade; //FIRST, SECOND, THIRD: １年, ２年, ３年
    

    public SchoolClass() {    	
    }
    
    public SchoolClass(String name, Grade grade) {
    	this.name = name;
    	this.grade = grade;
    }
    
    public String toString() {
    	return this.grade.getNumber() + "年" + this.name + "組";
    }
}
