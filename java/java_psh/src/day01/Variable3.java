package day01;

public class Variable3 {

	public static void main(String[] args) {
		// 실수형 변수 선언 예제 float(4byte), double(8byte) [기본형] 
		
		//변수를 초기화 할때 쓰는 값을 '리터럴'이라고 함.
		//실수 리터럴 1.23의 기본타입은 double, double은 8byte 이고 float은 4byte이기 때문에
		//접미사 f를 붙여서 float임을 선언해야함 (작은 것 -> 큰 것은 가능, 큰 것 -> 작은 것은 불가능)
		float num1 = 1.23f;
		System.out.println(num1);
		
		double num2 = 3.14;
		System.out.println(num2);

	}

}
