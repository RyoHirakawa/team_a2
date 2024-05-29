package com.example.sample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sample.model.DocumentShare;

public interface DocumentShareRepository extends JpaRepository<DocumentShare, Long>{
	List<DocumentShare> findByCategory(String category);
	List<DocumentShare> findAllByOrderByCategoryAsc();
}
