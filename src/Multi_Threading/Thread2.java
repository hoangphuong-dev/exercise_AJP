package Multi_Threading;

public class Thread2 extends Thread {
	SharedData sharedData;

	public Thread2(SharedData sharedData) {
		this.sharedData = sharedData;
	}
	
	@Override
	public void run() {
		for(int i = 0; i< sharedData.addressList.length; i++) {
			synchronized (sharedData) {
				sharedData.notifyAll();
				
				try {
					sharedData.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println("Address : " + sharedData.addressList[i]);
				
				sharedData.notifyAll();
			}
			
		}
		System.out.println("stop thread 2");
	}
}
