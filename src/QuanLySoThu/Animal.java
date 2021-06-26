package QuanLySoThu;

import java.util.Scanner;

public abstract class Animal {
	protected String name;
	protected int age;
	protected String description;
	static Scanner input = new Scanner(System.in);

	public Animal() {
	}

	public Animal(String name, int age, String description) {
		this.name = name;
		this.age = age;
		this.description = description;
	}

	// method
	abstract void showSound();
	public void input() {
		input.nextLine();
		System.out.println("Nhap name : ");
		setName(input.nextLine());
		System.out.println("Nhap age : ");
		setAge(input.nextInt());
		input.nextLine();
		System.out.println("Nhap description : ");
		setDescription(input.nextLine());
		
	}
	public void display() {
		System.out.println(toString());
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getDescription() {
		return description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + ", age=" + age + ", description=" + description + "]";
	}

}
