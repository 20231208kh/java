package day12.product;

public class Product {
	protected String brand,code,name;
	

	public Product(String brand, String code, String name) {
		super();
		this.brand = brand;
		this.code = code;
		this.name = name;
	}
	
	public void printInfo() {
		System.out.println("----------");
		System.out.println("브랜드 : "+brand);
		System.out.println("제품코드 : "+code);
		System.out.println("제품명 : "+name);
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
