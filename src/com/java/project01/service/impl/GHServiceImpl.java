package com.java.project01.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

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
	public void addRoom(Room room) {
		rooms.add(room);
	}
	@Override
	public void addEvent(Event event) {
		events.add(event);
	}
	
	@Override
	public void addReservation(MyDate date, Customer customer, Room room, boolean isBreakfast, int people, int reserveCode, Event event) {
		reservations.add(new Reservation(reserveCode, room, date, customer, isBreakfast, people, event));
	}
	
	@Override
	public List<Room> getAllRooms() {
		return rooms;
	}
	
	@Override
	public List<Event> getAllEvents() {
		return events;
	}
	
	@Override
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
		System.out.println("현재 예약 수: " + reservations.size());
		Room pRoom = null;
		
		if (reservations.isEmpty()) return null;
		
		List<Integer> pList = new ArrayList<>();
		
		for (int i = 0; i < rooms.size(); i++) {
			pList.add(0);
		}
		
		for (Reservation r : reservations) {
			int idx = rooms.indexOf(r.getRoom());			
			pList.set(idx, pList.get(idx) + 1); 
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
		List<MyDate> soldOutDateList = new ArrayList<>();
		
		TreeSet<MyDate> dateTreeSet = new TreeSet<>();
		
		for (Reservation r : reservations) {
			dateTreeSet.add(r.getDate());
		}
		
		for (MyDate d : dateTreeSet) {
			HashMap<Room, Integer> roomsByDate = roomsByDate(d);
			if (roomsByDate == null) {
				soldOutDateList.add(d);
			}
		}		
		
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
			Room room = r.getRoom();
			int current = roomsHeadCount.getOrDefault(room, 0);
			roomsHeadCount.put(room, current + r.getPeople());
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
		
		return roomsHeadCount;
	}

	@Override
	public HashMap<Event, Integer> eventsByDate(MyDate date) {
		HashMap<Event, Integer> eventsHeadCount = new HashMap<>();
		List<Reservation> dateReserve = new ArrayList<>();
		
		for (Event e : events) {
			eventsHeadCount.put(e, 0);
		}
		
		for (Reservation r : reservations) {
			if (r.getDate().equals(date))  {
				dateReserve.add(r);
			}
		}
		
		for (Reservation r : dateReserve) {			
			eventsHeadCount.put(r.getEvent(), eventsHeadCount.get(r.getEvent()) + r.getPeople());
		}
		
//		List<Event> leftEvents = new ArrayList<>();
//		
//		for (Event r : events) {
//			if (eventsHeadCount.get(r) < EVENT_MAX_COUNT) {
//				leftEvents.add(r);
//			}
//		}
		
		return eventsHeadCount;
	}

	@Override
	public String getBreakfastInfo() {
		String breakfastInfo = "";
		
		return breakfastInfo;
	}

}
