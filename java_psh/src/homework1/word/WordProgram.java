package homework1.word;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class WordProgram implements Program{
	private Scanner scan = new Scanner(System.in);
	private final int EXIT = 5;
	private WordManager wm = new WordManager();
	private String fileName = "src/homework1/word/wordList.txt";
	//구동
	@Override
	public void run() {
		loadList();
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
		saveList();
	}
	
	private void loadList() {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
			wm = (WordManager) ois.readObject();
		} catch (Exception e) {
			System.out.println("단어장 파일이 없거나 불러오기에 실패했습니다.");
		}
	}
	
	// 단어장 저장하기	
	private void saveList() {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
			oos.writeObject(wm);
			System.out.println("단어장이 저장되었습니다.");
		} catch (IOException e) {
			System.out.println("단어장 저장 중 오류가 발생했습니다.");
		}
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
			test();
			break;
		default:
			//예외 처리
			throw new InputMismatchException();
		}


	}
	

	private void test() {
		List<String> a = wm.test(0);
		System.out.println(a);
		
	}

	// 단어 추가
	public void insertWord() {
		//단어 입력, 뜻 입력, 품사 입력
		System.out.print("단어 : ");
		String word = scan.next();
		Word wordTmp = new Word(word);
		if(wm.askContain(wordTmp)) {
			System.out.println("중복된 단어입니다.");
			return;
		}
		System.out.print("품사 : ");
		String wordClass = scan.next();
		System.out.print("뜻 : ");
		scan.nextLine();
		String mean = scan.nextLine();
		wm.insertWord(wordTmp, wordClass, mean);
		wm.sortWordList();
		
	}
	
	//단어 수정
	public void updateWord() {
		//단어 입력
		System.out.print("단어 : ");
		String word = scan.next();
		Word tmp = new Word(word);
		int index = wm.getIndex(tmp);
		if(!wm.askContain(tmp)) {
			System.out.println("없는 단어입니다.");
			return;
		}
		//수정할 값 입력
		System.out.print("단어(수정) : ");
		String updateWord = scan.next();
		if(wm.updateWord(tmp, updateWord)) {
			System.out.println("수정 완료");
			wm.sortWordList();
			System.out.println(wm.getWordList().get(index).toString());
			return;
		}

	}
	//단어 삭제
	public void deleteWord() {
		//단어 입력
		System.out.print("삭제할 단어를 입력해주세요 : ");
		String deleteWord = scan.next();
		Word word = new Word(deleteWord);
		if(wm.deleteWord(word)) {
			System.out.println("삭제 완료");
			return;
		}
		System.out.println("삭제할 단어가 없습니다.");

	}

	//뜻 관리 세부 메뉴
	public void manageMean() {
		meanMenu();
		int menu= scan.nextInt();
		switch(menu) {
		case 1:
			//뜻 추가
			insertMean2();
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
//	public void insertMean() {
//		//단어 입력
//		System.out.print("뜻을 추가할 단어를 입력하세요 : ");
//		String meanWord = scan.next();
//		Word word = new Word(meanWord);
//		if(!wm.askContain(word)) {
//			System.out.println("해당 단어가 없습니다.");
//			return;
//		}
//		System.out.print("추가할 뜻을 입력하세요 : ");
//		scan.nextLine();
//		String newMean = scan.nextLine();			
//		wm.insertOnlyMean(word, newMean);
//		
//	}
	
	public void insertMean2() {
		System.out.print("뜻을 추가할 단어 : ");
		String wordC = scan.next();
		Word word = new Word(wordC);
		if(!wm.askContain(word)) {
			System.out.println("없는 단어입니다.");
			return;
		}
		int index = wm.getIndex(word);
		System.out.print("뜻에 해당하는 품사 : ");
		String wordClass = scan.next();
		int index2 = -1;
		for(int i=0;i<wm.getWordList().get(index).getMean().size();i++) {
			String a = wm.getWordList().get(index).getMean().get(i).getWordClass();
			if(a.equals(wordClass)){
				index2 = i;
			}
		}
		if (index2 == -1) {
			System.out.println("등록되지 않은 품사입니다. 품사를 추가합니다.");
			System.out.print("추가할 뜻 : ");
			scan.nextLine();
			String NewMean2 = scan.nextLine();
			List<String> newMeanList = new ArrayList<String>();
			newMeanList.add(NewMean2);
			Means tmp = new Means(wordClass,newMeanList);
			wm.getWordList().get(index).getMean().add(tmp);
			wm.sortWordClass();
//			wm.getWordList().get(index).getMean().add(tmp);
			System.out.println(wm.getWordList().get(index).toString());
			return;
		}
		
		if (index2 != -1) {
			System.out.println("기존에 등록된 품사입니다. 기존 품사에 뜻을 추가합니다.");
			System.out.print("추가할 뜻 : ");
			scan.nextLine();
			String newMean = scan.nextLine();
			wm.insertOnlyMean(word, newMean, index2);
		}
	}
		

	
	//뜻 수정
	public void updateMean() {
		//단어 입력
		System.out.print("뜻을 수정할 단어 : ");
		String wordC = scan.next();
		Word word = new Word(wordC);
		if(!wm.askContain(word)) {
			System.out.println("없는 단어입니다.");
			return;
		}
		int index = wm.getIndex(word);
		System.out.print("뜻에 해당하는 품사 : ");
		String wordClass = scan.next();
		int index2 = -1;
		for(int i=0;i<wm.getWordList().get(index).getMean().size();i++) {
			String a = wm.getWordList().get(index).getMean().get(i).getWordClass();
			if(a.equals(wordClass)){
				index2 = i;
			}
		}
		if (index2 == -1) {
			System.out.println("잘못된 품사입니다.");
			return;
		}
		System.out.print("수정 전 뜻 : ");
		scan.nextLine();
		String mean = scan.nextLine();
		if(!wm.getWordList().get(index).containsMean(mean)) {
			System.out.println("없는 뜻 입니다.");
			return;
		}
		
		System.out.print("수정 후 뜻 : ");
		scan.nextLine();
		String updateMean = scan.nextLine();
		wm.updateMean(index,updateMean,index2,mean);
		System.out.println(wm.getWordList().get(index).toString());

	}
	//뜻 삭제
	public void deleteMean() {
		//단어 입력
		System.out.print("뜻을 삭제할 단어 : ");
		String wordC = scan.next();
		Word word = new Word(wordC);
		if(!wm.askContain(word)) {
			System.out.println("없는 단어입니다.");
			return;
		}
		int index = wm.getIndex(word);
		System.out.print("삭제할 뜻의 품사 : ");
		String wordClass = scan.next();
		int index2 = -1;
		for(int i=0;i<wm.getWordList().get(index).getMean().size();i++) {
			String a = wm.getWordList().get(index).getMean().get(i).getWordClass();
			if(a.equals(wordClass)){
				index2 = i;
			}
		}
		System.out.print("삭제할 뜻 : ");
		scan.nextLine();
		String deleteMean = scan.nextLine();
		if(!wm.getWordList().get(index).containsMean(deleteMean)) {
			System.out.println("없는 뜻 입니다.");
			return;
		}
		wm.deleteMean(index,deleteMean,index2);
		System.out.println("삭제 완료");
		
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
			//첫글자
			searchFirstChar();
			break;
		case 5:
			//전체조회
			wm.printAll();
			break;
		case 6:
			//뒤로가기
			break;
		default:
			//예외처리
			throw new InputMismatchException();
		}

	}


	public void searchByWord() {
		System.out.print("검색할 단어 : ");
		String word = scan.next();
		Word tmp = new Word(word);
		if(!wm.askContain(tmp)) {
			System.out.println("등록 되지 않은 단어입니다.");
			return;
		}
		int index = wm.getIndex(tmp);
		System.out.println(wm.getWordList().get(index).toString());
	}
	//뜻으로 조회
	public void searchByMean() {
		scan.nextLine();
		System.out.print("검색할 뜻 : ");
		String mean = scan.nextLine();
		
		wm.getWordList().forEach(w -> w.getMean().forEach(c->c.getMeanList().forEach(m-> {
					if(m.equals(mean)) {
						System.out.println(w.toString());
						return; // 리턴 오류 // 아마 람다식은 임시 클래스를 생성하기 떄문
					}
				})
			)
		);
		// System.out.println("등록 되지 않은 뜻입니다.");
	}
	//품사로 조회
	public void searchByType() {
		System.out.print("검색할 품사 : ");
		String wordClass = scan.next();
		wm.getWordList().forEach(w-> w.getMean().forEach(c -> {
			if(c.getWordClass().equals(wordClass)) {
				System.out.println(w.toString());
			}
		})
		);
	}
	// 첫 알파벳 검색
	public void searchFirstChar() {
		System.out.print("검색할 알파벳 : ");
		char ch = scan.next().charAt(0);
		wm.getWordList().forEach(w-> {
			if(w.getWord().charAt(0)==ch) {
				System.out.println(w.toString());
			}
		});
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
			wm.clearFailList();
			break;
		default:
			//예외처리
			throw new InputMismatchException();
		}

	}

	//단어 퀴즈
	//0부터 wordList 크기 만큼의 숫자가 담긴 리스트를 통해서 난수를 만들어
	//문제의 중복을 피함
	public void wordQuiz() {
		
		
		if(wm.getWordList().size()<=0) {
			System.out.println("먼저 단어를 추가해주세요");
			return;
		}
		String userAnswer="";
		List<Integer> quiz = wm.makeRanList();
		scan.nextLine();
		//소트
		//뜻 확인
		//
		
		while(quiz.size()!=0) {
			int min1 =0, max1 = quiz.size()-1;
			int r1 = (int)(Math.random()*(max1-min1+1)+min1);
			int r2 = quiz.remove(r1);
			String quizWord = wm.getWordList().get(r2).getWord();
			Word word = new Word(quizWord);
			int index = wm.getIndex(word);
			List<String> a = wm.test(index);
			System.out.println("단어 : "+quizWord);
			System.out.print("위 단어의 뜻을 입력하세요 : ");
			userAnswer = scan.nextLine();
			if(a.contains(userAnswer)) {
				System.out.println("정답입니다.");
			}else {
				System.out.println("오답입니다.");
				if (wm.getFailList().contains(word)) {
					continue;
				}
				wm.getFailList().add(wm.getWordList().get(r2));
				wm.sortFailList();
			}
		}
		
	
		
	}

	//오답 노트
	public void failNote() {
		wm.failPrintAll();
	}

	//추가기능 메뉴 출력
	public void functionMenu() {
		System.out.println("--추가 기능--");
		System.out.println("1. 단어 시험");
		System.out.println("2. 오답 노트");
		System.out.println("3. 오답 노트 초기화");
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
		System.out.println("4. 첫 글자로 조회");
		System.out.println("5. 전체 조회");
		System.out.println("6. 뒤로가기");
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
