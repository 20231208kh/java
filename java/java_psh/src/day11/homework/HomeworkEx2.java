package day11.homework;
import java.util.Scanner;
public class HomeworkEx2 {

	public static void main(String[] args) {
		// 두 정수와 산술 연산자를 입력받아 결과를 출력하는 코드를 작성하세요.
		Scanner scan = new Scanner(System.in);
		System.out.print("숫자 1 입력 : ");
		int num1 = scan.nextInt();
		System.out.print("숫자 2 입력 : ");
		int num2 = scan.nextInt();
		System.out.print("산술 연산자 입력 : ");
		String code = scan.next();
		
		calculate(num1,num2,code);
		
	}

	
	public static void calculate(int num1, int num2, String code) {
		if (code.equals("+")) {
			System.out.println(num1+" + "+num2+" = "+(num1+num2));
		} else if(code.equals("-")) {
			System.out.println(num1+" - "+num2+" = "+(num1-num2));
		} else if(code.equals("*")) {
			System.out.println(num1+" * "+num2+" = "+(num1*num2));
		} else if(code.equals("/")) {
			System.out.println(num1+" / "+num2+" = "+(num1/num2));
		}
	}
}
