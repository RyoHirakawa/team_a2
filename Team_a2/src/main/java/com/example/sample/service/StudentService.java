package com.example.sample.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sample.enums.Gender;
import com.example.sample.enums.Grade;
import com.example.sample.model.Student;
import com.example.sample.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void registerStudent() {
        Student student = new Student();
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setBirthdate(Date.valueOf("2000-01-01"));
        student.setGender(Gender.MALE);
        student.setGrade(Grade.FIRST);

        // 1年生のクラスに登録
//        SchoolClass firstGradeClass = new SchoolClass();
//        firstGradeClass.setName("First Grade Class");
        // firstGradeClassを適切に設定する必要があります

        // 他の年度のクラスも同様に登録することができます

        studentRepository.save(student);
    }
    public Student save(Student student) {
    	System.out.println("student: " + student.getFirstName() + "さんを登録");
        return studentRepository.save(student);
    }
}
