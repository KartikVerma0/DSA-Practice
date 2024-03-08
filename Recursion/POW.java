/*
 * 50. Pow(x, n)
 * [https://leetcode.com/problems/powx-n/]
 */

public class POW {
    public static void main(String[] args) {
        System.out.printf("%.5f \n", pow(1.84364, -14));
    }

    static double pow(double x, int n) {
        boolean isNegative = false;
        if (n < 0) {
            isNegative = true;
            n = -1 * n;
        }

        double res = helper(x, n);

        if (isNegative) {
            return 1 / res;
        }

        return res;

    }

    static double helper(double x, int n) {
        if (n == 0)
            return 1;
        if (n == 1) {
            return x;
        }

        if (n % 2 != 0) {
            double res = helper(x, n / 2);
            return res * res * x;
        }

        double res = helper(x, n / 2);
        return res * res;
    }
}
