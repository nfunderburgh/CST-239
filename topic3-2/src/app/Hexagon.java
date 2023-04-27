package app;

public class Hexagon extends ShapeBase{

	private int side;
	
	
	/**
	 * parameterized constructor
	 * 
	 * @param  name the name of the shape
	 * @param  width the width of a hexagon
	 * @param  height the height of a hexagon
	 * @param  side the size of a side of a hexagon
	 */
	public Hexagon(String name, int width, int height, int side) {
		super(name, width, height);
		this.side = side;
	}
	
	
	/**
	 * calculates the area of a hexagon
	 * 
	 * @return int returns the area of a hexagon
	 */
	@Override
	public int calculateArea() {
		return (int) ((3 * Math.sqrt(3) *
                (side * side)) / 2);
	}
}
