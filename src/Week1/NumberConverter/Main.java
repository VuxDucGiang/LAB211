package Week1.NumberConverter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose the original base type:");
        System.out.println("1 - Binary (2)");
        System.out.println("2 - Decimal (10)");
        System.out.println("3 - Hexadecimal (16)");
        System.out.print("Please input your choice: ");
        int baseType = sc.nextInt();
        sc.nextLine();  

        System.out.print("Enter the number: ");
        String fromBase = sc.nextLine();

        NumberConverter converter = new NumberConverter(baseType, fromBase);
        NumberConverterView ncv = new NumberConverterView();

        switch (baseType) {
            case 1:
                ncv.converteFromBin(converter);
                break;
            case 2:
                ncv.converteFromDec(converter);
                break;
            case 3:
                ncv.converteFromHex(converter);
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
}
