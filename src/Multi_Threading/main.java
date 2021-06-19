package Multi_Threading;
/*
 Bài 1 : CHo một danh sách là họ tên các sinh viên : 
 ví dụ("Nguyễn Ngọc Lan", "Trần Văn Đức", "Phan Mai Duyên")
 
 Một danh sách khác là quê của các sinh viên trên
 ("Hải Phòng","Hà Nội","Quảng Ninh")
 
 Viết 1 ứng dụng trong Java sử dụng thread để thực hiện các công việc sau 
 - Thread 1 sau mỗi giây sẽ hiển thị tên một người trong danh sách tên 
 - Thread 2 sau đó sẽ hiển thị quê tương ứng của người đó 
 - Hai thread thực hiện mỗi thread 5 lần sẽ dừng lại 
 Phải luôn đảm bảo rằng thread 1 luôn được chạy trước rồi mới đến thread2
 */
public class main {
	public static void main(String[] args) {
		SharedData sharedData = new SharedData();
		
		Thread1 t1 = new Thread1(sharedData);
		Thread2 t2 = new Thread2(sharedData);
		t2.start();
		t1.start();
		
		
	}

}
