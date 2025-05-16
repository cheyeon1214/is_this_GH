package com.java.project01.test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import com.java.project01.exception.InvalidInputDataException;
import com.java.project01.exception.RecordNotFoundException;
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
		service.addEvent(new FishingEvent("Fishing", new MyTime(7, 10, 00), new MyTime(10, 30, 00), false, "게하 앞 시내"));
		service.addEvent(new PartyEvent("Party", new MyTime(6, 30, 00), new MyTime(11, 50, 00), "소주, 맥주"));

		// 5월 13일 - 여성 2, 남성 1
		service.addReservation(new MyDate(2025, 5, 13), new Customer("김민지", 'f', "010-1234-5678"),
				service.getAllRooms().get(0), true, 4, 1234, null);
		service.addReservation(new MyDate(2025, 5, 13), new Customer("정예린", 'f', "010-5678-9012"),
				service.getAllRooms().get(1), false, 8, 2345, service.getAllEvents().get(1));
		service.addReservation(new MyDate(2025, 5, 13), new Customer("이준호", 'm', "010-2345-6789"),
				service.getAllRooms().get(2), true, 4, 3456, service.getAllEvents().get(2));

		// 5월 14일 - 여성 2, 남성 1
		service.addReservation(new MyDate(2025, 5, 14), new Customer("박서연", 'f', "010-3456-7890"),
				service.getAllRooms().get(0), true, 4, 4567, service.getAllEvents().get(0));
		service.addReservation(new MyDate(2025, 5, 14), new Customer("윤서아", 'f', "010-7890-1234"),
				service.getAllRooms().get(1), false, 8, 5678, service.getAllEvents().get(1));
		service.addReservation(new MyDate(2025, 5, 14), new Customer("최현우", 'm', "010-4567-8901"),
				service.getAllRooms().get(2), true, 4, 6789, service.getAllEvents().get(2));
		service.addReservation(new MyDate(2025, 5, 14), new Customer("최진우", 'm', "010-7767-8901"),
				service.getAllRooms().get(3), true, 8, 6899, service.getAllEvents().get(1));
		// 5월 15일 - 여성 2, 남성 1
		service.addReservation(new MyDate(2025, 5, 15), new Customer("배지은", 'f', "010-9012-3456"),
				service.getAllRooms().get(0), true, 2, 7890, service.getAllEvents().get(0));
		service.addReservation(new MyDate(2025, 5, 15), new Customer("서하윤", 'f', "010-1122-3344"),
				service.getAllRooms().get(1), false, 1, 8901, service.getAllEvents().get(1));
		service.addReservation(new MyDate(2025, 5, 15), new Customer("장우진", 'm', "010-8901-2345"),
				service.getAllRooms().get(2), true, 3, 9012, service.getAllEvents().get(2));

		service.addReservation(new MyDate(2025, 5, 16), new Customer("곽채연", 'f', "010-5582-1857"),
				service.getAllRooms().get(0), false, 2, 1923, service.getAllEvents().get(0));
		service.addReservation(new MyDate(2025, 5, 17), new Customer("곽채언", 'f', "010-5581-8857"),
				service.getAllRooms().get(1), true, 2, 5832, service.getAllEvents().get(2));
		service.addReservation(new MyDate(2025, 5, 18), new Customer("곽채은", 'f', "010-5822-1117"),
				service.getAllRooms().get(0), false, 2, 4110, service.getAllEvents().get(1));
		service.addReservation(new MyDate(2025, 5, 16), new Customer("이지은", 'f', "010-2211-3366"),
				service.getAllRooms().get(1), true, 2, 7234, service.getAllEvents().get(0));
		service.addReservation(new MyDate(2025, 5, 17), new Customer("이지연", 'f', "010-2218-8471"),
				service.getAllRooms().get(1), false, 2, 8541, service.getAllEvents().get(1));
		service.addReservation(new MyDate(2025, 5, 18), new Customer("이지아", 'f', "010-2819-0172"),
				service.getAllRooms().get(0), true, 2, 3790, service.getAllEvents().get(2));
		service.addReservation(new MyDate(2025, 5, 16), new Customer("김민서", 'm', "010-1123-2918"),
				service.getAllRooms().get(2), false, 2, 6481, service.getAllEvents().get(1));
		service.addReservation(new MyDate(2025, 5, 17), new Customer("김민상", 'm', "010-1234-5678"),
				service.getAllRooms().get(3), true, 2, 9012, service.getAllEvents().get(0));
		service.addReservation(new MyDate(2025, 5, 18), new Customer("김민승", 'm', "010-2819-9918"),
				service.getAllRooms().get(2), true, 2, 7345, service.getAllEvents().get(2));

		boolean runFlag = true;
		while (runFlag) {
			System.out.println("숫자를 눌러 메뉴를 입력하세요\r\n" + "1. 어떤 게스트하우스인가요?\r\n" + "2. 예약을 하고 싶어요\r\n"
					+ "3. 예약을 확인하고 싶어요\r\n" + "4. 예약을 수정하고 싶어요\r\n" + "5. 예약을 삭제하고 싶어요\r\n" + "6. 종료");

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
				updateReserveGH();
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
		
		service.printReservation();

		sc.close();
	}

	private static void searchGH() {

		boolean runFlag = true;
		while (runFlag) {
			System.out.println("원하는 정보를 입력하세요\r\n" + "1. 게스트하우스의 모든 방 소개\r\n" + "2. 제일 인기 많은 방\r\n" + "3. 예약이 마감된 날\r\n"
					+ "4. 모든 이벤트 소개\r\n" + "5. 조식 메뉴 소개\r\n" + "6. 뒤로가기");

			String menuStr = sc.next();

			switch (menuStr) {
			case "1":
				printAllRooms();
				break;
			case "2":
				printMostPopular();
				break;
			case "3":
				printSoldOutDays();
				break;
			case "4":
				printAllEvents();
				break;
			case "5":
				printBreakfast();
				break;
			case "6":
				runFlag = false;
				return;
			default:
				System.out.println("잘못된 숫자를 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}

	public static void printAllRooms() {
		GHServiceImpl service = GHServiceImpl.getInstance();
		System.out.println("**모든 방 정보**");
		
		/* 기존 코드
		 * for (Room r : service.getAllRooms()) 
		 * 	System.out.println(r);
		 */
		
		// 모든 방 객체를 출력하는데 방의 이름을 오름차순으로 정렬하여 출력한다.
		service.getAllRooms().stream()
		.sorted(Comparator.comparing(Room::getName))
		.forEach(room -> System.out.println(room));
	}

	public static void printMostPopular() {
		GHServiceImpl service = GHServiceImpl.getInstance();
		System.out.println("제일 인기있는 방을 소개합니다!");

		try {
			System.out.println(service.mostPopularRoom());
		} catch (NullPointerException e) {
			System.out.println("인기있는 방을 찾을 수 없습니다. :: " + e.getMessage());
		}
	}

	public static void printSoldOutDays() {
		GHServiceImpl service = GHServiceImpl.getInstance();
		System.out.println("예약이 마감된 날짜입니다.");

		if (service.soldOutDate().size() == 0) 
			System.out.println("예약이 마감된 날짜가 없습니다.");
		else
			System.out.println(service.soldOutDate());
	}

	public static void printAllEvents() {
		GHServiceImpl service = GHServiceImpl.getInstance();
		System.out.println("모든 이벤트 목록입니다");
		for (Event event : service.getAllEvents()) {
			System.out.println(event);
		}
	}

	public static void printBreakfast() {
		GHServiceImpl service = GHServiceImpl.getInstance();

		try {
			System.out.println(service.getBreakfastInfo());
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public static void reserveGH() {
		// 예약을 하는 곳
		GHServiceImpl service = GHServiceImpl.getInstance();
		System.out.println("날짜를 입력해주세요.");
		MyDate wantDate = null;
		try {
			wantDate = new MyDate(sc.nextInt(), sc.nextInt(), sc.nextInt());
		} catch (Exception e) {
			System.out.println("날짜는 숫자만 입력해야 합니다.");
			sc.nextLine();
			return;
		}
		LocalDate nowDate = LocalDate.now();

		// 예약 날짜가 오늘보다 앞인 경우
		if (!wantDate.isCorrectDate() || wantDate.getYear() < nowDate.getYear()
				|| wantDate.getMonth() < nowDate.getMonthValue() || wantDate.getDay() < nowDate.getDayOfMonth()) {
			System.out.println("날짜가 잘못 입력되었습니다." + "오늘은 " + nowDate.getYear() + "년 " + nowDate.getMonthValue() + "월 "
					+ nowDate.getDayOfMonth() + "일 입니다.");
			return;
		}
		
		if (service.soldOutDate().contains(wantDate)) {
			System.out.println("해당 일자는 예약이 마감되었습니다.");
			return;
		}

		boolean reserveFlag = true;
		while (reserveFlag) {
			System.out.println("원하는 서비스를 선택해주세요");
			System.out.println("1. 해당 날짜의 남아있는 방 출력\n" + "2. 원하는 인원수의 남아있는 방 출력\n" + "3. 예약하기\n" + "4. 뒤로가기 \n");
			String reserveNum = sc.next();

			switch (reserveNum) {
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
		System.out.println(wantDate.getMonth() + "월 " + wantDate.getDay() + "일 기준, 방 예약 현황입니다.");
		
		List<Room> roomList = service.getAllRooms();
		
		// 기존 코드
		
		int i = 1;
		HashMap<Room, Integer> roomMapByDate = service.roomsByDate(wantDate);
		for (Room r : roomList) {
			System.out.println(i + ". " + r.getName() + "(" + roomMapByDate.get(r) + "/" + r.getMaxCount() +
					")"
					+ (roomMapByDate.get(r) == r.getMaxCount() ? " - 마감" : ""));
			i++;
		}
		
		
		
		// 이벤트 목록을 스트림으로 변환하고 이벤트에 참여하는 인원수를 기준으로 가장 적은 순으로 정렬하여 출력하도록 한다.
//		i =1;
//		roomList.stream()
//				.sorted(Comparator.comparingInt(room-> roomMapByDate.get(room)))
//				.collect(Collectors.groupingBy(
//						(room) -> room, Collectors.summingInt(n -> n++)
//				))
//				.forEach((room, j) -> { 
//					System.out.println(j + ". " + room.getName() + "(" + roomMapByDate.get(room) + "/" + room.getMaxCount() + ")"
//				+ (roomMapByDate.get(room) == room.getMaxCount() ? " - 마감" : ""));
//				});
	}

	private static void printReserveByCount(MyDate wantDate) {
		GHServiceImpl service = GHServiceImpl.getInstance();
		System.out.println("예약을 원하시는 인원 수를 입력해주세요:");
		int count = sc.nextInt();

		System.out.println(wantDate.getMonth() + "월 " + wantDate.getDay() + "일 기준, " + count + "인실 예약 가능한 방 목록입니다.");
		List<Room> roomList = service.getAllRooms();
		int i = 1;
		HashMap<Room, Integer> roomMapByDate = service.roomsByDate(wantDate);

		for (Room r : roomList) {
			if (r.getMaxCount() == count)
				System.out.println(i + ". " + r.getName() + "(" + roomMapByDate.get(r) + "/" + r.getMaxCount() + ")"
						+ (roomMapByDate.get(r) == r.getMaxCount() ? " - 마감" : ""));
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

		while (true) {
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

		System.out.println(input + "성 전용 방 리스트입니다.");
		List<Room> roomList = service.getAllRooms().stream().filter(m -> (m.getGender() == gender)).toList();

		int i = 1;
		HashMap<Room, Integer> roomMapByDate = service.roomsByDate(wantDate);

		for (Room r : roomList) {
			if (r.getGender() == gender) {
				System.out.println(i + ". " + r.getName() + "(" + roomMapByDate.get(r) + "/" + r.getMaxCount() + ")"
						+ (roomMapByDate.get(r) == r.getMaxCount() ? " - 마감" : ""));
				i++;
			}
		}

		System.out.println("예약을 원하지 않으시면 -1을 입력하십시오.");

		Room reserveRoom = null;
		boolean validRoom = false;

		while (!validRoom) {
			int roomChoice = sc.nextInt();

			// 뒤로가기
			if (roomChoice == -1) {
				System.out.println("예약 선택을 취소합니다.");
				return;
			}

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
		while (true) {
			System.out.println("다음은 이벤트 신청입니다. 이벤트를 신청하시겠습니까?(네/아니요)");
			String booleanEvent = sc.next();
			if (booleanEvent.equals("네")) {
				System.out.println("원하시는 이벤트 번호를 입력해주세요.");
				List<Event> eventList = service.getAllEvents();
				int j = 1;
				HashMap<Event, Integer> eventMapByDate = service.eventsByDate(wantDate);

				for (Event e : eventList) {
					System.out.println(j + ". " + e.getEventType() + "(" + eventMapByDate.get(e) + "/"
							+ GHServiceImpl.EVENT_MAX_COUNT + ")");
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

				System.out.println(reserveEvent.getEventType() + "이벤트 예약 정보가 저장되었습니다.");
				break;
			} else if (booleanEvent.equals("아니요")) {
				break;
			} else {
				System.out.println("다시 입력해주세요");
			}
		}

		// 기능으로 추출하는게 어떤지.
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
		service.addReservation(wantDate, new Customer(nameString, gender, phoneString), reserveRoom, isBreakfast,
				countPeople, newCode, reserveEvent);

		System.out.println("예약 되었습니다. 예약 번호는" + newCode + "입니다.\n");

		System.out.println(service.getAllReservations());

	}

	public static void checkReserveGH() {
		GHServiceImpl service = GHServiceImpl.getInstance();
		System.out.println("예약 번호를 입력해주세요");

		int reserveCode = sc.nextInt();

		try {
			Reservation r = service.checkMyReserve(reserveCode);
			System.out.println("***예약 정보***"+ r);
		} catch (RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void updateReserveGH() {
		GHServiceImpl service = GHServiceImpl.getInstance();
		System.out.println("예약 번호를 입력해주세요");
		int reserveCode = sc.nextInt();
		Reservation originRes = null;
		try {
			originRes = service.checkMyReserve(reserveCode);
		} catch (RecordNotFoundException e) {
			System.out.println(e.getMessage());
			return;
		}
		Customer tempCustomer = originRes.getCustomer();
		boolean tempIsBreakfast = originRes.getIsBreakfast();
		Event tempEvent = originRes.getEvent();

		boolean runUpdateFlag = true;
		while (runUpdateFlag) {
			System.out.println("수정을 원하는 정보의 번호를 입력하세요.");
			System.out.println("1. 예약자의 정보\n" + "2. 조식 여부\n" + "3. 이벤트 여부\n" + "4. 돌아가기");
			String numString = sc.next();

			switch (numString) {
			case "1":
				tempCustomer = updateCustomer(tempCustomer);
				break;
			case "2":
				tempIsBreakfast = isBreakfastOption(tempIsBreakfast);
				break;
			case "3":
				tempEvent = updateEvent(originRes);
				break;
			case "4":
				runUpdateFlag = false;
				break;
			default:
				System.out.println("다시 입력해주세요.");
			}
		}
		try {
			service.updateReserve(reserveCode, new Reservation(reserveCode, originRes.getRoom(), originRes.getDate(),
					tempCustomer, tempIsBreakfast, originRes.getPeople(), tempEvent));
		} catch (RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	private static Customer updateCustomer(Customer changeCustomer) {
		System.out.println("예약자 정보를 다시 입력받습니다.");
		System.out.println("이름을 입력해 주세요: ");
		String tempName = sc.next();
		System.out.println("전화번호를 입력해 주세요: ");
		String phoneString = sc.next();
		return new Customer(tempName, changeCustomer.getGender(), phoneString);
	}
	
	private static boolean isBreakfastOption(boolean currentIsBreakfast) {
		while (true) {
			System.out.println("회원님의 조식 현황입니다.");
			System.out.println("조식 : " + (currentIsBreakfast ? "신청" : "미신청"));

			System.out.println("변경하시겠습니까?(네/아니요) ");
			String answer = sc.next();

			if (answer.equals("네")) {
				return !currentIsBreakfast;
			} else if (answer.equals("아니요")) {
				return currentIsBreakfast;
			} else {
				System.out.println("잘못된 값을 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}

	private static Event updateEvent(Reservation originRes) {
		GHServiceImpl service = GHServiceImpl.getInstance();
		
		// 고객이 기존 선택한 이벤트
		Event currentEvent = originRes.getEvent();
		// 고객이 선택한 이벤트 날짜
		MyDate date = originRes.getDate();
		// 이벤트 참여 인원
		int people = originRes.getPeople();
		
		while (true) {
			System.out.println("회원님의 이벤트 정보입니다.");
			try {
				System.out.println("현재 이벤트 : " + currentEvent.getEventType());
			} catch (Exception e) {
				System.out.println("예약한 이벤트가 없습니다.");
			}
			System.out.println("바꾸시겠습니까?(네/아니요)");
			
			String answer2 = sc.next();
			
			if (answer2.equals("네")) {
				System.out.println("원하시는 이벤트 번호를 입력해주세요.");
				List<Event> eventList = service.getAllEvents();
				int j = 1;
				HashMap<Event, Integer> eventMapByDate = service.eventsByDate(date);

				for (Event e : eventList) {
					System.out.println(j + ". " + e.getEventType() + "(" + eventMapByDate.get(e) + "/"
							+ GHServiceImpl.EVENT_MAX_COUNT + ")");
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

					if (current_Count + people > GHServiceImpl.EVENT_MAX_COUNT) {
						System.out.println("이벤트 인원이 가득 찼습니다. 다시 선택해주세요.");
					} else {
						System.out.println(selectedEvent.getEventType() + " 이벤트로 예약이 변경되었습니다.");
						return selectedEvent;
					}
				}
			} else if (answer2.equals("아니요")) {
				return currentEvent;
			} else {
				System.out.println("잘못된 값을 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}

	public static void deleteReserveGH() {
		GHServiceImpl service = GHServiceImpl.getInstance();   
		System.out.println("예약 번호를 입력해주세요");
		int reserveCode = sc.nextInt();

		try {
			System.out.println("회원님의 에약 정보입니다.");
			System.out.println(service.checkMyReserve(reserveCode));

			System.out.println("정말 예약을 취소하시겠습니까?(네/아니요)");
			String confirm = sc.next();

			if (confirm.equals("아니요")) {
				System.out.println("이전 메뉴로 돌아갑니다.");
				return;
			} else if (!confirm.equals("네")) {
				System.out.println("잘못된 입력입니다. 예약을 취소합니다.");
				return;
			}

			service.deleteReserve(reserveCode);
			System.out.println("( " + reserveCode + " )의 예약을 삭제하였습니다.");
		} catch (RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}
