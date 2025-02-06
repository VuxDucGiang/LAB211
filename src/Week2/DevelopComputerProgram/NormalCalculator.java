package Week2.DevelopComputerProgram;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class NormalCalculator extends Computer {

    private float memory;
    private Scanner sc = new Scanner(System.in);

    public NormalCalculator(float num1) {
        this.memory = num1;
    }

    @Override
    public List<Float> calculate() {
        List<Float> results = new ArrayList<>();
        while (true) {
            System.out.println("Enter an operator (+, -, *, /, ^) or '=' to finish: ");
            String operator = sc.nextLine().trim();

            if (operator.equals("=")) {
                System.out.println("Final Result: " + memory);
                results.add(memory);
                break;
            }

            if (!isValidOperator(operator)) {
                System.out.println("Invalid operator! Please input one of (+, -, *, /, ^)");
                continue;
            }

            System.out.println("Enter a number: ");
            float number = sc.nextFloat();
            sc.nextLine(); 

            memory = calculate(memory, number, operator);
            System.out.println("Current Memory: " + memory);
            results.add(memory);
        }
        return results;
    }

    private static boolean isValidOperator(String operator) {
        return operator.equals("+") || operator.equals("-") || operator.equals("*")
                || operator.equals("/") || operator.equals("^");
    }

    private static float calculate(float num1, float num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    System.out.println("Error: Division by zero");
                    return num1;
                }
                return num1 / num2;
            case "^":
                return (float) Math.pow(num1, num2);
            default:
                return num1;
        }
    }
}
