package com.example.sample.model;

import java.sql.Date;
import java.util.HashMap;

import com.example.sample.enums.Grade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Student {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String firstName;
    private String lastName;
    
//    @Temporal(TemporalType.DATE)
    private Date birthdate;
    
    private com.example.sample.enums.Gender gender;
    
    private com.example.sample.enums.Grade grade; //FIRST, SECOND, THIRD
//    @ManyToOne
//    @JoinColumn(name = "grade1Class_id")
//    private SchoolClass grade1Class;
//    
//    @ManyToOne
//    @JoinColumn(name = "grade2Class_id")
//    private SchoolClass grade2Class;
//    
//    @ManyToOne
//    @JoinColumn(name = "grade3Class_id")
//    private SchoolClass grade3Class;
    
    @ManyToMany
    @JoinTable(
        name = "student_school_class",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "school_class_id")
    )
    private java.util.Map<Grade, SchoolClass> classes = new HashMap<Grade, SchoolClass>();
    //schoolClass[First] <= 1年のクラス 
    //schoolClass[Second] <= 2年のクラス
    //schoolClass[Third] <= 3年のクラス

}
