package com.java.project01.exception;

/**
 * RecordNotFoundException
 * - 사용자 정의 예외처리 클래스입니다.
 * - 입력한 정보 또는 프로그램 프로세스 중 정보를 찾을 수 없을 경우의 예외사항을 처리합니다.
 */
public class RecordNotFoundException extends Exception{

	/**
	 * message를 생성하지 않고 바로 예외사항이 출력되도록 합니다.
	 */
	public RecordNotFoundException() {
		this("해당 정보를 찾을 수 없습니다. :: Record Not Found");
	}
	
	/**
	 * 
	 * @param message 어떤 항목에서 어떠한 데이터를 찾을 수 없는지를 명시하고 출력합니다.
	 */
	public RecordNotFoundException(String message) {
		super(message);
	}
	
}
