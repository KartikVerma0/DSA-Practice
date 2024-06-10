package Subsets;

/*
 * 974. Subarray Sums Divisible by K
 * [https://leetcode.com/problems/subarray-sums-divisible-by-k/description/]
 */

public class SubArraySumsDivisibleByK {
    public static void main(String[] args) {
        System.out.println(subArraysDivByK(new int[] { 4, 5, 0, -2, -3, 1 }, 5));
    }

    static int subArraysDivByK(int[] num, int k) {
        return subArrays(num, k);
    }

    static int subArrays(int[] array, int k) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = i; j < array.length; j++) {
                sum += array[j];
                if (sum % k == 0) {
                    result++;
                }
            }

        }

        return result;
    }
}
