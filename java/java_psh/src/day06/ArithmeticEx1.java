package day06;
import java.util.*;
public class ArithmeticEx1 {

	public static void main(String[] args) {
		/* 랜덤으로 산수(+, -, *) 문제를 생성하여 맞추는 게임
		 * 단, 숫자 범위는 1~99, 연산자는 + - *
		 * 1 + 2 = 3
		 * 정답입니다.
		 * 
		 * 2 * 3 = 5
		 * 틀렸습니다.
		 */
		
		Scanner scan = new Scanner(System.in);
		int min=1, max=3, max2 = 99;
		
		int ranNum = (int)(Math.random()*(max2 - min +1) + min);
		int ranNum2 = (int)(Math.random()*(max2 - min +1) + min);
		int answer = 0;
		int ran = (int)(Math.random()*(max - min +1) + min);
		
		switch(ran) {
		case 1:
			answer = ranNum + ranNum2;
			System.out.print(ranNum + "+" + ranNum2 + " = ");
			break;
		case 2:
			answer = ranNum - ranNum2;
			System.out.print(ranNum + "-" + ranNum2 + " = ");
			break;
		case 3:
			answer = ranNum * ranNum2;
			System.out.print(ranNum + "*" + ranNum2 + " = ");
			break;
		}
		
		int userAnswer = scan.nextInt();
		if (userAnswer==answer) {
			System.out.println("정답입니다.");
		}else {
			System.out.println("틀렸습니다.");
		}
		

	}

}
