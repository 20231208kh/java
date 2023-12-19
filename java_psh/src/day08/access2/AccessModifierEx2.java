package day08.access2;
import day08.access1.Student;
public class AccessModifierEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student std = new Student();
		//std.grade=1; //grade의 접근 제어자가 private이어서 다른 패키지에 있는 클래스에서 사용불가
		//std.classNum =1; // classNum의 접근 제어자가 default 이어서 다른 패키지에 있는 클래스에서 사용 불가능
		std.num =1; //num의 접근제어자가 public 이어서 사용 O, public은 같은패키지 , 다른패키지 안따짐
		            //연결만 되어있으면 사용 가능
		
	}

}
