package com.java.project01.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.java.project01.service.GHService;
import com.java.project01.util.MyDate;
import com.java.project01.vo.Customer;
import com.java.project01.vo.Reservation;
import com.java.project01.vo.Room;
import com.java.project01.vo.parent.Event;

public class GHServiceImpl implements GHService{
	private static GHServiceImpl service = new GHServiceImpl();
	List<Reservation> reservations = null;
	List<Room> rooms = null;
	List<Event> events = null;
	
	/**
	 *  @param EVENT_MIN_COUNT 최소 인원 4명
	 *  @param EVENT_MAX_COUNT 최대 인원 20명
	 */
	public static final int EVENT_MIN_COUNT = 4;
	public static final int EVENT_MAX_COUNT = 20;
	
	private GHServiceImpl() {
		reservations = new ArrayList<>();
		rooms = new ArrayList<>();
		events = new ArrayList<>();
	}
	
	public static GHServiceImpl getInstance() {
		return service;
	}
	
	//CRUD
	@Override
	public void addReservation(MyDate date, Customer customer, Room room, boolean isBreakfast, int people, int reserveCode) {
		reservations.add(new Reservation(reserveCode, room, date, customer, isBreakfast, people));
	}
	
	@Override
	public List<Room> getAllRooms() {
		return rooms;
	}
	
	@Override
	public List<Event> getAllEvents() {
		return events;
	}
	public List<Reservation> getAllReservations(){
		return reservations;
	}
	
	@Override
	public Reservation checkMyReserve(int code) {
		for (Reservation r : reservations) {
			if (r.getReserveCode() == code) {
				return r;
			}
		}
		return null;
	}
	
	@Override
	public void deleteReserve(int code) {
		boolean isDeleted = false;
		
		for (Reservation r : reservations) {
			if (r.getReserveCode() == code) {
				isDeleted = reservations.remove(r);
			}
		}
		
		System.out.println(isDeleted ? "삭제 완료" : "해당 예약 번호가 없습니다.");
	}
	
	@Override
	public void updateReserve(int code, Reservation reserve) {
		for (int i = 0; i < reservations.size(); i++) {
			if (reservations.get(i).getReserveCode() == code) {
				reservations.set(i, reserve);
			}
		}
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
