package Week7.Shape;
abstract class TwoDimensionalShape extends Shape{
    public abstract double getArea();

    @Override
    public String getType(){
        return "Two - Dimensional Shape";
    }
    
}
