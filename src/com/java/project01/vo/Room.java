package com.java.project01.vo;

import java.util.Objects;

import com.java.project01.util.MyTime;
/**
 * 객실과 관련된 클래스
 */
public class Room {
	/**
	 * 체크인 시간
	 */
	public static final MyTime checkIn = new MyTime(14,0,0);
	/**
	 * 체크아웃 시간
	 */
	public static final MyTime checkOut = new MyTime(10,0,0);
	
	private String name;
	private double price;
	private String info;
	private char gender;
	private int maxCount;
	//private int headCount;
	private String funiture;
	//private boolean isSoldOut;
	
	public Room() {}
	
	/**
	 * Room 생성자
	 * @param name
	 * @param price
	 * @param info
	 * @param gender
	 * @param maxCount
	 * @param minCount
	 * @param funiture
	 */
	public Room(String name, double price,	String info, char gender, int maxCount,	
			 String funiture) {
		this.name = name;
		this.price = price; 
		this.info = info;
		this.gender = gender;
		this.maxCount = maxCount;
		this.funiture = funiture;
	}
	
	/**
	 * 객실명을 반환하는 getter
	 * @return 객실명
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 객실명을 변경하는 setter
	 * @param name 객실명
	 */
	public void changeName(String name) {
		this.name = name;
	}
	
	/**
	 * 객실 가격을 반환하는 getter
	 * @return 객실 가격
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * 객실 가격을 변경하는 setter
	 * @param price 객실 가격
	 */
	public void changePrice(double price) {
		this.price = price;
	}
	
	/**
	 * 방 정보를 반환하는 getter
	 * @return 방 정보
	 */
	public String getInfo() {
		return info;
	}
	
	/**
	 * 방 정보를 변경하는 setter
	 * @param info 방의 정보
	 */
	public void changeInfo(String info) {
		this.info = info;
	}
	
	/**
	 * 방의 전용 성별을 반환하는 setter
	 * @return 현제 방의 전용성별
	 */
	public char getGender() {
		return gender;
	}
	
	/**
	 * 방의 전용 성별을 변경하는 setter
	 * @param gender 성별, F/M만 입력받음
	 */
	public void changeGender(char gender) {
		this.gender = gender;
	}
	
	/**
	 * 방의 최대 인원수를 반환하는 getter
	 * @return 방의 최대 인원수
	 */
	public int getMaxCount() {
		return maxCount;
	}
	
	/**
	 * 방의 최대 인원수를 변경하는 setter
	 * @param maxCount 방의 최대 인원수
	 */
	public void changeMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}
	
	/**
	 * 방 내부의 가구를 반환하는 getter
	 * @return 가구
	 */
	public String getFuniture() {
		return funiture;
	}
	
	/**
	 * 방 내부의 가구를 변경하는 setter 
	 * @param funiture 가구
	 */
	public void changeFuniture(String funiture) {
		this.funiture = funiture;
	}
	
	public static MyTime getCheckin() {
		return checkIn;
	}
	
	public static MyTime getCheckout() {
		return checkOut;
	}

	@Override
	public String toString() {
		return "방 이름:" + name + ", 방 가격:" + price + ", 방 정보:" + info + ", 전용 성별:" + gender + ", 인원수:"
				+ maxCount + ", 가구 정보:" + funiture;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Room other = (Room) obj;
		return Objects.equals(this.name, other.name);
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(this.name);
	}
}
