package Week1.EquationSolverApp;

import java.util.ArrayList;
import java.util.List;

public class QuadraticEquation extends Equation {
    
    private float a;
    private float b;
    private float c;

    public QuadraticEquation(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public List<Float> calculate() {
        if (a == 0) {
            return new SuperlativeEquation(b, c).calculate(); // bx+c = 0
        }

        float delta = b * b - 4 * a * c;
        if (delta < 0) {
            return null;
        } else if (delta == 0) {
            List<Float> solution = new ArrayList<>();
            solution.add(-b / (2 * a));
            return solution;
        } else {
            List<Float> solutions = new ArrayList<>();
            solutions.add((-b + (float) Math.sqrt(delta)) / (2 * a));
            solutions.add((-b - (float) Math.sqrt(delta)) / (2 * a));
            return solutions;
        }
    }
}
