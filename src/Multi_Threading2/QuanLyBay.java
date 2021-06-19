package Multi_Threading2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/*
 Tạo một class VeMayBay có các thuộc tính sau : 
 mã chuyến bay, tên chuyến bay, ngày bay, hành lý kí gửi, giá vé 
 Mã vé được nhập vào cho 3 hãng bay hiện có ở Việt Nam, theo các quy ước sau : 
 VJABB : Là mã chuyến bay của VietJetAir, trong đó A(0-9) , BB(0-9)
 VNABBC : VietNam Airline , A(1-9), B(0-9), C(0-9) và C có thể có hoặc không
 JETABB : JetStar A(0-9) B(0-9)
 
  Tạo đầy đủ các contructor , các phương thức set/get và toString cho lớp 
  
 Tạo lớp QuanLyBay có hàm main và thực hiện các công việc sau : 
 - Nhập vào thông tin cho n chuyến bay với mã chuyến bay quy ước như trên 
 Lưu thông tin vừa nhập vào file DuLieuBay.txt
 Đọc thông tin từ DuLieuBay và hiển thị ra màn hình 
 Hiển thị thông tin sau khi đã sp xếp giảm dần theo giá vé
 in ra thông tin của mỗi hãng bay ra một file tương ứng
 */
public class QuanLyBay {

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		boolean flag = true;
		List<VeMayBay> list = new ArrayList<>();
		do {
			showMenu();
			int choose = input.nextInt();
			switch (choose) {
			case 1:
				inputData(list);
				break;

			case 2:
				save(list, "D:/DataForAJP/dulieubay.dat");
				System.out.println("Save file success !");
				break;

			case 3:
				System.out.println("Dữ liệu lấy ra từ file là : ");
				list = readData("D:/DataForAJP/dulieubay.dat");
				displayArrayList(list);
				break;

			case 4:
				soft(list);
				break;

			case 5:
				saveByAirline(list);
				System.out.println("Save files success !");
				break;

			case 6:
				displayByAirLine();
				break;

			case 7:
				System.out.println("You choosed exit !");
				flag = false;
				break;

			default:
				System.out.println("Your choose fail . You choose again !");
				break;
			}
		} while (flag);

	}

	static void inputData(List<VeMayBay> list) {
		System.out.println("Nhập số vé máy bay : ");
		int n = input.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println("Nhap ve so " + (i+1) + " :");
			VeMayBay vmb = new VeMayBay();
			vmb.input();
			list.add(vmb);
		}
	}

	// 2 lưu thông tin vừa nhập vào file : dulieubay.dat
	static void save(List<VeMayBay> list, String fileName) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);

			oos.writeObject(list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
				if (oos != null) {
					oos.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// 3 đọc thông tin từ file (tham số truyền vào là tên file)
	static List<VeMayBay> readData(String fileName) {
		List<VeMayBay> danh_sach_tu_file = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(fileName);
			ois = new ObjectInputStream(fis);

			danh_sach_tu_file = (List<VeMayBay>) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
				if (ois != null) {
					ois.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return danh_sach_tu_file;
	}

	// 3&6 : In thông tin từ mảng
	static void displayArrayList(List<VeMayBay> list) {
		VeMayBay.displayHeader();
		for (VeMayBay item : list) {
			item.display();
		}
	}

	// 4 sắp xếp các vé máy bay theo giá
	static void soft(List<VeMayBay> list) {
		System.out.println("Thông tin sau khi sắp xếp là : ");
		VeMayBay.displayHeader();
		Collections.sort(list, new Comparator<VeMayBay>() {
			@Override
			public int compare(VeMayBay o1, VeMayBay o2) {
				if (o1.getGiaVe() < o2.getGiaVe()) {
					return -1;
				}
				return 1;
			}
		});

		for (int i = 0; i < list.size(); i++) {
			list.get(i).display();
		}
	}

	// 5 Lưu thông tin của các hãng bay ra 1 file tương ứng
	static void saveByAirline(List<VeMayBay> list) {
		// lấy ra tất cả các hãng của VietjetAirline => lưu ra 1 file
		List<VeMayBay> VietJetAirline = getAirLine(list, "VJ");
		save(VietJetAirline, "D:/DataForAJP/VietJetAirline.dat");

		List<VeMayBay> VietNamAirline = getAirLine(list, "VN");
		save(VietNamAirline, "D:/DataForAJP/VietNamAirline.dat");

		List<VeMayBay> JetStar = getAirLine(list, "JET");
		save(JetStar, "D:/DataForAJP/JetStar.dat");

	}

	// 5 lấy thông tin của mỗi hãng bay tương ứng => trả về dạng mảng : có kí tự đầu
	// của các hãng bay giống nhau
	static List<VeMayBay> getAirLine(List<VeMayBay> list, String hai_kytu_dau) {
		List<VeMayBay> airlineList = new ArrayList<>();
		for (VeMayBay veMayBay : list) {
			if (veMayBay.getMaChuyenBay().startsWith(hai_kytu_dau)) { // lấy ra 2 ký tự đầu của mã vé
				airlineList.add(veMayBay); // nếu có cũng ký tự đầu => thêm vào 1 mảng
			}
		}
		return airlineList;
	}

	// 6 In ra thông tin của các hãng bay tương ứng
	static void displayByAirLine() {
		List<VeMayBay> listByAirLine = null;
		boolean flag01 = true;
		do {
			System.out.println("Bạn muốn lấy thông tin của hãng nào ?");
			System.out.println("1. VietJetAir");
			System.out.println("2. VietNam Airline");
			System.out.println("3. JetStar");
			System.out.println("Bạn chọn : ");
			int luaChon = input.nextInt();
			switch (luaChon) {
			case 1:
				listByAirLine = readData("D:/DataForAJP/VietJetAirline.dat");
				displayArrayList(listByAirLine); // gọi đến phương thức in
				flag01 = false;
				break;
			case 2:
				listByAirLine = readData("D:/DataForAJP/VietNamAirline.dat");
				displayArrayList(listByAirLine);
				flag01 = false;
				break;
			case 3:
				listByAirLine = readData("D:/DataForAJP/JetStar.dat");
				displayArrayList(listByAirLine);
				flag01 = false;
				break;
			default:
				System.out.println("Chọn lại !");
				flag01 = true;
				break;
			}
		} while (flag01);
	}

	static void showMenu() {
		System.out.println("1. Nhập vào thông tin n chuyến bay");
		System.out.println("2. Lưu thông tin vừa nhập vào file");
		System.out.println("3. Đọc thông tin từ file và hiển thị a màn hình");
		System.out.println("4. Hiển thị thông tin sau khi đã sắp xếp giảm dần theo vé");
		System.out.println("5. In ra thông tin của mỗi hãng bay ra 1 file tương ứng");
		System.out.println("6. Lấy thông tin từ các file đã lưu");
		System.out.println("7. Thoát");
		System.out.println("You choose : ");
	}

}
