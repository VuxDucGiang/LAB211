package Week2.DevelopComputerProgram;

import java.util.Scanner;

public class ComputerProgram {

    private Scanner sc;

    public ComputerProgram(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        while (true) {
            displayMenu();
            int choice = getValidChoice();
            switch (choice) {
                case 1:
                    handleNormalCalculator();
                    break;
                case 2:
                    handleBMICalculator();
                    break;
                case 3:
                    System.out.println("Exiting Program!!!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid Option. Please choose again.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("======= Calculator Program =======");
        System.out.println("1. Normal Calculator");
        System.out.println("2. BMI Calculator");
        System.out.println("3. Exit");
        System.out.println("\nPlease choose one option: ");
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

    private float getFloatInput(String message) {
        while (true) {
            try {
                System.out.println(message);
                return Float.parseFloat(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input. Please enter a number:");
            }
        }
    }

    private void handleNormalCalculator() {
        System.out.println("======= Normal Calculator =======");
        float num1 = getFloatInput("Enter  Number: ");
        NormalCalculator normalCalculator = new NormalCalculator(num1);
        normalCalculator.calculate();
    }

    private void handleBMICalculator() {
        System.out.println("======= BMI Calculator =======");
        float weight = getFloatInput("Enter weight (kg): ");
        float height = getFloatInput("Enter height (m): ");
        BMICalculator bc = new BMICalculator(weight, height);
        bc.calculate();
}
}
