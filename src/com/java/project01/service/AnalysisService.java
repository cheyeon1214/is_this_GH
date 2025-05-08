package com.java.project01.service;

import java.util.List;

import com.java.project01.util.MyDate;
import com.java.project01.vo.Room;
/**
 * 
 */
public interface AnalysisService {
	Room mostPopularRoom();
	List<MyDate> soldOutDate();
}
