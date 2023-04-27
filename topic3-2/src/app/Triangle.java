package app;

public class Triangle extends ShapeBase{
	
	
	/**
	 * parameterized constructor
	 * 
	 * @param  name the name of the shape
	 * @param  width the width of a Triagnle
	 * @param  height the height of a Triangle
	 */
	public Triangle(String name, int width, int height) {
		super(name, width, height);
	}
	
	
	/**
	 * calculates the area of a triangle
	 * 
	 * @return int returns the area of a triangle
	 */
	@Override
	public int calculateArea() {
		return width = height /2;
	}
	
}
