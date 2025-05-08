package com.java.project01.vo.child;

import com.java.project01.vo.parent.Event;

public class PartyEvent extends Event{

	private String type;
	private String food;
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getFood() {
		return food;
	}
	
	public void setFood(String food) {
		this.food = food;
	}

	@Override
	public String toString() {
		return "PartyEvent [type=" + type + ", food=" + food + "]";
	}
	
	
	
}
