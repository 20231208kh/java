package day07;
import java.util.Scanner;
public class OddEvenGameEx1 {

	public static void main(String[] args) {
		/* 다음 기능을 가진 프로그램을 작성하세요, 메서드 이용
		 * --------------------
		 * 메뉴
		 * 1. 새 게임
		 * 2. 결과 조회
		 * 3. 프로그램 종료
		 * 메뉴 선택 : 1
		 * --------------------
		 * 선택 (홀:1, 짝:0) : 1
		 * 3 홀입니다.
		 * 성공 !
		 * -----------------
		 * 메뉴
		 * 1. 새 게임
		 * 2. 결과 조회
		 * 3. 프로그램 종료
		 * 메뉴 선택 : 2
		 * -----------------
		 * 결과 : 1승 0패
		 * -----------------
		 * 메뉴
		 * 1. 새 게임
		 * 2. 결과 조회
		 * 3. 프로그램 종료
		 * 메뉴 선택 : 3
		 * ---------------
		 * 프로그램 종료
		 */
		Scanner scan = new Scanner(System.in);
		int user;
		int num;
		int victory = 0;
		int lose = 0;
		do {
			menu();
			user = scan.nextInt();
			switch(user) {
			case 1:
				System.out.print("홀(1) / 짝(0) 을 고르시오. : ");
				num = scan.nextInt();
				if(newGame(num)) {
					victory ++;
				}else {
					lose ++;
				}
				break;
			case 2:
				printRecord(victory,lose);
				break;
			case 3:
				System.out.println("--------------");
				System.out.println("게임 종료! ");
				break;
			default:
				System.out.println("잘못된 메뉴 선택");
			}
			
		}while(user != 3);

	}
	
	public static void menu() {
		System.out.println("---------------");
		System.out.println("메뉴");
		System.out.println("1. 새 게임");
		System.out.println("2. 결과 조회");
		System.out.println("3. 프로그램 종료");
		System.out.print("메뉴 선택 : ");		
	}
	
	public static boolean newGame(int num) {
		int min = 1, max = 100;
		int r = (int)(Math.random()*(max - min +1) + min);
		
		if (r%2 ==0) {
			if(num==0) {
				System.out.println(r + "는 짝수, 성공");
				return true;
				
			}else if(num ==1) {
				System.out.println(r + "는 짝수, 실패");
				return false;
			}	
		}else if(r%2 !=0) {
			if(num==1) {
				System.out.println(r + "는 홀수, 성공");
				return true;
			}else if(num ==0) {
				System.out.println(r + "는 홀수, 실패");
				
				return false;
			}
		}
		return false;
	}
	
	public static void printRecord(int victory, int lose) {
		System.out.println("----------------");
		System.out.println("기록확인");
		System.out.println("결과 : "+ victory + "승 " +lose+"패");
	}

}
