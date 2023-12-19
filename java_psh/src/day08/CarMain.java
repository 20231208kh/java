package day08;
import java.util.Scanner;
public class CarMain {

	public static void main(String[] args) {
		/* Car : 클래스명
		 * car : 인스턴스명
		 * new : 인스턴스를 생성하는 연산자
		 * Car() : 생성자. 멤버변수를 초기화
		 */
		Car car = new Car();
		/* Scanner : 클래스명
		 * scan : 인스턴스명
		 * Scanner(System.in) : 표준 입력을 이용하여 초기화 하는 생성자
		 * Scanner("123\nabc") : 문자열을 이용하여 초기화 하는 생성자
		 */
		
		Scanner scan = new Scanner(System.in);
		car.turn();
		car.print();
		car.turnLight(-1);
		car.print();
		car.turnLight(1);
		car.print();
		car.turnLight(0);
		car.print();
		for (int i =0; i <10; i++) {
			car.speedUp();
		}
		car.print();
		for (int i =0; i <10; i++) {
			car.speedDown();
		}
		car.print();

	}

}
