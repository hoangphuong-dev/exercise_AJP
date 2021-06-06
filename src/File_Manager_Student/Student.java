package File_Manager_Student;

import java.util.Scanner;
import java.io.Serializable;
/*
 Khi dùng Scanner thì không thể implements được . Có 2 cách để xử lí vẫn đề này 
 -   1 : Sửa khai báo biến Scanner bằng cách thêm từ khóa transient (tạm thời). 
 	Nó sẽ thông báo cái biến Scanner đó sẽ không được Serialization

   private transient Scanner input;
2 : Đơn giản hơn là chỉ dùng nó như 1 biến local
 */

public class Student implements Serializable {
	transient Scanner input = new Scanner(System.in);
	private int id;
	private String name;
	private int age;
	private String address;
	private float gpa;

	public Student() {
	}

	public Student(int id, String name, int age, String address, float gpa) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.gpa = gpa;
	}

	// method
	public void inputInfo() {
		System.out.println("Nhap id : ");
		setId(input.nextInt());
		edit();

	}

	public void edit() {
		input.nextLine();
		System.out.println("Nhap name : ");
		setName(input.nextLine());
		System.out.println("Nhap age : ");
		setAge(input.nextInt());
		input.nextLine();
		System.out.println("Nhap address : ");
		setAddress(input.nextLine());
		System.out.println("Nhap gpa : ");
		setGpa(input.nextFloat());
	}

	static void displayHeader() {
		System.out.println(String.format("%10s %10s %10s %10s %10s %10s %30s %10s %10s", "ID", "|", "Name", "|", "Age",
				"|", "Adress", "|", "GPA"));
		System.out.println(String.format("%s",
				"-------------------------------------------------------------------------------------------------------------------------"));
	}

	public void display() {
		System.out.println(String.format("%10d %10s %10s %10s %10d %10s %30s %10s %10.2f", getId(), "|", getName(), "|",
				getAge(), "|", getAddress(), "|", getGpa()));
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getAddress() {
		return address;
	}

	public float getGpa() {
		return gpa;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setGpa(float gpa) {
		this.gpa = gpa;
	}

}
