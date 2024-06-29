package Arrays;

import java.util.Scanner;

/*
 * Let number of elements be N.
 * Let number of queries be Q.
 * 
 * Time complexity - O(N) + O(Q)
 *                  => O(N) or O(Q) whichever is bigger
 * 
 * O(N) for constructing prefix array
 * O(Q) = Q * O(1) ==> since getting sum has O(1) complexity
 */

public class SumOfArrayUsingPrefixSum {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 7, 3, 9 };
        int[] prefix = prefixArray(arr);
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < prefix.length; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            if (l < 0 || r >= arr.length) {
                break;
            }
            System.out.println("Sum= " + sum(l, r, prefix));
        }

        sc.close();
    }

    static int[] prefixArray(int[] arr) {
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        return prefix;
    }

    static int sum(int left, int right, int[] prefix) {
        return prefix[right] - prefix[left - 1];
    }
}
