package Week1.EquationSolverApp;

import java.util.List;
import java.util.Scanner;

public class EquationSolver {

    private Scanner sc;

    public EquationSolver() {
        sc = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            displayMenu();
            int choice = getValidChoice();

            switch (choice) {
                case 1:
                    handleSuperlativeEquation();
                    break;
                case 2:
                    handleQuadraticEquation();
                    break;
                case 3:
                    System.out.println("Exiting Program. Good Bye !");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid Option. Please choose again.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("======== Equation Program ========");
        System.out.println("1. Calculate Superlative Equation");
        System.out.println("2. Calculate Quadratic Equation");
        System.out.println("3. Exit");
        System.out.print("\n Please choice one option: ");

    }

    private int getValidChoice() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Invalid Input. Please enter a number: ");
            }
        }
    }

    private void handleSuperlativeEquation() {
         System.out.println("\n=== Superlative Equation Solver ===");
        float a = getFloatInput("Enter coefficient A: ");
        float b = getFloatInput("Enter coefficient B: ");

        Equation superlativeEquation = new SuperlativeEquation(a, b);
        List<Float> solutions = superlativeEquation.calculate();

        displaySolutions(solutions);
        findNumbers(a, b);
    }

    private void handleQuadraticEquation() {
System.out.println("\n=== Quadratic Equation Solver ===");
        float a = getFloatInput("Enter coefficient A: ");
        float b = getFloatInput("Enter coefficient B: ");
        float c = getFloatInput("Enter coefficient C: ");

        Equation quadraticEquation = new QuadraticEquation(a, b, c);
        List<Float> solutions = quadraticEquation.calculate();

        displaySolutions(solutions);
        findNumbers(a, b, c);
    }

    private float getFloatInput(String message) {
        while (true) {
            try {
                System.out.println(message);
                return Float.parseFloat(sc.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number: ");
            }
        }

    }

    private void displaySolutions(List<Float> solutions) {
        if (solutions == null) {
            System.out.println("The equation has no solution.");
        } else if (solutions.isEmpty()) {
            System.out.println("The equation has infinitely many solutions");
        } else {
            for (int i = 0; i < solutions.size(); i++) {
                System.out.println("Solution x" + (i + 1) + " = " + solutions.get(i));
            }
        }
    }

    private void findNumbers(float... numbers) {
        System.out.print("\nEven numbers: ");
        for (float number : numbers) {
            if ((int) number % 2 == 0) {
                System.out.println((int) number);
            }
        }
        System.out.print("Odd numbers: ");
        for(float number : numbers){
            if((int )number % 2 != 0 ){
                System.out.println((int )number);
        }
        }
        System.out.print("Square numbers: ");
        for(float number : numbers){
            if(isPerfectSquare(number)){
                System.out.println((int ) number);
            }
        }
    }
   private boolean isPerfectSquare(float number) {
        if (number < 0) return false;
        int sqrt = (int) Math.sqrt(number);
        return sqrt * sqrt == number;
    }
}
