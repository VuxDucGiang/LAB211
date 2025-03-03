package Week7.Shape;
public class Square extends TwoDimensionalShape{
    private double side;

    public Square(double side) {
        this.side = side;
    }
    @Override
    public double getArea(){
        return side * side;
    }
    @Override
    public String toString(){
        return "Square with Side: " +side;
    }
}
