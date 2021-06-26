package QuanLySoThu;

import java.util.Scanner;

public class TestZoo {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Zoo zoo = new Zoo();
		int ma_chuong;
		boolean flag = true;
		do {
			showMenu();
			int choose = input.nextInt();
			switch (choose) {
			case 1:
				Room room = new Room();
				room.input();
				zoo.addRoom(room);
				break;
			case 2:
				System.out.println("Nhập mã chuồng cần xoá : ");
				ma_chuong = input.nextInt();
				zoo.removeRoom(ma_chuong);
				break;
			case 3:
				System.out.println("Nhập mã chuồng cần thêm động vật : ");
				ma_chuong = input.nextInt();
				Animal animal = Room.createAnimal();
				zoo.addAnimal(ma_chuong, animal);
				break;
			case 4:
				System.out.println("Nhâp mã chuồng cần xoá : ");
				ma_chuong = input.nextInt();
				input.nextLine();
				System.out.println("Nhập tên động vật cần xoá : ");
				String name = input.nextLine();
				zoo.removeAnimal(ma_chuong, name);
				break;

			case 5:
				zoo.display();
				break;

			case 6:
				zoo.showAllId();
				break;

			case 7:
				System.out.println("Bạn vừa chọn thoát !");
				flag = false;
				break;

			default:
				System.out.println("Bạn nhập sai . Mời nhập lại ");
				break;
			}
		} while (flag);

	}

	static void showMenu() {
		System.out.println("1. Thêm chuồng");
		System.out.println("2. Xoá chuồng");
		System.out.println("3. Thêm con vật");
		System.out.println("4. Xoá con vật");
		System.out.println("5. Xem tất cả con vật");
		System.out.println("6. Hiển thị tất cả các chuồng");
		System.out.println("7. Thoát");
		System.out.println("Nhập lựa chọn : ");
	}
}
