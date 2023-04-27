package app;

public class MyThread1 extends Thread {

	/**
	 * Prints a message along with which iteration the method is on.
	 * The thread sleeps for 1 second after.
	 */
	public void run() {
		for(int x=0; x< 1000;++x) {
			System.out.println("MyThread1 is running iteration" + x);
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
