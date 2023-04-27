package game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import products.SalableProduct;

public class MultiThread {
	public static void main(String[] args) {

		ServerSocket server = null;

		try {
			System.out.println("Server listening on port 1337");
			server = new ServerSocket(1337);
			server.setReuseAddress(true);
			InventoryManager.basicInventoryInit();
			System.out.println("Inventory stocked with basic items");

			while (true) {
				Socket client = server.accept();
				ClientHandler clientSocket = new ClientHandler(client);
				new Thread(clientSocket).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (server != null) {
				try {
					server.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}


	private static class ClientHandler implements Runnable {

		private final Socket clientSocket;

		/*
		 * Client Handler Parameter constructor
		 * 
		 */
		public ClientHandler(Socket socket) {
			this.clientSocket = socket;
		}

		
		/*
		 * Main loop of commands for the admin and the user
		 */
		@Override
		public void run() {
			PrintWriter out = null;
			BufferedReader in = null;

			try {
				out = new PrintWriter(clientSocket.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				System.out.println("New client connected from " + clientSocket.getInetAddress().getHostAddress());
				String line;
				while ((line = in.readLine()) != null) {
					System.out.printf("Server received command: " + line + "\n");
					switch (line) {
					case "1":
						out.println(InventoryManager.store.viewStore());
						break;
					case "2":
						out.println("Type the name of the product you wish to buy!");
						line = in.readLine();
						SalableProduct product = InventoryManager.findItem(line, InventoryManager.store.getProductsForSale());
						if (product != null) {
							InventoryManager.store.addToCart(product);
							out.println(product.getName() + " was added to cart.");
						} else
							out.println("We don't sell " + line);
						break;
					case "3":
						out.println(InventoryManager.store.viewCart());
						break;
					case "4":
						out.println("Enter the name of product to remove from cart:");
						line = in.readLine();
						SalableProduct productToRemove = InventoryManager.findItem(line, InventoryManager.store.getCart());
						if (productToRemove != null) {
							InventoryManager.store.deleteFromCart(productToRemove);
							out.println(productToRemove.getName() + " was removed from your cart.");
						} else
							out.println(line + " is not in your your cart.");
						break;
					case "5":
						InventoryManager.store.emptyCart();
						out.println("Cart is empty");
						break;
					case "6":
						out.println(InventoryManager.store.checkout());
						break;
					case "7":
						out.println("\n1: Sort by name (Ascending)\n2: Sort by name (Descending)\n3: Sort by price (low to high)\n4: Sort by price (high to low)");
						line = in.readLine();
						switch (line) {
						case "1":
							InventoryManager.store.setSortSetting(1);
							out.println("sort setting changed.");
							break;
						case "2":
							InventoryManager.store.setSortSetting(2);
							out.println("sort setting changed.");
							break;
						case "3":
							InventoryManager.store.setSortSetting(3);
							out.println("sort setting changed.");
							break;
						case "4":
							InventoryManager.store.setSortSetting(4);
							out.println("sort setting changed.");
							break;
						default:
							out.println("invalid sort setting");

						}
						break;
					case ".LEAVE":
						out.println("You left the store");
						return;
					case ".leave":
						out.println("You left the store");
						return;
					case ".U":
						InventoryManager.store.emptyStore();
						InventoryManager.ArmorsInit("json/Armor.json");
						InventoryManager.WeaponsInit("json/Weapon.json");
						InventoryManager.HealthsInit("json/Health.json");
						out.println("items in the shop have been updated");
						break;
					case ".R":
						ArrayList<SalableProduct> allItems = new ArrayList<SalableProduct>();
						allItems.addAll(InventoryManager.store.getCart());
						allItems.addAll(InventoryManager.store.getProductsForSale());
						LocalDateTime now = LocalDateTime.now();
						BufferedWriter fileOut = new BufferedWriter(new FileWriter("json/all-items_" + now.toString().replaceAll(":", "") + ".json"));
						fileOut.write("[");
						for (int i = 0; i < allItems.size(); i++) {
							if (i == allItems.size() - 1)
								fileOut.write(allItems.get(i).toJSON());
							else
								fileOut.write(allItems.get(i).toJSON() + ",");
						}
						fileOut.write("]");
						fileOut.close();
						out.println("JSON file with all item in game has been added");
						break;
					default:
						out.println("invalid command");
					}
				}

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				System.out.println("Client from " + clientSocket.getInetAddress().getHostAddress()+ " has disconnected from server");
				try {
					if (out != null) {
						out.close();
					}
					if (in != null) {
						in.close();
						clientSocket.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
