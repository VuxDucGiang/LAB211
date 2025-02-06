package Week3.BinarySearch;

import java.util.Scanner;

public class Input {
    
    private static final Scanner sc = new Scanner(System.in);

    public static int getInt() {
        int value;
        while (true) {
            try {
                System.out.println("Enter the number of elements arrays: ");
                value = Integer.parseInt(sc.nextLine().trim());
                if (value <= 2) {
                    System.out.println("Error: Please enter a positive integer.");
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error : Please input a valid integer.");
            }
        }

    }
     public static int getValue() {
        int value;
        while (true) {
            try {
                System.out.println("Enter the number of searching: ");
                value = Integer.parseInt(sc.nextLine().trim());
                if (value <= 0) {
                    System.out.println("Error: Please enter a positive integer.");
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error : Please input a valid integer.");
            }
        }

    }
}
