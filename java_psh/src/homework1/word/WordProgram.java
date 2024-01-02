package homework1.word;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class WordProgram implements Program{
	private Scanner scan = new Scanner(System.in);
	private final int EXIT = 5;
	private List<Word> wordList = new ArrayList<Word>();
	private List<Word> failList = new ArrayList<Word>();
	private List<Integer> quiz = new ArrayList<Integer>();

	//구동
	@Override
	public void run() {
		int menu =0;
		do {
			printMenu();
			try {
				menu = scan.nextInt();
				runMenu(menu);
			}catch(InputMismatchException e) {
				System.out.println("잘못된 메뉴 선택");
				scan.nextLine();
			}


		}while(menu!=EXIT);

	}

	//구동메뉴
	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			//단어 관리
			manageWord();
			break;
		case 2:
			//뜻 관리
			manageMean();
			break;
		case 3:
			//조회
			manageSearch();
			break;
		case 4:
			//추가기능 - 1. 단어시험
			//추가기능 - 2. 오답노트
			additionalFunction();
			break;
		case 5:
			//종료메뉴 출력
			exitMenu();
			break;
		default:
			//예외 처리
			throw new InputMismatchException();
		}

	}















	//단어 관리 세부 메뉴
	public void manageWord() {
		wordMenu();
		int menu = scan.nextInt();
		switch(menu) {
		case 1:
			//단어 추가
			insertWord();
			break;
		case 2:
			//단어 수정
			updateWord();
			break;
		case 3:
			//단어 삭제
			deleteWord();
			break;
		case 4:
			//뒤로가기
			break;
		default:
			//예외 처리
			throw new InputMismatchException();
		}


	}

	// 단어 추가
	public void insertWord() {
		//단어 입력, 뜻 입력, 품사 입력

		//인스턴스 생성

		//중복 확인

		//중복 아닐시 wordList에 인스턴스 저장

	}
	//단어 수정
	public void updateWord() {
		//단어 입력

		//wordList에 몇번째 인덱스에 있는지 확인

		//수정할 값 입력

		//입력된 값이 기존의 wordList[index]와 같은지 확인

		//같지 않다면 수정

	}
	//단어 삭제
	public void deleteWord() {
		//단어 입력

		//인스턴스 생성후 wordList 안에 있다면 삭제

	}

	//뜻 관리 세부 메뉴
	public void manageMean() {
		meanMenu();
		int menu= scan.nextInt();
		switch(menu) {
		case 1:
			//뜻 추가
			insertMean();
			break;
		case 2:
			//뜻 수정
			updateMean();
			break;
		case 3:
			//뜻 삭제
			deleteMean();
			break;
		case 4:
			//뒤로가기
			break;
		default:
			//예외 처리
			throw new InputMismatchException();
		}

	}
	//뜻 추가
	public void insertMean() {
		//단어 입력

		//리스트 검색

		//뜻 입력

		//인스턴스 생성

		//리스트에 인스턴스 저장


	}
	//뜻 수정
	public void updateMean() {
		//단어 입력

		//리스트 검색

		//수정할 값 입력

		//인스턴스 생성

		//리스트에 인스턴스 저장


	}
	//뜻 삭제
	public void deleteMean() {
		//단어 입력

		//리스트 검색

		//인스턴스 생성

		//리스트안에 인스턴스가 있다면 삭제


	}

	//조회 세부 메뉴(람다식을 이용)
	public void manageSearch() {
		searchMenu();
		int menu=scan.nextInt();
		switch(menu) {
		case 1:
			//단어로 조회
			searchByWord();
			break;
		case 2:
			//뜻으로 조회
			searchByMean();
			break;
		case 3:
			//품사로 조회
			searchByType();
			break;
		case 4:
			//뒤로가기
			break;
		default:
			//예외처리
			throw new InputMismatchException();
		}

	}


	//단어로 조회
	public void searchByWord() {



	}
	//뜻으로 조회
	public void searchByMean() {


	}
	//품사로 조회
	public void searchByType() {


	}

	//추가기능 세부 메뉴
	public void additionalFunction() {
		functionMenu();
		int menu=scan.nextInt();
		switch(menu) {
		case 1:
			//단어 시험
			wordQuiz();
			break;
		case 2:
			//오답 노트
			failNote();
			break;
		case 3:
			//뒤로가기
			break;
		default:
			//예외처리
			throw new InputMismatchException();
		}

	}








	//단어 퀴즈
	public void wordQuiz() {
		for (int i=0; i<wordList.size();i++) {
			quiz.add(i);
		}
		String user="";
		int min1 =0, max1 = quiz.size()-1;
		do {
			int r1 = (int)(Math.random()*(max1-min1+1)+min1);
			int r2 = quiz.remove(r1);
			List<Means> answer= wordList.get(r2).getMean();
			String quiz = wordList.get(r2).getWord();
			System.out.println("문제 : "+quiz);
			System.out.print("뜻을 입력하세요 : ");
			user = scan.next();
			if (answer.contains(user)) {
				System.out.println("정답입니다.");
			}else {
				System.out.println("틀렸습니다.");
				Word tmp = new Word(user,answer);
				failList.add(tmp);
			}
		}while(!user.equals("종료"));
	}

	//오답 노트
	public void failNote() {
		//람다식을 이용하여 오답을 모아둔 failList의 값을 모두 출력

	}

	//추가기능 메뉴 출력
	public void functionMenu() {
		System.out.println("--추가 기능--");
		System.out.println("1. 단어 시험");
		System.out.println("2. 오답 노트");
		System.out.println("3. 뒤로가기");
		System.out.print("메뉴 선택 : ");
	}
	//단어 메뉴 출력
	public void wordMenu() {
		System.out.println("--단어 관리--");
		System.out.println("1. 단어 추가");
		System.out.println("2. 단어 수정");
		System.out.println("3. 단어 삭제");
		System.out.println("4. 뒤로가기");
		System.out.print("메뉴 선택 : ");
	}
	//뜻 메뉴 출력
	public void meanMenu() {
		System.out.println("--뜻 관리--");
		System.out.println("1. 뜻 추가");
		System.out.println("2. 뜻 수정");
		System.out.println("3. 뜻 삭제");
		System.out.println("4. 뒤로가기");
		System.out.print("메뉴 선택 : ");


	}
	//조회 메뉴 출력
	public void searchMenu() {
		System.out.println("--조회 메뉴--");
		System.out.println("1. 단어로 조회");
		System.out.println("2. 뜻으로 조회");
		System.out.println("3. 품사로 조회");
		System.out.println("4. 뒤로가기");
		System.out.print("메뉴 선택 : ");

	}
	//시작메뉴
	@Override
	public void printMenu() {
		System.out.println("----메뉴------");
		System.out.println("1. 단어 관리");
		System.out.println("2. 단어 뜻 관리");
		System.out.println("3. 조회 메뉴");
		System.out.println("4. 추가 기능");
		System.out.println("5. 프로그램 종료");
		System.out.print("메뉴 선택 : ");


	}
	//프로그램종료
	@Override
	public void exitMenu() {
		System.out.println("================");
		System.out.println("프로그램을 종료합니다.");
		System.out.println("================");

	}

}
