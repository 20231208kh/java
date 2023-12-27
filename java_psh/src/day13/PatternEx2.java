package day13;

import java.util.regex.Pattern;

public class PatternEx2 {

	/* 아이디를 입력받아 아이디 형식에 맞는지 틀린지를 출력하는 프로그램을 작성하세요.
	 * 아이디 정규 표현식 : 영문,숫자로 구성, 8~13자
	 * 
	 * 아이디 : abc
	 * 아이디 형식에 맞지 않습니다.
	 */
	public static void main(String[] args) {
		
		String regex = "^[a-zA-Z0-9]{8,13}$";
		String str = "abcdefgh1";
		String str1 = "abcdef";
		String str2 = "abcdef21415145512";
		
		checkRegex(str,regex);
		checkRegex(str1,regex);
		checkRegex(str2,regex);
				
	}
	
	public static void checkRegex(String str,String regex) {
		System.out.println("아이디 : "+str);
		if(Pattern.matches(regex, str)) {
			System.out.println("올바른 아이디 형식입니다.");
			return;          
		}
		System.out.println("올바르지 않은 아이디 형식입니다.");
		
	}

}
