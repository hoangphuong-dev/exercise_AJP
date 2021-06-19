package Thread;

import java.util.ArrayList;
import java.util.Random;

public class Thread1 extends Thread {
	 ArrayList<Integer> list1 = new ArrayList<>();

	@Override
	public void run() {
//		System.out.println("Luồng 1 đang chạy");
		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			int ranNum = rand.nextInt(100);
			list1.add(ranNum);
			System.out.println("t1 -> " + ranNum);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	
	}
}
