package com.java.project01.vo.parent;

import com.java.project01.util.MyTime;

public class Event {
	
	
	private int price;
	private String info;
	private String name;
	private MyTime startTime;
	private MyTime endTime;
	private int headCount;
	
	public Event() {}
	
	/**
	 * Event Constructor
	 * @param name = 이벤트 명
	 * @param info = 이벤트 정보
	 * @param startTime = 이벤트 시작 시간
	 * @param endTime = 이벤트 종료 시간
	 */
	public Event(String name, String info, MyTime startTime, MyTime endTime, int headCount) {
		this.name = name;
		this.info = info;
		this.startTime = startTime;
		this.endTime = endTime;
		this.headCount = headCount;
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
	 * @return 이벤트 정보 반환
	 */
	public String getInfo() {
		return info;
	}
	
	/**
	 * 
	 * @param info 이벤트 정보
	 */
	public void changeInfo(String info) {
		this.info = info;
	}
	
	/**
	 * 
	 * @return 이벤트 이름 반환
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @param name 이벤트 이름
	 */
	public void changeName(String name) {
		this.name = name;
	}
	
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
	
	/**
	 * 이벤트에 참여하는 인원수 반환
	 * @return 이벤트에 참여하는 인원수 반환
	 */
	public int getHeadCount() {
		return headCount;
	}
	
	/**
	 * 이벤트에 참여하는 인원수 수정
	 * @param headCount 참여하는 인원수
	 */
	public void changeHeadCount(int headCount) {
		this.headCount = headCount;
	}

	@Override
	public String toString() {
		return "Event [price=" + price + ", info=" + info + ", name=" + name + ", startTime=" + startTime + ", endTime="
				+ endTime + "]";
	}
	
	
	
	
}
