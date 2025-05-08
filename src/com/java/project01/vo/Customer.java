package com.java.project01.vo;
/**
 *  Customer Class
 *  - 고객의 정보 관련 클래스입니다.
 *  
 */
public class Customer {
	
	private String name;
	private char gender;
	private String phoneNumber;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String toString() {
		return "Customer [name=" + name + ", gender=" + gender + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
	

}
