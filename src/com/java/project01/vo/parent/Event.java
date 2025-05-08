package com.java.project01.vo.parent;

import com.java.project01.util.MyTime;

public class Event {
	
	public static final int minCount = 4;
	public static final int maxCount = 20 ;
	
	private int price;
	private String info;
	private String name;
	private MyTime startTime;
	private MyTime endTime;
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getInfo() {
		return info;
	}
	
	public void setInfo(String info) {
		this.info = info;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public MyTime getStartTime() {
		return startTime;
	}
	
	public void setStartTime(MyTime startTime) {
		this.startTime = startTime;
	}
	
	public MyTime getEndTime() {
		return endTime;
	}
	
	public void setEndTime(MyTime endTime) {
		this.endTime = endTime;
	}
	
	public static int getMincount() {
		return minCount;
	}
	
	public static int getMaxcount() {
		return maxCount;
	}

	@Override
	public String toString() {
		return "Event [price=" + price + ", info=" + info + ", name=" + name + ", startTime=" + startTime + ", endTime="
				+ endTime + "]";
	}
	
	
	
	
}
