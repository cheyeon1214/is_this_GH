package com.java.project01.service;

import java.util.HashMap;
import java.util.List;

import com.java.project01.exception.RecordNotFoundException;
import com.java.project01.util.MyDate;
import com.java.project01.vo.Reservation;
import com.java.project01.vo.Room;
import com.java.project01.vo.parent.Event;
/**
 * 조회와 관련된 서비스 인터페이스
 */
public interface SearchService {
	/**
	 * 해당하는 예약번호를 입력받아서 예약을 반환함
	 * @param code 예약번호
	 * @return 해당하는 예약 객체
	 */
	Reservation checkMyReserve(int code) throws RecordNotFoundException;
	
	/**
	 * 해당하는 날짜의 예약가능한 방 목록을 반환함
	 * @param date 예약날짜
	 * @return 예약가능한 방 목록
	 */
	HashMap<Room, Integer> roomsByDate(MyDate date);
	
	/**
	 * 해당하는 날짜의 인원수가 모두 들어갈 수 있는 예약가능한 방 목록을 반환함
	 * @param date 예약날짜
	 * @param people 인원수
	 * @return 예약가능한 방 목록
	 */
	HashMap<Room, Integer> roomsByDate(MyDate date, int people);
	
	/**
	 * 해당하는 날짜의 모든 이벤트 목록과 인원수를 반환함
	 * @param date 날짜
	 * @return 이벤트 목록
	 */
	HashMap<Event, Integer> eventsByDate(MyDate date);
	
	/**
	 * 모든 방을 반환함
	 * @return
	 */
	List<Room> getAllRooms();
	
	/**
	 * 모든 이벤트 목록을 반환함
	 * @return
	 */
	List<Event> getAllEvents();
}
