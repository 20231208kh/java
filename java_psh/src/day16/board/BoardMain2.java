package day16.board;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BoardMain2 {
	/* 다음 기능을 가진 프로그램을 만드세요.
	 * -학생 관리 프고르ㅐㅁ
	 * -기능
	 * 1.학생 추가
	 * 2.학생 조회
	 * 3. 종료
	 * -학생은 학년,반 번호 , 이름을 가진다.
	 * -저장 기능과 불러오기 기능을 통해 학생 정보들을 유지 
	 */
	private static String fileName = "src/day16/board/boardEx.txt";
	private static Scanner scan = new Scanner(System.in);
	private static List<Board> boardList = new ArrayList<>();
	
	public static void main(String[] args) {
		final int EXIT = 3;
		int menu =0;
		load(fileName);
		do {
			printMenu();
			try {
				menu = scan.nextInt();
				runMenu(menu);
			}catch(InputMismatchException e) {
				System.out.println("잘못된 메뉴 선택");
				scan.nextLine();
			}
			
		}while(menu != EXIT);
		save(fileName);

	}
	
	public static void save(String fileName2) {
		// TODO Auto-generated method stub
		
	}

	public static void load(String fileName2) {
		// TODO Auto-generated method stub
		
	}

	public static void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertStudent();
			break;
		case 2:
			printInfo();
			break;
		case 3:
			System.out.println("프로그램 종료");
			break;
		default:
			throw new InputMismatchException();
			
		}
		
	}
	
	public static void printMenu() {
		System.out.println("--메뉴--");
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 조회[전체]");
		System.out.println("3. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
	}
	
	public static void insertStudent() {
		System.out.println("--학생 추가--");
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("반 : ");
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int num = scan.nextInt();
		System.out.print("이름 : ");
		scan.nextLine();
		String name = scan.nextLine();

		Board tmp = new Board(grade,classNum,num,name);
		if(boardList.contains(tmp)) {
			System.out.println("중복된 학생");
			return;
		}
		boardList.add(tmp);
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeObject(boardList);
			} catch (FileNotFoundException e) {
				System.out.println("파일 찾을 수 없음");
			} catch (IOException e) {
				System.out.println("파일 작업 중 예외 발생");
				
			}
	}
	
	public static void printInfo() {
		try(FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis)){
			boardList = (List<Board>)ois.readObject();
			System.out.println(boardList);
			
			} catch (FileNotFoundException e) {
				System.out.println("파일 찾을 수 없음");
			} catch (IOException e) {
				System.out.println("파일 작업 중 예외 발생");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
