package day06;

import java.util.Scanner;

public class ArithmeticEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int min=0, max=2, max2 = 99;
		
		int ranNum = (int)(Math.random()*(max2 - min +1) + min);
		int ranNum2 = (int)(Math.random()*(max2 - min +1) + min);
		int ran = (int)(Math.random()*(max - min +1) + min);
		int user;
		int ranQuiz1 = ranNum + ranNum2;
		int ranQuiz2 = ranNum - ranNum2;
		int ranQuiz3 = ranNum * ranNum2;
		int arr [] = new int[] {ranQuiz1,ranQuiz2,ranQuiz3};
		String str = "+-*";
		char op = str.charAt(ran);
		int answer =arr[ran];
		
		System.out.println("" + ranNum + op + ranNum2 + "=");
		user= scan.nextInt();
		
		if (user ==answer) {
			System.out.println("정답입니다.");
		} else {
			System.out.println("틀렸습니다.");
		}
		
		
//		switch(op) {
//		case '+' :
//			answer = ranNum + ranNum2;
//			break;
//		case '-' :
//			answer = ranNum - ranNum2;
//			break;
//		case '*' :
//			answer = ranNum * ranNum2;
//			break;
//		default:
//			System.out.println("잘못된 연산자.");
//			}
//		
		
		
	}

}
