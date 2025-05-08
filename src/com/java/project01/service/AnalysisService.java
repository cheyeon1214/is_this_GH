package com.java.project01.service;

import java.util.List;

import com.java.project01.util.MyDate;
import com.java.project01.vo.Room;
/**
 *	게스트 하우스를 이용하는 이용자 분석을 위한 서비스입니다.
 *
 */
public interface AnalysisService {
	/**
	 * 
	 * @return 게스트 하우스 Room 중에서 가장 많이 예약됐었던 Room을 반환합니다.
	 */
	Room mostPopularRoom();
	
	/**
	 * 
	 * @return 게스트 하우스의 모든 Room 예약이 가득 차, 더이상 예약할 수 없는 날짜를 반환합니다.
	 */
	List<MyDate> soldOutDate();
}
