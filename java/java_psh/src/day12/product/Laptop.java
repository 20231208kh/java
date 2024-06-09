package day12.product;

public class Laptop extends Product {
	String cpu,ram;

	
	
	public Laptop(String brand, String code, String name, String cpu, String ram) {
		super(brand, code, name);
		this.cpu = cpu;
		this.ram = ram;
	}
	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println("CPU : "+cpu);
		System.out.println("RAM : "+ram);
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}
	

}
