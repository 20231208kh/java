package day08;

public class StudentMain3 {

	public static void main(String[] args) {
		// Student2의 생성자를 이용한 예제, 파이썬하고 똑같은듯?  def __init__(self,name,grade)
		//                                             self.name = name
		//											   self.grade = grade
		//                                         Public Student2 (int name,int grade)
		Student2 std = new Student2(1, 1, 1, "홍길동");
		std.printScore();
		
	}

}
