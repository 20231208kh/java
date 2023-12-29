package day15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MapEx2 {
	public static Scanner scan = new Scanner(System.in);
	public static Map<String,String> signIn = new HashMap<String,String>();
	public static List<String> userInfo = new ArrayList<String>();
	public static void main(String[] args) {
		/* 회원을 관리하는 프로그램을 작성하세요.
		 * 메뉴
		 * 1. 회원가입
		 * -아이디와 비번만입력
		 * -중복확인(containsKey)
		 * 2. 회원검색
		 * -아이디를 입력해서 회원 정보를 조회
		 * 
		 */
		int menu = 0 ;
		do {
			menu();
			try {
				menu = scan.nextInt();
				runMenu(menu);
			}catch(InputMismatchException e) {
				System.out.println("잘못된 입력");
				scan.nextLine();
			}
		}while(menu!=3);

	}
	public static void runMenu(int menu) {
		switch(menu) {
		case 1:
			signIn();
			break;
		case 2:
			searchInfo();
			break;
		case 3:
			System.out.println("프로그램 종료");
			break;
		default:
			throw new InputMismatchException();
		}
		
	}
	public static void searchInfo() {
		System.out.print("검색할 ID 입력 : ");
		String id = scan.next();
		Set<String> keySet = signIn.keySet();
		for(String tmpString : keySet) {
			if(tmpString.equals(id)) {
				String value = signIn.get(tmpString);
				System.out.println("---- "+tmpString+"정보 ----");
				System.out.println("pw : "+value);
				return;
			}
		}
		System.out.println("검색할 ID가 없습니다.");
	}
		
	public static void signIn() {
		System.out.print("ID 입력 : ");
		String id = scan.next();
		if (signIn.containsKey(id)) {
			System.out.println("이미 가입된 ID 입니다.");
			return;
		}
		System.out.print("PW 입력 : ");
		String pw = scan.next();
		signIn.put(id, pw);

		
	}
	public static void menu() {
		System.out.println("메뉴");
		System.out.println("1. 회원 가입");
		System.out.println("2. 회원 검색");
		System.out.println("3. 종료");
		System.out.print("메뉴 선택 : ");
		
	}

}
