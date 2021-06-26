package QuanLyThietBiMayTinh;

import java.util.Scanner;

public class Computer extends Device {
	private String cpu;
	private String ram;
	Scanner input = new Scanner(System.in);

	public Computer() {
	}

	public Computer(Integer id, String name, String manufacturer, String importedDate, String cpu, String ram) {
		super(id, name, manufacturer, importedDate);
		this.cpu = cpu;
		this.ram = ram;
	}

	@Override
	void input() {
		super.inputInfo();
		System.out.println("Nhập CPU : ");
		setCpu(input.nextLine());
		System.out.println("Nhập Ram : ");
		setRam(input.nextLine());
	}

	@Override
	void display() {
		System.out.println(super.toString());
		System.out.println(toString());

	}

	public String getCpu() {
		return cpu;
	}

	public String getRam() {
		return ram;
	}

	public Scanner getInput() {
		return input;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public void setInput(Scanner input) {
		this.input = input;
	}

	@Override
	public String toString() {
		return "Computer [cpu=" + cpu + ", ram=" + ram + "]";
	}

}
