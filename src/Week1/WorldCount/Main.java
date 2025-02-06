package Week1.WorldCount;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Input the String: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        LetterAndCharacterCount letterAndCharacterCount = new LetterAndCharacterCount(input);

        letterAndCharacterCount.coundCharacter(input);
        letterAndCharacterCount.countWord(input);

    }
}
