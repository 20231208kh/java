package day12;

public class PolymorphismEx1 {

	public static void main(String[] args) {
		/* 다형성 예제
		 * 1. 매개변수의 다형성
		 */
		
		Remocon r = new Remocon();
		Tv tv = new Tv();
		AirConditioner aircon = new AirConditioner();
		r.turnOn(tv);
		r.turnOn(aircon);

	}

}

class Remocon{
	
	/*
	void turnOn(Tv target) {
		System.out.println("제품이 켜졌습니다.");
	}
	void turnOn(AirConditioner Target) {
		System.out.println("제품이 켜졌습니다. ");
	}
	*/
	
	/*
	 * 매개변수의 다형성을 이용하여 turnOn 메서드를 
	 * 1개만 생성
	 */
	void turnOn(ElectronicProduct target) {
		if (target instanceof Tv) {
			System.out.println("Tv ");
		}else if(target instanceof AirConditioner) {
			System.out.println("에어컨");
		}else {
			System.out.println("전자 ");
		}
		System.out.println("제품이 켜졌습니다.");
	}
}

//전자제품
class ElectronicProduct{
	
}

class Tv extends ElectronicProduct{
	
}


class AirConditioner extends ElectronicProduct{
	
}