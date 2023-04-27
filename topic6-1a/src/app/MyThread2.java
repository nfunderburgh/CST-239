package app;

public class MyThread2 implements Runnable{
	
	/**
	 * Prints a message along with which iteration the method is on.
	 */
	public void run() {
		for(int x=0; x< 100;++x) {
			System.out.println("MyThread2 is running iteration" + x);
		}
	}
}
