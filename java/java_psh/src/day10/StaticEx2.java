package day10;

public class StaticEx2 {

	public static void main(String[] args) {
		System.out.println(sum1(1,2));
		
		//System.out.println(sum2(1,2)); //에러발생
		
		//sum2 메서드는 static이 없기때문에 인스턴스를 만든 후 제어 가능
		StaticEx2 ex = new StaticEx2();
		System.out.println(ex.sum2(1, 2));

	}
	public static int sum1(int num1, int num2) {
		return num1+num2;
	}
	
	public int sum2(int num1, int num2) {
		return num1 + num2;
	}
	// 인스턴스(객체 메서드) : static이 안 붙어있기 때문
	// 인스턴스 메서드 안에서는 다른 인스턴스메서드 사용가능
	public void test() {
		System.out.println(sum1(1,2));
		System.out.println(sum2(1,2));
		
	}
}
