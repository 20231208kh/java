package day08.access1;

//public 접근제어자 사용시, 파일이름과 클래스 이름이 같아야함
public class Student {
	//멤버 변수는, 일반적으로 private으로 만듬
	//파이썬의 설정자를 따로두는것처럼 메서드를 통해서 접근하게끔, getter , setter
	private int grade;
	int classNum; // 접근 제어자가 default
	public int num;
	private String name;
	
	//getter , setter
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getClassNum() {
		return classNum;
	}
	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
