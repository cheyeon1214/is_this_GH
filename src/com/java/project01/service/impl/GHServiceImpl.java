package com.java.project01.service.impl;

import java.util.List;

import com.java.project01.service.GHService;
import com.java.project01.util.MyDate;
import com.java.project01.vo.Customer;
import com.java.project01.vo.Reservation;
import com.java.project01.vo.Room;
import com.java.project01.vo.parent.Event;

public class GHServiceImpl implements GHService{
	
	
	
	
	//CRUD
	@Override
	public void Reservation(MyDate date, Customer customer, Room room, boolean isBreakfast, int people, Event event,
			int reserveCode) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<Room> getAllRooms() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Event> getAllEvents() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Reservation checkMyReserve(int code) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void deleteReserve(int code) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void updateReserve(int code, Reservation reserve) {
		// TODO Auto-generated method stub
		
	}
	
	
	//비지니스 로직

	@Override
	public Room mostPopularRoom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MyDate> soldOutDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Room> roomsByDate(MyDate date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Room> roomsByDate(MyDate date, int people) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> eventsByDate(MyDate date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBreakfastInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
