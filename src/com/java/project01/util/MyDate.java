package com.java.project01.util;

/**
 *  MyDate Class
 *  - 날짜를 관리하는 클래스입니다.
 */
public class MyDate {
	
	private int year;
	private int month;
	private int day;

	public MyDate() {}
	
	/**
	 * MyDate 생성자
	 * @param year 연도
	 * @param month 월
	 * @param day 일
	 */
	public MyDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public int getYear() {
		return year;
	}
	public void changeYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void changeMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void changeDay(int day) {
		this.day = day;
	}

	/**
	 * 
	 * @return 연도 + 월 + 일
	 */
	public int getMyDate() {
		return year + month + day;
	}
	
	@Override
	public String toString() {
		return "MyDate [year=" + year + ", month=" + month + ", day=" + day + "]";
	}
	
	

}
