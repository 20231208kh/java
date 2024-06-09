package day08.access1;

public class AccessModifierEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student std = new Student();
		//grade의 접근 제어자가 private이어서 같은 패키지에 있는 클래스에서 사용불가
		//std.grade=1;
		std.setGrade(1); // grade가 private 이기 때문에 setter을 이용하여 수정
		
		std.classNum =2; // classNum의 접근 제어자가 default 이어서 같은 패키지에 있는 클래스에서 사용 가능
		std.num =3; //num의 접근제어자가 public 이어서 사용 O, public은 같은패키지 , 다른패키지 안따짐
		            //연결만 되어있으면 사용 가능
		
		//grade가 private 이기 때문에 getter을 이용하여 매개변수의 값을 가져옴
		System.out.println(std.getGrade()+ "학년");

		
	}

}
