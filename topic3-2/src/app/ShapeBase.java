
package app;

public class ShapeBase implements ShapeInterface{

	protected String name;
	protected int width, height;
	
	
	/**
	 * parameterized constructor
	 * 
	 * @param  name the name of the shape
	 * @param  width the width of a Oval
	 * @param  height the height of a Oval
	 */
	public ShapeBase(String name, int width, int height) {
		this.name = name;
		this.width = width;
		this.height = height;
	}
	
	/**
	 * gets the name of the shape
	 * 
	 * @return String returns the name of the shape
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * returns -1 if other calculate area methods fail.
	 * 
	 * @return int return -1 if other methods don't work
	 */
	@Override
	public int calculateArea() {
		return -1;
	}

}
