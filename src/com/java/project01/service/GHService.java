package com.java.project01.service;

/**
 * 게스트하우스에 관련된 서비스 인터페이스
 */
public interface GHService extends AnalysisService, ReserveService, SearchService {
	/**
	 * 조식 메뉴를 반환함
	 * @return 조식 메뉴 문자열
	 */
	String getBreakfastInfo();
}
