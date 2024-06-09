package day05;
import java.util.Scanner;
public class ReverseNumberEx1 {

	public static void main(String[] args) {
		/* 정수를 입력받아 입력받은 정수를 거꾸로 출력하는 코드를 작성하세요.
		 * 예
		 * 입력 : 1234
		 * 출력 : 4321
		 */
		
		Scanner scan = new Scanner(System.in);
		int user [] = new int[4];
		int out [] = new int[4];
		
		System.out.print("입력 : ");
		for(int i=0; i<user.length; i++) {
			user[i] = scan.nextInt();
			out[3-i] = user[i];
		}
		System.out.println();
		System.out.print("입력 : ");
		for (int tmp : user) {
			System.out.print(tmp + " ");
		}
		System.out.println();
		System.out.print("출력 : ");
		for (int tmp : out) {
			System.out.print(tmp + " ");
		}

	}

}
