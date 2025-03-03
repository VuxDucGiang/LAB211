package Week7.Shape;

public class Tetrahedron extends ThreeDimensionalShape {

    private double edge;

    public Tetrahedron(double edge) {
        this.edge = edge;
    }

    @Override
    public double getArea() {
        return Math.sqrt(3) * edge * edge;
    }

    @Override
    public double getVolume() {
        return (Math.pow(edge, 3) / (6 * Math.sqrt(2)));
    }

    @Override
    public String toString() {
        return "Tetrahedron with Edge: " + edge;
    }

}
