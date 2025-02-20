package Week5.BigNumber;

import java.util.Scanner;

public class LargeNumberCalculator {
    

    
    public static int[] addLargeNumbers(int[] num1, int[] num2) {
        int maxLength = Math.max(num1.length, num2.length);
        int[] result = new int[maxLength + 1];
        int carry = 0;
        
        for (int i = 0; i < maxLength; i++) {
            int digit1 = (i < num1.length) ? num1[num1.length - 1 - i] : 0;
            int digit2 = (i < num2.length) ? num2[num2.length - 1 - i] : 0;
            int sum = digit1 + digit2 + carry;
            result[result.length - 1 - i] = sum % 10;
            carry = sum / 10;
        }
        result[0] = carry;
        return result;
    }
    
    public static int[] multiplyLargeNumbers(int[] num1, int[] num2) {
        int[] result = new int[num1.length + num2.length];
        for (int i = num1.length - 1; i >= 0; i--) {
            for (int j = num2.length - 1; j >= 0; j--) {
                int product = num1[i] * num2[j];
                int tempPos = i + j + 1;
                int sum = product + result[tempPos];
                result[tempPos] = sum % 10;
                result[tempPos - 1] += sum / 10;
            }
        }
        return result;
    }
    
    public static int[] convertStringToArray(String num) {
        int[] result = new int[num.length()];
        for (int i = 0; i < num.length(); i++) {
            result[i] = num.charAt(i) - '0';
        }
        return result;
    }
    
    public static void printArray(int[] num) {
        boolean leadingZero = true;
        for (int digit : num) {
            if (leadingZero && digit == 0) continue;
            leadingZero = false;
            System.out.print(digit);
        }
        if (leadingZero) System.out.print(0);
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first large number: ");
        int[] num1 = convertStringToArray(scanner.nextLine());
        
        System.out.print("Enter second large number: ");
        int[] num2 = convertStringToArray(scanner.nextLine());
        
        System.out.print("Addition Result: ");
        printArray(addLargeNumbers(num1, num2));
        
        System.out.print("Multiplication Result: ");
        printArray(multiplyLargeNumbers(num1, num2));
    }
}


