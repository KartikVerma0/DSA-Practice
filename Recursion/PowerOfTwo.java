/*
 * 231. Power of Two
 * https://leetcode.com/problems/power-of-two/
 * 
 * Given an integer n, return true if it is a power of two. Otherwise, return false.
 *  An integer n is a power of two, if there exists an integer x such that n == 2x.
 */

public class PowerOfTwo {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(2147483646));
    }

    static boolean isPowerOfTwo(int n) {
        if (n == 1)
            return true;
        if (n < 1)
            return false;
        if (n % 2 != 0)
            return false;
        return isPowerOfTwo(n / 2);
    }
}