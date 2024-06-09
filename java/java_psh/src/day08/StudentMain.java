package day08;

public class StudentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student student = new Student();
		student.name = "박성훈";
		student.grade = 1;
		student.classNum =1;
		student.num = 1;
		student.printInfo();
		student.printScore();
		student.setKor(90);
		student.setEng(100);
		student.setMath(80);
		student.printScore();
	}

}
