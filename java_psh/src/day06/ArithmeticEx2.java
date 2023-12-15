package day06;
import java.util.*;
public class ArithmeticEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int min=0, max=2, max2 = 99;
		int r = (int)(Math.random()*(max - min +1) + min);
		int ranNum = (int)(Math.random()*(max2 - min +1) + min);
		int ranNum2 = (int)(Math.random()*(max2 - min +1) + min);
		int ranQuiz1 = ranNum + ranNum2;
		int ranQuiz2 = ranNum - ranNum2;
		int ranQuiz3 = ranNum * ranNum2;
		int arr [] = new int[] {ranQuiz1,ranQuiz2,ranQuiz3};
		int	quiz = arr[r];
		Scanner scan = new Scanner(System.in);
			switch(r) {
			case 0 :
				System.out.println(ranNum + "+" + ranNum2 + "=");
				break;
			case 1 :
				System.out.println(ranNum + "-" + ranNum2 + "=");
				break;
			case 2 :
				System.out.println(ranNum + "*" + ranNum2 + "=");
				break;
			}
			int userAnswer = scan.nextInt();
			if (userAnswer==quiz) {
				System.out.println("정답입니다.");
			}else {
				System.out.println("틀렸습니다.");
			}
		
	}

}
