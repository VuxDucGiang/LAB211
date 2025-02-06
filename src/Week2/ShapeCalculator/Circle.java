package Week2.ShapeCalculator;

import java.util.ArrayList;
import java.util.List;

public class Circle extends Shape {

    private float radius;
    private double pi = Math.PI;

    public Circle(float radius) {
        this.radius = radius;
    }

    @Override
    public void calculate() {
        System.out.println("===== Circle =====");
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + calArea(radius));
        System.out.println("Perimeter: " + calPerimeter(radius));
    }

    private float calArea(float radius) {
        return (float) ((float) radius * radius * pi);
    }

    private float calPerimeter(float radius) {
        return (float) ((float) 2 * radius * pi);
    }
}
