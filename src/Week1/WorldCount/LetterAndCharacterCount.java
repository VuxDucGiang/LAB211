package Week1.WorldCount;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class LetterAndCharacterCount {

    private String input;

    public LetterAndCharacterCount(String input) {
        this.input = input;
    }

    public void countWord(String input) {
        StringTokenizer tokenizer = new StringTokenizer(input, " ");
        Map<String, Integer> wordCount = new HashMap<>();
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken().toLowerCase();
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        System.out.println("Word count: " + wordCount);

    }

    public void coundCharacter(String input) {
        Map<Character, Integer> letterCount = new TreeMap<>();

        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                c = Character.toLowerCase(c);
                letterCount.put(c, letterCount.getOrDefault(c, 0) + 1);
            }
        }
        System.out.println("Letter Count: " + letterCount);
    }
}
