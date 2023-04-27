package Test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import products.SalableProduct;

public class SalableProductTest {

	@Test
	public void ToJSONTest() throws JsonProcessingException {
		SalableProduct axe1 = new SalableProduct("axe", "a one sided axe made of iron", (float) 6.99, 1);
		SalableProduct axe2 = new SalableProduct("axe", "a one sided axe made of iron", (float) 6.99, 1);
		SalableProduct sword = new SalableProduct("Sword", "short sword", (float) 10.99, 1);
		
		assertEquals(axe1.toJSON(),"{\"name\":\"axe\",\"description\":\"a one sided axe made of iron\",\"price\":6.99,\"quantity\":1}");
		assertFalse(axe2.toJSON().equals(sword.toJSON()));
	}
	
	@Test
	public void printItemTest() {
		SalableProduct axe1 = new SalableProduct("axe", "a one sided axe made of iron", (float) 6.99, 1);
		SalableProduct sword1 = new SalableProduct("sword", "short sword", (float) 10.99, 1);
		
		assertEquals(axe1.printItem(), "axe: a one sided axe made of iron\n$6.99 Quantity: 1");
		assertFalse(axe1.printItem().equals(sword1.printItem()));
	}
	
	@Test
	public void setGetQuantityTest() {
		SalableProduct axe1 = new SalableProduct("axe", "a one sided axe made of iron", (float) 6.99, 1);
		SalableProduct sword1 = new SalableProduct("sword", "short sword", (float) 10.99, 1);
		
		Assert.assertEquals(axe1.getQuantity(), 1);
		axe1.setQuantity(10);
		Assert.assertEquals(axe1.getQuantity(), 10);
	}
	
	@Test
	public void getPriceTest() {
		SalableProduct axe1 = new SalableProduct("axe", "a one sided axe made of iron", (float) 6.99, 1);
		assertEquals(axe1.getPrice(), (float) 6.99);

	}
	
	@Test
	public void getDescriptionTest() {
		SalableProduct axe1 = new SalableProduct("axe", "a one sided axe made of iron", (float) 6.99, 1);
		assertTrue(axe1.getDescription().equals("a one sided axe made of iron"));

	}
	
	@Test
	public void getNameTest() {
		SalableProduct axe1 = new SalableProduct("axe", "a one sided axe made of iron", (float) 6.99, 1);
		assertTrue(axe1.getName().equals("axe"));

	}
	
	@Test
	public void compareToTest() {
		SalableProduct axe1 = new SalableProduct("axe", "a one sided axe made of iron", (float) 6.99, 1);
		SalableProduct sword1 = new SalableProduct("sword", "short sword", (float) 6.99, 1);
		assertTrue(axe1.compareTo(sword1) < 1);
		assertTrue(sword1.compareTo(axe1) > 1);

	}
}
