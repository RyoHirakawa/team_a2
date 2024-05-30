package com.example.sample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sample.enums.Grade;
import com.example.sample.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	List<Student> findByGrade(Grade grade);
	List<Student> findBySchoolClassId(Long schoolClassId);
//	Optional<Student> findById(Long id);
//	@Query("SELECT s FROM Student s JOIN s.classes sc WHERE sc.id = :classId")
//    List<Student> findBySchoolClassId(@Param("classId") Long classId);
}
