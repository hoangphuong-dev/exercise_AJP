package QuanLySinhVien_GiaoVien;

import java.util.Scanner;

public class Person {
	protected String name;
	protected String dOb;
	protected String address;
	static Scanner input = new Scanner(System.in);
	// mcontructor
	public Person() {
	}

	public Person(String name, String dOb, String address) {
		this.name = name;
		this.dOb = dOb;
		this.address = address;
	}
	// method 
	public void inputInfo() {
		System.out.println("Nhap name : ");
		setName(input.nextLine());
		System.out.println("Nhap ngay sinh : ");
		setdOb(input.nextLine());
		System.out.println("Nhap dia chi : ");
		setAddress(input.nextLine());
	}
	public void showInfo() {
		System.out.println("Name : " + getName());
		System.out.println("DateOfBrith : " + getdOb());
		System.out.println("Address : " + getAddress());
	}
 	// setter and getter
	public String getName() {
		return name;
	}

	public String getdOb() {
		return dOb;
	}

	public String getAddress() {
		return address;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setdOb(String dOb) {
		this.dOb = dOb;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
