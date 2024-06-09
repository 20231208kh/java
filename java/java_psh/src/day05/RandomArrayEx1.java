package day05;
import java.util.Random;
public class RandomArrayEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 1~9 사이의 랜덤한  수를 3개 생성해서 배열에 저장하는 코드를 작성하세요.
		 * 
		 */
		
		Random random = new Random();
		int arr1 [] = new int[3];

		
		for(int i = 0; i<arr1.length; i++) {
			arr1[i] = random.nextInt(10);
		}
		
		for (int i = 0 ; i<arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
	}

}
