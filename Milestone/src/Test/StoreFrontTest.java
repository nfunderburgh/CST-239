package Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;
import game.InventoryManager;
import products.SalableProduct;
import store.StoreFront;

public class StoreFrontTest {
	
	@Test
	public void addEmptyProductsTest() {
		SalableProduct armor1 = new SalableProduct("Armor 1", "Light armor made of leather", (float) 5.99, 4);
		SalableProduct armor2 = new SalableProduct("Armor 2", "Light armor made of leather", (float) 5.99, 4);
		SalableProduct armor3 = new SalableProduct("Armor 3", "Light armor made of leather", (float) 5.99, 4);
		StoreFront store1 = new StoreFront(true);
		StoreFront store2 = new StoreFront(true);

		store1.addProduct(armor1);
		store1.addProduct(armor2);
		store1.addProduct(armor3);
		store2.addProduct(armor1);
		store2.addProduct(armor2);
		store2.addProduct(armor3);
		
		//Both store1 and store2 should be equal
		assertArrayEquals(store1.getProductsForSale().toArray(), store2.getProductsForSale().toArray());
		
		store2.addToCart(armor1);
		store2.addToCart(armor2);
		store2.addToCart(armor3);
		
		// Arrays should not be equal
		assertFalse(Arrays.equals(store1.getCart().toArray(), store2.getCart().toArray()));
		
		store2.emptyCart();
		//Arrays should be equal after emptying cart
		assertArrayEquals(store1.getCart().toArray(), store2.getCart().toArray());
	}
	
	@Test
	public void viewCartTest() {
		SalableProduct armor1 = new SalableProduct("Armor 1", "Light armor made of leather", (float) 5.99, 4);
		SalableProduct armor2 = new SalableProduct("Armor 2", "Light armor made of leather", (float) 5.99, 4);
		SalableProduct armor3 = new SalableProduct("Armor 3", "Light armor made of leather", (float) 5.99, 4);
		StoreFront store1 = new StoreFront(true);
		StoreFront store2 = new StoreFront(true);

		store1.addProduct(armor1);
		store1.addProduct(armor2);
		store1.addProduct(armor3);
		store2.addProduct(armor1);
		store2.addProduct(armor2);
		store2.addProduct(armor3);
		// Adding items to cart in store1 only
		store1.addToCart(armor1);
		store1.addToCart(armor2);
		store1.addToCart(armor3);
		
		String str1 = store1.viewCart();
		String str2 = store2.viewCart();
		// String shouldn't be equal as there is nothing in store2 and 3 items are in the cart for store1
		assertFalse(str1.equals(str2));
		// empty cart
		store1.emptyCart();
		// set the new string
		str1 = store1.viewCart();
		// Strings should be equal
		assertTrue(str1.equals(str2));
	}
}
