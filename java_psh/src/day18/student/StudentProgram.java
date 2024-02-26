package day18.student;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import program.Program;

public class StudentProgram implements Program{
	private final int EXIT =3;
	private Scanner scan = new Scanner(System.in);
	private StudentManger sm = new StudentManger();
	private Socket socket;
	@Override
	public void run() {
		String ip = "192.168.30.193";
		int port = 5001;
		int menu=0;
		do {
			connectServer(ip,port);
			load();
			printMenu();
			try {
				menu = scan.nextInt();
				runMenu(menu);
			}catch(InputMismatchException e) {
				System.out.println("잘못된 입력");
			}
		}while(menu!=EXIT);
		
	}
	private void sendStudent(Student std) {
		if(socket == null) {
			System.out.println("[서버에 연결되지 않아 추가할 수 없습니다.");
		}
		try {
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeUTF("INSERT");
			oos.writeObject(std);
			oos.flush();
			System.out.println("[불러오기 성공]");
		} catch (IOException e) {
			System.out.println("로드 실패");
		}
	}
	
	
	private void load() {
		if(socket == null) {
			System.out.println("[서버에 연결되지 않아 불러올 수 없습니다.");
		}
		try {
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeUTF("LOAD");
			oos.flush();
			
			//읽기
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			List <Student> list = (List<Student>)ois.readObject();
			sm = new StudentManger(list);
			System.out.println("불러오기 성공");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("로드 실패");
		}
	}
	private void connectServer(String ip, int port) {
		try {
			socket = new Socket(ip,port);
			System.out.println("[서버 연결 성공]");
		}catch(IOException e) {
			System.out.println("[서버 연결 실패]");
		}
	}

	@Override
	public void printMenu() {
		System.out.println("--메뉴--");
		System.out.println("1. 학생 등록");
		System.out.println("2. 학생 조회");
		System.out.println("3. 종료");
		System.out.print("메뉴 선택 : ");
		
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertStudent();
			break;
		case 2:
			sm.printAll();
			break;
		case 3:
			exit();
			System.out.println("프로그램 종료");
			break;
		default:
			throw new InputMismatchException();
		}
		
	}
	private void exit() {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeUTF("SAVE");
			oos.flush();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	private void insertStudent() {
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("반 : ");
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int num = scan.nextInt();
		System.out.print("이름 : ");
		String name = scan.next();
		
		Student std = new Student(grade,classNum,num,name);
		if(sm.insertStudent(std)) {
			System.out.println("학생 등록 완료");
			return;
		}
		System.out.println("이미 등록된 학생입니다.");
		
	}

	private void searchStudent() {
		// TODO Auto-generated method stub
		
	}


}
