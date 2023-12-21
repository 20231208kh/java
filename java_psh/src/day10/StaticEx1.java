package day10;

public class StaticEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KiaCar c1 = new KiaCar("모닝");
	}

}

class KiaCar{
	public static String brand ="KIA";
	public String name;
	
	public KiaCar(String name) {
		super();
		this.name = name;
	}
	
	
}
