package day01;

public class VariableNamingEx1 {

	public static void main(String[] args) {
		// 변수명 작성 규칙(필수)과 관례 (선택이지만 추천)
		
		//1. 대소문자를 구분 (모두 다른 변수)
		int num; //관례
		int NUM;
		int Num;
		int nuM;
		
		//2. 예약어 사용 불가능
		
		//int int; (X)
		//int public; (X)
		//int class; (X)
		
		//3. 숫자로 시작 불가능
		int num2;
		//int 2num; (X)
		
		//4. 특수문자는 _ 와 $만 가능
		int _num;
		int num$;
		// int #num; (X)
		// int n um; (X)
		
		//5. 중복 선언 불가능
		int num1;
		//int num1; (X)
		

	}

}
