package day01;

/* 변수 선언 방법
 * 1. 선언만
 * 변수타입 변수명;
 * 
 * 2. 선언 후 초기화
 * 변수타입 변수명 = 값;
 */

public class Variable {

	public static void main(String[] args) {
		// 문자형 변수 선언 예제 
		
		//char, 문자형 변수, 2byte [기본형]
		char ch1;
		char ch2 = 'A';
		//변수는 초기화를 하고, 사용해야 한다. 
		ch1 = '+';
		System.out.println(ch1);
		System.out.println(ch2);
		//char은 쌍따옴표로 초기화 불가능, 두 글자 이상 초기화 불가능
		//char ch3 = "A"; (X)
		//char ch4 = '12'; (X)
		
		//유니코드 61에 해당하는 문자(한 글자)를 저장.
		char ch5 = '\u0061';
		System.out.println(ch5);
		//아스키코드 65에 해당하는 문자(한 글자)를 저장.
		char ch6 = 65;
		System.out.println(ch6);
		//\가 들어간 문자들이 있음. \n : 개행, \t : 공백, \\: \문자 등
		char ch7 = '\n';
		
	}

}
