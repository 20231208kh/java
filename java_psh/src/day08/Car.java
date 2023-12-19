package day08;

public class Car {
	double weight;
	String brand;
	String Color;
	String Name;
	int year;
	String category;
	String [] itres;
	int speed;
	boolean rightLight;
	boolean leftLight;
	boolean power;
	
	public void speedUp(){
		speed ++;
	}
	
	public void speedDown() {
		speed --;
	}
	public void turn() {
		power = true;
		System.out.println("시동이 켜졌습니다.");
	}
	
	// 위:우측 1, 가운데 0, 아래:좌측 -1
	public void turnLight(int direction) {
		switch(direction) {
		case 1: rightLight =true; leftLight = false; break;
		case -1: rightLight =false; leftLight = true; break;
		case 0: rightLight =false; leftLight = false; break;
		}
		
	}
	
	public void print() {
		System.out.println("----------------");
		System.out.println("시동 : " + power);
		System.out.println("속력 : " + speed);
		System.out.println("좌깜 : " + leftLight);
		System.out.println("우깜 : " + rightLight);
		System.out.println("----------------");
	}
}
