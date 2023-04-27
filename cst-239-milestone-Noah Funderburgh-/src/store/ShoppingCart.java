package store;

import java.util.ArrayList;

import products.SalableProduct;

public class ShoppingCart {
	private ArrayList<SalableProduct> products = new ArrayList<SalableProduct>();
	
	
	/**
	 * returns the array list of products in the cart
	 * 
	 * @return Arraylist of salable products
	 */
	public ArrayList<SalableProduct> getProductsInCart() {
		return products;
	}

	/**
	 * Adds the item to the cart if item is already in the cart it increases the quantity by one.
	 * 
	 * @param item  the item to be deleted from the cart
	 */
	public void addToCart(SalableProduct item) {
		SalableProduct productToAdd = findProduct(item.getName());
		
		if(productToAdd != null) {
			int quantity = productToAdd.getQuantity();
			quantity++;
			productToAdd.setQuantity(quantity);
		}
		else {
			productToAdd = new SalableProduct(item.getName(), item.getDescription(), item.getPrice(), 1);
			products.add(productToAdd);
		}
		System.out.println(item.getName() + " was added to the cart.");
	}

	

	/**
	 * Deletes one from quantity, if the quantity is zero it remove the item entirely
	 * 
	 * @param item  the item to be deleted from the cart
	 */
	public void deleteFromCart(SalableProduct item) {
		if(item.getQuantity() != 0) {
			int quantity = item.getQuantity();
			quantity = quantity - 1;
			if(quantity == 0) {
				products.remove(item);
				System.out.println("Successfully removed one " + item.getName() + " from the cart.");
			}
			else {
				item.setQuantity(quantity);
			}
		}
	}
	
	
	/**
	 * Empty's all items in the cart
	 */
	public void emptyCart() {
		products.removeAll(products);
	}
	
	/**
	 * Searches the array list to see if we have the product in the cart
	 * 
	 * @param  productName the name of the product the user is looking for in the cart
	 * @return SalableProduct the product that matches the string
	 */
	public SalableProduct findProduct(String productName) {
		SalableProduct product = null;
		String item = "";
		for(SalableProduct products : products) {
			item = products.getName();
			if(item.equalsIgnoreCase(productName)) {
				product = products;
			}
		}
        return product;
	}	
}
