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
	
	public int getHour() {
		return hour;
	}
	public void changeHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void changeMinute(int minute) {
		this.minute = minute;
	}
	public int getSeconds() {
		return seconds;
	}
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
		return "MyTime [hour=" + hour + ", minute=" + minute + ", seconds=" + seconds + "]";
	}
}
