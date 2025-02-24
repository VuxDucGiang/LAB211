
package Week6.ContactManagementProgram.View;

import java.util.Scanner;

public class DataInput {
    public static String inputString() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String result = scanner.nextLine();
            if (!result.isEmpty()) {
                return result;
            } else {
                System.out.println("Input must not be empty");
                System.out.println("Please input again: ");
            }
        }
    }
}

