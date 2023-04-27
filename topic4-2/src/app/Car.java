package app;

public class Car {
	private int year;
	private String make;
	private String model;
	private int odometer;
	private double engineLiters;
	
	/*
	 * Default constructor
	 * 
	 */
	public Car() {
		year = 0;
		make = "";
		model = "";
		odometer = 0;
		engineLiters = 0;
	}
	
	
	/*
	 * Paramaterized constructor
	 * 
	 * @param year  the year of the car
	 * @param make  the make of the car
	 * @param model the model of the car
	 * @param odometer the amount of miles on the odometer
	 * @param engineLiters  the size of the engine in liters
	 * 
	 */
	public Car(int year, String make, String model, int odometer, double engineLiters) {
		super();
		this.year = year;
		this.make = make;
		this.model = model;
		this.odometer = odometer;
		this.engineLiters = engineLiters;
	}
	
	/*
	 * Returns the year of the car
	 * 
	 * @return int  the year of the car
	 * 
	 */
	public int getYear() {
		return year;
	}
	
	/*
	 * Returns the make of the car
	 * 
	 * @return String  the make of the car
	 * 
	 */
	public String getMake() {
		return make;
	}
	
	/*
	 * Returns the model of the car
	 * 
	 * @return String  the model of the car
	 * 
	 */
	public String getModel() {
		return model;
	}
	
	/*
	 * Returns the odmeter which is the total miles on the car
	 * 
	 * @return int returns the miles on the car
	 * 
	 */
	public int getOdometer() {
		return odometer;
	}
	
	/*
	 * Returns the amount of liters the engine has
	 * 
	 * @return double returns the engine liters
	 * 
	 */
	public double getEngingeLiters() {
		return engineLiters;
	}
	
	
	/*
	 * Sets the year of the car
	 * 
	 * @param year  the year of the car stored as a int
	 * 
	 */
	public void setYear(int year) {
		this.year = year;
	}
	
	/*
	 * Sets the make of the car
	 * 
	 * @param make  the make of the car stored as a String
	 * 
	 */
	public void setMake(String make) {
		this.make = make;
	}
	
	/*
	 * Sets the model of the car
	 * 
	 * @param model  the model of the car stored as a String
	 * 
	 */
	public void setModel(String model) {
		this.model = model;
	}
	
	/*
	 * Sets the odometer of the car
	 * 
	 * @param odometer  the odometer of the car stored as a int
	 * 
	 */
	public void setOdometer(int odometer) {
		this.odometer = odometer;
	}
	
	/*
	 * Sets the engineLiters of the car
	 * 
	 * @param engineLiters  the engineLiter of the car stored as a double
	 *  
	 */
	public void setEngingeLiters(double engineLiters) {
		this.engineLiters = engineLiters;
	}
}
