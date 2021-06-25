package QuanLySinhVien_GiaoVien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TestStudent {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int choose = 0;
		List<Student> studentList = new ArrayList<>();
		while (choose != 7) {
			showMenu();
			choose = input.nextInt();
			switch (choose) {
			case 1:
				inputStudent(studentList);
				break;
			case 2:
				showInfo(studentList);
				break;
			case 3:
				showInfo_max_min(studentList);
				break;
			case 4:
				searchById(studentList);
				break;
			case 5:
				sorfByName(studentList);
				break;
			case 6:
				showStuden_hoc_bong(studentList);
				break;
			case 7:
				System.out.println("Ban chon thoat !");
				break;

			default:
				System.out.println("Ban nhap sai . Moi nhap lai !");
				break;
			}

		}

	}

	static void showMenu() {
		System.out.println("1. Nhap vao n sinh vien ");
		System.out.println("2. Hien thi thong tin sinh vien");
		System.out.println("3. Hien thi sinh vien co diem trung binh cao nhat và thap nhat ");
		System.out.println("4. Tim kiem sinh vien theo ma sinh vien");
		System.out.println("5. Hien thi sinh vien sap xep a-z theo ten");
		System.out.println("6. Hien thi sinh vien duoc hoc bong (sap xep cao den thap)");
		System.out.println("7. Thoat");
		System.out.println("Moi ban chon : ");
	}

	static void inputStudent(List<Student> list) {
		System.out.println("Nhap so luong sinh vien : ");
		int n = input.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println("Nhap thong tin sinh vien thu " + (i + 1));
			Student std = new Student();
			std.inputInfo();
			list.add(std);
		}
	}

	static void showInfo(List<Student> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println("\nThong tin sinh vien thu " + (i + 1));
			list.get(i).showInfo();
		}
	}

	static void showInfo_max_min(List<Student> list) {
		float max_avgMark = max_avgMarks(list);
		float min_avgMark = min_avgMarks(list);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getAvg_mark() == max_avgMark) {
				System.out.println("Thong tin sv co DTB cao nhat : ");
				list.get(i).showInfo();
			}
			if (list.get(i).getAvg_mark() == min_avgMark) {
				System.out.println("Thong tin sv co DTB thap nhat la : ");
				list.get(i).showInfo();
			}
		}
	}

	static void searchById(List<Student> list) {
		input.nextLine();
		int count = 0;
		System.out.println("Nhap ma sinh vien can tim : ");
		String id = input.nextLine();
		for (int i = 0; i < list.size(); i++) {
			if (id.equals(list.get(i).getId_student())) {
				list.get(i).showInfo();
				count ++;
			}
		}
		if(count == 0) System.out.println("Khong thay sinh vien co ma : " + id);
	}

	static void sorfByName(List<Student> list) {
		System.out.println("Thong tin sv sap xep theo ten la : ");
		Collections.sort(list, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		showInfo(list);
	}

	static void showStuden_hoc_bong(List<Student> list_student) {
		List<Student> list_hoc_bong = new ArrayList<>();
		for (int i = 0; i < list_student.size(); i++) {
			if (list_student.get(i).check_hoc_bong()) {
				list_hoc_bong.add(list_student.get(i));
			}
		}
		showInfo(list_hoc_bong);
	}

	static float max_avgMarks(List<Student> list) {
		float max = list.get(0).getAvg_mark();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getAvg_mark() > max) {
				max = list.get(i).getAvg_mark();
			}
		}
		return max;
	}

	static float min_avgMarks(List<Student> list) {
		float min = list.get(0).getAvg_mark();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getAvg_mark() < min) {
				min = list.get(i).getAvg_mark();
			}
		}
		return min;
	}
}
