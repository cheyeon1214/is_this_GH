package com.java.project01.vo.child;

import com.java.project01.util.MyTime;
import com.java.project01.vo.parent.Event;
/**
 * BBQ 이벤트에 관한 클래스
 */
public class BBQEvent extends Event {

	private String equipment;
	private String food;
	
	public BBQEvent() {}
	
	/**
	 * BBQEvent 생성자
	 * @param equipment BBQ용 장비
	 * @param food 음식
	 */
	public BBQEvent(String eventType, MyTime startTime, MyTime endTime, String equipment, String food) {
		super(eventType, startTime, endTime);
		this.equipment = equipment;
		this.food = food;
	}
	
	/**
	 * BBQ용 장비 getter
	 * @return BBQ용 장비 문자열
	 */
	public String getEquipment() {
		return equipment;
	}

	/**
	 * BBQ용 장비 setter
	 * @param equipment BBQ용 장비
	 */
	public void changeEquipment(String equipment) {
		this.equipment = equipment;
	}

	/**
	 * BBQ 음식 getter
	 * @return 음식
	 */
	public String getFood() {
		return food;
	}

	/**
	 * BBQ 음식 setter
	 * @param food 음식
	 */
	public void changeFood(String food) {
		this.food = food;
	}

	@Override
	public String toString() {
		return "BBQEvent [equipment=" + equipment + ", food=" + food + "]";
	}

}
