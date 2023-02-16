import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // write your code here
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        double m = scanner.nextDouble();
        Random random = new Random();

        double result = 0;
        int check = 0;

        do {
            for (int i = 0; i < n; i++) {
                result = random.nextGaussian();
                if (result > m) {
                    k++;
                    random.setSeed(k); // or ++k
                    check = 0;
                    break;
                }
                check++;
            }
        } while (check != n);
        System.out.println(k);
    }
}