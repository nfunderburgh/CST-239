package app;

public class ServerApp {

	public static void main(String[] args) throws InterruptedException {
		ServerThread serverThread = new ServerThread();
		serverThread.start();
		for(int i = 0; i< 1000; i++) {
			System.out.println(".");
			
			Thread.sleep(5000);
		}
		
		
		
	}
}
