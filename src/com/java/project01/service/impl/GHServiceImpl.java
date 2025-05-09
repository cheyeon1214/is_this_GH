package com.java.project01.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
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
	public void addRoom(Room room) {
		rooms.add(room);
	}
	public void addEvent(Event event) {
		events.add(event);
	}
	
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
		Room pRoom = null;
		
		if (reservations.isEmpty()) return null;
		
		List<Integer> pList = new ArrayList<>();
		
		for (int i = 0; i < rooms.size(); i++) {
			pList.add(0);
		}
		
		for (Reservation r : reservations) {
			int idx = rooms.indexOf(r.getRoom());			
			pList.add(idx, pList.get(idx) + 1); 
		}
		
		int mostIdx = 0;		
		for (int i = 0; i < pList.size(); i++) {
			if (pList.get(mostIdx) < pList.get(i)) {
				mostIdx = i;
			}
		}
		
		pRoom = rooms.get(mostIdx);
		
		return pRoom;
	}

	@Override
	public List<MyDate> soldOutDate() {
		MyDate date = new MyDate(2025, 5, 1);	
		
		List<MyDate> soldOutDateList = new ArrayList<>();
		
//		List<Room> leftRooms = roomsByDate(date);
//		
//		for (int i = 0; i < now.lengthOfMonth(); i++) {
//			MyDate date = new MyDate(now.getYear(), now.getMonthValue(), now.getDayOfMonth());
//			soldOutDateList.add(date)
//		}
		
		return soldOutDateList;
	}

	@Override
	public HashMap<Room, Integer> roomsByDate(MyDate date) {
		HashMap<Room, Integer> roomsHeadCount = new HashMap<>();
		List<Reservation> dateReserve = new ArrayList<>();
		
		for (Room r : rooms) {
			roomsHeadCount.put(r, 0);
		}
		
		for (Reservation r : reservations) {
			if (r.getDate().equals(date))  {
				dateReserve.add(r);
			}
		}
		
		for (Reservation r : dateReserve) {			
			roomsHeadCount.put(r.getRoom(), roomsHeadCount.get(r.getRoom()) + r.getPeople());
		}
		
//		List<Room> leftRooms = new ArrayList<>();
//		
//		for (Room r : rooms) {
//			if (roomsHeadCount.get(r) < r.getMaxCount()) {
//				leftRooms.add(r);
//			}
//		}
		
		return roomsHeadCount;
	}

	@Override
	public HashMap<Room, Integer> roomsByDate(MyDate date, int people) {
		HashMap<Room, Integer> roomsHeadCount = new HashMap<>();
		List<Reservation> dateReserve = new ArrayList<>();
		
		for (Room r : rooms) {
			roomsHeadCount.put(r, 0);
		}
		
		for (Reservation r : reservations) {
			if (r.getDate().equals(date))  {
				dateReserve.add(r);
			}
		}
		
		for (Reservation r : dateReserve) {			
			roomsHeadCount.put(r.getRoom(), roomsHeadCount.get(r.getRoom()) + r.getPeople());
		}
		
//		List<Room> leftRooms = new ArrayList<>();
//		
//		for (Room r : rooms) {
//			if (roomsHeadCount.get(r) < r.getMaxCount() && people <= r.getMaxCount() - roomsHeadCount.get(r)) {
//				leftRooms.add(r);
//			}
//		}
		
		return roomsHeadCount;
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
