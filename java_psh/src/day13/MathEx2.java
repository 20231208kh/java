package day13;

public class MathEx2 {

	public static void main(String[] args) {
		double num=1.234567;
		//주어진 실수의 소수점 n자리에서 올림한 값을 출력하는 코드를 작성하세요
		for(int i=2; i<7;i++) {
			ceil(num,i);
		}
		
		
	}
	
	public static void ceil(double num,int n) {
		double result = num*Math.pow(10, n-1);
		result = Math.ceil(result);
		result = result/Math.pow(10, n-1);
		System.out.println(result);
	}

}
