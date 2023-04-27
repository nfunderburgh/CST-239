package products;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SalableProduct implements Comparable<SalableProduct> {
	
	private String name;
	private String description;
	private float price;
	private Integer quantity;
	
	
	/**
	 * default constructor
	 * 
	 */
	public SalableProduct() {
		name = "";
		description = "";
		price = 0;
		quantity = 0;
	}
	
	/**
	 * parameterized constructor
	 * 
	 * @param  name  the name of the product
	 * @param  description  short description about product
	 * @param  price  the price of the product
	 * @param  quantity  the amount of product in stock
	 */
	public SalableProduct(String name, String description, float price, int quantity) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}
	
	
	/**
	 * This method return the name of the current product
	 * 
	 * @return name  return the name of the current salable product object
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This method return the name of the current product
	 * 
	 * @return name  return the name of the current salable product object
	 * 
	 */
	public String getDescription() {
		return description;
	}
	
	
	/**
	 * This method is used to get the quantity of the product
	 * 
	 * @return name  return the quantity of the current salable product object
	 * 
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * This method is used to get the price of a product
	 * 
	 * @return price the price of that product
	 * 
	 */
	public float getPrice() {
		return price;
	}
	
	/**
	 * This method is used to set the quantity of the product
	 * 
	 * @param  newQuantity  the new amount in stock
	 * 
	 */
	public void setQuantity(int newQuantity) {
		quantity = newQuantity;
	}
	
	/**
	 * Converts SalableProduct object into a JSON string
	 * 
	 * @return Returns the string
	 */
	public String toJSON() throws JsonProcessingException {
		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(this);
		return json;
	}
	
	/**
	 * This method prints the current salable product information
	 * 
	 */
	public String printItem() {
		String itemInfo = "";
		itemInfo = name + ": " + description + "\n";
		itemInfo = itemInfo.concat("$" + price + "   " + "Quantity: " + quantity);
		return itemInfo;
	}

	/**
	 * compares Salable Product names
	 * 
	 * @param product the product to compare against
	 * @return int the number of the product
	 * 
	 */
	@Override
	public int compareTo(SalableProduct product) {
		int value = this.name.compareTo(product.name);
		return value;

	}
}
