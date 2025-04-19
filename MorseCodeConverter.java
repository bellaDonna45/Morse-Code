package morsecodepackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MorseCodeConverter {
    private static MorseCodeTree morseTree = new MorseCodeTree();

    public static String convertToEnglish(String code) {
        StringBuilder sb = new StringBuilder();
        String[] words = code.trim().split(" / ");
        for (int i = 0; i < words.length; i++) {
            String[] letters = words[i].trim().split(" ");
            for (String letter : letters) {
                sb.append(morseTree.fetch(letter));
            }
            if (i < words.length - 1) sb.append(" ");
        }
        return sb.toString();
    }

    public static String convertToEnglish(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        StringBuilder code = new StringBuilder();
        while (scanner.hasNextLine()) {
            code.append(scanner.nextLine()).append(" ");
        }
        scanner.close();
        return convertToEnglish(code.toString());
    }

    public static String printTree() {
        StringBuilder sb = new StringBuilder();
        for (String letter : morseTree.toArrayList()) {
            sb.append(letter).append(" ");
        }
        return sb.toString().trim();
    }
}
