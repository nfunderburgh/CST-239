package game;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import products.Armor;
import products.Health;
import products.SalableProduct;
import products.Weapon;
import store.StoreFront;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class InventoryManager {

	public static StoreFront store = new StoreFront(false);
	
	/**
	 * call the three  items initailizers, armor, weapon and health.
	 * 
	 */
	public static void basicInventoryInit() {
	
		try {
			ArmorsInit("json/Armor.json");
			WeaponsInit("json/Weapon.json");
			HealthsInit("json/Health.json");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Weapons Initialization reads from Weapon.json to declare weapons
	 * 
	 * @param  filename  the name of the file
	 * 
	 */
	protected static void WeaponsInit(String filename) throws IOException {
		ObjectMapper om = new ObjectMapper();
		List<Weapon> inventory = om.readValue(new File(filename), new TypeReference<List<Weapon>>() {
		});
		for (Weapon w : inventory) {
			store.addProduct(w);
		}
	}


	/**
	 * Armor Initialization reads from Armor.json to declare Armor
	 * 
	 * @param  filename  the name of the file
	 * 
	 */
	protected static void ArmorsInit(String filename) throws IOException {
		ObjectMapper om = new ObjectMapper();
		List<Armor> inventory = om.readValue(new File(filename), new TypeReference<List<Armor>>() {
		});
		for (Armor a : inventory) {
			store.addProduct(a);
		}
	}
	

	/**
	 * Health Initialization reads from Health.json to declare Health
	 * 
	 * @param  filename  the name of the file
	 * 
	 */
	protected static void HealthsInit(String filename) throws IOException {
		ObjectMapper om = new ObjectMapper();
		List<Health> inventory = om.readValue(new File(filename), new TypeReference<List<Health>>() {
		});
		for (Health h : inventory) {
			store.addProduct(h);
		}
	}
	
	/**
	 * This method finds a item to return from a list with that name
	 * 
	 * @param foundItem The String name of the item to be found.
	 * @param list The ArrayList of SalableProducts being searched thru.
	 * @return Returns the SalableProduct object found in list otherwise returns null
	 */
	public static SalableProduct findItem(String itemName, ArrayList<SalableProduct> list) {
		SalableProduct foundItem = null;
		for (SalableProduct item : list) {
			if (item.getName().equalsIgnoreCase(itemName)) {
				foundItem = item;
			}
		}
		return foundItem;
	}
	
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
	
	/*
	 * Handles the admin view
	 */
	public static synchronized void main(String[] args) throws IOException {

		PrintWriter out = null;
		BufferedReader in = null;
		Scanner scnr = new Scanner(System.in);

		try (Socket socket = new Socket("localhost", 1337)) {
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String line = "";

			System.out.println("Admin connected to server on " + socket.getPort());
			System.out.println("Instructions for admin:");
			System.out.println(".U: to update store items to shop.");
			System.out.println(".R: to create JSON file of all items currently in-game.");
			System.out.println(".LEAVE: to leave the shop.");

			while (!".LEAVE".equalsIgnoreCase(line)) {
				line = scnr.nextLine().toUpperCase().trim();
				out.println(line);
				out.flush();
				readMessage(in);
			}

			scnr.close();
			out.close();
			in.close();

			System.out.println("Thank you for your administration.");

		} catch (IOException e) {
			System.out.println("Check if the server is running.");
			e.printStackTrace();
		}
	}
}
