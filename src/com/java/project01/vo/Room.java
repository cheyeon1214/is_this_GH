package com.java.project01.vo;

import com.java.project01.util.MyTime;

public class Room {
	public static final MyTime checkIn = new MyTime(14,0,0);
	public static final MyTime checkOut = new MyTime(10,0,0);
	
	private String name;
	private double price;
	private String info;
	private char gender;
	private int maxCount;
	private int minCount;
	private String funiture;
	private boolean isSoldOut;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getInfo() {
		return info;
	}
	
	public void setInfo(String info) {
		this.info = info;
	}
	
	public char getGender() {
		return gender;
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public int getMaxCount() {
		return maxCount;
	}
	
	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}
	
	public int getMinCount() {
		return minCount;
	}
	
	public void setMinCount(int minCount) {
		this.minCount = minCount;
	}
	
	public String getFuniture() {
		return funiture;
	}
	
	public void setFuniture(String funiture) {
		this.funiture = funiture;
	}
	
	public boolean isSoldOut() {
		return isSoldOut;
	}
	
	public void setSoldOut(boolean isSoldOut) {
		this.isSoldOut = isSoldOut;
	}
	
	public static MyTime getCheckin() {
		return checkIn;
	}
	
	public static MyTime getCheckout() {
		return checkOut;
	}

	@Override
	public String toString() {
		return "Room [name=" + name + ", price=" + price + ", info=" + info + ", gender=" + gender + ", maxCount="
				+ maxCount + ", minCount=" + minCount + ", funiture=" + funiture + ", isSoldOut=" + isSoldOut + "]";
	}
	
	
}
