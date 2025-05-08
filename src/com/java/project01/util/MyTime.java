package com.java.project01.util;

/**
 *  MyTime Class
 *  - 시, 분, 초
 */
public class MyTime {
	
	private int hour;
	private int minute;
	private int seconds;
	
	public MyTime(int hour, int minute, int seconds) {
		this.hour = hour;
		this.minute = minute;
		this.seconds = seconds;
	}
	
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public int getSeconds() {
		return seconds;
	}
	public void setSecond(int seconds) {
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
