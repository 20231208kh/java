package day11.product;

import java.util.Scanner;


public class ProductMain {
	public static Scanner scan = new Scanner(System.in);
	private static int buyCount = 0;
	private static int sellingCount =0;
	private static Product []productList = new Product[10];
	private static Product []sellingList = new Product[10];

	/*제품을 관리하는 프로그램을 구현하세요
	 *메뉴
	 * 1. 제품 입고
	 *  - 제품을 판매하기 위해 다른곳에서 제품을 구매
	 *  - 기존의 제품이 있으면 추가, 없으면 신규 구매
	 *    (반복문을 돌려서, 같은이름이 있으면 추가의 방식 없으면 신규 등록의 방식)
	 *    (뭔가 고유의 번호를 넣고, 같은이름이 들어올때마다 +1, 빠지면 -1)
	 *    (이 번호는 객체 고유의 번호이기때문에 static 보다는 생성자로 하는게 나을듯)
	 * 
	 * 2. 제품 판매
	 *  - 입고된 제품을 판매
	 *  - 
	 *  
	 * 3. 제품 수정[가격]
	 * 
	 * 
	 * 4. 매출 내역 조회
	 * 
	 * 
	 * 5. 종료
	 */
	public static void main(String[] args) {
		int menu;
		do {
			mainMenu();
			menu = scan.nextInt();
			runMenu(menu);
		}while(menu != 5);

	}
	
	
	/**
	 * @param runMenu 구동부
	 */
	public static void runMenu(int menu) {
		int user;
		switch(menu) {
		case 1:
			insertProduct();
			break;
		case 2:
			extractProduct();
			break;
		case 3:
			fixProductPrice();
			break;
		case 4:
			System.out.println("--매출 내역 조회--");
			System.out.println("1. 전체 매출 내역 조회");
			System.out.println("2. 일자별 매출 내역 조회");
			System.out.print("메뉴 선택 : ");
			user = scan.nextInt();
			if(user==1) {
				printSellingList();
			}else if(user==2) {
				System.out.println("--일자별 매출 내역 조회--");
				System.out.print("일자를 입력하세요 : ");
				String date = scan.next();
				printSellingListDate(date);
				
			}
			
			
			break;
		case 5:
			System.out.println("프로그램 종료");
			break;
		default :
			System.out.println("잘못된 메뉴 선택");
		}
		
	}
	
	/**
	 * @param insertProduct 제품 입고, 제품이 기존에 존재한다면 개수만 추가
	 */
	public static void insertProduct() {
			
		System.out.print("구매한 제품의 이름을 입력하세요 : ");
		String productName = scan.next();
		if (buyCount>0) {
			for(int i =0;i<buyCount;i++) {
				if(productList[i].getProductName().equals(productName)) {
				   System.out.print("기존에 있던 제품입니다. 몇개를 추가하실 건가요? : ");
				   int count = scan.nextInt();
				   productList[i].setCount(productList[i].getCount()+count);
				   productList[i].printInfo();
				   return;
				}
			}
		}
		System.out.print("제품을 구매한 가격을 입력하세요 : ");
		int price = scan.nextInt();
		System.out.print("구매한 제품의 개수를 입력하세요 : ");
		int count = scan.nextInt();
		//구매 일자 등록
		System.out.println("제품 구매 일자를 입력하세요 : ");
		String buyDate = scan.next();
		Product buyingProduct = new Product(productName,price,count,buyDate);
		productList[buyCount] =buyingProduct; 
		productList[buyCount].printInfo();
		++buyCount;
		if (buyCount>=productList.length) {
			expandArr(productList);
		}
	}
	/**
	 * @param expandArr 배열확장
	 */
	private static Product[] expandArr(Product[] List) {
		Product[] tmpList = new Product[productList.length +5];
		//새로 생성된 배열에 기존 배열을 복사
		System.arraycopy(productList, 0, tmpList, 0, List.length);
		//새로 생성된 배열을 boardList가 연결
		return tmpList;
		
	}
	
	public static void printing() {
		if (buyCount>0){
			for (int i =0; i<buyCount;i++) {
			productList[i].printInfo();}
		}
	}
	
	
	/**
	 * @param extractProduct 제품 출고
	 */
	public static void extractProduct() {
		printing();
		if (buyCount>0) {
			System.out.print("판매할 제품을 입력하세요 : ");
			String productName = scan.next();
			for (int i =0; i<buyCount;i++) {
				if(productList[i].getProductName().equals(productName)) {
					System.out.print("판매할 개수를 입력하세요 : ");
					int count = scan.nextInt();
					if (count <= productList[i].getCount())	{
						productList[i].setCount(productList[i].getCount()-count);
						System.out.print("판매할 가격을 입력하세요 : ");
						int sellprice = scan.nextInt();
						System.out.print("판매한 날짜를 입력하세요 : ");
						String sellDate = scan.next();
						productList[i].setSellDate(sellDate);
						System.out.println("판매 되었습니다. ");
						productList[i].updateSellInfo(productName,count,sellprice,sellDate);
						productList[i].sellingInfo();
						sellingList[sellingCount] = new Product(productList[i]);
						sellingCount++;
						return;
					}else {
						System.out.println("구매 개수보다 판매 개수가 많습니다.");
						return;
					}
				}
			}
			
		}
		System.out.println("판매할 제품이 없습니다.");
	}
	
	/**
	 *@param printSellingList 매출 내역 조회 
	 */
	
	private static void printSellingList() {
		for (int i =0; i<sellingCount;i++) {
			sellingList[i].sellingListInfo();
		}

		
	}
	private static void printSellingListDate(String date) {
		for(int i=0; i<sellingCount; i++) {
			if(date.equals(sellingList[i].getSellDate())) {
				System.out.println(sellingList[i].getSellDate());
				sellingList[i].sellingListInfo();
			}
	   }
	}


	/**
	 * @param fixProductPrice 제품 가격 수정
	 */
	private static void fixProductPrice() {
		if (buyCount>0) {
			System.out.print("가격을 수정할 제품 이름을 입력하세요 : ");
			String productName = scan.next();
			for(int i =0; i<productList.length;i++) {
				if(productName.equals(productList[i].getProductName())) {
					System.out.print("수정할 가격을 입력하세요 : ");
					int price = scan.nextInt();
					productList[i].setPrice(price);
					System.out.println("수정 되었습니다.");
					productList[i].printInfo();
					return;
				}
			}
		}
		System.out.println("수정할 제품이 없습니다.");
		
		
	}



	/**
	 * @param mainMenu 메인메뉴
	 */
	public static void mainMenu() {
		System.out.println("----메뉴----");
		System.out.println("1. 제품 입고");
		System.out.println("2. 제품 판매");
		System.out.println("3. 제품 수정");
		System.out.println("4. 매출 내역 조회");
		System.out.println("5. 종료");
		System.out.print("메뉴 선택 : ");
	}

}
