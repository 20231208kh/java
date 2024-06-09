package day08;
import java.util.Scanner;
public class StudentProgram {
	/* 다음 기능을 가진 성적 관리 프로그램을 작성하세요.(클래스 활용)
	 *  - 1반의 성적을 관리
	 *  - 최대 5 번호순으로 관리
	 *  - 성적은 국어, 영어, 수학성적을 관리
	 */
	public static void main(String[] args) {
		//학년, 이름은 생략하고, 반은 1반으로 고정
		//번호는 각각 1번부터 5번으로 저장
		int user, user1;
		int arr[] = new int[5];
		Scanner scan = new Scanner(System.in);
		Student [] stds = new Student[5];
		// 향상된 for문을 이용하여 std를 다른 인스턴스로 교체하는건 안되지만, std의 멤버변수를 바꾸는건 가능
		/* for(Student std : stds){
		 * std.classNum=1; = stds[0~4].classNum = 1;
		 * std.num = count++ 
		 * }
		 */
		for (int i = 0 ; i<stds.length;i++) {
			stds[i] = new Student();
			stds[i].classNum = 1;
			stds[i].num = i+1;
		}
		// 반복문 : 프로그램 종료를 선택하지 않으면 반복
		do {
			//메뉴 출력
			menu();
			//메뉴 선택
			user = scan.nextInt();
			//선택한 메뉴에 따른 기능 실행
			switch(user) {
			case 1:
				updateScore(stds);
				break;
			//성적 조회	
			case 2: 
				viewInfo(stds);
				
				break;
			case 3:
				System.out.println("프로그램 종료");
				break;
			default:
				System.out.println("잘못된 메뉴 선택");
				
			}
		//프로그램 종료를 출력
	}while(user!= 3);
	

	}
	
	public static void updateScore(Student[]stds1) {
		menu2();
		Scanner scan = new Scanner(System.in);
		int subject = scan.nextInt();
		menu3();
		int num = scan.nextInt();
		System.out.print("성적 입력 : ");
		int score = scan.nextInt();
		for (Student std:stds1) {
			if(std.num != num) {
				continue;
			}
			//일치하는 학생이 있을때
			switch(subject) {
			case 1:
				std.setKor(score);
				return;
			case 2:
				std.setEng(score);
				return;
			case 3:
				std.setMath(score);
				return;
			}
		}
		
		System.out.println("과목 또는 학생 번호가 잘못됐습니다.");
	}

	public static void menu() {
		System.out.println("메뉴");
		System.out.println("1. 성적 수정");
		System.out.println("2. 성적 조회");
		System.out.println("3. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
	}
	
	public static void menu2() {
		System.out.println("--성적 수정--");
		System.out.println("1.국어");
		System.out.println("2.영어");
		System.out.println("3.수학");
		System.out.print("과목 선택");
	}
	
	public static void menu3() {
		System.out.println("--성적 수정--");
		System.out.print("학생 선택: ");
	}

	public static void viewInfo(Student stds1[]) {
		Scanner scan = new Scanner(System.in);
		System.out.println("--성적 조회--");
		System.out.println("1. 과목별 조회  ");
		System.out.println("2. 학생별 조회  ");
		System.out.print("선택 : ");
			
		int user = scan.nextInt();
		switch(user) {
		case 1:
				//학생 배열을 주고 조회할 과목을 입력받아 과목에 맞는 성적을 출력하라고 시킴(메서드)
				printScoreBySubject(stds1);
				break;
		case 2:	
				//학생 배열을 주고 학생 번호를 입력받아 번호에 맞는 학생 성적를 출력하라고 시킴(메서드)
				printScoreByNum(stds1);
				break;
		default:
				System.out.println("잘못된 선택");
			}
	}
	public static void printScoreByNum(Student stds1[]) {
			System.out.print("학생 번호를 입력하세요 : ");
			Scanner scan = new Scanner(System.in);
			int num = scan.nextInt();
			stds1[num-1].printScore();
	}
	public static void printScoreBySubject(Student stds1[]) {
			System.out.print("과목을 선택하세요(국어0/영어1/수학2) : ");
			Scanner scan = new Scanner(System.in);
			int num = scan.nextInt();
			for(Student stds : stds1) {
				switch(num) {
				case 0:
					System.out.println("번호 : "+stds.num+", 국어 : "+stds.kor);
					break;
				case 1:
					System.out.println("번호 : "+stds.num+", 영어 : "+stds.eng);
					break;
				case 2:
					System.out.println("번호 : "+stds.num+", 수학 : "+stds.math);
					break;
				default:
					System.out.println("잘못된 과목");
				}
			}
	}
}
