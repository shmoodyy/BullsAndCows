import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        final double degreeConverter = 180;
        double vector1a = scanner.nextDouble();
        double vector1b = scanner.nextDouble();
        double vector2a = scanner.nextDouble();
        double vector2b = scanner.nextDouble();

        double scalarProduct = (vector1a * vector2a) + (vector1b * vector2b);

        double vector1 = Math.abs(Math.sqrt(Math.pow(vector1a, 2)
                + Math.pow(vector1b, 2)));

        double vector2 = Math.abs(Math.sqrt(Math.pow(vector2a, 2)
                + Math.pow(vector2b, 2)));

        double angle = Math.acos(scalarProduct / (vector1 * vector2));

        angle *= degreeConverter / Math.PI;
        System.out.println(Math.floor(angle));




    }
}