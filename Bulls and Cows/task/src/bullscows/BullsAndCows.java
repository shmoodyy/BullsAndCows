package bullscows;

import java.util.Objects;
import java.util.Scanner;

public class BullsAndCows extends SecretCode {
    boolean gameOver;

    public void bullsAndCowsGame() {
//        System.out.println("CODE IS: " + inputSecretCode);
        int bullCount = 0, cowCount = 0;
        String codeGuess = new Scanner(System.in).next();
        String[] inputArray = codeGuess.split("");
        String[] secretCodeArray = inputSecretCode.split("");

        for (int i = 0; i < inputArray.length; i++) {
            if (inputSecretCode.contains(inputArray[i])) { // REMEMBER THIS TECHNIQUE - checks input(i) for any of these
                if (Objects.equals(inputArray[i], secretCodeArray[i])) {
                    bullCount++;
                } else {
                    cowCount++;
                }
            }
        }

        String grade = (bullCount == 0 && cowCount == 0) ? "None.\n"
                : (bullCount > 1 && cowCount == 0) ? bullCount + " bulls\n"
                : (bullCount == 0 && cowCount > 1) ? cowCount + " cows\n"
                : (bullCount == 1 && cowCount == 0) ? bullCount + " bull\n"
                : (bullCount == 0 && cowCount == 1) ? cowCount + " cow\n"
                : (bullCount == 1 && cowCount == 1) ? bullCount + " bull and " + cowCount + " cow\n"
                : bullCount + " bulls and " + cowCount + " cows\n";

        System.out.printf("Grade: " + grade);

        gameOver = bullCount == secretCodeLength;
    }
}
