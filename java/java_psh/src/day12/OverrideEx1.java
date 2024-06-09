package day12;

public class OverrideEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		D d = new D();
		//print1()은 접근 제어자가 protected 이기 때문에 같은 패키지에서는 실행 되지만,
		//다른 패키지에서는 실행이 안됨
		d.print1();//오버라이딩을 이용하여 재정의된 메서드가 호출
		System.out.println("------");
		d.print2();//오버라이딩을 이용하여 재 정의된 메서드가 호출
		System.out.println("------");
		d.print1(20);//오버로딩을 이용하여 추가된 메서드가 호출
	}

}

class C{
	protected int num1 =1, num2= 2;
	protected void print1() {
		System.out.println(num1);
		System.out.println(num2);
	}
	public void print2() {
		System.out.println(num1);
		System.out.println(num2);
	}
}

class D extends C{
	
	@Override
	/*
	 * 1. 해당 메서드에 매개변수가 부모 클래스에는 없음
	 * 2. 부모 클래스에서는 접근제어자가 protected였는데 여기선 default (protected > default)
	void print1(int num1) {
	}
	*/
	protected void print1() {
		System.out.println("num1 : "+num1);
		System.out.println("num2 : "+num2);
	}
	
	//메서드 오버 로드에 의해 print1 메서드를 추가, 오버라이딩 아님
	public void print1(int num1) {
		System.out.println("num1 : "+num1);
		System.out.println("num2 : "+num2);
	}
	public void print2() {
		super.print2();
		System.out.println("B 클래스의 메서드 입니다.");
	}
}