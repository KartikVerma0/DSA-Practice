package BitwiseOperator;

public class Pow {
    public static void main(String[] args) {
        int base = 5;
        int power = 4;
        System.out.println(power(base, power));
    }

    static int power(int base, int power) {
        int res = 1;

        while (power > 0) {
            if ((power & 1) != 0) {
                res = res * base;
            }

            power = power >> 1;
            base = base * base;
        }

        return res;
    }
}
