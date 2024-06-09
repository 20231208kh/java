package day01;

public class Variable2 {

	public static void main(String[] args) {
		// 정수형 변수 선언 예제 byte, short(2byte), int(4byte), long(8byte) [기본형]
		
		/*1bit = 2
		*2bit = 4
		*n bit = 2의 n제곱
		*8bit = 256 = 1byte
		*1byte = 256 = -2의 7제곱 ~ 2의 7제곱-1 = ★byte★ , -128 ~ 127
		*2byte = 2의 16제곱 = -2의 15제곱 ~ 2의 15제곱-1 = ★short★ , -32,768 ~ 32,767
		*4byte = 2의 32제곱  = -2의 31제곱 ~ 2의 31제곱 -1 = ★int★ , -2,147,483,648 ~ 2,147,483,647
		*8byte = 2의 64제곱  = -2의 63제곱 ~ 2의 63제곱 -1 = ★long★ , 대충 엄청 큼
		*/
		
		byte num1 = 1;
		System.out.println(num1);
		//byte는 127까지 표현 가능하기 때문에 128을 저장할 수 없다.
		//byte num2 = 128; (X)
		
		//byte의 양수 표현 범위(127)를 넘어서 오버플로우가 발생하여 -128이 됨
		byte num3 = (byte)(127+1);
		System.out.println(num3);
		
		//byte의 음수 표현 범위(-128)를 넘어서 언더플로우가 발생하여 127이 됨
		byte num4 = (byte)(-128-1);
		System.out.println(num4);
		
		int num5 = 128;
		System.out.println(num5);
		
		//int의 양수 표현 범위(2,147,483,647)를 넘어서 저장할 수 없다.
		//int num6 = 123456789123; (X)
		
		int num7 = 010; // 8진수 10 => 10진수 8
		System.out.println(num7);
		int num8 = 0x10; // 16진수 10 => 10진수 16
		System.out.println(num8);
		int num9 = 0b10; // 2진수 10 => 10진수 2
		System.out.println(num9);
		
		long num10 = 123456789123L; // 큰수를 초기화 하는 경우 기본 타입이 int이기 때문에 접미사 L을 붙여줘야 한다.
		System.out.println(num10);
		
	}

}
