package day01;

public class Variable5 {

	public static void main(String[] args) {
		// String 선언 예제 [참조형]
		String str1 = null;
		System.out.println(str1);
		// null 은 오로지 참조형만 선언 가능, 기본형은 null 저장 불가
		// int num1 = null; (X)
		
		String str2 = "Hello";
		System.out.println(str2);
		
		//String 클래스에 단일 문자('')를 저장할 수 없다.
		//String str3 = 'A'; (X)
		
		String str4 = "A";
		System.out.println(str4);
		
		//String 클래스에 빈문자열 저장 가능.
		String str5 = "";
		System.out.println(str5);
		
		//문자열에 정수 , 실수 , 문자 또는 논리값을 더하면 문자열이 됨
		
		String str6 = "" + 'A'; //문자열 + 문자
		String str7 = "" + 1;   //문자열 + 정수
		String str8 = "" + 1.0; //문자열 + 실수
		String str9 = "" + true;//문자열 + 논리
		System.out.println(str6);
		System.out.println(str7);
		System.out.println(str8);
		System.out.println(str9);
	}

}
