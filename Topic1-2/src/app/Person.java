package app;

public class Person {
	
	private int age;
	private String name;
	private float weight;
	
	/**
	 * This method creates a person object
	 * 
	 * @param  age  the persons age
	 * @param  name  the persons name
	 * @param  weight  the persons weight
	 * @return  none
	 */
	public Person(int age, String name, float weight) {
		super();
		this.age = age;
		this.name = name;
		this.weight = weight;
	}
	
	/**
	 * This returns the values of age
	 * 
	 * @param none
	 * @return the age of the person
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * This returns the values of name
	 * 
	 * @param none
	 * @return the name of the person
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This returns the values of weight
	 * 
	 * @param none
	 * @return the weight of the person
	 */
	public float getWeight() {
		return weight;
	}
	
	/**
	 * prints "I am in walk()" to the console
	 * 
	 * @param none
	 * @return none
	 */
	public void walk() {
		System.out.println("I am in walk()");
	}
	
	/**
	 * prints "I am in run()" to the console
	 * 
	 * @param distance the distance ran
	 * @return 0
	 */
	public float run(float distance) {
		System.out.println("I am in run()");
		return 0;
	}
	
	public static void main(String[] args) {
		Person person = new Person(25, "Bob", (float) 165.02);
		System.out.println("My name is " + person.getName());
		person.walk();
		person.run(10);
	}
}
