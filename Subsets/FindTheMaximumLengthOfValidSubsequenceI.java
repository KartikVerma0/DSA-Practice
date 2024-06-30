package Subsets;

import java.util.Arrays;

/*
 * 100357. Find the Maximum Length of Valid Subsequence I
 * [https://leetcode.com/problems/find-the-maximum-length-of-valid-subsequence-i/description/]
 */

//  Needs Optimization

public class FindTheMaximumLengthOfValidSubsequenceI {
    public static void main(String[] args) {
        System.out.println(maximumLength(new int[] { 2, 10, 6, 4, 9, 5, 9, 4, 6, 9, 3, 4, 5, 5, 4, 1, 7, 4, 3, 7, 9, 5,
                8, 7, 9, 4, 2, 7, 4, 10, 2, 2, 2, 6, 1, 9, 9, 3, 10, 3, 2, 3, 8, 1, 10, 9, 4, 2, 7, 5 }));
    }

    static int maximumLength(int[] nums) {
        return subsequence(new int[] {}, nums);
    }

    static int subsequence(int[] processed, int[] unprocessed) {
        int processedLength = processed.length;
        if (processedLength >= 3) {
            if (!((processed[processedLength - 1] + processed[processedLength - 2])
                    % 2 == (processed[processedLength - 2] + processed[processedLength - 3]) % 2))
                return 0;
        }

        if (unprocessed.length == 0) {
            return processed.length;
        }

        int[] newProcessed = Arrays.copyOf(processed, processedLength + 1);
        newProcessed[newProcessed.length - 1] = unprocessed[0];
        int[] newUnprocessed = Arrays.copyOfRange(unprocessed, 1, unprocessed.length);

        int right = subsequence(newProcessed, newUnprocessed);
        int left = subsequence(processed, newUnprocessed);

        return Math.max(left, right);
    }
}
