package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException{
		Server server = new Server();
		server.start(6666);
		
		
		server.cleanup();
	}
	
	private ServerSocket serverSocket;
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;
	
	public void start(int port) throws IOException{
		System.out.println("Waiting for a Client connection.....");
		serverSocket = new ServerSocket(port);
		clientSocket = serverSocket.accept();
		
		System.out.println("Received a Client connection on port " + clientSocket.getLocalPort());
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		String inputLine;
		while((inputLine = in.readLine()) != null) {
			
			if(".".equals(inputLine)) {
				System.out.println("Got a message to shut the Server down");
				out.println("Quit");
				break;
			}
			else {
				System.out.println("Got a message of: " + inputLine);
				out.println("OK");
			}
			
		}
		System.out.println("server is shut down");
	}
	
	public void cleanup() throws IOException {
		in.close();
		out.close();
		clientSocket.close();
		serverSocket.close();
	}
}
