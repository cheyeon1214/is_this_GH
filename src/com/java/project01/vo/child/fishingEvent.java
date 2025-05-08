package com.java.project01.vo.child;

import com.java.project01.vo.parent.Event;

public class fishingEvent extends Event{

	private boolean isBoat;
	private String area;
	
	public boolean isBoat() {
		return isBoat;
	}

	public void setBoat(boolean isBoat) {
		this.isBoat = isBoat;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "fishingEvent [isBoat=" + isBoat + ", area=" + area + "]";
	}
	
	
	
}
