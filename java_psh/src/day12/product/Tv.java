package day12.product;

public class Tv extends Product{
	private int screen;
	

	public Tv(String brand, String code, String name, int screen) {
		super(brand, code, name);
		this.screen = screen;
	}
	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println("화면크기 : "+screen);
	}
	public int getScreen() {
		return screen;
	}

	public void setScreen(int screen) {
		this.screen = screen;
	}
	

}
