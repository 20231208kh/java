package day10;

public class StringEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//데이터 영역에 abc가 추가되고 추가된 주소를 가져와서 str1에 저장
		String str1 = "abc";
		//데이터 영역에 abc가 추가되고 추가된 주소를 가져와서 str2에 저장 -> 서로 주소가 같음
		String str2 = "abc";
		String str3 = new String("abc");
		//참조 변수에서 ==는 주소를 비교
		System.out.println(str1==str2);
		System.out.println(str1==str3);
		System.out.println(str2==str3);
		//문자열은 equals라는 메서드를 통해 비교
		System.out.println(str1.equals(str2));
		System.out.println(str1.equals(str3));
		System.out.println(str2.equals(str3));
	}

}
