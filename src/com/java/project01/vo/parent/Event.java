package com.java.project01.vo.parent;

import com.java.project01.util.MyTime;

public abstract class Event {
	
	private int price;
	private String eventType;
	private MyTime startTime;
	private MyTime endTime;
	
	public Event() {}
	
	/**
	 * Event Constructor
	 * @param eventType = 이벤트의 타입(Party, BBQ, Fishing)
	 * @param startTime = 이벤트 시작 시간
	 * @param endTime = 이벤트 종료 시간
	 */
	public Event(String eventType, MyTime startTime, MyTime endTime) {
		this.eventType = eventType;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	/**
	 * 
	 * @return 이벤트 가격 반환
	 */
	public int getPrice() {
		return price;
	}
	
	/**
	 * 
	 * @param price 이벤트 가격
	 */
	public void changePrice(int price) {
		this.price = price;
	}
	
	
	/**
	 * 
	 * @return 이벤트 종류 반환
	 */
	public String getEventType() {
		return eventType;
	}
	
	/**
	 * 
	 * @param eventType 이벤트 종류
	 */
	public void changeEventType(String eventType) {
		this.eventType = eventType;
	}
	
//	/**
//	 * 
//	 * @return 이벤트 정보 반환
//	 */
//	public String getInfo() {
//		return info;
//	}
//	
//	/**
//	 * 
//	 * @param info 이벤트 정보
//	 */
//	public void changeInfo(String info) {
//		this.info = info;
//	}
//	
//	/**
//	 * 
//	 * @return 이벤트 이름 반환
//	 */
//	public String getName() {
//		return name;
//	}
//	
//	/**
//	 * 
//	 * @param name 이벤트 이름
//	 */
//	public void changeName(String name) {
//		this.name = name;
//	}
	
	/**
	 * 
	 * @return 이벤트 시작 시간 반환
	 */
	public MyTime getStartTime() {
		return startTime;
	}
	
	/**
	 * 
	 * @param startTime 이벤트 시작 시간
	 */
	public void changeStartTime(MyTime startTime) {
		this.startTime = startTime;
	}
	
	/**
	 * 
	 * @return 이벤트 종료 시간 반환
	 */
	public MyTime getEndTime() {
		return endTime;
	}
	
	/**
	 * 
	 * @param endTime 이벤트 종료 시간
	 */
	public void changeEndTime(MyTime endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "Event [price=" + price + ", eventType=" + eventType +", startTime=" + startTime + ", endTime="
				+ endTime + "]";
	}
	
	
	
	
}
