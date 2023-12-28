package myProject01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountBookMain {
	/*
	 * 용돈기입장
	 * 사용할 컬렉션 : 리스트
	 * 사용할 메서드 : toString, MessageFormat, Date, Calender, 예외처리
	 * 
	 * 
	 * 메뉴
	 * 1. 지출 기록
	 * 1-1 . 지출 액수 :
	 * 1-2 . 지출 용도 :
	 * 
	 * 2. 지출 내역 조회
	 * 2-1. 전체 조회
	 * --병원--
	 * 지출액 :
	 * 날짜 : 
	 * --쇼핑--
	 * 지출액 :
	 * 날짜 :
	 * 2-2. 지출 용도 조회
	 * 2-2-1 : 용도 검색
	 * ex) 용도 : 병원
	 * --병원--
	 * 지출액 : 20,000원 
	 * 날짜 : 2023-12-28
	 * 3. 사용자 정보(이름,잔고)
	 * 4. 입금(액수,출처)
	 * 5. 종료
	 */
	public static Scanner scan = new Scanner(System.in);
	public static List<AccountBookClass> list = new ArrayList<AccountBookClass>();
	public static void main(String[] args) {
		int menu;
		
		do {
			menu();
			menu = scan.nextInt();
			runMenu(menu);
			
		}while(menu!=5);

	}
	
	public static void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertWithdraw();
			break;
		case 2:
			searchWithdraw();
			break;
		case 3:
			searchUserInfo();
			break;
		case 4:
			deposit();
			break;
		case 5:
			System.out.println("프로그램 종료");
			break;
		default :
			System.out.println("잘못된 선택");
		}
	}

	public static void deposit() {
		
		
	}

	public static void searchUserInfo() {
		
		
	}

	public static void searchWithdraw() {
		
		
	}

	public static void insertWithdraw() {
		
		
	}
	
	public static void menu() {
		System.out.println("--메뉴--");
		System.out.println("1. 지출내역 기록");
		System.out.println("2. 지출내역 조회");
		System.out.println("3. 사용자 정보");
		System.out.println("4. 입금");
		System.out.println("5. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
	}

}
