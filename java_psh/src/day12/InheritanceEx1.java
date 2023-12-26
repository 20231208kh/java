package day12;

public class InheritanceEx1 {

	public static void main(String[] args) {
		/* 상속 예제 */
		Car c1 = new Car("K3","기아",4);
		c1.print();
		
		KiaCar k1 = new KiaCar("레이",4);
		k1.brand = "기아";
		k1.name = "레이";
		k1.print();
		
		HyundaiCar h1 = new HyundaiCar("아반떼",4);
		h1.brand = "현대";
		h1.name = "아반떼";
		h1.print();

	}

}


class Car{
	String name,brand;
	int wheelCount;//바퀴수
	boolean power;
	int speed;
	
	void turn() {
		power =! power;
	}
	
	void speed(int speed) {
		this.speed += speed;
	}

	public Car(String name, String brand, int wheelCount) {
		super();
		this.name = name;
		this.brand = brand;
		this.wheelCount = wheelCount;
	}
	
	public Car() {}
	public void print() {
		System.out.println("회사 : " +brand);
		System.out.println("차명 : " +name);
	}
	
	
}

//기아차 : 기아자동차는 자동차이다

class KiaCar extends Car{
	//상속을 할 때, 부모클래스의 기본 생성자가 없는경우
	//super()안에 부모클래스의 생성자를 호출해야한다.
	//기본 생성자가 있다면 super()을 생략해도 자동으로 부모클래스의 기본생성자를 불러온다.
	public KiaCar(String name, int wheelCount) {
		/*brand = "기아";
		this.name = name;
		this.wheelCount =wheelcount;
		*/
		super(name,"기아",wheelCount);
	}
		
}

//현대차 : 현대자동차는 자동차이다
class HyundaiCar extends Car{
	public HyundaiCar(String name, int wheelCount) {
		/*brand = "현대";
		this.name = name;
		this.wheelCount =wheelcount;
		*/
		super(name,"현대",wheelCount);
	}
		
	
}