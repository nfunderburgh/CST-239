package products;

public class Health extends SalableProduct implements Comparable<SalableProduct>{
	private int hitpoints;
	
	/**
	 * default constructor
	 * 
	 */
	public Health() {
		super();
		hitpoints = 0;
	}
	
	/**
	 * parameterized constructor
	 * 
	 * @param  name  the name of the product
	 * @param  description  short description about product
	 * @param  price  the price of the product
	 * @param  quantity  the amount of product in stock
	 * @param  hitpoints  the amount of hitpoints in the potion
	 */
	public Health(String name, String description, float price, int quantity, int hitpoints) {
		super(name, description, price, quantity);
		this.hitpoints = hitpoints;
	}
	
	/**
	 * compares Salable Product names
	 * 
	 * @param product the product to compare against
	 * @return int the number of the product
	 */
	@Override
	public int compareTo(SalableProduct product) {
		int value = this.getName().compareTo(product.getName());
		return value;

	}
	
}
