package com.java.project01.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import com.java.project01.service.impl.GHServiceImpl;
import com.java.project01.util.MyDate;
import com.java.project01.util.MyTime;
import com.java.project01.vo.Customer;
import com.java.project01.vo.Reservation;
import com.java.project01.vo.Room;
import com.java.project01.vo.child.BBQEvent;
import com.java.project01.vo.child.FishingEvent;
import com.java.project01.vo.child.PartyEvent;
import com.java.project01.vo.parent.Event;

public class GHServiceTest {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		GHServiceImpl service = GHServiceImpl.getInstance();
		service.addRoom(new Room("여성 방 201호", 48000.0, "실내화장실,오션뷰", 'f', 4, "이층침대2, 책상1, 화장실1"));
		service.addRoom(new Room("여성 방 202호", 40000.0, "공용화장실", 'f', 8, "이층침대4, 책상2, 화장실x"));
		service.addRoom(new Room("남성 방 301호", 50000.0, "실내화장실,오션뷰", 'm', 4, "이층침대2, 책상1, 화장실1"));
		service.addRoom(new Room("남성 방 302호", 40000.0, "공용화장실,공용탁자", 'm', 8, "이층침대4, 책상2, 화장실x"));
		
		service.addEvent(new BBQEvent("BBQ", new MyTime(6, 10, 00), new MyTime(11, 30, 00), "화로", "돼지고기, 소고기"));
		service.addEvent(new FishingEvent("Fishing",new MyTime(7, 10, 00), new MyTime(10, 30, 00), false, "게하 앞 시내"));
		service.addEvent(new PartyEvent("Party", new MyTime(6, 30, 00), new MyTime(11, 50, 00), "소주, 맥주"));
		
		boolean runFlag = true;
		while (runFlag) {
			System.out.println(
					"숫자를 눌러 메뉴를 입력하세요\r\n"
					+ "1. 어떤 게스트하우스인가요?\r\n"
					+ "2. 예약을 하고 싶어요\r\n"
					+ "3. 예약을 확인하고 싶어요\r\n"
					+ "4. 예약을 수정하고 싶어요\r\n"
					+ "5. 예약을 삭제하고 싶어요\r\n"
					+ "6. 종료");
			
			String menuStr = sc.next();
			
			switch (menuStr) {
			case "1":
				searchGH();
				break;
			case "2":
				reserveGH();
				break;
			case "3":
				checkReserveGH();		
				break;
			case "4":
				System.out.println("예약 번호를 입력해주세요");				
				int reserveCode = sc.nextInt();
				
				Reservation originRes = service.checkMyReserve(reserveCode);
				
				if (originRes == null) {
					System.out.println("해당하는 예약이 없습니다.");
					break;
				}
				
				// 예약자의 정보
				
				// 조식 여부
				
				// 이벤트 여부
				
				Reservation res = new Reservation(originRes.getReserveCode(), originRes.getRoom(), null, null, runFlag, reserveCode, null);
				service.updateReserve(reserveCode, res);
				
				System.out.println();
				break;
			case "5":
				deleteReserveGH();
				break;
			case "6":
				runFlag = false;
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("숫자를 잘못 입력하셨습니다. 다시 입력하십시오.");
			}
		}
		
		sc.close();
	}

	private static void searchGH() {

		boolean runFlag = true;
		while (runFlag) {
			System.out.println("원하는 정보를 입력하세요\r\n"
					+ "1. 게스트하우스의 모든 방 소개\r\n"
					+ "2. 제일 인기 많은 방\r\n"
					+ "3. 예약이 마감된 날\r\n"
					+ "4. 모든 이벤트 소개\r\n"
					+ "5. 조식 메뉴 소개\r\n"
					+ "6. 뒤로가기");
			
			String menuStr = sc.next();
			
			switch (menuStr) {
			case "1":
				printAllRooms();
				break;
			case "2":
				printMostPopular();
				break;
			case "3":
				break;
			case "4":
				break;
			case "5":
				break;
			case "6":
				runFlag = false;
				return;
			default:
				System.out.println("숫자를 잘못 입력하셨습니다. 다시 입력하십시오.");
			}
		}
	}
	
	public static void printAllRooms() {
		//게하의 모든 방을 출력하는 함수
	}
	
	public static void printMostPopular() {
		GHServiceImpl service = GHServiceImpl.getInstance();
		System.out.println("제일 인기있는 방을 소개합니다");
		System.out.println(service.mostPopularRoom());
		System.out.println();
	}
	
	public static void reserveGH() {
		//예약을 하는 곳
		GHServiceImpl service = GHServiceImpl.getInstance();
		System.out.println("날짜를 입력해주세요."); //나중에 년,월 받고 매진 안된 날짜 출력되는 형식으로 upgrade
		MyDate wantDate = new MyDate(sc.nextInt(), sc.nextInt(), sc.nextInt());
		
		boolean reserveFlag = true;
		while(reserveFlag) {
			System.out.println("원하는 서비스를 선택해주세요");
		    System.out.println("1. 해당 날짜의 남아있는 방 출력\n"
		            +"2. 원하는 인원수의 남아있는 방 출력\n"
		            +"3. 예약하기\n"
		            +"4. 뒤로가기 \n");
		    String reserveNum = sc.next();

		    switch(reserveNum) {
		        case "1":
		            printReserveByDate(wantDate);
		            break;
		        case "2":
		        	printReserveByCount(wantDate);
		            break;
		        case "3":
		            addAReserve(wantDate);
		            break;
		        case "4":
		            reserveFlag = false;
		            break;
		        default:
		            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
		    }
		}
	}
	
	private static void printReserveByDate(MyDate wantDate) {
		GHServiceImpl service = GHServiceImpl.getInstance();
		System.out.println(wantDate.getMonth()+"월 "+wantDate.getDay()+"일 기준, 방 예약 현황입니다.");
		List<Room> roomList = service.getAllRooms();
		int i=1;
		HashMap<Room,Integer> roomMapByDate = service.roomsByDate(wantDate);
		
		for(Room r: roomList) {
			System.out.println(i+". "+r.getName() + "("+ roomMapByDate.get(r)+"/"+r.getMaxCount()+")");
			i++;
		}
	}
	
	private static void printReserveByCount(MyDate wantDate) {
		GHServiceImpl service = GHServiceImpl.getInstance();
		System.out.println("예약을 원하시는 인원 수를 입력해주세요:");
		int count = sc.nextInt();

		System.out.println(wantDate.getMonth() + "월 " + wantDate.getDay() + "일 기준, " + count + "인실 예약 가능한 방 목록입니다.");
		List<Room> roomList = service.getAllRooms();
		int i=1;
		HashMap<Room,Integer> roomMapByDate = service.roomsByDate(wantDate);
		
		for(Room r: roomList) {
			if(r.getMaxCount() == count)
				System.out.println(i+". "+r.getName() + "("+ roomMapByDate.get(r)+"/"+r.getMaxCount()+")");
			i++;
		}
		
	}

	public static void addAReserve(MyDate wantDate) {
		GHServiceImpl service = GHServiceImpl.getInstance();
		System.out.println("**사용자 정보를 입력해주세요**");
		System.out.println("예약자분 성함: ");
		String nameString = sc.next();
		System.out.println("예약자분 성별(여/남): ");
		String input = "";
		char gender;

		while(true) {
			input = sc.next();
			if (input.equals("여")) {
			    gender = 'f';
			    break;
			} else if (input.equals("남")) {
			    gender = 'm';
			    break;
			} else {
			    System.out.println("다시 입력해주세요.");
			}
		}
		
		System.out.println("인원수(혼성 예약 불가): ");
		int countPeople = sc.nextInt();
		
		System.out.println("예약자분 전화번호: ");
		String phoneString = sc.next();
		
		System.out.println("**원하시는 방을 입력해주세요**");
		
		System.out.println(input+"성 전용 방 리스트입니다.");
		List<Room> roomList = service.getAllRooms();
		
		int i=1;
		HashMap<Room,Integer> roomMapByDate = service.roomsByDate(wantDate);
		
		for(Room r: roomList) {
			if(r.getGender() == gender) {
				System.out.println(i+". "+r.getName() + "("+ roomMapByDate.get(r)+"/"+r.getMaxCount()+")");
				i++;
			}
		}
		
		//이 때 방 현황보고 뒤로가기 하는 것도 생각해야 함.
		Room reserveRoom = null;
		boolean validRoom = false;

		while (!validRoom) {
		    int roomChoice = sc.nextInt();

		    if (roomChoice < 1 || roomChoice > roomList.size()) {
		        System.out.println("입력하신 번호의 방은 존재하지 않습니다. 다시 입력해주세요.");
		        continue;
		    }

		    Room selectedRoom = roomList.get(roomChoice - 1);
		    int currentCount = roomMapByDate.getOrDefault(selectedRoom, 0);

		    if (currentCount + countPeople > selectedRoom.getMaxCount()) {
		        System.out.println("인원수가 가득 찼습니다. 다시 입력해주세요.");
		    } else {
		        reserveRoom = selectedRoom;
		        validRoom = true;
		    }
		}
		
		System.out.println("방 선택이 완료되었습니다. 다음은 부가서비스 안내입니다.");
		Boolean isBreakfast = false;
		while (true) {
		    System.out.println("조식을 신청하시겠습니까? (네/아니요)");
		    String inputBoolean = sc.next();

		    if (inputBoolean.equals("네")) {
		        isBreakfast = true;
		        break;
		    } else if (inputBoolean.equals("아니요")) {
		        isBreakfast = false;
		        break;
		    } else {
		        System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
		    }
		}
		
		System.out.println("조식 신청이 완료되었습니다.");
		Event reserveEvent = null;
		while(true) {
			System.out.println("다음은 이벤트 신청입니다. 이벤트를 신청하시겠습니까?(네/아니요)");
			String booleanEvent = sc.next();  
			if(booleanEvent.equals("네")) {
				System.out.println("원하시는 이벤트 번호를 입력해주세요.");
				List<Event> eventList = service.getAllEvents();
				int j = 1;
				HashMap<Event,Integer> eventMapByDate = service.eventsByDate(wantDate);
				
				for(Event e: eventList) {
					System.out.println(j+". "+e.getEventType() + "("+ eventMapByDate.get(e)+"/"+GHServiceImpl.EVENT_MAX_COUNT+")");
					j++;
				}
				boolean validEvent = false;

				while (!validEvent) {
				    int eventChoice = sc.nextInt();

				    if (eventChoice < 1 || eventChoice > eventList.size()) {
				        System.out.println("입력하신 번호의 이벤트는 존재하지 않습니다. 다시 입력해주세요.");
				        continue;
				    }

				    Event selectedEvent = eventList.get(eventChoice - 1);
				    int current_Count = eventMapByDate.getOrDefault(selectedEvent, 0);

				    if (current_Count + countPeople > GHServiceImpl.EVENT_MAX_COUNT) {
				        System.out.println("인원수가 가득 찼습니다. 다시 입력해주세요.");
				    } else {
				        reserveEvent = selectedEvent;
				        validEvent = true;
				    }
				}
				
				System.out.println(reserveEvent.getEventType()+"이벤트 예약 정보가 저장되었습니다.");
				break;
			}else if(booleanEvent.equals("아니요")) {
				break;
			}else {
				System.out.println("다시 입력해주세요");
			}
		}
		
		Set<Integer> usedCodes = new HashSet<>();
		for (Reservation r : service.getAllReservations()) {
		    usedCodes.add(r.getReserveCode()); 
		}

		Random random = new Random();
		int newCode;

		do {
		    newCode = random.nextInt(9000) + 1000; // 1000 ~ 9999
		} while (usedCodes.contains(newCode));

		System.out.println("예약 정보를 모두 입력하셨습니다.");
		System.out.println("정말 예약하시겠습니까? (네/아니요)");

		String confirm = sc.next();
		if (confirm.equals("아니요")) {
		    System.out.println("예약이 취소되었습니다. 이전 메뉴로 돌아갑니다.");
		    return; // 함수 종료
		} else if (!confirm.equals("네")) {
		    System.out.println("잘못된 입력입니다. 예약을 취소합니다.");
		    return;
		}
		
		// 예약 추가
		service.addReservation(
		    wantDate,
		    new Customer(nameString, gender, phoneString),
		    reserveRoom,
		    isBreakfast,
		    countPeople,
		    newCode,
		    reserveEvent
		);
		
		System.out.println("예약 되었습니다. 예약 번호는"+newCode+"입니다.\n");
		
		System.out.println(service.getAllReservations());
		
	}
	
	public static void checkReserveGH() {
		GHServiceImpl service = GHServiceImpl.getInstance();
		System.out.println("예약 번호를 입력해주세요");
		
		int reserveCode = sc.nextInt();
		
		System.out.println(service.checkMyReserve(reserveCode) == null ? "해당 예약이 없습니다." : service.checkMyReserve(reserveCode));	
	}
	
	public static void deleteReserveGH() {
		GHServiceImpl service = GHServiceImpl.getInstance();
		System.out.println("예약 번호를 입력해주세요");
		int reserveCode = sc.nextInt();
		service.deleteReserve(reserveCode);
		System.out.println(service.getAllReservations() == null ? "null" : service.getAllReservations());
	}
	
}
