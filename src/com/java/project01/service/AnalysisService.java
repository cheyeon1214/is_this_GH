package com.java.project01.service;

import java.util.List;

import com.java.project01.util.MyDate;
import com.java.project01.vo.Room;

/**
 * 게스트하우스 예약을 분석한 정보에 대해서 관리하는 인터페이스
 */
public interface AnalysisService {
	/**
	 * 가장 예약이 많이 된 방을 반환함
	 * - 예약된 수가 동일하다면 가장 최근에 예약된 방으로 반환
	 * @return 가장 예약이 많이 된 방
	 */
	Room mostPopularRoom();
	/**
	 * 방들이 모두 마감된 날짜들을 반환함
	 * @return 마감된 날짜 리스트
	 */
	List<MyDate> soldOutDate();
}
