package com.java.project01.vo.child;

import com.java.project01.util.MyTime;
import com.java.project01.vo.parent.Event;
/**
 * 파티와 관련된 클래스
 */
public class PartyEvent extends Event{

	private String food;
	
	public PartyEvent() {}
	/**
	 * PartyEvent 생성자
	 * @param type 파티 유형
	 * @param food 파티 음식
	 */
	public PartyEvent(String eventType, MyTime startTime, MyTime endTime, String food) {
		super(eventType, startTime, endTime);
		this.food = food;
	}
	
//	/**
//	 * 파타 유형을 반환하는 getter
//	 * @return 파티 유형 문자열
//	 */
//	public String getType() {
//		return type;
//	}
//	
//	/**
//	 * 파티 유형을 전환하는 setter
//	 * @param type 파티유형
//	 */
//	public void changeType(String type) {
//		this.type = type;
//	}
	
	/**
	 * 파티 음식을 반환하는 getter
	 * @return 파티 음식 문자열
	 */
	public String getFood() {
		return food;
	}
	
	/**
	 * 파티 음식을 변경하는 setter
	 * @param food 파티음식
	 */
	public void setFood(String food) {
		this.food = food;
	}

	@Override
	public String toString() {
		return "PartyEvent [ food=" + food + "]";
	}
	
	
	
}
