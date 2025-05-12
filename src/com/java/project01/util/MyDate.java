package com.java.project01.util;

import java.time.LocalDate;

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
	
	/**
	 * 
	 * @return 연도 반환
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * 
	 * @param year 연도 입력
	 */
	public void changeYear(int year) {
		this.year = year;
	}
	
	/**
	 * 
	 * @return 월 반환
	 */
	public int getMonth() {
		return month;
	}
	
	/**
	 * 
	 * @param month 월 입력
	 */
	public void changeMonth(int month) {
		this.month = month;
	}
	
	/**
	 * 
	 * @return 일 반환
	 */
	public int getDay() {
		return day;
	}
	
	/**
	 * 
	 * @param day 일 입력
	 */
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
	
	public boolean isCorrectDate() {
		if (this.year <= 0)
			return false;
		
		if (this.month < 1 || this.month > 12)
			return false;
		
		switch (this.month) {
		case 2:
			if (this.day < 1 || this.day > 29)
				return false;
			break;
		case 4:
		case 9:
		case 11:
			if (this.day < 1 || this.day > 30)
				return false;
			break;
		default:
			if (this.day < 1 || this.day > 31)
				return false;
			break;
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		return "MyDate [year=" + year + ", month=" + month + ", day=" + day + "]";
	}
	
	
	@Override
	public boolean equals(Object obj) {
		MyDate other = (MyDate) obj;
		return this.year == other.year && this.month == other.month && this.day == other.day;
	}
}
