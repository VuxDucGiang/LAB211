package Week2.ShapeCalculator;

import java.util.Scanner;

public class CalculatorProgram {

    private Scanner sc;

    public CalculatorProgram(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        while (true) {
            displayMenu();
            int choice = getValidChoice();
            switch (choice) {
                case 1:
                    handleCalculator();
                    break;
                case 2:
                    System.out.println("Exiting the program!!!!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid Option. Choose Again");
            }
        }
    }
    private void displayMenu (){
        System.out.println("===== Calculator Program =====");
        System.out.println("1. Shape Calculator");
        System.out.println("2. Exit");
        System.out.println("\n Please choose one option:");
    }
    
    private int getValidChoice(){
        while (true){
            try {
                return Integer.parseInt(sc.nextLine());
                
            }catch (NumberFormatException e){
                System.out.println("Invalid Input. Again: ");
            }
        }
    }
    
    private void handleCalculator (){
        getInputRectangle();
        getInputCircle();
        getInputTriangle();
    }
    
    private void getInputRectangle (){
        System.out.println("Please input width of Rectangle: ");
        float recWidth = sc.nextFloat();
        System.out.println("Please input height of Rectangle: ");
        float recHeight = sc.nextFloat();
        Rectangle rectangle = new Rectangle(recHeight,recWidth);
        rectangle.calculate();
    }
    private void getInputCircle(){
        System.out.println("Please input Radius of Cirlce:");
        float radius = sc.nextFloat();
        Circle circle = new Circle(radius);
        circle.calculate();
    }
    private void getInputTriangle(){
        System.out.println("Please input side A of Triangle: ");
        float sideA = sc.nextFloat();
        System.out.println("Please input side B of Triangle: ");
        float sideB = sc.nextFloat();
        System.out.println("Please input side C of Triangle: ");
        float sideC = sc.nextFloat();
        Triangle triangle = new Triangle(sideA, sideB, sideC);
        triangle.calculate();
    }
}
