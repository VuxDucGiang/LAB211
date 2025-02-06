package Week2.ShapeCalculator;

import java.util.ArrayList;
import java.util.List;

public class Rectangle extends Shape {

    private float height;
    private float width;

    public Rectangle(float height, float width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public void calculate() {
        System.out.println("===== Rectangle =====");
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
        System.out.println("Area: " + calArea(height, width));
        System.out.println("Perimeter: " + calPerimeter(height, width));
    }


    private float calArea(float height, float width) {
        return height * width;
    }

    private float calPerimeter(float height, float width) {
        return (height + width) * 2;
    }

}
