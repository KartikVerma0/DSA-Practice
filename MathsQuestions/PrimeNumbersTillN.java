package MathsQuestions;

public class PrimeNumbersTillN {
    public static void main(String[] args) {
        printPrimeTillN(40);
    }

    static void printPrimeTillN(int num) {
        for (int i = 2; i < num; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
