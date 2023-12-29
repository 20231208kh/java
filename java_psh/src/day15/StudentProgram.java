package day15;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class StudentProgram implements Program {
	private Scanner scan = new Scanner(System.in);
	int menu=0;
	private final int EXIT =4;
	List<Student> studentList = new ArrayList<Student>();
	int count =0;
	
	@Override
	
	public void run() {
		System.out.println("-----------------------");
		System.out.println("프로그램을 실행합니다.");
		System.out.println("-----------------------");
		do {
			printMenu();
			try {
				menu = scan.nextInt();
				runMenu(menu);
			}catch(InputMismatchException e) {
				scan.nextLine();
				System.out.println("잘못된 입력입니다.");
			}
		}while(menu!=EXIT);
		
	}

	@Override
	public void printMenu() {
		System.out.println("-----------메뉴----------");
		System.out.println("1. 학생관리");
		System.out.println("2. 성적관리");
		System.out.println("3. 조회");
		System.out.println("4. 종료");
		System.out.println("-----------------------");
		System.out.print("메뉴 선택 : ");
	}
		


	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			manageStudentMenu();
			break;
		case 2:
			updateScore();
			break;
		case 3:
			searchMenu();
			break;
		case 4:
			exitMenu();
			break;
		default:
			throw new InputMismatchException(); 
		}
		
	}

	public void manageStudentMenu() {
		subMenu1();
		int menu = scan.nextInt();
		switch(menu) {
		case 1:
			insertStudent();
			break;
		case 2:
			updateStudent();
			break;
		case 3:
			deleteStudent();
			break;
		default:
			throw new InputMismatchException();
		}
		
		
	}
	
	public void insertStudent() {
		System.out.println("--학생 추가--");
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("반 : ");
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int studentNum = scan.nextInt();
		System.out.print("이름 : ");
		String name = scan.next();
		
		Student std = new Student(grade,classNum,studentNum,name);
		
		if(studentList.contains(new Student(grade,classNum,studentNum,name))) {
			System.out.println("중복된 학생입니다.");
			return;
		}
		
		studentList.add(std);
		
	}
	
	public boolean checkDuplicate(int grade, int classNum, int studentNum, String name) {
		if(count>0) {
			for(int i=0; i<count; i++) {
				int checkG = studentList.get(i).getGrade();
				int checkCN =studentList.get(i).getClassNum();
				int checkN =studentList.get(i).getStudentNum();
				String checkName =studentList.get(i).getName();
				if(grade==checkG&&classNum==checkCN&&studentNum==checkN&&checkName.equals(name)) {
					return true;
				}
			}
		}
		return false;
		
	}

	
	public void updateStudent() {
		System.out.println("--학생 수정--");
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("반 : ");
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int studentNum = scan.nextInt();
		
		Student std = new Student(grade,classNum,studentNum,"");
		
		int index = studentList.indexOf(std);
		
		if(index==-1) {
			System.out.println("수정할 학생이 없음");
			return;
		}
		
		std = studentList.get(index);
		
		System.out.print("학년(수정) : ");
		grade = scan.nextInt();
		System.out.print("반(수정) : ");
		classNum = scan.nextInt();
		System.out.print("번호(수정) : ");
		studentNum = scan.nextInt();
		System.out.print("이름(수정) : ");
		String name = scan.next();
		
		Student newStd = new Student(grade,classNum,studentNum,name);
		
		if(studentList.contains(newStd)) {
			System.out.println("중복된 학생입니다. 수정 실패");
			return;
		}
		
		newStd.updateScore(std.getKor(), std.getEng(), std.getMath());
		
		studentList.remove(index);
		
		studentList.add(newStd);
		
		studentList.sort((o1,o2)->{
			if(o1.getGrade() != o2.getGrade()) {
				return o1.getGrade()- o2.getGrade();
			}
			if(o1.getClassNum() != o2.getClassNum()) {
				return o1.getClassNum()-o2.getClassNum();
			}
			return o1.getStudentNum() - o2.getStudentNum();
		});
		
		System.out.println("수정 완료");

	}
	
	public void fix(int i, int menu) {
		switch(menu) {
		case 1:
			System.out.print("학년(수정) : ");
			int grade = scan.nextInt();
			studentList.get(i).setGrade(grade);
			System.out.println("수정 완료");
			break;
		case 2:
			System.out.print("반(수정) : ");
			int classNum = scan.nextInt();
			studentList.get(i).setClassNum(classNum);
			System.out.println("수정 완료");
			break;
		case 3:
			System.out.print("번호(수정) : ");
			int studentNum = scan.nextInt();
			studentList.get(i).setStudentNum(studentNum);
			System.out.println("수정 완료");
			break;
		case 4:
			System.out.print("이름(수정) : ");
			String name1 = scan.next();
			studentList.get(i).setName(name1);
			System.out.println("수정 완료");
			break;
		default:
			throw new InputMismatchException();
		}
	}
	
	public void deleteStudent() {
		System.out.println("--학생 삭제--");
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("반 : ");
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int studentNum = scan.nextInt();
		
		Student std = new Student(grade,classNum,studentNum,"");
		if(studentList.remove(std)) {
			System.out.println("삭제 완료");
		}else {
			System.out.println("삭제할 학생이 없습니다.");
		}
		
		
		
	}
	
	public void updateScore() {
		System.out.println("--성적수정--");
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("반 : ");
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int studentNum = scan.nextInt();
		
		Student std = new Student(grade,classNum,studentNum,"");
		int index = studentList.indexOf(std);
		
		if(index==-1) {
			System.out.println("수정할 학생이 없음");
			return;
		}
		subjectMenu();
		int menu=scan.nextInt();
		switch(menu) {
		case 1:
			System.out.print("국어 점수 : ");
			int kor = scan.nextInt();
			studentList.get(index).setKor(kor);
			break;
		case 2:
			System.out.print("영어 점수 : ");
			int eng = scan.nextInt();
			studentList.get(index).setEng(eng);
			break;
		case 3:
			System.out.print("수학 점수 : ");
			int math = scan.nextInt();
			studentList.get(index).setMath(math);
			break;
		default:
			throw new InputMismatchException();
		}	
	}
	
	public void subjectMenu() {
		System.out.println("과목");
		System.out.println("1. 국어");
		System.out.println("2. 영어");
		System.out.println("3. 수학");
		System.out.print("선택 : ");
	}
	
	public void searchMenu() {
		subMenu3();
		int menu = scan.nextInt();
		switch(menu){
		case 1:
			searchByStudent();
			break;
		case 2:
			searchByScore();
			break;
		default:
			throw new InputMismatchException();
		}
		
	}



	public void searchByStudent() {
		subMenu4();
		int menu = scan.nextInt();
		switch(menu) {
		case 1:
			searchAll();
			break;
		case 2:
			searchByGrade();
			break;
		case 3:
			searchByClass();
			break;
		case 4:
			searchByInfo();
			break;
		default:
			throw new InputMismatchException();
		}
		
	}
	
	public void searchByInfo() {
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("반  : ");
		int classNum = scan.nextInt();
		System.out.print("번호  : ");
		int num = scan.nextInt();
		Student std = new Student(grade, classNum, num, "");
		printStudent(s->s.equals(std));
		
	}

	public void searchByClass() {
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("반  : ");
		int classNum = scan.nextInt();
		printStudent(s->s.getGrade() == grade && s.getClassNum() == classNum);
		
	}

	public void searchByGrade() {
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		printStudent(s->s.getGrade() == grade);
		
	}

	public void searchAll() {
		printStudent(s->true);
		
	}

	public void searchByScore() {
		subMenu5();
		int menu=scan.nextInt();
		switch(menu) {
		case 1:
			printSubject(s->s.getKor());
			break;
		case 2:
			printSubject(s->s.getEng());
			break;
		case 3:
			printSubject(s->s.getMath());
			break;
		default:
			throw new InputMismatchException();
		}
	}
	

	private void printStudent(Predicate<Student> p) {
		for(Student std : studentList) {
			if(p.test(std)) {
				System.out.println(std);
			}
		}
	}
	private void printSubject(Function<Student, Integer> f) {
		for(Student std : studentList) {
			System.out.println(std.getName() + " : " + f.apply(std));
		}
	}

	
	public void subMenu1() {
		System.out.println("--학생관리--");
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 수정");
		System.out.println("3. 학생 삭제");
		System.out.print("메뉴 선택 : ");
		
	}



	public void subMenu3() {
		System.out.println("--조회--");
		System.out.println("1. 학생 조회");
		System.out.println("2. 성적 조회");
		System.out.print("메뉴 선택 : ");
		
	}

	@Override
	public void exitMenu() {
		System.out.println("-----------------------");
		System.out.println("프로그램을 종료합니다.");
		System.out.println("-----------------------");
		
	}


	public void subMenu4() {
		System.out.println("--학생조회--");
		System.out.println("1. 전체 조회");
		System.out.println("2. 학년 조회");
		System.out.println("3. 반 조회");
		System.out.println("4. 학생 조회");
		System.out.print("메뉴 선택 : ");
		
	}


	public void subMenu5() {
		System.out.println("--성적조회--");
		System.out.println("1. 국어");
		System.out.println("2. 영어");
		System.out.println("3. 수학");
		System.out.print("메뉴 선택 : ");
		
		
	}

}
