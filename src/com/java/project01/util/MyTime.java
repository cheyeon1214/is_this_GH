package com.java.project01.util;

/**
 *  MyTime Class
 *  - 시간을 관리하는 클래스입니다.
 */
public class MyTime {
	
	private int hour;
	private int minute;
	private int seconds;
	
	public MyTime() {}
	
	/**
	 * MyTime 생성자
	 * @param hour 시간
	 * @param minute 분
	 * @param seconds 초
	 */
	public MyTime(int hour, int minute, int seconds) {
		this.hour = hour;
		this.minute = minute;
		this.seconds = seconds;
	}
	
	/**
	 * 
	 * @return 시간 반환
	 */
	public int getHour() {
		return hour;
	}
	
	/**
	 * 
	 * @param hour 시간
	 */
	public void changeHour(int hour) {
		this.hour = hour;
	}
	
	/**
	 * 
	 * @return 분 반환
	 */
	public int getMinute() {
		return minute;
	}
	
	/**
	 * 
	 * @param minute 분 입력
	 */
	public void changeMinute(int minute) {
		this.minute = minute;
	}
	
	/**
	 * 
	 * @return 초 반환
	 */
	public int getSeconds() {
		return seconds;
	}
	
	/**
	 * 
	 * @param seconds 초 입력
	 */
	public void changeSeconds(int seconds) {
		this.seconds = seconds;
	}
	
	/**
	 * 
	 * @return 시 + 분 + 초
	 */
	public int getMyTime() {
		return hour + minute + seconds;
	}
	
	@Override
	public String toString() {
		return "시간 [시 : " + hour + ", 분 : " + minute + ", 초 : " + seconds + "]";
	}
}
