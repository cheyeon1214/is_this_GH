package com.java.project01.vo.parent;

import com.java.project01.util.MyTime;

public class Event {
	
	/**
	 *  @param minCount 최소 인원 4명
	 *  @param maxCount 최대 인원 20명
	 */
	public static final int minCount = 4;
	public static final int maxCount = 20;
	
	private int price;
	private String info;
	private String name;
	private MyTime startTime;
	private MyTime endTime;
	
	public Event() {}
	
	/**
	 * Event Constructor
	 * @param name = 이벤트 명
	 * @param info = 이벤트 정보
	 * @param startTime = 이벤트 시작 시간
	 * @param endTime = 이벤트 종료 시간
	 */
	public Event(String name, String info, MyTime startTime, MyTime endTime) {
		this.name = name;
		this.info = info;
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
	 * 
	 * @return 이벤트에 참여하는 최소 인원 반환
	 */
	public static int getMincount() {
		return minCount;
	}
	
	/**
	 * 
	 * @return 이벤트에 참여할 수 있는 최대 인원 반환
	 */
	public static int getMaxcount() {
		return maxCount;
	}

	@Override
	public String toString() {
		return "Event [price=" + price + ", info=" + info + ", name=" + name + ", startTime=" + startTime + ", endTime="
				+ endTime + "]";
	}
	
	
	
	
}
