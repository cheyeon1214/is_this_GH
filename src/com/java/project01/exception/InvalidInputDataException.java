package com.java.project01.exception;

/**
 *  InvalidInputDataException
 *  - 사용자 정의 예외처리 클래스입니다.
 *  - 사용자가 잘못된 데이터를 입력했을 시, 예외사항을 처리하도록합니다.
 *  - 현재 Service 에서는 Test에서 사용자의 입력을 받으므로 각 항목에 맞는 메세지를 생성하도록 합니다.
 *  
 */
public class InvalidInputDataException extends Exception {
	
	/**
	 * message를 생성하지 않고 바로 예외사항이 출력되도록 합니다.
	 */
	public InvalidInputDataException() {
		this("유효하지 않은 정보를 입력하였습니다.");
	}
	
	/**
	 * 
	 * @param message 사용자가 잘못 입력시 출력할 내용을 입력합니다.
	 */
	public InvalidInputDataException(String message) {
		super(message);
	}
}
