package Thread;

/*
 Tạo lớp Thread1 kế thừa Thread gồm các thuộc tính ArrayList<Integer> list1
- Thread này thực hiện sau 1s sinh ngẫu nhiên các số tự nhiêu chạy từ 0-100 
-> lưu kết quả vào mảng list1
Tạo lớp Thread2 kế thừa Thread gồm các thuộc tính ArrayList<Char> list2
- Thread này thực hiện sau 2s thi sinh ngẫu nhiên các ký tự từ a-z và lưu vào mảng list2
Trong phương thức main của lớp Test tạo ra 2 thread t1 và t2 lần lượt từ Thread1 
và Thread2
Khi t1 đã sinh 10 lần -> thực hiện dừng t1
Khi t2 đã sinh đc 10 ký tự thì stop t2
Sau khi 2 thread 1 và 2 kết thúc. Thực hiện in kết quả của các thread trên thread main
 */
public class main {

	public static void main(String[] args) {
		System.out.println("Bắt đầu luồng main");
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		
		System.out.println("Luồng 1 đang chạy");
		t1.start();
		System.out.println("Luồng 2 đang chạy");
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Kết thúc luồng main");
		
		
		System.out.println("Hiển thị kết quả sinh ngẫu nhiên của luồng 1 và luồng 2 : ");
		System.out.print("T1 : ");
		for(int i = 0; i < t1.list1.size(); i++) {
			System.out.print(" " + t1.list1.get(i));
		}
		System.out.println("");
		System.out.print("T2 : ");
		for(int i = 0; i < t2.list2.size(); i++) {
			System.out.print(" " + t2.list2.get(i));
		}
	}

}
 