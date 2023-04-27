package app;

public class Counter {
	
	static int count = 0;
	
	/**
	 * adds 1 to the count
	 */
	static synchronized void increment() {
		count = count + 1;
	}
	
	/**
	 * Returns the number of count
	 * 
	 * @return int
	 */
	static int getCount() {
		return count;
	}
}
