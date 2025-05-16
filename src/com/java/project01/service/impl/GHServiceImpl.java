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
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
		Reservation myReservation = reservations.stream()
												.filter((r) -> r.getReserveCode() == code)
												.findFirst()
												.get();
		
		if (myReservation == null)
			throw new RecordNotFoundException("해당 예약 번호(" + code + ")에 대한 정보를 찾을 수 없습니다.");
		else 
			return myReservation;
	}

	@Override
	public void deleteReserve(int code) throws RecordNotFoundException {
	    Optional<Reservation> target = reservations.stream()
	        .filter(r -> r.getReserveCode() == code)
	        .findFirst();

	    if (target.isPresent()) {
	        reservations.remove(target.get());
	        System.out.println("예약 취소를 완료하였습니다.");
	    } else {
	        throw new RecordNotFoundException("해당 예약 번호(" + code + ")에 대한 정보를 찾을 수 없습니다. :: 삭제 실패");
	    }
	}
	@Override
	public void updateReserve(int code, Reservation reserve) throws RecordNotFoundException {
	
		// Java Stream은 기본적으로 "읽기(read-only)" 전용으로 설계되어 있어서 List의 요소를 직접 수정하는 용도로는 잘 사용하지 않음
		Reservation target = checkMyReserve(code);
		
		if (target == null)
			throw new RecordNotFoundException("해당 예약 번호(" + code + ")에 대한 정보를 찾을 수 없습니다.");
		
		int idx = reservations.indexOf(target);
		
		reservations.set(idx, reserve);

		System.out.println("예약 번호(" + code + ") 고객의 정보를 수정 완료하였습니다.");
	}

	// 비지니스 로직
	@Override
	public Room mostPopularRoom() {
	    if (reservations.isEmpty()) {
	        throw new NullPointerException("예약된 정보가 없어, 인기 방을 계산할 수 없습니다.");
	    }
	    Map<Room, Long> roomCountMap = reservations.stream()
	    .collect(Collectors.groupingBy(Reservation::getRoom, Collectors.counting()));
	    // 가장 많이 예약된 횟수 계산
	    Long maxCount = Collections.max(roomCountMap.values());
	    
	    // 뒤에서부터 순회하면서 최신 예약된 인기 방 찾기
	    for (int i = reservations.size() - 1; i >= 0; i--) {
	        Room room = reservations.get(i).getRoom();
	        if (roomCountMap.get(room) == maxCount) {
	            return room; // 최신 인기 방 반환
	        }
	    }
//	    Optional<Room> mostRecentPopularRoom = IntStream.range(0, reservations.size())
//	    	    .mapToObj(i -> reservations.get(reservations.size() - 1 - i)) // 역순 스트림
//	    	    .map(Reservation::getRoom)
//	    	    .filter(room -> roomCountMap.get(room) == maxCount)
//	    	    .findFirst();
	    
	    
	    return null;
	}

	@Override
	public List<MyDate> soldOutDate() {
		List<MyDate> soldOutDateList = new ArrayList<>();

		TreeSet<MyDate> dateTreeSet = reservations.stream()
                .map(Reservation::getDate)
                .collect(Collectors.toCollection(TreeSet::new));
		
		soldOutDateList.addAll(
			    dateTreeSet.stream()
			        .filter(d -> {
			            return roomsByDate(d).entrySet().stream()
			                   .allMatch(entry -> entry.getValue().equals(entry.getKey().getMaxCount()));
			        })
			        .toList()
			);

		return soldOutDateList;
	}

	@Override
	public HashMap<Room, Integer> roomsByDate(MyDate date) {
	    HashMap<Room, Integer> roomsHeadCount = new HashMap<>();

	    // 1. 모든 방을 0으로 초기화
	    for (Room r : rooms) {
	        roomsHeadCount.put(r, 0);
	    }

	    // 2. 해당 날짜의 예약만 반영해서 인원 누적
	    reservations.stream()
	        .filter(r -> r.getDate().equals(date))
	        .forEach(r -> {
	            Room room = r.getRoom();
	            roomsHeadCount.put(room, roomsHeadCount.get(room) + r.getPeople());
	        });

	    return roomsHeadCount;
	}


	@Override
	public HashMap<Event, Integer> eventsByDate(MyDate date) {
		HashMap<Event, Integer> eventHeadCounts = reservations
				.stream()
		        .filter(r -> r.getDate().equals(date))   
		        .filter(r -> r.getEvent() != null)
		        .collect(Collectors.groupingBy(
		        		Reservation::getEvent,
		        		HashMap::new,
		        		Collectors.summingInt(Reservation::getPeople)
		        ));
		
		events.forEach((e) -> eventHeadCounts.putIfAbsent(e, 0));


		return eventHeadCounts;
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
