package app;

public class Circle extends ShapeBase{
	
	/**
	 * parameterized constructor
	 * 
	 * @param  name  the name of the shape
	 * @param  diameter the size of the circle
	 */
	public Circle(String name, int diameter) {
		super(name, diameter, diameter);
	}
	
	/**
	 * calculates the area of a circle
	 * 
	 * @return int returns the area of a circle
	 */
	@Override
	public int calculateArea() {
		// Area = pi r Squared
		return (int) (Math.PI * (width * height));
	}
}
