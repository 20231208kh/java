package day12.product;
import java.util.Scanner;
public class ProductMain {
	public static Scanner scan = new Scanner(System.in);
	public static int count =0;
	public static Product  [] productList = new Product[30] ;
	/* 제품을 추가하는 프로그램을 작성하세요.
	 * 제품은 TV, 에어컨, 컴퓨터만 추가 가능
	 * 공용 : 브랜드, 제품코드, 제품명
	 * tv : 화면크기
	 * 에어컨 : 냉방면적
	 * 노트북 : cpu,램
	 * 메뉴
	 * 1. 제품 추가
	 * 2. 제품 확인
	 * 3. 종료
	 * 메뉴 선택 : 1
	 * -----------
	 * 추가할 제품
	 * 1. TV
	 * 2. 에어컨
	 * 3. 노트북
	 * 제품 선택 : 1
	 * 브랜드 : 삼성
	 * 제품코드 : KWQE0WQ-1
	 * 제품 명 : 2023 ~~~~
	 * 화면크기(cm) : 189cm
	 * 등록이 완료됐습니다.
	 * -------------
	 * 메뉴
	 * 1. 제품 추가
	 * 2. 제품 확인
	 * 3. 종료
	 * 메뉴 선택 : 1
	 * -----------
	 * 추가할 제품
	 * 1.TV
	 * 2.에어컨
	 * 3.컴퓨터
	 * 제품 선택 : 2
	 * 브랜드 : 삼성
	 * 제품코드 : K124210
	 * 제품명 : 어쩌고저쩌고
	 * 냉방면적(m2) : 56.9
	 * 등록이 완료됐습니다.
	 */
	public static void main(String[] args) {
		int menu;
		do {
			mainMenu();
			menu=scan.nextInt();
			runMenu(menu);
			
		}while(menu!=3);

	}
	
	public static void runMenu(int menu) {
		int user;
		switch(menu) {
		case 1:
			subMenu();
			user = scan.nextInt();
			adding(user);
			break;
		case 2:
			searchProduct();
			break;
		case 3:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("잘못된 메뉴 선택");
		}
	}
	
	public static void searchProduct() {
		for(int i=0;i<count;i++) {
			productList[i].printInfo();
		}
		
	}

	//메인메뉴
	public static void mainMenu() {
		System.out.println("--메뉴--");
		System.out.println("1. 제품 추가");
		System.out.println("2. 제품 확인");
		System.out.println("3. 종료");
		System.out.print("메뉴 선택 : ");
	}
	//메뉴1선택 메뉴
	public static void subMenu() {
		System.out.println("--추가할 제품--");
		System.out.println("1. TV");
		System.out.println("2. 에어컨");
		System.out.println("3. 노트북");
		System.out.print("제품 선택 : ");
	}
	
	//제품 추가
	public static void adding(int user) {
		String brand,code,name,cpu,ram;
		int screen,coldRange;
		System.out.print("제품의 브랜드를 입력 : ");
		scan.nextLine();
		brand = scan.nextLine();
		System.out.print("제품의 코드를 입력 : ");
		code = scan.nextLine();
		System.out.print("제품의 이름을 입력 : ");
		name = scan.nextLine();
		switch(user){
		case 1:
			System.out.print("제품의 화면크기를 입력 : ");
			screen = scan.nextInt();
			productList[count++] = new Tv(brand,code,name,screen);
			System.out.println("등록 되었습니다.");
			break;
		case 2:
			System.out.print("제품의 냉방면적을 입력 : ");
			coldRange = scan.nextInt();
			productList[count++] = new AirConditioner(brand,code,name,coldRange);
			System.out.println("등록 되었습니다.");
			break;
		case 3:
			System.out.print("제품의 CPU를 입력 : ");
			cpu = scan.nextLine();
			System.out.print("제품의 RAM을 입력 : ");
			ram = scan.nextLine();
			productList[count++] = new Laptop (brand,code,name,cpu,ram);
			System.out.println("등록 되었습니다.");
			break;
		default :
			System.out.println("잘못된 메뉴 선택");	
		}
	}
}
