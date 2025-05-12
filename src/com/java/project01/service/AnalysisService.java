package com.java.project01.service;

import java.util.List;

import com.java.project01.util.MyDate;
import com.java.project01.vo.Room;

/**
 * 게스트하우스 예약을 분석한 정보에 대해서 관리하는 인터페이스
 */
public interface AnalysisService {
	Room mostPopularRoom();
	List<MyDate> soldOutDate();
}
