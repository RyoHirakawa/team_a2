package com.example.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.sample.model.SchoolClass;

@Repository
public interface SchoolClassRepository extends JpaRepository<SchoolClass, Long> {	
	java.util.List<SchoolClass> findByYear(int year);
	@Query("SELECT DISTINCT sc.year FROM SchoolClass sc")
    java.util.List<Integer> findAllYears();
}