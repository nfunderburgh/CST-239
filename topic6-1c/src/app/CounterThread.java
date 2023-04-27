package app;

import java.util.Random;

public class CounterThread extends Thread{
	
	/**
	 * Sleeps for a random amount of time then increases counter.
	 * 
	 */
	public void run() {
		try {
			Random rand = new Random();
			int sleeper = rand.ints(1,(1000+1)).findFirst().getAsInt();
			Thread.sleep(sleeper);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		Counter.increment();
	}
	
}
