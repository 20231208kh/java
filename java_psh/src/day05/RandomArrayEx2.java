package day05;

public class RandomArrayEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int min = 1, max = 3;
		int arr1 [] = new int [3];
		int count = 0; // 배열에 저장된 중복되지 않은 수의 개수
		//배열에 중복되지 않은 수 3보다 작으면 반복
		while(count < 3 ) {
			//랜덤수 생성
			int r = (int)(Math.random()*(max - min +1) + min);
			//중복 확인
			boolean duplicated = false;
			for (int i =0; i< count; i++) {
				if (arr1[i]==r) {
					duplicated = true;
					break;
				}
			}
			
			//중복되지 않으면 저장 후 count 증가
			if(!duplicated) {
				arr1[count] = r;
				count ++;
			}
		}
	
		for (int i = 0 ; i<arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}

	}

}
