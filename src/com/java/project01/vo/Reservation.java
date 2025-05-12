package com.java.project01.vo;

import com.java.project01.util.MyDate;
import com.java.project01.vo.parent.Event;
/**
 *  Reservation Class
 *  - 예약 클래스입니다.
 *  
 */
public class Reservation {
	
	private int reserveCode;
	private Room room;
	private MyDate date;
	private Customer customer;
	private boolean isBreakfast;
	private int people;
	private Event event;
	
	/**
	 * 예약을 생성할 때 쓰이는 예약 생성자
	 * @param reserveCode 예약 코드 
	 * @param room 방 정보를 담은 방 객체 
	 * @param date 예약 날짜 
	 * @param customer 손님 정보를 담은 손님 객체 
	 * @param isBreakfast 조식 유무 
	 * @param people 인원수 
	 */
	public Reservation(int reserveCode, Room room, MyDate date, Customer customer, boolean isBreakfast, int people, Event event) {
		super();
		this.reserveCode = reserveCode;
		this.room = room;
		this.date = date;
		this.customer = customer;
		this.isBreakfast = isBreakfast;
		this.people = people;
		this.event = event;
	}

	/**
	 * 예약 코드를 반환함
	 * @return 예약 코드
	 */
	public int getReserveCode() {
		return reserveCode;
	}
	
	/**
	 * 방 객체를 반환함
	 * @return 방 객체 
	 */
	public Room getRoom() {
		return room;
	}
	
	/**
	 * 예약한 방을 변경함 
	 * @param room 변경할 방
	 */
	public void changeRoom(Room room) {
		this.room = room;
	}
	
	/**
	 * 예약 날짜를 반환함 
	 * @return 예약 날짜
	 */
	public MyDate getDate() {
		return date;
	}
	
	/**
	 * 예약 날짜를 변경함 
	 * @param date 변경할 날짜
	 */
	public void changeDate(MyDate date) {
		this.date = date;
	}
	/**
	 * 예약한 손님을 반환
	 * @return 손님 반환
	 */
	public Customer getCustomer() {
		return customer;
	}
	/**
	 * 손님 정보를 변경
	 * @param customer 변경할 손님 정보를 담은 손님 객체 
	 */
	public void changeCustomer(Customer customer) {
		this.customer = customer;
	}
	/**
	 * 조식 유무를 반환함
	 * @return true 이면 조식 YES, false 이면 조식 예약 NO
	 */
	public boolean getIsBreakfast() {
		return isBreakfast;
	}
	/**
	 * 조식 유무를 변경함 
	 * @param isBreakfast 변경할 조식 유무 
	 */
	public void changeBreakfast(boolean isBreakfast) {
		this.isBreakfast = isBreakfast;
	}
	
	/**
	 * 인원수를 반환
	 * @return
	 */
	public int getPeople() {
		return people;
	}
	
	/**
	 * 인원수 변경 
	 * @param people 변경할 인원수 
	 */
	public void changePeople(int people) {
		this.people = people;
	}
	
	/**
	 * 이벤트 반환 
	 * @return 이벤트 
	 */
	public Event getEvent() {
		return event;
	}
	
	/**
	 * 이벤트 추가
	 * @param event 추가할 이벤트
	 */
	public void setEvent(Event event) {
		this.event = event;
	}

	/**
	 * 예약 정보를 출력
	 */
	@Override
	public String toString() {
		/*
		 * return "\n예약 번호 :" + reserveCode + ", 방 정보\n" + room + ", date :" + date +
		 * "\n사용자 정보 :" + customer + ", 조식 유무 :" + isBreakfast + ", 인원수 :" + people +
		 * ", 이벤트 :" + event + "]";
		 */
		
		return "\n예약 번호 : " + reserveCode + "\n방 정보-> " + room + "\n예약 날짜 : " + date + "\n사용자 정보-> " + customer 
				+ "\n조식 유무 : " + (isBreakfast == true ? "신청" : "미신청") + "\n예약 인원수 : " + people + "\n이벤트 " + (event == null ? "미참여" : event);
	}
	
	
	
	
}
