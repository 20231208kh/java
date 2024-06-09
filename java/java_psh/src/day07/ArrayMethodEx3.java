package day07;

public class ArrayMethodEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr1 = new int[5];
		initArray1(arr1);
		printArray(arr1);
		
		System.out.println();
		
		int [] arr2 = new int[5];
		initArray2(arr2);
		printArray(arr2);
		
		System.out.println();
		
		int[] arr3 = initArray3(5);
		printArray(arr3);

	}
	
	/* 기능 : 정수 배열에 1부터 순차적으로 저장하는 메서드 (잘못된 메서드)
	 * 매개변수 : 정수 배열 => int [] arr
	 * 리턴타입 : 없음 = void
	 * 메서드명 : initArray1
	 */
	public static void printArray(int[]arr) {
		for(int tmp : arr) {
			System.out.print(tmp + " ");
		}
	}
	public static void initArray1(int[]arr) {
		//arr =new int[10] 을 지우면 됨, 메서드 안에서 새로 선언한 것이 문제
		arr = new int[10];
		for(int i =0; i< arr.length; i++) {
			arr[i] =i+1;
		}
	}
	/* 기능 : 정수 배열에 1부터 순차적으로 저장하는 메서드(올바른 메서드)
	 * 매개변수 : 정수 배열 => int [] arr
	 * 리턴타입 : 없음 = void
	 * 메서드명 : initArray2
	 */
	public static void initArray2(int[]arr) {
		//1번 메소드에서 배열 초기화를 지운 메소드, 올바르게 작동
		for(int i =0; i< arr.length; i++) {
			arr[i] =i+1;
		}
	}
	/* 기능 : 정수가 주어지면 정수 크기에 배열을 생성하고, 배열에 1부터 순차적으로 저장하여 만들어진
	 * 		 배열을 메서드 알려주는 (다른 메서드)
	 * 매개변수 : 정수 => int length
	 * 리턴타입 : 생성된 배열 = > int []
	 * 메서드명 : initArray3
	 */
	public static int[] initArray3(int length) {
		int arr1[] = new int[length];
		for (int i=0;i<arr1.length;i++) {
			arr1[i] = i+1;
		}
		return arr1;
		
	}

}
