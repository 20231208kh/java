package day06;
import java.util.*;
public class OddEvenGameEx1 {

	public static void main(String[] args) {
		// 정수 num가 주어졌을 때 홀수인지 짝수인지 판별하는 예제
//		int num = 10;
		
//		if(num % 2==0) {
//			System.out.println("짝수");
//		}
//		else if(num % 2 != 0) {
//			System.out.println("홀수");
//		}
//		else {
//			System.out.println("0");
//		}
		
		//num가 1~100사이의 랜덤한 수를 작성하는 코드
		Scanner scanner = new Scanner(System.in);
		int min = 1, max = 100;
		int totalMoney = 10000; //게임 시작시 주어지는 금액
		//사용자가 0또는 1을 입력받은 코드를 작성 0: 짝수, 1:홀수
		
		//사용자가 게임에 투입할 금액을 입력하는 코드를 작성하세요
		while(totalMoney >0) {
			
			System.out.print("게임에 투입할 금액: ");
			int moneyIn = scanner.nextInt();
			moneyIn = moneyIn > totalMoney? totalMoney:moneyIn;
			System.out.println();
			
			int r = (int)(Math.random()*(max - min +1) + min);
			
			System.out.print("홀(1)/짝(0)");
			int user = scanner.nextInt();
			System.out.println();
			
			String check = "";
			if(user==1) {
				check = "홀수";
			}else if(user ==0) {
				check = "짝수";
			}
			if(r%2==0) {
				if(check=="짝수") {
					System.out.println(r+"는 짝수, 정답");
					totalMoney = totalMoney + moneyIn;
				}else if(check=="홀수") {
					System.out.println(r+"는 짝수, 오답");
					totalMoney -= moneyIn;
					
				}
			}else if(r%2 !=0) {
				if(check=="짝수") {
					System.out.println(r+"는 홀수, 오답");
					totalMoney -= moneyIn;
				}else if(check=="홀수") {
					System.out.println(r+"는 홀수, 정답");
					totalMoney = totalMoney + moneyIn;
				}
			}else {
				System.out.println("0");
			}
			
			System.out.println("남은돈:"+totalMoney);
		}
	}

}
