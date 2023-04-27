package products;

public class Armor extends SalableProduct implements Comparable<SalableProduct>{
	private int protection;
	
	/**
	 * default constructor
	 * 
	 */
	public Armor() {
		super();
		protection = 0;
	}
	
	/**
	 * parameterized constructor
	 * 
	 * @param  name  the name of the product
	 * @param  description  short description about product
	 * @param  price  the price of the product
	 * @param  quantity  the amount of product in stock
	 * @param  protection the amount of protection in the armor
	 * 
	 */
	public Armor(String name, String description, float price, int quantity, int protection) {
		super(name, description, price, quantity);
		this.protection = protection;
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
		int value = this.getName().compareTo(product.getName());
		return value;

	}
	
}
