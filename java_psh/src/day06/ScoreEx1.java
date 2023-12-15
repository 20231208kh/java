package day06;
import java.util.*;
public class ScoreEx1 {

	public static void main(String[] args) {
		/* 다음 기능을 가진 성적 관리 프로그램을 작성하세요.
		 *  - 1반의 성적을 관리
		 *  - 최대 30명  
		 *  - 성적은 번호순으로 관리
		 *  - 성적은 국어, 영어, 수학성적을 관리
		 *-> 30개짜리 학생 배열, 국어, 영어, 수학 배열 생성
		 */	
		
			int [] students = new int[30];
			int [] kor = new int[30];
			int [] eng = new int[30];
			int [] math = new int[30];
			Scanner scan = new Scanner(System.in);
			
		/*   메뉴
		 *   1. 성적수정
		 *   2. 성적조회
		 *   3. 프로그램 종료
		 *   메뉴 선택 : 
		 *   
		 *   -> while문 이용해서 메뉴 구현, 안에다가 switch 혹은 if로 각각의 메뉴로 들어가기
		 */   
			while(true) {
				System.out.println("메뉴");
				System.out.println("1. 성적 수정");
				System.out.println("2. 성적 조회");
				System.out.println("3. 프로그램 종료");
				System.out.print("메뉴 선택 : ");
				int user1 = scan.nextInt();
				System.out.println("=======================");
				
				//성적 수정 메뉴
				if (user1 == 1) {
					System.out.println("--성적수정--");
					System.out.println("1. 국어");
					System.out.println("2. 영어");
					System.out.println("3. 수학");
					System.out.print("과목 선택 : ");
					int user2 = scan.nextInt();
					System.out.println("=======================");
					//국어
					if (user2 ==1) {
						System.out.println("--국어 성적 수정--");
						System.out.print("학생 선택: ");
						int user3 = scan.nextInt();
						System.out.print("성적 입력: ");
						int korScore = scan.nextInt();
						kor[user3-1] = korScore;
						System.out.println("=======================");
					} //영어
					else if (user2 ==2) {
						System.out.println("--영어 성적 수정--");
						System.out.print("학생 선택: ");
						int user3 = scan.nextInt();
						System.out.print("성적 입력: ");
						int engScore = scan.nextInt();
						eng[user3-1] = engScore;
						System.out.println("=======================");
					} //수학
					else if (user2 ==3) {
						System.out.println("--수학 성적 수정--");
						System.out.println("학생 선택: ");
						int user3 = scan.nextInt();
						System.out.print("성적 입력: ");
						int mathScore = scan.nextInt();
						math[user3-1] = mathScore;
						System.out.println("=======================");
					}
					
				
				
				}//성적 조회
				else if (user1 == 2) {
					System.out.println("--성적 조회--");
					System.out.println("1. 과목별 조회");
					System.out.println("2. 학생별 조회");
					System.out.print("선택: ");
					int user4 = scan.nextInt();
					System.out.println("=======================");
					//과목별 조회
					if (user4 == 1) {
						System.out.println("1. 국어");
						System.out.println("2. 영어");
						System.out.println("3. 수학");
						System.out.print("과목 선택: ");
						int user5 = scan.nextInt();
						System.out.println("=======================");
						/* int []selectedSubject;
						 * switch (selectedSubject){
						 * case 1: selectedSubject=kor[]
						 * case 2: selectedSubject=eng[]
						 * case 3: selectedSubject=math[]
						 * }
						 * 이렇게 줄이고
						 * for(int i=0; i<selectedSubject.length;i++){
						 * 	   System.out.println((i+1)+"번 : "+ selectedSubject[i])
						 * }
						 * 이렇게 for문 중복 제거하면서 한줄로 출력부 만들 수 있음
						 */
						
						switch(user5) {
						case 1://과목별 - 국어
							System.out.println("--국어성적 조회--");
							for(int i=0; i<kor.length;i++) {
								students[i] = i+1;
								System.out.println(students[i] + "번 : " + kor[i]);
							}
							System.out.println("=======================");
							break;
						case 2://과목별 - 영어
							System.out.println("--영어성적 조회--");
							for(int i=0; i<eng.length;i++) {
								students[i] = i+1;
								System.out.println(students[i] + "번 : " + eng[i]);
							}
							System.out.println("=======================");
							break;
						case 3://과목별 - 수학
							System.out.println("--수학성적 조회--");
							for(int i=0; i<math.length;i++) {
								students[i] = i+1;
								System.out.println(students[i] + "번 : " + math[i]);
							}
							System.out.println("=======================");
							break;
						}

					}//학생별 조회
					else if(user4 ==2) {
						System.out.print("학생 선택 : ");
						int user6 = scan.nextInt();
						System.out.println("선택된 학생 : " +(students[user6]+1));
						System.out.println("국어 : " + kor[user6-1]);
						System.out.println("영어 : " + eng[user6-1]);
						System.out.println("수어 : " + math[user6-1]);
						System.out.println("=======================");
					}
					
				}//프로그램 종료
				else if (user1 == 3) {
					break;
				}
				else {
					System.out.println("잘못된 입력");
					System.out.println("=======================");
					continue;
				}
			}
		
		
		
		
		 /*   ~~성적수정~~
		 *   1. 국어
		 *   2. 영어
		 *   3. 수학
		 *   과목 선택 :
		 *   
		 *   -> 각 메뉴마다 국어, 영어, 수학 배열과 연동시키기
		 *   
		 *   ~~과목 선택~~
		 *   학생 선택 : 번호를 선택
		 *   성적 입력 : 100
		 *   
		 *   ~~성적조회~~
		 *   1. 과목별 조회
		 *   2. 학생별 조회
		 *   선택 : 
		 *   
		 *   ~~과목별 조회~~
		 *   1. 국어
		 *   2. 영어
		 *   3. 수학
		 *   과목 선택 :
		 *   1번 : 0점
		 *   2번 : 0점
		 *   3번 : 100점
		 *   ...
		 *   30번 : 0점
		 *   
		 *   ~~학생별 조회~~
		 *   학생 선택 :
		 *   국어:
		 *   영어:
		 *   수학:
		 *  
		 */
		
	

	}

}
