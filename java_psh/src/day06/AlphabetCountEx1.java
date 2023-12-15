package day06;
import java.util.*;
public class AlphabetCountEx1 {

	public static void main(String[] args) {
		/* 단어를 입력받아 단어 각 알파벳이 몇번 나왔는지 출력하는 코드
		 * 입력 : apple
		 * a : 1
		 * e : 1
		 * l : 1
		 * p : 2
		 */
		
		// 1. 입력받고 저장, 배열로?
	
		
		Scanner scan = new Scanner(System.in);
		System.out.print("단어 입력 : ");
		String str = scan.next();
		char chr1[] = new char[str.length()];
		int arr [] = new int[26];

		
		//가져온 문자가 a이면 0번지에 있는 숫자를 1증가, b이면 1번지, c이면 2번지 . . . z는 25번지
		for (int i = 0 ; i < str.length() ; i ++) {
			//문자열의 각 문자를 가져옴
			chr1[i] = str.charAt(i);
			//아스키 코드를 이용
			arr[chr1[i]-'a']++;
			}
			
		for(int i=0; i<arr.length; i++) {
			//개수가 0이아닌 알파벳들을 출력
			if (arr[i] != 0) {
				char ch = (char)('a'+i);
				System.out.println(ch+ " : " +arr[i]);
			}
		}
		System.out.println("=============");
		
		//향상된 포문을 이용한 출력
		char ch = 'a';
		for (int count : arr) {
			if(count !=0) {
				System.out.println(ch + " : " +count);
			}
		}

		
	
		
		
		
	}

}
