package QuanLySinhVien_GiaoVien;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestTeacher {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int choose = 0;
		List<Teacher> listTeacher = new ArrayList<>();
		while (choose != 4) {
			showMenu();
			choose = input.nextInt();
			switch (choose) {
			case 1:
				inputTeacher(listTeacher);
				break;

			case 2:
				showInfoTeacher(listTeacher);
				break;

			case 3:
				showTeacherMaxSalary(listTeacher);
				break;

			case 4:
				System.out.println("Bạn vừa chọn thoát !");
				break;

			default:
				System.out.println("Bạn chọn sai , mời nhập lại !");
				break;
			}

		}

	}

	static void showMenu() {
		System.out.println("1. Nhập thông tin của n giảng viên : ");
		System.out.println("2. Hiển thị thông tin của các giảng viên");
		System.out.println("3. Hiển thị giảng viên có lương cao nhất");
		System.out.println("4. Thoát");
		System.out.println("Nhập lựa chọn của bạn : ");
	}

	static void inputTeacher(List<Teacher> list) {
		System.out.println("Nhập số lượng giảng viên : ");
		int n = input.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println("Nhâp thông tin của giảng viên thứ : " + (i + 1));
			Teacher t = new Teacher();
			t.inputInfo();
			list.add(t);
		}
	}

	static void showInfoTeacher(List<Teacher> list) {
		System.out.println("\nThông tin của tất cả giảng viên là : ");
		for (int i = 0; i < list.size(); i++) {
			System.out.println("Thông tin của giảng viên thứ : " + (i + 1));
			list.get(i).showInfo();
		}
	}

	static void showTeacherMaxSalary(List<Teacher> list) {
		System.out.println("Thông tin của giảng viên có lương cao nhất là : ");
		float max_luong = maxSalary(list);
		for (int i = 0; i < list.size(); i++) {
			if (max_luong == list.get(i).luong_thu_nhan()) {
				list.get(i).showInfo();
			}
		}
		System.out.println("Lương thực lãnh : " + max_luong);
	}

	static float maxSalary(List<Teacher> list) {
		float max_luong = list.get(0).luong_thu_nhan(); // gán max cho giá trị đầu tiên của mảng
		for (int i = 0; i < list.size(); i++) {
			if (max_luong < list.get(i).luong_thu_nhan()) {
				max_luong = list.get(i).luong_thu_nhan();
			}
		}
		return max_luong;
	}
}
