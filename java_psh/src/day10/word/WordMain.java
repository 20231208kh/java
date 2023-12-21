package day10.word;

import java.util.Scanner;


public class WordMain {

	/* 단어장 프로그램을 만드세요.
	 * 
	 * 1. 기능 정리
	 * 1-1. 저장된 전체 영어단어
	 * 1-2. 영어 단어 추가
	 * 1-3. 영어 단어 검색
	 * 
	 * 2. 틀 작성
	 * ---메뉴---
	 * 1. 저장된 전체 영어 단어
	 * 2. 영어 단어 추가
	 * 3. 영어 단어 검색
	 * 메뉴 선택 : 1
	 * 
	 * --저장된 전체 영어 단어---
	 * 번호   단어   뜻   (printAllWord())
	 * 
	 * ---메뉴---
	 * 1. 저장된 전체 영어 단어 
	 * word[0] 부터 word [count] 까지 printAllWord()
	 * 2. 영어 단어 추가
	 * 생성자와 반복문을 이용하여 추가
	 * 
	 * 3. 영어 단어 검색
	 * 메뉴 선택 : 2
	 * 
	 * ---영어 단어 추가---
	 * 영어 단어를 입력해주세요 :
	 * 생성자에 넣기
	 * 영어 단어의 뜻을 입력해주세요 :
	 * 생성자에 넣기 
	 * 영어 단어 추가가 완료 되었습니다.
	 * 
	 * * ---메뉴---
	 * 1. 저장된 전체 영어 단어
	 * 2. 영어 단어 추가
	 * 3. 영어 단어 검색
	 * 메뉴 선택 : 3
	 * 
	 * --영어 단어 검색--
	 * 1. 번호로 검색
	 * 2. 단어로 검색
	 * 3. 뜻으로 검색
	 * 메뉴 선택 : 1
	 * --단어로 검색--
	 * 영어 단어를 입력하세요 : 
	 * 
	 * --뜻으로 검색--
	 * 영어 단어의 뜻을 입력하세요 :
	 * 객체를 생성하고 그 안에 영어단어와 뜻을저장, 반복문을 이용해서 객체 배열을 만들고 그곳에 다 집어넣음
	 * 이 경우 배열의 확장 메서드가 필요함
	 * 인스턴스로 사용할 경우 static int count=0 을 선언해서, 각 인스턴스의 count 숫자를 파악한후
	 * 매칭되는 단어와 뜻을 반복문을 이용하여 쉽게 찾을 수 있다는 장점이 있음
	 * 
	 * 클래스의 생성자는 번호,단어,뜻, 타입은 스트링. 각각 num,wordv,mean
	 * static int count =0 , num = count++
	 * 
	 * 
	 * 
	 * 영어 단어를 검색하려면??
	 * 만약 인스턴스를 이용하여 영단어를 추가했다면, 추가하는 시점마다 고유 번호의 상승을 시킴
	 * 생성자는 번호,영단어,뜻을 이용하면 될거같음
	 * 첫 번쨰 단어를 넣게되면 word[0]에는 1, apple, 사과 가 담기는거임
	 * 만약 영단어의 번호로 검색한다면? getNum 메소드를 이용해서 이것과 매칭되는 단어,뜻 찾기
	 * 반복문은 word[0]부터 word[count] 까지
	 * if userNum == word[0].getNum ~word[count].getNum
	 * 출력 : word[i].getWord + word[i].getMean
	 * 만약 영단어의 철자로 검색한다면? getWord 메소드를 이용해서 이것과 매칭되는 뜻,번호 찾기
	 * 만약 영단어의 뜻으로 검색한다면? getMean 메소드를 이용해서 이것과 매칭되는 번호, 단어찾기
	 * 
	 * 3. 필요한 메서드 구현
	 * 
	 * 클래스 멤버변수들의 세터와 게터
	 * 
	 * 메뉴출력
	 * 
	 * 
	 * 
	 */
	private static Scanner scan = new Scanner(System.in);
	private static Word [] wordList = new Word[50];
	private static int count = 0;
	private static int failcount =0;

	public static void main(String[] args) {
		
		int	menu;
		do {
			menu1();
			menu = scan.nextInt();
			runMenu(menu);
		}while(menu!=7);
		
	}
	
	/**
	 * 
	 * @param runMenu 구동부
	 */
	
	private static void runMenu(int menu) {
		switch(menu) {
		case 1:
			showAllWord();
			break;
		case 2:
			insertWord();
			break;
		case 3:
			findWord();
			break;
		case 4:
			fixWord();
			break;
		case 5:
			testWord();
			break;
		case 6:
			failTestList();
			break;
		case 7:
			System.out.println("프로그램 종료");
			break;
		default:
			System.out.println("잘못된 메뉴 선택입니다.");
		}
		
	}



	/**
	 * @param fixWord 단어 수정 메서드
	 */
	private static void fixWord() {
		// TODO Auto-generated method stub
		System.out.println("--단어 수정--");
		System.out.print("수정할 단어를 입력하세요 : ");
		String user = scan.next();
		for (int i=0; i<count; i++) {
			if(user.equals(wordList[i].getWordv())) {
				System.out.println("--수정하실 단어--");
				wordList[i].printAllWord();
				System.out.print("어떤 뜻으로 바꾸시겠습니까? : ");
				String fixM = scan.next();
				wordList[i].updateMean(fixM);
				System.out.println("수정 되었습니다.");
				wordList[i].printSearchWord();
				return;
			}
		}
		System.out.println("해당하는 단어가 없습니다. ");
	}


	/**
	 *@param showAllWord 지금까지 추가된 단어를 출력하는 메서드
	 */
	private static void showAllWord() {
		for(int i=0; i<count; i++) {
			wordList[i].printAllWord();
		}
		
	}

	/**
	 * @param findWord 단어를 검색해주는 메서드
	 */
	private static void findWord() {
		subMenu();
		int user = scan.nextInt();
		switch(user) {
		case 1 :
			System.out.println("--단어로 검색--");
			System.out.print("찾을 단어를 입력하세요 : ");
			String searchWord = scan.next();
			for (int i=0; i <count; i++) {
				if (searchWord.equals(wordList[i].getWordv())) {
					wordList[i].printSearchWord();
					
				}
			}
			break;
		case 2 :
			System.out.println("---뜻으로 검색---");
			System.out.print("찾을 단어의 뜻을 입력하세요: ");
			String searchMean = scan.next();
			for (int i=0; i <count; i++) {
				if (searchMean.equals(wordList[i].getMean())) {
					wordList[i].printSearchWord();
				}
			}
			break;
		default:
			System.out.println("잘못된 메뉴 선택");
		}
		
	}


	/**
	 * @param insertWord 단어를 추가해주는 메서드
	 */
	private static void insertWord() {
		System.out.print("추가할 단어를 입력하세요 : ");
		String userword = scan.next();
		System.out.print("추가할 단어의 뜻을 입력하세요 : ");
		String usermean = scan.next();
		Word word = new Word(userword,usermean);
		wordList[count] = word;
		++count;
		if (count==wordList.length);{
			expandArr();
		}	
	}
	
	/**
	 * @param exPandArr 배열 크기 늘려주는 메서드
	 */
	public static void expandArr() {
		//배열이 꽉 차면 배열을 늘려줌
		//기존 배열보다 큰 배열 생성
		Word[] tmpList = new Word[wordList.length +5];
		//새로 생성된 배열에 기존 배열을 복사
		System.arraycopy(wordList, 0, tmpList, 0, count);
		//새로 생성된 배열을 boardList가 연결
		wordList = tmpList;
	}
	
	/**
	 * @param menu1 메인 메뉴 출력
	 */
	public static void menu1() {
		System.out.println("------메뉴------");
		System.out.println("1. 저장된 전체 단어");
		System.out.println("2. 단어 추가");
		System.out.println("3. 단어 검색");
		System.out.println("4. 단어 수정");
		System.out.println("5. 단어 시험");
		System.out.println("6. 오답노트");
		System.out.println("7. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
	}
	
	/**
	 * @param subMenu 서브메뉴 출력
	 */
	public static void subMenu() {
		System.out.println("--영어 단어 검색--");
		System.out.println("1. 단어로 검색");
		System.out.println("2. 뜻으로 검색");
		System.out.println("메뉴 선택 : ");
		System.out.println("--------------");
	}
	
	/**
	 * @param testWord 단어 시험 메서드
	 */
	public static void testWord() {
		System.out.println("--단어 시험 시작--");
		int min = 0, max = count-1;
		int r = (int)(Math.random()*(max - min +1) + min);
		if(count !=0) {
			String quiz = wordList[r].getWordv();
			System.out.println("해당하는 단어의 뜻을 입력하세요.");
			System.out.println("단어 : "+quiz);
			System.out.print("뜻 : ");
			String answer = scan.next();
			if (answer.equals(wordList[r].getMean())) {
				System.out.println("정답 입니다.");
				return;
			}
			System.out.println("오답 입니다.");
			System.out.println("올바른 뜻 : "+wordList[r].getMean());
			saveFail(r,answer);
		}else {
			System.out.println("먼저 단어를 추가해주세요.");
		}
		
	}
	
	/**
	 * @param saveFail 유저의 오답과 원본 단어와 답을 저장하는 메서드 
	 */
	public static void saveFail(int r, String answer) {
		wordList[r].setFailTestAnswer(wordList[r].getMean());
		wordList[r].setFailTestUser(answer);
		wordList[r].setFailTestWord(wordList[r].getWordv());
		failcount++;
	}
	

	
	
	/**
	 * @param failTestList 오답노트를 출력하는 메서드
	 */
	private static void failTestList() {
		System.out.println("----오답노트----");
		for(int i = 0; i<count;i++) {
			if(wordList[i].getFailTestAnswer()!=null) {
				wordList[i].failTestPrint();
			}
		}
		if(failcount >0) {
			System.out.println("오답 노트 시험을 시작하시겠습니까?Y(0)/N(1)");
			int user = scan.nextInt();
			if(user==0) {
				failTestTest();
			}else {
				System.out.println("오답 노트 시험을 시작하지않습니다.");
			}
		}
		
	
	}
	/**
	 * @param failTestTest 오답 노트로 시험치는 메서드
	 */
	private static void failTestTest() {
		System.out.println("----오답노트로 시험치기----");
		if(failcount>0) {	
			for(int i =0; i<count;i++) {
				if(wordList[i].getFailTestAnswer()!=null) {
					String quiz = wordList[i].getFailTestWord();
					System.out.println("해당하는 단어의 뜻을 입력하세요.");
					System.out.println("단어 : "+quiz);
					System.out.print("뜻 : ");
					String answer = scan.next();
					if (answer.equals(wordList[i].getFailTestAnswer())) {
						System.out.println("정답 입니다.");
						wordList[i].setFailTestWord(null);
						wordList[i].setFailTestUser(null);
						wordList[i].setFailTestAnswer(null);
						failcount--;
					}else {
					System.out.println("오답 입니다.");
					}

			}
		
		}
	}
		System.out.println("현재 오답노트에 아무것도 없습니다.");
 }
}
