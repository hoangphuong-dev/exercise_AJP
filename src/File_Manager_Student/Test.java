package File_Manager_Student;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 Viết chương trình quản lý sinh viên. Mỗi đối tượng sinh viên có các thuộc tính sau: 
 id, name, age, address và gpa (điểm trung bình). 
 Yêu cầu: tạo ra một menu với các chức năng sau: 
	1. Add student.
	2. Edit student by id.
	3. Delete student by id.
	4. Sort student by gpa.
	5. Sort student by name.
	6. Show student.
	7. Lưu thông tin sv vào file student.txt
	8. Đọc thông tin sv từ file student.txt và hiển thị ra màn hình
	0. Exit.
*/
public class Test {
	public static void main(String[] args) {
		int choose;
		boolean flag = true;
		Scanner input = new Scanner(System.in);
		List<Student> list = new ArrayList<>();
		do {
			showMenu();
			System.out.println("You choose : ");
			choose = input.nextInt();
			switch (choose) {
			case 1: {
				System.out.println("Nhap so sinh vien can them : ");
				int n = input.nextInt();
				for (int i = 0; i < n; i++) {
					System.out.println("Nhap thong tin sinh vien thu : " + (i + 1));
					Student st = new Student();
					st.inputInfo();

					list.add(st);
				}
				break;
			}

			case 2: {
				System.out.println("Nhap id sinh viên cần sửa : ");
				int idEdit = input.nextInt();
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getId() == idEdit) {
						list.get(i).edit();
						break;
					}
				}
				break;
			}

			case 3: {
				System.out.println("Nhap id sinh viên cần xoá : ");
				int idDelete = input.nextInt();
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getId() == idDelete) {
						list.remove(i);
						break;
					}
				}
				break;
			}

			case 4: {
				Collections.sort(list, (o1, o2) -> {
					if (o1.getGpa() < o2.getGpa()) {
						return -1;
					}
					return 1;
				});
				// in ra thông tin sau khi sắp xếp
				Student.displayHeader();
				for (int i = 0; i < list.size(); i++) {
					list.get(i).display();
				}
				break;
			}

			case 5: {
				Collections.sort(list, (o1, o2) -> o1.getName().compareTo(o2.getName()));
				// in ra thông tin sau khi sắp xếp
				Student.displayHeader();
				for (int i = 0; i < list.size(); i++) {
					list.get(i).display();
				}
				break;
			}

			case 6: {
				Student.displayHeader();
				for (int i = 0; i < list.size(); i++) {
					list.get(i).display();
				}
				break;
			}

			case 7: {
				FileOutputStream fos = null;
				ObjectOutputStream oos = null;
				try {
					fos = new FileOutputStream("D:/DataForAJP/student.dat");
					oos = new ObjectOutputStream(fos);

					oos.writeObject(list);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						if (fos != null)
							fos.close();
						if (oos != null)
							oos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					System.out.println("Written file sucess ... ");
				}
				break;
			}

			case 8: {
				List<Student> list_demo = null;
				FileInputStream fis = null;
				ObjectInputStream ois = null;
				try {
					fis = new FileInputStream("D:/DataForAJP/student.dat");
					ois = new ObjectInputStream(fis);

					list_demo = (List<Student>) ois.readObject();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						if (fis != null)
							fis.close();
						if (ois != null)
							ois.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Data from file : ");
				Student.displayHeader();
				for (int i = 0; i < list_demo.size(); i++) {
					list_demo.get(i).display();
				}

				break;
			}

			case 0: {
				System.out.println("You choose exit !");
				flag = false;
				break;
			}

			default:
				System.out.println("Invalid selection !");
				break;
			}
		} while (flag);

	}

	static void showMenu() {
		System.out.println("\n1. Add Student");
		System.out.println("2. Edit student by id");
		System.out.println("3. Delete student by id");
		System.out.println("4. Sort student by gpa");
		System.out.println("5. Sort student by name");
		System.out.println("6. Show student");
		System.out.println("7. Save student information to file : student.txt");
		System.out.println("8. Read student information from file (student.txt) and display it on the screen ");
		System.out.println("0. Exit");
	}
}
