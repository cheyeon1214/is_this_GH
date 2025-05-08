package com.java.project01.vo.child;

import com.java.project01.vo.parent.Event;

/**
 * 낚시 이벤트에 관한 클래스
 */
public class FishingEvent extends Event{

	private boolean isBoat;
	private String area;
	
	public FishingEvent() {}
	/**
	 * FishingEvent 생성자
	 * @param isBoat 배 사용유무
	 * @param area 낚시지역
	 */
	public FishingEvent(boolean isBoat, String area) {
		this.isBoat = isBoat;
		this.area = area;
	}
	
	/**
	 * 배를 사용하는 지를 반환하는 getter
	 * @return 배 사용유무
	 */
	public boolean isBoat() {
		return isBoat;
	}

	/**
	 * 배 사용여부를 변경하는 setter
	 * @param isBoat 배 사용여부
	 */
	public void changeBoat(boolean isBoat) {
		this.isBoat = isBoat;
	}

	/**
	 * 낚시지역을 반환하는 getter
	 * @return 낚시지역
	 */
	public String getArea() {
		return area;
	}

	/**
	 * 낚시지역을 변경하는 setter
	 * @param area 낚시지역
	 */
	public void changeArea(String area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "fishingEvent [isBoat=" + isBoat + ", area=" + area + "]";
	}
	
	
	
}
