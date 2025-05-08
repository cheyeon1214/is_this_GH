package com.java.project01.vo.child;

import com.java.project01.vo.parent.Event;

public class BBQEvent extends Event {

	private String equipment;
	private String food;

	public String getEquipment() {
		return equipment;
	}

	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	@Override
	public String toString() {
		return "BBQEvent [equipment=" + equipment + ", food=" + food + "]";
	}

}
