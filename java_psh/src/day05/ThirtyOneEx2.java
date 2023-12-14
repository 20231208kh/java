package day05;
import java.util.*;
public class ThirtyOneEx2 {

	public static void main(String[] args) {
		// 31 게임 복습
		
		int user = 0;
		int count = 0;
		int min = 1, max =3;
		Scanner scanner = new Scanner(System.in);
		
		while(count<31) {
			int com = (int)(Math.random()*(max - min +1) + min);
			int end = count+com;
			
			end = end >= 31 ? 31 : end;
			//왜 count+1 ? 현재 숫자보다 무조건 높아야 하기도 하고 시작을 0에서 할 수 없기 때문
			System.out.print("Com : ");
			//왜 <= end ? count는 현재숫자, end는 마지막숫자
			//
			for(int i = count+1 ; i <= end; i++) {
				System.out.print(i + " ");
			}
			break;
			
			
		}
		

	}

}
