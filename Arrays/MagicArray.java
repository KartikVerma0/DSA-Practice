/*
 * Magic Array
 * [https://practice.geeksforgeeks.org/contest/gfg-weekly-coding-contest-143/problems]
 * 
 * Given an array of n non-negative integers arr,
 *  check whether arr is a magic array or not.
 *  An array is said to be magic array if no 2 consecutively indexed integers in the array have same parity.
 * If arr is a magic array, return 1, else, 0.
 */

package Arrays;

public class MagicArray {
    public static void main(String[] args) {
        System.out.println(isMagicArray(4, new int[] { 1, 2, 3, 4 }));
    }

    static boolean isMagicArray(int n, int[] arr) {
        // code here
        for (int i = 0; i < arr.length - 1; i++) {
            if (!checkParity(arr[i], arr[i + 1])) {
                return false;
            }
        }
        return true;
    }

    static boolean checkParity(int num1, int num2) {
        boolean isEven1 = true;
        boolean isEven2 = true;

        if (num1 % 2 != 0)
            isEven1 = false;
        if (num2 % 2 != 0)
            isEven2 = false;
        if (isEven1 == isEven2)
            return false;
        return true;
    }
}
