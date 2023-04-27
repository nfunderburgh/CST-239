package store;

import products.SalableProduct;
import game.InventoryManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class StoreFront {

	public ArrayList<SalableProduct> productsForSale = new ArrayList<SalableProduct>();
	private ShoppingCart cart = new ShoppingCart();
	private String outputStrings = "";
	private int sortSetting = 1;
	private boolean isOpen;
	
	/**
	 * Parameterized Constructor
	 * 
	 * @param  isOpen  whether the store is open which is true or closed which is false.
	 */
	public StoreFront(boolean isOpen) {
		this.isOpen = isOpen;
	}


	/**
	 * This method opens the store front
	 * 
	 */
	public void openStore() {
		isOpen = true;
	}

	/**
	 * This method closes the store front
	 * 
	 */
	public void closeStore() {
		isOpen = false;
	}
	
	/**
	 * This method returns if the store front is open
	 * 
	 * @return  boolean  return true if store is open and false if its closed
	 */
	public boolean getIsOpen() {
		return isOpen;
	}
	
	/**
	 * This method adds a salable product to the array list
	 * 
	 * @param  product the product to add to the store
	 */
	public void addProduct(SalableProduct product) {
		productsForSale.add(product);
	}
	
	
	/**
	 * Searches the array list to see if we have that product in stock
	 * 
	 * @param  productName the name of the product the user is looking for
	 * @return SalableProduct the product that matches the string
	 */
	public SalableProduct findProduct(String productName) {
		SalableProduct product = null;
		String item = "";
		for(SalableProduct products : productsForSale) {
			item = products.getName();
			if(item.equalsIgnoreCase(productName)) {
				product = products;
			}
		}
        return product;
	}
	
	
	/**
	 * 
	 * @return Contents of store as string in console friendly format
	 */
	public String viewStore() {
		outputStrings = "The current store:\n";
		sortStore();
		for (SalableProduct item : productsForSale) {
			outputStrings = outputStrings.concat(item.printItem() + "\n");
		}
		return outputStrings;
	}
	
	/*float totalPriceInCart = 0;
	for (SalableProduct item : products) {
		item.printItem();
		totalPriceInCart += item.getPrice() * item.getQuantity();
	}
	System.out.println("The total price in cart is: $" + totalPriceInCart);*/
	
	/**
	 * This method returns the items in the shop that are currently being sold
	 * 
	 * @return The ArrayList containing all items currently for sale in shop.
	 */
	public ArrayList<SalableProduct> getProductsForSale() {
		return productsForSale;
	}
	
	
	/**
	 * This method empty's all items within the store
	 */
	public void emptyStore() {
		productsForSale.clear();
	}
	
	/**
	 * This method adds a item into the cart
	 * 
	 * @param The SalableProduct that is being added to the cart
	 */
	public void addToCart(SalableProduct item) {
		cart.addToCart(item);
	}

	
	/**
	 * This method deletes an item from the cart
	 * 
	 * @param The SalableProduct that is being deleted to the cart
	 */
	public void deleteFromCart(SalableProduct item) {
		cart.deleteFromCart(item);
	}
	
	
	/**
	 * This method empty's all items within the cart
	 */
	public void emptyCart() {
		cart.emptyCart();
	}
	
	
	/**
	 * Returns all items currently in player cart
	 * 
	 * @return The ArrayList containing all items currently in the player's cart.
	 */
	public ArrayList<SalableProduct> getCart() {
		return cart.getProductsInCart();
	}
	
	/**
	 * Returns a string so we can nicely print
	 *  all items in players cart
	 * 
	 * @return The string of players items in there cart
	 */
	public String viewCart() {
		outputStrings = "The current cart:\n";
		for (SalableProduct item : this.getCart()) {
			outputStrings = outputStrings.concat(item.printItem() + "\n");
		}
		return outputStrings;
	}
	
	/**
	 * Checks out the players items by printing a receipt and
	 * subtracting the stock minus items sold
	 * 
	 * @return The receipt of all purchased items with total price.
	 */
	public String checkout() {
		float totalPrice = 0;
		String receipt = "Your Receipt:\n";
		for (SalableProduct item : cart.getProductsInCart()) {
			receipt = receipt.concat(item.printItem() + "\n");
			totalPrice += item.getQuantity() * item.getPrice();
			SalableProduct productInStock = findProduct(item.getName());
			int sold = item.getQuantity();
			int stock = productInStock.getQuantity();
			productInStock.setQuantity(stock-sold);
			System.out.println(item.getQuantity());
				
		}
		receipt = receipt.concat("Your checkout total is: $" + totalPrice);
		cart.getProductsInCart().clear();
		return receipt;
	}
	
	/**
	 * Sorts all goods in store by item name
	 * 
	 * @param arrayList the arrayList to be sorted
	 */
	private void sortByName(ArrayList<SalableProduct> arrayList) {
		arrayList.sort(Comparator.comparing(SalableProduct::getName));
	}

	/**
	 * Sorts all goods in store by price (high to low).
	 * 
	 * @param arrayList the arrayList to be sorted
	 */
	private void sortByPrice(ArrayList<SalableProduct> arrayList) {
		arrayList.sort(Comparator.comparing(SalableProduct::getPrice));
	}
	

	/**
	 * Reverse the order of the arrayList
	 * 
	 * @param arrayList the arrayList to be sorted
	 */
	private void sortReverse(ArrayList<SalableProduct> arrayList) {
		Collections.reverse(arrayList);
	}
	
	/**
	 * This method sets the value of sort setting
	 * 
	 * @param  sortSetting a number 1-4 on the type of sort
	 */
	public void setSortSetting(int sortSetting){
		this.sortSetting = sortSetting;
	}

	
	/**
	 * This method chooses the sort method based off the sort setting.
	 * 
	 */
	public void sortStore() {
		switch (sortSetting) {
		case 1:
			sortByName(productsForSale);
			break;
		case 2:
			sortByName(productsForSale);
			sortReverse(productsForSale);
			break;
		case 3:
			sortByPrice(productsForSale);
			break;
		case 4:
			sortByPrice(productsForSale);
			sortReverse(productsForSale);
			break;
		default:
			System.out.println("Option wasn't available. Default sort enabled.");
			sortByName(productsForSale);
		}
	}
	
}











