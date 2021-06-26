package QuanLyThietBiMayTinh;

import java.util.Iterator;
import java.util.Scanner;

public class Test {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int choose = 0;
		Device[] list = new Device[5];
		while (choose != 5) {
			showMenu();
			choose = input.nextInt();
			switch (choose) {
			case 1:
				int index = 0;
				while (index < 5) {
					System.out.println("Bạn cần nhập thiết bị nào : ");
					System.out.println("1. Computer");
					System.out.println("2. Moniter");
					int select = input.nextInt();
					if (select == 1) {
						Computer computer = new Computer();
						computer.input();
						list[index] = computer;
					} else {
						Monitor monitor = new Monitor();
						monitor.input();
						list[index] = monitor;
					}
					index++;
					if (index == 5)
						System.out.println("Kết thúc nhập !");
				}
				break;

			case 2:
				for (Device device : list) {
					device.display();
				}
				break;
			case 3:
				int countComputer = 0;
				for (Device device : list) {
					if (device instanceof Computer)
						countComputer++;
				}
				System.out.println("Số computer được nhập vào là : " + countComputer);
				break;
			case 4:
				int countMoniter = 0;
				for (Device device : list) {
					if (device instanceof Monitor)
						countMoniter++;
				}
				System.out.println("Số moniter được nhập vào là : " + countMoniter);
				break;
			case 5:
				System.out.println("Bạn vừa chọn thoát !");
				break;
			default:
				System.out.println("Bạn chọn sai .. Mời nhập lại !");
				break;
			}

		}

	}

	static void showMenu() {
		System.out.println("1. Nhập thông tin thiết bị");
		System.out.println("2. Hiển thị thông tin thiết bị");
		System.out.println("3. Hiển thị số computer được nhập vào");
		System.out.println("4. Hiển thị số Monitor được nhập vào");
		System.out.println("5. Thoát");
		System.out.println("Mời bạn chọn : ");
	}
}
