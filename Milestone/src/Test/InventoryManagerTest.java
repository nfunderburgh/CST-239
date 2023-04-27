package Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.Test;

import game.InventoryManager;
import products.SalableProduct;

public class InventoryManagerTest {

	@Test
	public void findProductTest() {
		SalableProduct axe = new SalableProduct("axe", "a one sided axe made of iron", (float) 6.99, 1);
		SalableProduct sword = new SalableProduct("Sword", "short sword", (float) 10.99, 1);

		InventoryManager.store.addProduct(axe);
		InventoryManager.store.addProduct(sword);

		// Checks to find the item int the store
		assertEquals(axe, InventoryManager.findItem("axe", InventoryManager.store.getProductsForSale()));
		assertEquals(sword, InventoryManager.findItem("sword", InventoryManager.store.getProductsForSale()));
	}
}