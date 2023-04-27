package app;

public class Oval extends ShapeBase{
	
	
	/**
	 * parameterized constructor
	 * 
	 * @param  name the name of the shape
	 * @param  width the width of a Oval
	 * @param  height the height of a Oval
	 */
	public Oval(String name, int width, int height) {
		super(name, width, height);
	}
	
	
	/**
	 * calculates the area of a Oval
	 * 
	 * @return int returns the area of a Oval
	 */
	@Override
	public int calculateArea() {
		return (int) (Math.PI * width * height);
	}
}
