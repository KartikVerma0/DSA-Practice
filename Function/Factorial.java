package Function;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        sc.close();
        int fact = factorial(input);
        System.out.println("Factorial of " + input + " is: " + fact);

    }

    static int factorial(int n) {
        int factorial = 1;
        while (n > 1) {
            factorial *= n;
            n--;
        }
        return factorial;
    }
}
