package app;

public class Trapezoid extends ShapeBase{

	private int base;
	
	/**
	 * parameterized constructor
	 * 
	 * @param  name the name of the shape
	 * @param  base1 the first base of a trapezoid
	 * @param  height the height of a Oval
	 * @param base2 the second base of a trapezoid
	 */
	public Trapezoid(String name, int base1, int height, int base2) {
		super(name, base1, height);
		this.base = base2;
	}
	
	
	/**
	 * calculates the area of a trapezoid
	 * 
	 * @return int returns the area of a trapezoid
	 */
	@Override
	public int calculateArea() {
		return ((base + width)/2)*height;
	}
}
