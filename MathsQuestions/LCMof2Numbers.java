package MathsQuestions;

public class LCMof2Numbers {

    // Product of two numbers - a*b = HCF*LCM
    // LCM = (a*b)/HCF
    public static void main(String[] args) {
        System.out.println(lcm(2, 3));
    }

    static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}
