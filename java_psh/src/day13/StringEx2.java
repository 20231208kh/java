package day13;
import java.util.Scanner;
public class StringEx2 {

	/* 문장들을 입력받아 배열에 저장하고, 특정 단어가 들어가 있는 문장들을 출력하는
	 * 프로그램을 작성하세요;.
	 * 메뉴
	 * 1. 문장 추가
	 * 2. 검색
	 * 3. 종료
	 * 
	 */
	
	public static Scanner scan = new Scanner(System.in);
	public static String strArray [] = new String[10];
	public static int count = 0;
	/*
	 * 안녕하세요.
	 * 테스트
	 * 만나서 반갑습니다.
	 * 나는 홍길동입니다.
	 * 
	 * 나로 검색
	 * 
	 * 만나서 반갑습니다.
	 * 나는홍길동입니다.
	 */
	public static void main(String[] args) {
		int menu;
		do {
			menu();
			menu = scan.nextInt();
			runMenu(menu);
			
		}while(menu!=3);
		
	}
	
	public static void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertWord();
			break;
		case 2:
			searchWord();
			break;
		case 3:
			System.out.println("프로그램 종료");
			break;
		default:
			System.out.println("잘못된 메뉴 선택");
		}
		
		
	}
	
	public static void searchWord() {
		System.out.print("검색할 단어를 입력하세요 : ");
		scan.nextLine();
		String searchWord = scan.nextLine();
		System.out.println("----"+searchWord+"로 검색----");
		for(String tmp : strArray) {
			if (tmp != null&& tmp.contains(searchWord)) {
				System.out.println(tmp);
				
			}
		}
	}

	public static void insertWord() {
		scan.nextLine();
		String str= "";
		while(!str.equals("0")) {
			System.out.print("문장을 입력하세요(종료:0) :  ");
			str = scan.nextLine();
			strArray[count++] = str;
		}
		
	}

	public static void menu() {
		System.out.println("--메뉴--");
		System.out.println("1. 문장 추가");
		System.out.println("2. 검색");
		System.out.println("3. 종료");
		System.out.print("메뉴 선택 : ");
	}

}
