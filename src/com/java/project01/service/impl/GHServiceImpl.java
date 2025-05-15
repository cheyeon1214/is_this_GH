package com.java.project01.service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.java.project01.exception.RecordNotFoundException;
import com.java.project01.service.GHService;
import com.java.project01.util.MyDate;
import com.java.project01.vo.Customer;
import com.java.project01.vo.Reservation;
import com.java.project01.vo.Room;
import com.java.project01.vo.parent.Event;

public class GHServiceImpl implements GHService {
	private static GHServiceImpl service = new GHServiceImpl();
	List<Reservation> reservations = null;
	List<Room> rooms = null;
	List<Event> events = null;

	/**
	 * @param EVENT_MIN_COUNT 최소 인원 4명
	 * @param EVENT_MAX_COUNT 최대 인원 20명
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

	// CRUD
	@Override
	public void addRoom(Room room) {
		rooms.add(room);
	}

	@Override
	public void addEvent(Event event) {
		events.add(event);
	}

	@Override
	public void addReservation(MyDate date, Customer customer, Room room, boolean isBreakfast, int people,
			int reserveCode, Event event) {
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
	public List<Reservation> getAllReservations() {
		return reservations;
	}

	@Override
	public Reservation checkMyReserve(int code) throws RecordNotFoundException {
//		for (Reservation r : reservations) {
//			if (r.getReserveCode() == code) {
//				return r;
//			}
//		}
		reservations.stream()
					.filter((r) -> r.getReserveCode() == code)
					.collect(Collectors.toList())
					.get(0);
		
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
		if (!isDeleted) {
			throw new RecordNotFoundException("해당 예약 번호(" + code + ")에 대한 정보를 찾을 수 없습니다. :: 삭제 실패");
		}
		System.out.println("예약 취소를 완료하였습니다.");
	}

	@Override
	public void updateReserve(int code, Reservation reserve) throws RecordNotFoundException {
		boolean isUpdated = false;

		// Java Stream은 기본적으로 "읽기(read-only)" 전용으로 설계되어 있어서 List의 요소를 직접 수정하는 용도로는 잘 사용하지 않음
				
		reservations.forEach((r) -> {
			if (r.getReserveCode() == code) {
				r.setEvent(reserve.getEvent());
				r.changeBreakfast(reserve.getIsBreakfast());
				r.changeCustomer(reserve.getCustomer());
			}
		});

		if (!isUpdated) {
			throw new RecordNotFoundException("해당 예약 번호(" + code + ")에 대한 정보를 찾을 수 없습니다. :: 고객 정보 업데이트 실패");
		}

		System.out.println("예약 번호(" + code + ") 고객의 정보를 수정 완료하였습니다.");
	}

	// 비지니스 로직
	@Override
	public Room mostPopularRoom() {
	    if (reservations.isEmpty()) {
	        throw new NullPointerException("예약된 정보가 없어, 인기 방을 계산할 수 없습니다.");
	    }
	    Map<Room, Integer> roomCountMap = new HashMap<>();
	    
	    	   
	    for (Room room : rooms) {
	        roomCountMap.put(room, 0);
	    }
	    
	    for (Reservation r : reservations) {
	        Room room = r.getRoom();
	        roomCountMap.put(room, roomCountMap.getOrDefault(room, 0) + 1);
	    }
	    // 가장 많이 예약된 횟수 계산
	    int maxCount = Collections.max(roomCountMap.values());
	    
	    // 뒤에서부터 순회하면서 최신 예약된 인기 방 찾기
	    for (int i = reservations.size() - 1; i >= 0; i--) {
	        Room room = reservations.get(i).getRoom();
	        if (roomCountMap.get(room) == maxCount) {
	            return room; // 최신 인기 방 반환
	        }
	    }
	    
	    return null;
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

			if (isFullyBooked)
				soldOutDateList.add(d);
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
			if (r.getDate().equals(date)) {
				dateReserve.add(r);
			}
		}

		for (Reservation r : dateReserve) {
			Room room = r.getRoom();
			int current = roomsHeadCount.getOrDefault(room, 0);
			roomsHeadCount.put(room, current + r.getPeople());
		}


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
			if (r.getDate().equals(date)) {
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
			if (r.getDate().equals(date)) {
				dateReserve.add(r);
			}
		}

		for (Reservation r : dateReserve) {
		    Event event = r.getEvent();
		    int eventHead = eventsHeadCount.getOrDefault(event, 0);
		    eventsHeadCount.put(event, eventHead + r.getPeople());
		}


		return eventsHeadCount;
	}

	@Override
	public String getBreakfastInfo() throws IOException {
		String breakfastInfo = "";
		BufferedReader br = new BufferedReader(new FileReader("./breakfast.txt"));

		while (true) {
			String tmpStr = br.readLine();
			if (tmpStr == null)
				break;
			breakfastInfo += tmpStr;
		}

		br.close();

		return breakfastInfo;
	}

	public void printReservation() {
		try (PrintWriter pw = new PrintWriter(new FileWriter("./reservations.txt"))) {
			for (Reservation r : service.getAllReservations()) 
				pw.println(r);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
