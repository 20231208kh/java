package day05;
import java.util.*;
public class CountEx1 {

	public static void main(String[] args) {
		// 1에서 9 사이의 정수를 5개 입력받아 각 숫자가 몇개씩 입력됐는지 출력하는 코드를 작성하세요
		
		int count[] = new int[10];
		int user[] = new int[5];
		Scanner scan = new Scanner(System.in);
		
		
		System.out.println(count[0]);
		//5개짜리 배열(입력한 수 저장)
		//10개짜리 배열(각 숫자가 몇개 입력됐는지 저장하는 배열)
		
		for(int i = 0 ;i<user.length;i++) {
			user[i] = scan.nextInt();
			count[user[i]] ++;
		}
		
		for(int i = 1; i<count.length; i++) {
			System.out.println(i + " : " + count[i]);
		}
		
		
		


	}

}
