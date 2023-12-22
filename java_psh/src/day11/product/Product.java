package day11.product;

public class Product {

	
	private String productName,sellproductName,buyDate,sellDate;
	private int price,money,count,sellprice,buyprice,profit,cost,sellcount,check;
	
	public Product(String productName, int price,int count,String buyDate) {
		super();
		this.productName = productName;
		this.price = price;
		this.count = count;
		this.buyDate = buyDate;
		this.cost = price*count;
	}
	
	
	
	public String getBuyDate() {
		return buyDate;
	}



	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}



	public String getSellDate() {
		return sellDate;
	}



	public void setSellDate(String sellDate) {
		this.sellDate = sellDate;
	}



	//복사 생성자
	public Product(Product product) {
		this.price = product.price;
		this.sellproductName = product.sellproductName;
		this.sellprice = product.sellprice;
		this.sellcount = product.sellcount;
		this.sellDate = product.sellDate;
	}
	
	public String getSellproductName() {
		return sellproductName;
	}



	public void setSellproductName(String sellproductName) {
		this.sellproductName = sellproductName;
	}


	public void updateSellInfo(String productName,int sellCount, int sellPrice,String date) {
		this.sellproductName = productName;
		this.sellcount = sellCount;
		this.sellprice = sellPrice;
		this.sellDate = date;
	}







	public int getSellcount() {
		return sellcount;
	}



	public void setSellcount(int sellcount) {
		this.sellcount = sellcount;
	}



	public void sellingProduct(int count) {
		money += sellprice * count;
	}
	
	public void sellingListInfo() {
		System.out.println("판매한 제품 : "+sellproductName);
		System.out.println("판매 개수 : "+sellcount+"개");
		System.out.println("판매했을 때 한 개당 가격 : "+sellprice+"원");
		System.out.println("구매했을 때 한 개당 가격 : "+price+"원");
		
	}
	
	
	public void sell(int sellprice){
		this.sellprice = sellprice;
	}
	
	public void printInfo() {
		System.out.println("---물품 정보---");
		System.out.println("제품명 : "+ productName);
		System.out.println("한 개당 가격 : "+price+"원");
		System.out.println("구매한 개수 : "+count+"개");
		System.out.println("구매한 날짜 : "+buyDate);
	}
	
	public void sellingInfo() {
		System.out.println("---판매 정보---");
		System.out.println("제품명 : "+ productName);
		System.out.println("한 개당 가격 : "+sellprice+"원");
		System.out.println("판매한 개수 : "+sellcount+"개");
		System.out.println("판매한 날짜 : "+sellDate);
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public int getCount() {
		return count;
	}
	
	
	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	
	
	
	
	
}
