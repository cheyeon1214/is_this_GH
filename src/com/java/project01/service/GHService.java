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
	List<Reservation> getAllReservations();
	void addRoom(Room room);
	void addEvent(Event event);
}
