package day13;

public class StringEx1 {

	public static void main(String[] args) {
		System.out.println("--------1.--------");
		String str = "abcde";
		//0번지에 있는 문자를 반환
		System.out.println(str.charAt(0));
		//두 문자열이 같은지를 반환
		System.out.println("--------2.--------");
		System.out.println(str.equals("abc"));
		System.out.println(str.equals("abcde"));
		
		//있으면 시작번지를 반환
		System.out.println("--------3.--------");
		System.out.println(str.indexOf("cd"));
		//포함되어 있는지를 반환
		System.out.println("--------4.--------");
		System.out.println(str.contains("cd"));
		
		//문자열의 길이를 반환
		System.out.println("--------5.--------");
		System.out.println(str.length());
		
		//문자열을 바꿔서 새 문자열을 반환
		System.out.println("--------6.--------");
		String str2 = str.replace("cd","aa");
		//기존 문자열은 안바뀜
		System.out.println(str);
		System.out.println(str2);
		
		//부분 문자열을 반환
		System.out.println("--------7.--------");
		String str3 = str.substring(1,3);
		System.out.println(str);
		System.out.println(str3);
		
		//대문자로
		System.out.println("--------8.--------");
		String str4 = str.toUpperCase();
		System.out.println(str);
		System.out.println(str4);
		
		//소문자로
		System.out.println("--------9.--------");
		String str5 = str.toLowerCase();
		System.out.println(str4);
		System.out.println(str5);
		
		System.out.println("--------10.--------");
		//시작 문자 앞의 공백을 제거, 마지막 문자 뒤에 공백을 제거
		String str6 = "\n\nabc\tdef\t\t";
		System.out.println(str6);
		String str7 = str6.trim();
		System.out.println(str7);
		
		//문자열에서 문자열들을 추출해서 배열로 만들어 줌
		String fruits ="사과,배,오렌지";
		String furitArray [] = fruits.split(",");
		System.out.println(fruits);
		for(String tmp : furitArray) {
			System.out.println(tmp);
		}
	}

}
