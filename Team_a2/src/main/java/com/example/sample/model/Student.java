package com.example.sample.model;

import java.sql.Date;
import java.util.HashMap;

import com.example.sample.enums.Gender;
import com.example.sample.enums.Grade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Student {	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String firstName;
    private String lastName;
        
    private Date birthdate;
    
    private com.example.sample.enums.Gender gender; 
    
    private com.example.sample.enums.Grade grade; //FIRST, SECOND, THIRD, GRADUATED
    
    @ManyToOne
    @JoinColumn(name = "school_class_id")
    private SchoolClass schoolClass;
    
    public Student() {}
    
    public Student(String firstName, String lastName, Date birthdate, Gender gender) {
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.birthdate = birthdate;
    	this.gender = gender;
    	this.grade = Grade.FIRST;
    }

}
