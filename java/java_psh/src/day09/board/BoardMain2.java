package day09.board;
import java.util.Scanner;

import day08.Student;
public class BoardMain2 {
	/*게시판에서 게시글 관리를 위한 콘솔 프로그램을 작성하세요.
	 * - 제한사항 정리
	 * 로그인 구현 x, 아이디만 입력받음
	 * 게시판은 1개
	 * 게시글 제목과 내용은 한 줄만 가능
	 * 작성일을 입력
	 * 
	 * 1. 필요한 기능을 정리해서 메뉴로 출력
	 * 메뉴
	 * 1. 게시글 목록 조회
	 * 2. 게시글 등록
	 * 3. 프로그램 종료
	 * 메뉴 선택 1
	 * 게시글 목록
	 * 	2. 가입인사 2023-12-20 asd 1
	 * 	1. 공지 2023 - 12- 19 admin 3
	 * 메뉴
	 * 	1. 게시글 상세 조회
	 * 	2. 게시글 수정
	 * 	3. 게시글 삭제
	 * 	4. 뒤로가기
	 * 	메뉴 선택 : 1
	 * 	2. 가입인사 2023-12-20 asd 1
	 * 	1. 공지 2023 - 12- 19 admin 3
	 * 	조회할 게시글 번호 : 2
	 * 	번호 : 2
	 *  제목 : 가입인사
	 *  내용 : 안녕하세요.
	 *  작성일 : 2023-12-20
	 *  작성자 : asd
	 *  조회수 : 2
	 * 메뉴
	 * 	1. 게시글 상세조회
	 * 	2. 게시글 수정
	 * 	3. 게시글 삭제
	 * 	4. 뒤로가기
	 * 	메뉴 선택 : 2
	 * 	수정할 게시글 번호 : 2
	 * 	제목 : 가입인사입니다.
	 * 	내용 : 만나서 반갑습니다.
	 * 	수정이 완료됐습니다.
	 * 게시글 목록
	 *	2. 가입인사 2023-12-20 asd 1
	 * 	1. 공지 2023 - 12- 19 admin 3 
	 * 메뉴
	 * 	1. 게시글 상세조회
	 * 	2. 게시글 수정
	 * 	3. 게시글 삭제
	 * 	4. 뒤로가기
	 * 	메뉴 선택 : 3
	 * 	삭정할 게시글 번호 : 2
	 * 	삭제가 완료됐습니다.
	 * 	1. 공지 2023 - 12- 19 admin 3 

	 * 
	 * 2. 기능을 구현
	 */ 
	private static Scanner scan = new Scanner(System.in);
	private static Board [] boardList = new Board[5]; //게시글 목록
	private static int  boardNum = 1; //추가될 게시글 번호
	private static int count = 0; // 현재 등록될 게시글 개수
	
	
	public static void main(String[] args) {
	// 반복문
		int menu;
		do {
			printmenu();
			menu = scan.nextInt();
			//선택한 기능 실행
			runMenu(menu);
		}while(menu!=3);

	}
	/**
	 * menu가 주어지면 menu에 맞는 기능을 실행하는 메서드
	 * @param menu가 실행할 메뉴의 번호
	 */
	private static void runMenu(int menu) {
	
		switch(menu) {
		case 1:
			   runBoard();
			break;
		case 2:
				insertBoard();
			break;
		case 3:
			System.out.println("프로그램 종료");
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
		
	}
	

	/**게시글 목록 조회시 나타나는 서브메뉴를 출력하는 메서드
	 * @param
	 */
	private static void runBoard() {
		boardInfo();
		printmenu2();
		int user = scan.nextInt();
		switch(user) {
		case 1:
			boardInfo();
			detailInfo();
			break;
		case 2:
			boardInfo();
			updatePost();
			break;
		case 3:
			boardInfo();
			deletePost();
			break;
		case 4:System.out.println("이전으로 돌아갑니다. ");
			break;
			
		default:System.out.println("잘못된 메뉴입니다.");
				
		}
		
	}
	private static void deletePost() {
		System.out.println("삭제할 게시글 번호를 선택하세요 : ");
		int user1= scan.nextInt();
		
		Board tmp1 [] = new Board[boardList.length-1];
		
		//System.arraycopy(기존배열을,0번인덱스부터,신규배열에,0번인덱스부터,유저가 입력한 값 만큼복사)
		System.arraycopy(boardList, 0, tmp1, 0, user1-1);
		//System.arraycopy(기존배열을,user1부터,신규배열에,user1-1부터,길이에서 - 유저가 입력한 값 만큼복사)
		System.arraycopy(boardList, user1, tmp1, user1-1, boardList.length-user1);
		boardList = tmp1;
		--count;

	}
	private static void updatePost() {
		System.out.println("수정할 게시글 번호를 선택하세요 : ");
		int user1= scan.nextInt();
		for (int i=0;i<count;i++)
			 if(user1==boardList[i].getNum()) {
					scan.nextLine();
					System.out.print("수정할 제목을 작성하세요 : ");
					String topic = scan.nextLine();
					System.out.print("수정할 내용을 작성하세요 : ");
					String content = scan.nextLine();
					boardList[i].update(topic, content);
					return;
			 }
		System.out.println("일치하는 게시글이 없습니다.");
	}
	
	private static void detailInfo() {
		System.out.print("조회할 게시글 번호를 선택하세요 : ");
		int user1= scan.nextInt();
		//등록된 게시글 개수 만큼만 검사
		for (int i=0;i<count;i++)
			//글의 번호와 유저의 번호가 같다면
			 if(user1==boardList[i].getNum()) {
				 //조회수 상승
				 boardList[i].upView();
				 //출력
				 boardList[i].checkPost();
				 return;
			 }
		System.out.println("일치하는 게시글이 없습니다.");

	}
	private static void boardInfo() {
		System.out.println("--------------");
		for (int i=count-1; i>=0; i--){
			 boardList[i].printInfo();}
			}
	
		
	
	private static void insertBoard() {


		System.out.print("id를 입력하세요 : ");
		String id = scan.next();
		scan.nextLine();//입력 버퍼에 남아있는 엔터 처리
		System.out.print("제목을 입력하세요 : ");
		String subject = scan.nextLine();
		
		System.out.print("내용을 입력하세요 : ");
		String post = scan.nextLine();
		
		System.out.print("날짜를 입력하세요 : ");
		String date = scan.next();
		
		Board board = new Board(boardNum, id, subject, post, date);
		//추가될 게시글 번호를 1 증가
		++boardNum;
		//생성된 인스턴스를 배열에 저장
		boardList[count] = board;
		//저장된 개수를 1 증가
		++count;	
		//배열의 크기를 늘릴필요가 없으면 종료
		if (count < boardList.length) {
			return;
		}
		//배열이 꽉 차면 배열을 늘려줌
		
		//기존 배열보다 큰 배열 생성
		Board[] tmpList = new Board[boardList.length +5];
		//새로 생성된 배열에 기존 배열을 복사
		System.arraycopy(boardList, 0, tmpList, 0, count);
		//새로 생성된 배열을 boardList가 연결
		boardList = tmpList;
	}
	
	private static void printmenu() {
		System.out.println("-----메뉴------");
		System.out.println("1. 게시글 목록 조회");
		System.out.println("2. 게시글 등록");
		System.out.println("3. 프로그램 종료");
		System.out.println("---------------");
		System.out.print("메뉴 선택 : ");
		
	}
	
	private static void printmenu2() {
		 System.out.println("---------------");
		 System.out.println("1. 게시글 상세 조회");	
		 System.out.println("2. 게시글 수정"); 	
		 System.out.println("3. 게시글 삭제");	
		 System.out.println("4. 뒤로가기"); 	
		 System.out.print("메뉴 선택 : "); 	
	}

}
