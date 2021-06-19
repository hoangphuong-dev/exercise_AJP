package Multi_Threading;

public class Thread1 extends Thread {
	SharedData sharedData;

	public Thread1(SharedData sharedData) {
		this.sharedData = sharedData;
	}
	
	@Override 
	public void run() {
		for(int i = 0; i < sharedData.userList.length; i++) {
			synchronized (sharedData) {
				sharedData.notifyAll();
				System.out.println("Name : "+ sharedData.userList[i]);
				
				try {
					sharedData.wait();
					Thread1.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		System.out.println("stop thread 1");
	}
}
