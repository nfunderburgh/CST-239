package app;

public class Rectangle extends ShapeBase
{
	
	/**
	 * parameterized constructor
	 * 
	 * @param  name the name of the shape
	 * @param  width the width of a Rectangle
	 * @param  height the height of a Rectangle
	 */
	public Rectangle(String name, int width, int height) {
		super(name, width, height);
	}
	
	
	/**
	 * calculates the area of a rectangle
	 * 
	 * @return int returns the area of a rectangle
	 */
	@Override
	public int calculateArea() {
		return width * height;
	}
	
}
