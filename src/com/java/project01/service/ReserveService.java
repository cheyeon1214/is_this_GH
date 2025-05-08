package com.java.project01.service;

import com.java.project01.vo.Reservation;
/**
 * 예약 
 */
public interface ReserveService {
	void reserve();
	void updateReserve(int code, Reservation reserve);
	void deleteReserve(int code);
}
