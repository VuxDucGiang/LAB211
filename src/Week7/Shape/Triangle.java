package Week7.Shape;
public class Triangle extends TwoDimensionalShape{
    private double base, heigth;

    public Triangle(double base, double heigth) {
        this.base = base;
        this.heigth = heigth;
    }
    
    @Override 
    public double getArea (){
        return 0.5 * base * heigth;
    }
    @Override
    public String toString (){
        return "Triangle with Base and Height: " + base+ "," + heigth;
    }
    
}
