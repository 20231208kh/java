package day01;

public class typeCastingEx2 {

	public static void main(String[] args) {
		// 강제(명시적) 자료형 변환 예제
		
		//실수를 정수로 형변환 했기 때문에 소수점이 사라짐
		int num1 = (int)3.14;
		System.out.println(num1);
		
		//num1의 타입은 int이기 때문에 값은 3이지만 byte에 들어갈 수 없음.
		//강제 형변환을 해야 함.
		byte num2 = (byte)num1;
		System.out.println(num2);
		
		byte num4 = (byte)128;
		System.out.println(num4);
		
		//에러가 발생하지 않지만 필요에 의해 형변환 하는 경우
		//정수 / 정수 = 정수 , 올바른 값인 실수를 얻기 위해서는 에러는 없지만 형변환이 필요
		System.out.println(1/2);
		System.out.println((double)1/2);
		
		//같은 타입의 변수를 여러개 선언하는 방법
		int num5,num6,num7;
		int num8 = 1, num9 = 2, num10 = 3;
	}

}
