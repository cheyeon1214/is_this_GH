package com.java.project01.test;

import java.util.Scanner;

public class GHServiceTest {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
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
				menuInfo();
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
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("숫자를 잘못 입력하셨습니다. 다시 입력하십시오.");
			}
		}
		
		sc.close();
	}

	private static void menuInfo() {

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
}
