package day09.board;

public class SwitchEx1 {

	public static void main(String[] args) {
	
		
		
		int arr[] = new int[] {0,1,2,3};
		int tmp[] = new int[arr.length-1];
		int deletenum =2;
		System.arraycopy(arr, 0, tmp, 0, deletenum);
		for(int tmp1:tmp) {
			System.out.print(tmp1 + " ");
		}
		System.out.println();
		System.arraycopy(arr, deletenum+1, tmp, deletenum,arr.length- deletenum-1);
		for(int tmp1:tmp) {
			System.out.print(tmp1 + " ");
		}

		
		//switch 문 안에 지역 변수를 선언하는 경우 발생할 수 있는 문제점
//		
//		for (int i = 0;i<5; i++){
//			System.out.print(i + " ");
//		}
//		System.out.println();
//		for (int i = 0;i<5; i++){
//			System.out.print(i + " ");
//		}
//		System.out.println();
//		
//		
//		int menu =1;
//		int num;
//		switch(menu) {
//		case 1:
//			//여기서 선언된 num가 break 문이 없으면 case 2까지
//			//갈 수 있기 때문에 여기서 선언된 num는 이후 switch
//			//아래 코드에서 사용 가능
//			num=10;
//			System.out.println(num);
//			break;
//		case 2:
//			//int num=20; 을 하면 위에서 선언된 num와 중복. 에러 발생
//			num=20;
//			System.out.println(num);
//			break;
//		}
	}

}
