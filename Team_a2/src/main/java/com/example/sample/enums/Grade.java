package com.example.sample.enums;

public enum Grade {
	FIRST, SECOND, THIRD, GRADUATED;

	public String getNumber() {		
		switch (this) {
		case FIRST:			
			return "1";
		case SECOND:
			return "2";
		case THIRD:
			return "3";
		case GRADUATED:
			return "卒業";		
		default:			
			throw new IllegalArgumentException("Unknown grade: " + this);
		}
	}
	
	public int toInteger() {		
		switch (this) {
		case FIRST:			
			return 1;
		case SECOND :
			return 2;
		case THIRD:
			return 3;
		case GRADUATED:
			return 4;		
		default:			
			throw new IllegalArgumentException("Unknown grade: " + this);
		}
	}
	
	@Override
	public String toString() {
		switch (this) {
		case FIRST:		
			System.out.println("tostring : " + 1);
			return "1";
		case SECOND :
			return "2";
		case THIRD:
			return "3";
		case GRADUATED:
			return "卒業";		
		default:			
			throw new IllegalArgumentException("Unknown grade: " + this);
		}
	}
	
	public Grade getNext() {
		switch (this) {
		case FIRST:
			return SECOND;
		case SECOND:
			return THIRD;
		case THIRD:
			return GRADUATED;			
		default:
			throw new IllegalArgumentException("進級エラー");
		}
	}
}