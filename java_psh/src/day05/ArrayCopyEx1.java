package day05;

public class ArrayCopyEx1 {

	public static void main(String[] args) {
		// 배열 복사 예제
		int [] arr1 = new int[] {1,2,3,4,5};
		//arr2는 복사가 아닌 공유, = 로 배열 복사 하는 경우
		//복사가 아닌 공유기 때문에 값의 업데이트를 안해도 원본이 바뀐걸 따라가는듯
		int arr2 [] = arr1;
		int arr3 [] = new int [arr1.length];
		int arr4 [] = new int [arr1.length];
		int arr5 [] = new int [arr1.length];
		
		// 반복문을 이용하여 arr1에 있는 값들을 arr3에 복사
		for(int i =0; i<arr1.length; i++) {
			arr3[i] = arr1[i];
		}
		//arraycopy(누구를,몇부터,어디로,몇부터(받는쪽),몇개를)
		//System.arraycopy를 이용하여 arr1을 arr4에 전체 복사
		System.arraycopy(arr1, 0, arr4, 0,arr1.length);
		//arr1의 내용이 바뀌면 arr2도 같이 바뀜
		arr1[0]=10;
		
		//arr2의 0번인덱스 내용이 10으로 출력되는걸 확인
		for (int i = 0; i<5; i++) {
			System.out.println(arr2[i]);
		}
		System.out.print("arr3 확인 : ");
		//arr3의 내용을 확인, 내용의 변화가 없음
		for (int i = 0; i<5; i++) {
			System.out.print(arr3[i]);
		}
		
		System.out.print("\narr4 확인 : ");
		//arr4의 내용을 확인
		for (int i = 0; i<5; i++) {
			System.out.print(arr4[i]);
		}
		//arr1 배열에 1번 인덱스부터 2개를 복사해서 arr5배열에 0번인덱스부터 덮어씀
		System.arraycopy(arr1, 1, arr5, 0, 2);
		
		System.out.print("\narr5 확인 : ");
		for (int i = 0; i<5; i++) {
			System.out.print(arr5[i]);
		}

	}

}
