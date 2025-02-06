package Week2.DevelopComputerProgram;

import java.util.ArrayList;
import java.util.List;

public class BMICalculator extends Computer {

    private float weight;
    private float height;

    public BMICalculator(float weight, float height) {
        this.weight = weight;
        this.height = height;
    }

    @Override
    public List<Float> calculate() {
        List<Float> result = new ArrayList<>();
        float bmi = weight / (height * height);
        result.add(bmi);

        System.out.println("Your BMI is: " + bmi);

        if (bmi < 18.5) {
            System.out.println("Underweight");
        } else if (bmi < 24.9) {
            System.out.println("Normal weight");
        } else if (bmi < 29.9) {
            System.out.println("Overweight");
        } else {
            System.out.println("Obesity");
        }

        return result;
    }
}
