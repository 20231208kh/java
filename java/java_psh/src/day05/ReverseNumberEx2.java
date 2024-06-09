package day05;

import java.util.Scanner;

public class ReverseNumberEx2 {

	public static void main(String[] args) {
		// 거꾸로 출력 ver2 나머지 연산자 활용
		
		Scanner scan = new Scanner(System.in);
		int user = scan.nextInt();
		int arr [] = new int [10];
		int tmp = user;
		int count =0;
		
		System.out.print("입력 : " + tmp);
		
		// arr 배열에 tmp를 10으로 나눈 나머지 저장 (count번 인덱스에)
		// tmp 에 tmp를 10으로 나눈 몫 저장
		while(tmp != 0) {
			arr[count] = tmp%10;
			count ++;
			tmp = tmp/10;
		}
		
		System.out.println();
		System.out.print("출력 : ");
		for (int i=0 ; i < count; i++) {
			System.out.print(arr[i]);

			
			
		

	}

	}
}
