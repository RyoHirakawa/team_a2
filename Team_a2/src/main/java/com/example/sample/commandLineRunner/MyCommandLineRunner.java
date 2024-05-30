package com.example.sample.commandLineRunner;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.sample.enums.Gender;
import com.example.sample.enums.Grade;
import com.example.sample.model.Student;
import com.example.sample.service.StudentService;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Autowired
    private StudentService studentService;

    @Override
    public void run(String... args) throws Exception {
    	System.out.println("コマンドラインランナー開始");
        // Studentを登録する
        Student student = new Student();
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setBirthdate(Date.valueOf("2000-01-01")); 
        student.setGender(Gender.MALE);
        student.setGrade(Grade.FIRST);
        System.out.println(student.toString());
        studentService.save(student);
        System.out.println("コマンドラインランナー終了");
        // student.getClasses().put(Grade.FIRST, firstGradeClass);
    }
}