package com.example.sample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sample.enums.Grade;
import com.example.sample.model.Student;
import com.example.sample.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student save(Student student) {    	
        return studentRepository.save(student);
    }
    
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    
    public List<Student> getStudentsByGrade(Grade grade) {
        return studentRepository.findByGrade(grade);
    }
    
    public List<Student> getStudentBySchoolClassId(Long schoolClassId) {
    	return studentRepository.findBySchoolClassId(schoolClassId);
    }
    
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }
    
    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    } 
    
    
    
}
