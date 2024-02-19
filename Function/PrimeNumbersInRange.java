package Function;

import java.util.Scanner;

public class PrimeNumbersInRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int startNum = sc.nextInt();
        int endNum = sc.nextInt();
        sc.close();
        printPrimeInRange(startNum, endNum);
    }

    static boolean isPrime(int num) {
        int c = 2;
        while (c * c <= num) {
            if (num % c == 0) {
                return false;
            }
            c++;
        }
        return true;
    }

    static void printPrimeInRange(int start, int end) {
        for (int currentNum = start + 1; currentNum < end; currentNum++) {
            if (isPrime(currentNum)) {
                System.out.print(currentNum + " ");
            }
        }
    }
}
