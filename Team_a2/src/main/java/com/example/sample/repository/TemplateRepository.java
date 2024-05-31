package com.example.sample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sample.model.Template;

public interface TemplateRepository extends JpaRepository<Template, Long>{

	List<Template> findByCategory(String category);
}
