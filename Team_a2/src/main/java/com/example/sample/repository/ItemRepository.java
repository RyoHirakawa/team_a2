package com.example.sample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sample.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	List<Item> findByOrderById();

	Object findByName(String string);
	
}
