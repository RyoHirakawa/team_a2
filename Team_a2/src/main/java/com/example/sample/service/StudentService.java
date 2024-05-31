package com.example.sample.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sample.enums.Grade;
import com.example.sample.model.Student;
import com.example.sample.repository.StudentRepository;
import com.example.sample.util.StudentComparator;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student save(Student student) {    	
        return studentRepository.save(student);
    }
    
    public List<Student> getAllStudents() {
    	List<Student> students = studentRepository.findAll();
    	Collections.sort(students, new StudentComparator());
        return students;
    }
    
    public List<Student> getStudentsByGrade(Grade grade) {
        return studentRepository.findByGrade(grade);
    }
    
    public List<Student> getStudentBySchoolClassId(Long schoolClassId) {
    	List<Student> students = studentRepository.findBySchoolClassId(schoolClassId);
    	Collections.sort(students, new StudentComparator());
    	return students;
    }
    
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }
    
    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }
    
    public List<Student> filterStudents(List<Student> students, String name, String grade, String schoolClass, String gender) {
    	System.out.println(grade);
    	
    	return students.stream()
                .filter(student -> name == null || name.length() == 0 || student.getFirstName().contains(name) || student.getLastName().contains(name))
                .filter(student -> grade == null || grade.length() ==0 || student.getGrade().toString().equals(grade))
                .filter(student -> gender == null || gender.length() == 0 || student.getGender().toString().equals(gender))
                .filter(student -> schoolClass == null || schoolClass.length() == 0 || student.getSchoolClass().getName().equals(schoolClass))
                .collect(Collectors.toList());
    }
    
    
    
}
