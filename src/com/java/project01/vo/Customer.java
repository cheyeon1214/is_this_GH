package com.java.project01.vo;
/**
 *  Customer Class
 *  - 고객 클래스입니다.
 *  
 */
public class Customer {
	
	private String name;
	private char gender;
	private String phoneNumber;
	
	/**
	 * 손님 생성자
	 * @param name 손님의 이름
	 * @param gender 손님의 성별
	 * @param phoneNumber 손님의 전화번호
	 */
	public Customer(String name, char gender, String phoneNumber) {
		super();
		this.name = name;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * 이름을 반환하는 메서드
	 * @return 이름 문자열을 반환
	 */
	public String getName() {
		return name;
	}
	/**
	 * 이름을 변경하는 메서드
	 * @param name 변경할 이름
	 */
	public void changeName(String name) {
		this.name = name;
	}
	/**
	 * 성별을 반환하는 메서드 (f/m)
	 * @return 여자는 f 남자는 m 반환
	 */
	public char getGender() {
		return gender;
	}
	/**
	 * 성별을 변경하는 메서드
	 * @param gender 변경할 성별
	 */
	public void changeGender(char gender) {
		this.gender = gender;
	}
	/**
	 * 전화번호를 반환하는 메서드
	 * @return 전화번호를 문자열로 반환
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * 전화번호를 변경하는 메서드
	 * @param phoneNumber 변경할 전화번호 문자열
	 */
	public void changePhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * 손님의 정보를 출력
	 */
	@Override
	public String toString() {
		return "[이름 : " + name + ", 성별 : " + gender + ", 전화번호 : " + phoneNumber + "]";
	}
	
	
	

}
