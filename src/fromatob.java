import java.util.Scanner;

public class fromatob {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        scanner.close();

        int operations = minOperations(a, b);
        System.out.println(operations);
    }

    public static int minOperations(int a, int b) {
        int operations = 0;

        while (a != b) {
            if (a > b && a % 2 == 0) {
                    a /= 2;
            } else {
                a++;
            }
            operations++;
        }

        return operations;
    }
}