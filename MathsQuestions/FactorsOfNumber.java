package MathsQuestions;

import java.lang.Math;

public class FactorsOfNumber {
    public static void main(String[] args) {
        factors(50);
    }

    static void factors(int num) {
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                System.out.println(i);
                System.out.println(num / i);
            }
        }
    }
}
