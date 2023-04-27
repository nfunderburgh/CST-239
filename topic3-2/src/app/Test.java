package app;

public class Test {

	private static void displayArea(ShapeBase shape) {
		System.out.println("This is a shape named " + shape.getName() + " with an area of " + shape.calculateArea());
	}
	
	public static void main(String[] args) {
		
		ShapeBase[] shapes = new ShapeBase[2];
		shapes[0] = new Rectangle("Rectangle", 10, 200);
		shapes[1] = new Triangle("Triangle", 10, 50);
	    shapes[2] = new Circle("Circle", 10);
		shapes[3] = new Oval("Oval", 10, 50);
		shapes[4] = new Hexagon("Hexagon", 10, 20 , 5);
		shapes[5] = new Trapezoid("Trapezoid", 5, 5 , 10);
		
		for(int x=0; x < shapes.length; ++x) {
			displayArea(shapes[x]);
		}
	}
}
