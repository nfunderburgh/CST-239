package app;

public class Person implements PersonInterface, Comparable<Person> {
	
	private String firstName = "Mark";
	private String lastName = "Reha";
	private boolean running;
	private Integer age;
	
	/**
	 * parameterized constructor
	 * 
	 * @param  firstName  the first name of the person
	 * @param  lastName   the last name of the person
	 * @param  age   the age of the person
	 */
	public Person(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	/**
	 * parameterized constructor
	 * 
	 * @param  person  the person object to set equal to
	 */
	public Person(Person person) {
		this.firstName = person.getFirstName();
		this.lastName = person.getLastName();
	}
	
	/**
	 * returns the first name variable.
	 * 
	 * @return String return first name
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * returns the last name variable.
	 * 
	 * @return String return last name
	 */
	public String getLastName() {
		return lastName;
	}
	
	
	/**
	 * returns the last name variable.
	 * 
	 * @param  other  person object
	 * @return Boolean return true if objects are equal, false otherwise
	 */
	@Override
	public boolean equals(Object other) {
		
		if( other == this) {
			System.out.println("I am here in other == this");
			return true;
		}
		if( other == null) {
			System.out.println("I am here in other == null");
			return false;
		}
		if( getClass() != other.getClass()) {
			System.out.println("I am here in other == null");
			return false;
		}
		Person person = (Person)other;
		return (this.firstName == person.firstName && this.lastName == person.lastName);
	}
	
	
	/**
	 * prints out information about person object
	 * 
	 * @return String return string with first name and last name
	 */
	@Override
	public String toString() {
		return "My Class is " + getClass() + " " + this.firstName + " " + this.lastName;
	}

	
	/**
	 * prints out I am walking
	 * 
	 * @return void
	 */
	@Override
	public void walk() {
		System.out.println("I am walking");
		running = false;
	}

	/**
	 * prints out I am running
	 * 
	 * @return void
	 */
	@Override
	public void run() {
		System.out.println("I am running");
		running = true;
	}

	/**
	 * checks to see if user is running
	 * 
	 * @return boolean  true/false if user is running
	 */
	@Override
	public boolean isRunning() {
		return running;
	}

	
	/**
	 * compares person objects
	 * 
	 * @return boolean return true is equal else false
	 */
	@Override
	public int compareTo(Person p) {
		int value = this.age.compareTo(p.age);
		return value;
		
	}
	

}
