package com.example.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sample.model.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
}

