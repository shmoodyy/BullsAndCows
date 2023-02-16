package bullscows;

public class Main {

    public static void main(String[] args) {

        BullsAndCows bAC = new BullsAndCows();
        int turnCount = 1;

        if (!SecretCode.errorFound) {
            do {
                System.out.println("Turn " + turnCount + ":");
                bAC.bullsAndCowsGame();
                turnCount++;
            } while (!bAC.gameOver);

            System.out.println("Congratulations! You guessed the secret code.");

        } else return;

    }
}