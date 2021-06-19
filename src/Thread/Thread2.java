package Thread;

import java.util.ArrayList;
import java.util.Random;

public class Thread2 extends Thread {
	ArrayList<Character> list2 = new ArrayList<>();

	@Override
	public void run() {
//		System.out.println("Luồn 2 đang chạy");
		int min = (int) 'a'; // -> đưa về dạng số trong bảng ký tự ASC
		int max = (int) 'z';
		int limit = max - min; // giới hạn từ a-z

		Random rand = new Random();
		// vì random chỉ chạy từ 0 -> n : nên mới có limit
		for (int i = 0; i < 10; i++) {
			int rad = rand.nextInt(limit) + min;
			char c = (char) rad;
			list2.add(c);
			System.out.println("t2 -> " + c);

//			Random rand = new Random();
//			char value = (char) (rand.nextInt(26) + 'a');
//			list2.add(value);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
