package com.java.project01.service;

import java.io.IOException;
import java.util.List;

import com.java.project01.vo.Reservation;
import com.java.project01.vo.Room;
import com.java.project01.vo.parent.Event;

/**
 * 게스트하우스에 관련된 서비스 인터페이스
 */
public interface GHService extends AnalysisService, ReserveService, SearchService {
	/**
	 * 조식 메뉴를 반환함
	 * @return 조식 메뉴 문자열
	 * @throws IOException 
	 */
	String getBreakfastInfo() throws IOException;
	/**
	 * 현재 모든 예약 목록을 반환함
	 * @return 예약 목록
	 */
	List<Reservation> getAllReservations();
	/**
	 * 게스트하우스 방을 추가
	 * @param room 방
	 */
	void addRoom(Room room);
	/**
	 * 게스트하우스 이벤트를 추가
	 * @param event 이벤트
	 */
	void addEvent(Event event);
}
