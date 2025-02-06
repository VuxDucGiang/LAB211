
package Week3.QuickSort;


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

}
