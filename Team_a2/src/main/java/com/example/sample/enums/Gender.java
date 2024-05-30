package com.example.sample.enums;

public enum Gender {
	MALE, FEMALE, OTHER;
	
	
	public String getName() {
		switch (this) {
		case MALE:
			return "男";
		case FEMALE:
			return "女";
		case OTHER:
			return "その他";
		default:
			throw new IllegalArgumentException("Unknown grade: " + this);
		}
	}
}
