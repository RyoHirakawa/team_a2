package com.example.sample.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sample.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}

