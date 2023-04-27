package products;

public class Weapon extends SalableProduct implements Comparable<SalableProduct>{
	private Integer damage;
	
	/**
	 * default constructor
	 * 
	 */
	public Weapon() {
		super();
		damage = 0;
	}
	
	/**
	 * parameterized constructor
	 * 
	 * @param  name  the name of the product
	 * @param  description  short description about product
	 * @param  price  the price of the product
	 * @param  quantity  the amount of product in stock
	 * @param  dmg  the amount of damage the weapon does
	 */
	public Weapon(String name, String description, float price, int quantity, int dmg) {
		super(name, description, price, quantity);
		damage = dmg;
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
