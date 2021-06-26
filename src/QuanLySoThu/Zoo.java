package QuanLySoThu;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
	List<Room> roomList;

	public Zoo() {
		roomList = new ArrayList<>();
	}

	// method
	public void showAllId() {
		System.out.println("Có tất cả : " + roomList.size() + " chuồng !");
		System.out.println("Danh sách Id các chuồng : ");
		for (Room room : roomList) {
			System.out.println("Id : " + room.getId());

		}
	}

	public void addAnimal(int roomNo, Animal animal) {
		boolean flag = false;
		for (Room room : roomList) {
			if (room.getId() == roomNo) {
				room.addAnimal(animal);
				flag = true;
			}
		}
		if (flag == false)
			System.out.println("Không tìm thấy mã chuồng " + roomNo + " để thêm !");
	}

	public void removeAnimal(int roomNo, String name) {
		boolean flag = false;
		for (Room room : roomList) {
			if (room.getId() == roomNo) {
				room.removeAnimal(name);
				System.out.println("Xoá thành công " + name);
				flag = true;
			}
		}
		if (flag == false)
			System.out.println("Không tìm thấy mã chuồng " + roomNo + " để xoá !");
	}

	public void addRoom(Room room) {
		roomList.add(room);
	}

	public void display() {
		for (Room room : roomList) {
			room.display();
		}
	}

	public void removeRoom(int ma_chuong) {
		boolean flag = false;
		for (int i = 0; i < roomList.size(); i++) {
			if (roomList.get(i).getId() == ma_chuong) {
				roomList.remove(i);
				System.out.println("Đã xoá thành công chuồng : "+ ma_chuong +" và tất cả các động vật của chuồng này");
				flag = true;
			}
		}
		if (flag == false)
			System.out.println("Không tìm thấy chuồng cần xoá !");
	}
}
