package app;

public class CounterWorker {
	
	/**
	 * Tests Counter and CounterThread Class
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String args[]) throws InterruptedException
	{
		System.out.println("This is the inital value of the Counter " + Counter.getCount());
		
		int numberCounters = 1000;
		
		CounterThread[] counters = new CounterThread[numberCounters];
		for(int x = 0; x < 1000; ++x) {
			counters[x] = new CounterThread();
		}
		
		for(int x = 0; x < 1000; ++x) {
			counters[x].start();
		}
		
		for(int x = 0; x < 1000; ++x) {
			counters[x].join();
		}
		
		System.out.println("This is the end value of the Counter " + Counter.getCount());
	}
}
