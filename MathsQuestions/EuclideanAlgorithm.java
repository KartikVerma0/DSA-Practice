package MathsQuestions;

public class EuclideanAlgorithm {
    public static void main(String[] args) {
        System.out.println(gcd(50, 25));
    }

    static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }

        return gcd(b % a, a);
    }

}
