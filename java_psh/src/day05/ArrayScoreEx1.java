package day05;
import java.util.Scanner;


public class ArrayScoreEx1 {

	public static void main(String[] args) {
		// 학생 5명의 국어 성적을 입력받고, 총점과 평균을 구하는 코드를 작성하세요.
		
		Scanner scan = new Scanner(System.in);
		int [] korScores = new int[5];
		int total = 0;
		double mean = 0;
		
		for(int i = 0; i<5; i++) {
			System.out.print("학생"+(i+1)+" 성적 : ");
			korScores[i] = scan.nextInt();
			total += korScores[i];
		}
		
		mean = total/korScores.length;
		
		System.out.println(total);
		System.out.println(mean);
	}

}
