package bullscows;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SecretCode {
    final static int firstLowerCaseLetter = 97;
    static int secretCodeLength, symbolNumber, storageSymbolNumber;

    static boolean invalidNumber, invalidSymbols, invalidSymbolLength, invalidCodeLength, errorFound = false;
    String inputSecretCode;
    String possibleSymbols;

    SecretCode() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Input the length of the secret code:");
            if (scanner.hasNextInt()) {
                secretCodeLength = scanner.nextInt();
            } else {
                invalidNumber = true;
                break;
            }

            if (secretCodeLength > 0 && secretCodeLength <= 36) {
                System.out.println("Input the number of possible symbols in the code:");
                storageSymbolNumber = scanner.nextInt(); // for error printouts
                symbolNumber = storageSymbolNumber - 10; // for functions

                if (symbolNumber < 0 || (symbolNumber + 10) < secretCodeLength) {
                    symbolNumber = -1; // to trigger exception handling
                    invalidSymbols = true;
                    break;
                } else if (symbolNumber > 26) {
                    symbolNumber = -1; // to trigger exception handling
                    invalidSymbolLength = true;
                    break;
                }

                possibleSymbols = symbolNumber == 0 ? ")."
                        : symbolNumber == 1 ? ", a)."
                        : ", " + ((char)(firstLowerCaseLetter) + "-"
                        + (char)(firstLowerCaseLetter + symbolNumber - 1) +").");
                System.out.println("The secret is prepared: "
                        + "*".repeat(secretCodeLength) + " (0-9" + possibleSymbols);
                System.out.println("Okay, let's start a game!");

            } else {
                invalidCodeLength = true;
            }
            break;
        } while (true);

        try {
            inputSecretCode = secretCodeGenerator(secretCodeLength, symbolNumber);
        } catch (Exception e) {
            String error = invalidNumber ? "Error: \"" + scanner.nextLine() + "\" isn't a valid number"
                    : invalidSymbols ? ("Error: it's not possible to generate a code with a length of "
                    + secretCodeLength + " with " + (storageSymbolNumber) + " unique symbols.")
                    : invalidSymbolLength || invalidCodeLength ? "Error: maximum number of possible symbols in the code is 36 (0-9, a-z)." :"";

            System.out.println(error);
            errorFound = true;
        }
    }

    public static String secretCodeGenerator(int secretCodeLength, int symbolNumber) {
        Random random = new Random();
        int codeNumber = random.nextInt((int) ((Math.pow(10, secretCodeLength) - 1)
                - Math.pow(10, secretCodeLength - 1) + 1)) +  (int)(Math.pow(10, secretCodeLength - 1));
        StringBuilder secretCode = new StringBuilder(Arrays.toString(String.valueOf(codeNumber)
                .split("")).replaceAll("[\\[\\],\\s]*", ""));
        StringBuilder repeatChecker = new StringBuilder();

        for (int i = 0; i < secretCode.length(); i++) {
            char codeCharacter = (char)(random.nextInt(((firstLowerCaseLetter) + symbolNumber)
                    - (firstLowerCaseLetter) + 1)
                    + firstLowerCaseLetter);
            boolean repeatFound = false;
            for (int j = 0; j < repeatChecker.length(); j++) {// GREAT WAY TO REMOVE REPEATS, support string
                if (repeatChecker.charAt(j) == secretCode.charAt(i)) {
                    repeatFound = true;
                    break;
                }
            }
            if (!repeatFound) {
                repeatChecker.append(secretCode.charAt(i));
                if (Math.random() > 0.5 && i != 0
                        && !secretCode.toString().contains(String.valueOf(codeCharacter))
                        && symbolNumber == 0) {
                    secretCode.delete(i - 1, i);
                    secretCode.insert(i, codeCharacter);
                }
            }

            if (repeatChecker.length() == secretCodeLength) {
                break;
            }
        }

        if (repeatChecker.length() < secretCodeLength) {
            return secretCodeGenerator(secretCodeLength, symbolNumber); // RECURSIVE CALL when unique digit code shorter than input
        }

        return secretCode.toString();
    }
}
