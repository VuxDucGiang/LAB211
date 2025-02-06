package Week2.ShapeCalculator;
public class Triangle extends Shape {
    private float sideA;
    private float sideB;
    private float sideC;
    

    public Triangle(float sideA, float sideB, float sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public void calculate() {
         System.out.println("===== Triangle =====");
        System.out.println("Side A: " + sideA);
        System.out.println("Side B: " + sideB);
        System.out.println("Side C: " + sideC);
        System.out.println("Area: " + calArea(sideA, sideB, sideC));
        System.out.println("Perimeter: " + calPerimeter(sideA, sideB, sideC));
    }
    
    private float calArea(float sideA, float sideB, float sideC){
        
        float s  = calPerimeter(sideA, sideB, sideC) / 2;
        float result = (float) Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
        return result;
    }
    
    private float calPerimeter(float sideA, float sideB, float sideC){
        return sideA + sideB + sideC;
    }
    
}
