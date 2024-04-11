package MathsQuestions;

import java.lang.Math;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        printPrimeTillN(40);
    }

    static void printPrimeTillN(int n) {
        boolean[] isComposite = new boolean[n - 2];

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (!isComposite[i - 2]) {
                for (int j = 2 * i; j < n; j = j + i) {
                    isComposite[j - 2] = true;
                }
            }
        }

        for (int i = 2; i < n; i++) {
            if (!isComposite[i - 2]) {
                System.out.println(i);
            }
        }
    }
}