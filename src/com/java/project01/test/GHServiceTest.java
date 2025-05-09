package com.java.project01.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
		service.addRoom(new Room("201호", 48000.0, "실내화장실,오션뷰", 'f', 4, "이층침대2, 책상1, 화장실1"));
		service.addRoom(new Room("202호", 40000.0, "공용화장실", 'f', 8, "이층침대4, 책상2, 화장실x"));
		service.addRoom(new Room("301호", 50000.0, "실내화장실,오션뷰", 'm', 4, "이층침대2, 책상1, 화장실1"));
		service.addRoom(new Room("302호", 40000.0, "공용화장실,공용탁자", 'm', 8, "이층침대4, 책상2, 화장실x"));
		
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
				System.out.println("예약 번호를 입력해주세요");
				System.out.println(service.checkMyReserve(1000));
				
				break;
			case "4":
				System.out.println("예약 번호를 입력해주세요");
				service.updateReserve(1000, new Reservation(1000, new Room("1029방", 19000, "더블룸이고 화장실이 안에있습니다. 쾌적합니다.", 'f', 4, "침대2, 화장실1"),new MyDate(2025,5,5), new Customer("곽채연", 'f', "010-5582-1857"), true, 2));
				System.out.println(service.getAllReservations());
				break;
			case "5":
				service.deleteReserve(1000);
				System.out.println(service.getAllReservations() == null ? "null" : service.getAllReservations());
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
				break;
			case "2":
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
	
	public static void reserveGH() {
		//예약을 하는 곳
		GHServiceImpl service = GHServiceImpl.getInstance();
		System.out.println("날짜를 입력해주세요."); //나중에 년,월 받고 매진 안된 날짜 출력되는 형식으로 upgrade
		MyDate wantDate = new MyDate(sc.nextInt(), sc.nextInt(), sc.nextInt());
		System.out.println("원하는 서비스를 선택해주세요");
		System.out.println("1. 해당 날짜의 남아있는 방 출력\n"
				+"2. 원하는 인원수의 남아있는 방 출력\n"
				+"3. 예약하기\n"
				+"4. 종료 \n");
		boolean reserveFlag = true;
		String reserveNum = sc.next();
		while(reserveFlag) {
			switch(reserveNum) {
			case "1": 
				break;
			case "2": 
				break;
			case "3": 
				System.out.println("**사용자 정보를 입력해주세요**");
				System.out.println("예약자분 성함: ");
				String nameString = sc.next();
				System.out.println("예약자분 성별(여/남): ");
				String input = sc.next();
				char gender;

				if (input.equals("여")) {
				    gender = 'f';
				} else if (input.equals("남")) {
				    gender = 'm';
				} else {
				    gender = 'u'; // unknown 혹은 예외 처리
				}
				
				System.out.println("예약자분 전화번호: ");
				String phoneString = sc.next();
				
				System.out.println("**원하시는 방을 입력해주세요**");
				List<Room> roomList = service.getAllRooms();
				int i=1;
				//HashMap으로 수정 필요
				HashMap<Room,Integer> roomMapByDate = service.roomsByDate(wantDate);
				for(Room room : roomMapByDate.keySet()) {
					System.out.println(i+". "+room.getName()+"("+roomMapByDate.get(room)+"/"+roomList.get(i-1).getMaxCount()+")");
					i++;
				}
				
				Room reserveRoom = null;
				boolean validRoom = false;
				

				while (!validRoom) {
				    int roomChoice = sc.nextInt();

				    switch(roomChoice) {
				        case 1:
				            reserveRoom = roomList.get(0);
				            validRoom = true;
				            break;
				        case 2:
				            reserveRoom = roomList.get(1);
				            validRoom = true;
				            break;
				        case 3:
				            reserveRoom = roomList.get(2);
				            validRoom = true;
				            break;
				        case 4:
				            reserveRoom = roomList.get(3);
				            validRoom = true;
				            break;
				        default:
				            System.out.println("입력하신 번호의 방은 존재하지 않습니다. 다시 입력해주세요.");
				            break;
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
				        System.out.println("잘못된 입력입니다. 다시 입력해주세요. (네 또는 아니요)");
				    }
				}
				
				System.out.println("조식 신청이 완료되었습니다.");
				System.out.println("다음은 이벤트 목록입니다. 이벤트를 신청하고 싶으시다면 번호를 눌러주세요");
				
				
				service.addReservation(wantDate, new Customer("곽채연", 'f', "010-5582-1857"), new Room("1029방", 19000, "더블룸이고 화장실이 안에있습니다. 쾌적합니다.", 'f', 4, "침대2, 화장실1"), false, 2, 1000);
				System.out.println(service.getAllReservations());
				reserveFlag =false;
				break;
			case "4": 
				reserveFlag = false;
				break;
				default:
			}
		}
	}
	
}
