package day05;
import java.util.*;
public class LottoEx1 {

	public static void main(String[] args) {
		// 1~45 사이의 랜덤한 수 6개를 생성하여 출력하는 예제를 작성하세요.
		// 단, 정렬이 되도록
		
		int arr1 [] = new int[6];
		int min=1, max=45;
		int count = 0 ;
		while(count < arr1.length ) {
			//랜덤수 생성
			// 0 < r < 1 에다가 (max-min+1) + min 를 계산해줌
			// min < r < max+1 가 됨
			int r = (int)(Math.random()*(max - min +1) + min);
			//중복 확인
			int i;
			for (i =0; i< count; i++) {
				if (arr1[i]==r) {
					break;
				}
			}
			
			//중복되지 않으면 저장 후 count 증가
			if(i == count) {
				arr1[count++] = r;
			}
		}
		
		
		Arrays.sort(arr1);
		
		//버블 정렬
		/*for (int i=0; i<arr1.length -1; i++) {
			for(int j = 0; j<arr1.length -1; j++) {
				if (arr1[j] > arr1[j+1]) {
					int tmp = arr1[j];
					arr1[j] = arr1[j+1];
					arr1[j+1] = tmp;
				}
			}
		}
		*/
		
		for (int j = 0 ; j<arr1.length; j++) {
			System.out.print(arr1[j] + " ");
		}


	}
}
