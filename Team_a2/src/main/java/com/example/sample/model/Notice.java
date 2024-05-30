package com.example.sample.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    
    private LocalDate createdAt;
    
	private LocalDate updatedAt;

    @PrePersist//初期値にいれる（コンストラクタ的なやつ）
    protected void onCreate() {
        LocalDate now = LocalDate.now();
        createdAt = now;
        updatedAt = now;
    }

    @PreUpdate//更新処理前に実行
    protected void onUpdate() {
        updatedAt = LocalDate.now();
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    public LocalDate getCreatedAt() {
 		return createdAt;
 	}

 	public void setCreatedAt(LocalDate createdAt) {
 		this.createdAt = createdAt;
 	}

 	public LocalDate getUpdatedAt() {
 		return updatedAt;
 	}

 	public void setUpdatedAt(LocalDate updatedAt) {
 		this.updatedAt = updatedAt;
 	}



}
