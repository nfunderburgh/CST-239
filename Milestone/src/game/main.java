package game;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Collections;
import java.util.Scanner;

import store.ShoppingCart;
import products.SalableProduct;

public class main {
	
	/**
	 * Reads incoming messages and prints them to console while not null
	 * 
	 * @param in The BufferedReader that client uses to receive server's message
	 * @throws IOException
	 */
	public static void readMessage(BufferedReader in) throws IOException {
		String readMessage;
		while ((readMessage = in.readLine()) != null) {
			System.out.println(readMessage);
			if (!in.ready())
				break;
		}
	}

	/**
	 * Prints user commands to console.
	 */
	public static void commands() {
		System.out.println("0: Commands");
		System.out.println("1: View store");
		System.out.println("2: Add item to cart");
		System.out.println("3: View cart");
		System.out.println("4: Remove item from cart");
		System.out.println("5: Clear cart");
		System.out.println("6: Buy items");
		System.out.println("7: Sort options");
	}

	public static synchronized void main(String[] args) throws ClassNotFoundException, IOException {

		PrintWriter out = null;
		BufferedReader in = null;
		Scanner scnr = new Scanner(System.in);

		try (Socket socket = new Socket("localhost", 1337)) {
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println("The store is open for business");
			System.out.println("Welcome to Noah's store!");
			String line = "";
			commands();
			while (!".LEAVE".equalsIgnoreCase(line)) {
				line = scnr.nextLine().toLowerCase().trim();
				if ("0".equals(line)) {
					commands();
					continue;
				}

				out.println(line);
				out.flush();
				readMessage(in);
			}
			scnr.close();
			out.close();
			in.close();

		} catch (IOException e) {
			System.out.println("The store is currently empty. Come back later");
			System.out.println(e);
			return;
		}
	}
};
