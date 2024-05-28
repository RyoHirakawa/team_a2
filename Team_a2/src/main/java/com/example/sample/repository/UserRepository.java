package com.example.sample.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.sample.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByEmail(String email);
	
    @Query("SELECT r.name FROM User u JOIN u.roles r WHERE u.name = :username")
    Set<String> findRolesByName(@Param("username") String username);



}