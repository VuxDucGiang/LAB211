package Week7.Shape;

abstract class ThreeDimensionalShape extends Shape{
    public abstract double getArea();
    public abstract double getVolume();

    @Override
    public String getType (){
        return "Three - Dimensional Shape";
    }
    
}
