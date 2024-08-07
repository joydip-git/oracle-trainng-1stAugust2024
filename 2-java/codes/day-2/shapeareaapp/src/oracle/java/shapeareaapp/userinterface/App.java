package oracle.java.shapeareaapp.userinterface;

import oracle.java.shapeareaapp.entities.Circle;
import oracle.java.shapeareaapp.entities.Shape;
import oracle.java.shapeareaapp.entities.Triangle;

public class App {

	public static void main(String[] args) {
		Shape[] shapes = new Shape[2];
		shapes[0] = new Circle(12);
		shapes[1] = new Triangle(12, 13);

		for (Shape shape : shapes) {
			System.out.println("area of " + shape.getClass().getSimpleName() + " is " + shape.calculateArea());
		}
	}

}
