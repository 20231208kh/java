package day05;

public class EnhancedForLoopEx1 {

	public static void main(String[] args) {
		// 1부터 5까지 저장된 배열을 '향상된 for문'으로 출력하는 예제
		// 향상된 for문은 '전체 탐색' 할 때 사용, 특정 값만을 원할땐 사용 불가
		int arr[] = new int[] {1,2,3,4,5};
		
		//일반 for문을 이용한 배열 출력
		
		for (int i = 0 ; i<arr.length; i++) {
			int tmp = arr[i];
			System.out.print(tmp + " ");
		}
		System.out.println();
		
		//향상된 for 문을 이용한 배열 출력
		// for (타입 변수명 : 배열)
		for (int tmp : arr) {
			System.out.print(tmp + " ");
		}
		System.out.println();

	}

}
