package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;
	
	
	/**
	 * Entry method for the Server application (for testing only).
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException{
		Client client = new Client();
		client.start("127.0.0.1", 6666);
		
		String response;
		for(int count = 0; count < 10; ++count) {
			String message;
			if(count != 9) {
				message = "Hello from Client " + count;
			}
			else {
				message = ".";
			}
			response = client.sendMessage(message);
			
			System.out.println("Server response was " + response);
			if(response.equals("q"))
				break;
		}
		client.cleanup();
	}
	
	/*
	 * Start the Server and wait for connections on the specific port
	 * 
	 * @param port Port to listen on.
	 * @throws IOException Thrown in the networking classes if something bad happened.
	 */
	public void start(String ip, int port) throws UnknownHostException, IOException{
		clientSocket = new Socket(ip,port);
		
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	}
	
	/*
	 * Send a Message to the server
	 * 
	 * @param msg Message to send
	 * @return Response back from the Server
	 * @throws IOException Thrown if anything bad happens from any of the networking classes.
	 */
	public String sendMessage(String msg) throws IOException{
		out.println(msg);
		
		return in.readLine();
	}
	
	
	/*
	 * Cleanup logic to close all the network connections
	 * 
	 * @throws IOException Thrown if anything bad happens from the networking classes.
	 */
	public void cleanup() throws IOException{
		in.close();
		out.close();
		clientSocket.close();
	}
}
