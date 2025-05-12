package com.java.project01.service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.java.project01.exception.RecordNotFoundException;
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
	public Reservation checkMyReserve(int code) throws RecordNotFoundException {
		for (Reservation r : reservations) {
			if (r.getReserveCode() == code) {
				return r;
			}
		}
		throw new RecordNotFoundException("해당 예약 번호(" + code + ")에 대한 정보를 찾을 수 없습니다.");
	}
	
	@Override
	public void deleteReserve(int code) throws RecordNotFoundException {
		boolean isDeleted = false;
		
		for (Reservation r : reservations) {
			if (r.getReserveCode() == code) {
				isDeleted = reservations.remove(r);
				break;
			}
		}
		if(!isDeleted) {
			throw new RecordNotFoundException("해당 예약 번호(" + code + ")에 대한 정보를 찾을 수 없습니다. :: 삭제 실패");
		}
		System.out.println("예약 취소를 완료하였습니다.");
	}
	
	@Override
	public void updateReserve(int code, Reservation reserve) throws RecordNotFoundException {
		// update된 정보가 있는지 판단 여부
		boolean isUpdated = false;
		
		for (int i = 0; i < reservations.size(); i++) {
			if (reservations.get(i).getReserveCode() == code) {
				reservations.set(i, reserve);
				isUpdated = true;
			}
		}
		
		if (!isUpdated) {
	        throw new RecordNotFoundException("해당 예약 번호(" + code + ")에 대한 정보를 찾을 수 없습니다. :: 고객 정보 업데이트 실패");
	    }
		
		System.out.println("예약 번호(" + code + ") 고객의 정보를 수정 완료하였습니다.");
	}
	
	
	//비지니스 로직

	@Override
	public Room mostPopularRoom() {
		System.out.println("현재 예약 수: " + reservations.size());
		
		Room pRoom = null;
		
		if (reservations.isEmpty()) {
			throw new NullPointerException("예약된 정보가 없어, 인기 방을 계산할 수 없습니다.");
		};
		
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
		boolean isFullyBooked;
		
		for (Reservation r : reservations) {
			dateTreeSet.add(r.getDate());
		}
		
		for (MyDate d : dateTreeSet) {
			HashMap<Room, Integer> roomsByDateMap = roomsByDate(d);
			Set<Room> rooms = roomsByDateMap.keySet();
			isFullyBooked = true;
			
			for (Room r : rooms) {
				if (roomsByDateMap.get(r) != r.getMaxCount()) {
					isFullyBooked = false;
					break;
				}
			}
			
			if (isFullyBooked) soldOutDateList.add(d);
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
	public String getBreakfastInfo() throws IOException {
		String breakfastInfo = "";		
		BufferedReader br = new BufferedReader(new FileReader("./breakfast.txt"));
		
        while(true) {
        	String tmpStr = br.readLine();   
        	if (tmpStr == null)
        		break;
        	//System.out.println(breakfastInfo);
        	breakfastInfo += tmpStr;
        }       
        
        br.close();
		
		return breakfastInfo;
	}

}
