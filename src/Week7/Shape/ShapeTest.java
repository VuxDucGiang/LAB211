package Week7.Shape;

public class ShapeTest {

    public static void main(String[] args) {
        Shape[] shapes = {
            new Circle(5),
            new Square(4),
            new Triangle(3, 6),
            new Sphere(3),
            new Cube(2),
            new Tetrahedron(3)
        };

        for (Shape shape : shapes) {
            System.out.println(shape);
            System.out.println("Type: " + shape.getType());

            if (shape instanceof TwoDimensionalShape) {
                System.out.printf("Area: %.3f%n", ((TwoDimensionalShape) shape).getArea());
            } else if (shape instanceof ThreeDimensionalShape) {
                System.out.printf("Surface Area: %.3f%n", ((ThreeDimensionalShape) shape).getArea());
                System.out.printf("Volume: %.3f%n", ((ThreeDimensionalShape) shape).getVolume());
            }
            System.out.println("----------------------");
        }
    }
}
