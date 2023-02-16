import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int limit = 1000;
        int sum = 0;
        int newNumber;

        do {
            newNumber = scanner.nextInt();
            sum += newNumber;
        } while (newNumber != 0 && sum < limit);

        int result = sum < limit ? sum : sum - limit;
        System.out.println(result);
    }
}