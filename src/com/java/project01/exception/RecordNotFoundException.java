package com.java.project01.exception;

public class RecordNotFoundException extends Exception{

	public RecordNotFoundException() {
		this("해당 데이터를 찾을 수 없습니다.");
	}
	
	public RecordNotFoundException(String message) {
		super(message);
	}
	
	
	
	
}
