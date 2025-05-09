package com.java.project01.test;

import java.util.Scanner;

import com.java.project01.service.impl.GHServiceImpl;
import com.java.project01.util.MyDate;
import com.java.project01.vo.Customer;
import com.java.project01.vo.Reservation;
import com.java.project01.vo.Room;

public class GHServiceTest {
	static Scanner sc = new Scanner(System.in);
	static Room r1 = new Room("201호", 48000.0, "실내화장실,오션뷰", 'f', 4, "이층침대2, 책상1, 화장실1");
	static Room r2 = new Room("202호", 40000.0, "공용화장실", 'f', 8, "이층침대4, 책상2, 화장실x");
	static Room r3 = new Room("301호", 50000.0, "실내화장실,오션뷰", 'm', 4, "이층침대2, 책상1, 화장실1");
	static Room r4 = new Room("302호", 40000.0, "공용화장실,공용탁자", 'm', 8, "이층침대4, 책상2, 화장실x");

	public static void main(String[] args) {
		GHServiceImpl service = GHServiceImpl.getInstance();
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
				System.out.println("예약자분 성별: ");
				String genderString = sc.next();
				System.out.println("예약자분 전화번호: ");
				String phoneString = sc.next();
				
				System.out.println("**원하시는 방을 입력해주세요**");
				for(Room room : service.roomsByDate(wantDate)) {
					System.out.println(room);
				}
				
				Room room = null;
				switch(sc.nextInt()) {
				case 1:
					room = r1;
					break;
				case 2: 
					break; 
				case 3:
					break;
				case 4:
					break;
				default:
				}
				
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
