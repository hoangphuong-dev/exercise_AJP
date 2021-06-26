package QuanLySoThu;

import java.util.ArrayList;
import java.util.List;

public class Room {
	private int id;
	List<Animal> animalList;

	// constructor
	public Room() {
		this.animalList = new ArrayList<>();
	}

	public Room(int id, List<Animal> animalList) {
		this.id = id;
		this.animalList = animalList;
	}

	// method
	public void input() {
		System.out.println("Nhập mã chuồng : ");
		id = Animal.input.nextInt();
	}

	public void display() {
		System.out.println("Ma chuong : " + id);
		for (Animal animal : animalList) {
			animal.display();
			animal.showSound();
		}
	}
	

	public static Animal createAnimal() {
		Animal animal;
		System.out.println("Chọn động vật cần thêm ");
		System.out.println("1. Tạo Tiger");
		System.out.println("2. Tạo Dog");
		System.out.println("3. Tạo Cat");
		System.out.println("Bạn chọn : ");
		int choose = Animal.input.nextInt();
		switch (choose) {
		case 1:
			animal = new Tiger();
			break;

		case 2:
			animal = new Dog();
			break;

		default:
			animal = new Cat();
			break;
		}
		animal.input();
		return animal;
	}

	public void addAnimal(Animal abc) {
		animalList.add(abc);
	}

	public void removeAnimal(String name) {
		for (int i = 0; i < animalList.size(); i++) {
			if (name.equals(animalList.get(i).getName())) {
				animalList.remove(i);
			}
		}
	}

	// set and get
	public int getId() {
		return id;
	}

	public List<Animal> getAnimalList() {
		return animalList;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAnimalList(List<Animal> animalList) {
		this.animalList = animalList;
	}

}
