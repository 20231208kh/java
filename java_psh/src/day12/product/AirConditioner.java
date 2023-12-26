package day12.product;

public class AirConditioner extends Product{
	private int coldRange;

	
	public AirConditioner(String brand, String code, String name, int coldRange) {
		super(brand, code, name);
		this.coldRange = coldRange;
	}
	
	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println("냉방면적 : "+coldRange);
	}

	public int getColdRange() {
		return coldRange;
	}

	public void setColdRange(int coldRange) {
		this.coldRange = coldRange;
	}
	
	

}
