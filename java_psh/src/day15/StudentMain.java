package day15;

public class StudentMain {

	/*
	 * 학생 국어, 영어, 수학 성적 관리 프로그램을 작성하세요.
	 * -Program 인터페이스를 생성하여 활용
	 *  -void run()
	 *  -void printMenu()
	 *  -void runMenu()
	 *  
	 *  -program 인터페이스를 구현한 클래스 StudentProgram을 생성하여 활용
	 *  학성 정보를 Student 클래스를 생성하여 할용
	 *  -학년, 반, 번호 이름, 국어 ,영어, 수학
	 *  리스트를 활용
	 *  contains, indexOf
	 *  기능
	 *  1.학생관리
	 *  -학생 추가
	 *  -학생 수정
	 *  -학생 삭제
	 *  2. 성적 관리
	 *  -성적 추가
	 *  -성적 수정
	 *  -성적 삭제
	 *  3. 조회
	 *  3-1학생조회
	 *  -전체 조회
	 *  -학년 조회
	 *  -반 조회
	 *  -학생 조회(학년,반,번호 일치)
	 *  3-2 성적 조회
	 *  -국어
	 *  -영어
	 *  -수학
	 */
	
	
	
	public static void main(String[] args) {
		
		Program p = new StudentProgram();
		p.run();
	}

}
