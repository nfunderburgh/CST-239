package app;

public class Person {
	
	private String firstName = "Mark";
	private String lastName = "Reha";
	
	/**
	 * parameterized constructor
	 * 
	 * @param  firstName  the first name of the person
	 * @param  lastName   the last name of the person
	 */
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
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
		return "My Class is  " + getClass() + " " + this.firstName + " " + this.lastName;
	}
}
