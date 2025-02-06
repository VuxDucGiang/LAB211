package Week1.EquationSolverApp;

import java.util.ArrayList;
import java.util.List;

public class SuperlativeEquation extends Equation {
    private float a;
    private float b;

    public SuperlativeEquation(float a, float b) {
        this.a = a;
        this.b = b;
    }
   @Override
    public List<Float> calculate() {
        if (a == 0) {
            if (b == 0) {
                return new ArrayList<>(); 
            } else {
                return null; 
            }
        } else {
            List<Float> solution = new ArrayList<>();
            solution.add(-b / a);
            return solution;
        }
    }
}
