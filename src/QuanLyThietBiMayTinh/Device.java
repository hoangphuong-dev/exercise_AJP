package QuanLyThietBiMayTinh;

import java.util.Scanner;

public abstract class Device {
	protected int id;
	protected String name;
	protected String manufacturer; // người chế tạo
	protected String importedDate; // ngày nhập khẩu
	Scanner input = new Scanner(System.in);
	// constructor

	public Device() {
		super();
	}

	public Device(int id, String name, String manufacturer, String importedDate) {
		super();
		this.id = id;
		this.name = name;
		this.manufacturer = manufacturer;
		this.importedDate = importedDate;
	}

	// method
	abstract void input();

	abstract void display();

	public void inputInfo() {
		System.out.println("Nhập id : ");
		setId(input.nextInt());
		System.out.println("Nhap name : ");
		input.nextLine();
		setName(input.nextLine());
		System.out.println("Nhập nhà sản xuất : ");
		setManufacturer(input.nextLine());
		System.out.println("Nhập ngày nhập khẩu : ");
		setImportedDate(input.nextLine());
	}

	// set and get
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public String getImportedDate() {
		return importedDate;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public void setImportedDate(String importedDate) {
		this.importedDate = importedDate;
	}

	@Override
	public String toString() {
		return "Device [id=" + id + ", name=" + name + ", manufacturer=" + manufacturer + ", importedDate="
				+ importedDate + "]";
	}

}
