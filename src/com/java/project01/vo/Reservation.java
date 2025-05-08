package com.java.project01.vo;

import com.java.project01.util.MyDate;
import com.java.project01.vo.parent.Event;

public class Reservation {
	
	private int reserveCode;
	private Room room;
	private MyDate date;
	private Customer customer;
	private boolean isBreakfast;
	private int people;
	private Event event;
	
	public int getReserveCode() {
		return reserveCode;
	}
	
	public void setReserveCode(int reserveCode) {
		this.reserveCode = reserveCode;
	}
	
	public Room getRoom() {
		return room;
	}
	
	public void setRoom(Room room) {
		this.room = room;
	}
	
	public MyDate getDate() {
		return date;
	}
	
	public void setDate(MyDate date) {
		this.date = date;
	}
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public boolean isBreakfast() {
		return isBreakfast;
	}
	
	public void setBreakfast(boolean isBreakfast) {
		this.isBreakfast = isBreakfast;
	}
	
	public int getPeople() {
		return people;
	}
	
	public void setPeople(int people) {
		this.people = people;
	}
	
	public Event getEvent() {
		return event;
	}
	
	public void setEvent(Event event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return "Reservation [reserveCode=" + reserveCode + ", room=" + room + ", date=" + date + ", customer="
				+ customer + ", isBreakfast=" + isBreakfast + ", people=" + people + ", event=" + event + "]";
	}
	
	
	
	
}
