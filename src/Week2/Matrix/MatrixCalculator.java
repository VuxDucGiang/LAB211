package Week2.Matrix;

import java.util.Scanner;

public class MatrixCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMatrix Calculator");
            System.out.println("1. Addition of Matrices");
            System.out.println("2. Subtraction of Matrices");
            System.out.println("3. Multiplication of Matrices");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            if (choice == 4) {
                System.out.println("Exiting program...");
                break;
            }
            
            System.out.print("Enter the number of rows for the matrices: ");
            int rows = scanner.nextInt();
            System.out.print("Enter the number of columns for the matrices: ");
            int cols = scanner.nextInt();

        
            System.out.println("Enter values for the first matrix:");
            Matrix matrix1 = inputMatrix(rows, cols, scanner);
            System.out.println("Enter values for the second matrix:");
            Matrix matrix2 = inputMatrix(rows, cols, scanner);


            try {
                Matrix result = null;
                switch (choice) {
                    case 1:
                        result = matrix1.additionMatrix(matrix2);
                        System.out.println("Result of Addition:");
                        break;
                    case 2:
                        result = matrix1.subtractionMatrix(matrix2);
                        System.out.println("Result of Subtraction:");
                        break;
                    case 3:
                        result = matrix1.multiplicationMatrix(matrix2);
                        System.out.println("Result of Multiplication:");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        continue;
                }
                result.displayMatrix();
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }


    public static Matrix inputMatrix(int rows, int cols, Scanner scanner) {
        Matrix matrix = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Enter value for element [" + i + "][" + j + "]: ");
                while (!scanner.hasNextDouble()) {
                    System.out.println("Values of matrix must be numbers. Try again.");
                    scanner.next();
                }
                matrix.setValue(i, j, scanner.nextDouble());
            }
        }
        return matrix;
    }
}
