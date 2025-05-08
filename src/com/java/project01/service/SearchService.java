package com.java.project01.service;

import java.util.List;

import com.java.project01.util.MyDate;
import com.java.project01.vo.Reservation;
import com.java.project01.vo.Room;
import com.java.project01.vo.parent.Event;

public interface SearchService {
	Reservation checkMyReserve(int code);
	List<Room> roomsByDate(MyDate date);
	List<Room> roomsByDate(MyDate date, int people);
	List<Event> eventsByDate(MyDate date);
	List<Room> getAllRooms();
	List<Event> getAllEvents();
}
