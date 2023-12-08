package day01;

public class TypeCastingEx1 {

	public static void main(String[] args) {
		// 자동 자료형 변환 예제
		
		//리터럴 1의 타입은 int 이고 num1 의 타입은 double
		//리터럴 1(int)을 num1(double)에 저장하기 위해 int를 double로 자동형변환
		//작은 자료형 값 -> 큰 자료형 값 (O)
		double num1 = 1;
		System.out.println(num1);
		
		//리터럴 2의 타입은 int, num2의 타입은 long
		//리터럴 2(int)를 num2(long)에 저장하기 위해 int를 long으로 자동형변환
		//작은 자료형 값 -> 큰 자료형 값 (O)
		long num2 = 2;
		System.out.println(num2);
		
		char ch = 'a';
		int num3 = ch;
		//'a'의 아스키코드값인 97이 num3에 저장 , char(2byte) -> int(4byte)
		System.out.println(num3);
	}

}
