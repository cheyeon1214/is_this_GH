package com.java.project01.service;

import com.java.project01.exception.RecordNotFoundException;
import com.java.project01.util.MyDate;
import com.java.project01.vo.Customer;
import com.java.project01.vo.Reservation;
import com.java.project01.vo.Room;
import com.java.project01.vo.parent.Event;
/**
 * 예약과 관련된 서비스 인터페이스
 */
public interface ReserveService {
	/**
	 * 사용자 정보와 예약에 관련된 정보를 받아 예약을 생성한다.
	 * @param date 예약 날짜 
	 * @param customer 손님 객체
	 * @param room 방 객체
	 * @param isBreakfast 조식 유무
	 * @param people 인원수
	 * @param event 이벤트 객체
	 * @param reserveCode 예약 코드
	 */
	void addReservation(MyDate date,Customer customer, Room room, boolean isBreakfast, int people, int reserveCode, Event event);
	
	/**
	 * 수정 할 예약 코드와 수정 하고싶은 내역이 담긴 예약 객체를 받아 수정한다.
	 * @param code 수정하고 싶은 예약 코드
	 * @param reserve 바꾸고 싶은 예약 객체
	 */
	void updateReserve(int code, Reservation reserve) throws RecordNotFoundException;
	
	/**
	 * 삭제하고 싶은 예약 코드를 받아서 예약 리스트에서 삭제한다
	 * @param code 삭제하고 싶은 예약 코드
	 */
	void deleteReserve(int code) throws RecordNotFoundException;
}
