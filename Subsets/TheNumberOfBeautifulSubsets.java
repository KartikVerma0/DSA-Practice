package Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 2597. The Number of Beautiful Subsets
 * [https://leetcode.com/problems/the-number-of-beautiful-subsets]
 */

public class TheNumberOfBeautifulSubsets {
    public static void main(String[] args) {
        System.out.println(beautifulSubsets(new int[] { 2, 4, 6 }, 2));

    }

    static int beautifulSubsets(int[] num, int k) {
        return subsets(new ArrayList<>(), num, k);
    }

    static int subsets(List<Integer> processed, int[] unprocessed, int k) {
        if (unprocessed.length == 0) {
            if (isBeautifulSubset(processed, k)) {
                return 1;
            } else {
                return 0;
            }
        }

        List<Integer> newProcessed = new ArrayList<>(processed);
        newProcessed.add(unprocessed[0]);

        int[] newUnprocessed = Arrays.copyOfRange(unprocessed, 1, unprocessed.length);

        int left = subsets(newProcessed, newUnprocessed, k);
        int right = subsets(processed, newUnprocessed, k);

        return left + right;
    }

    static boolean isBeautifulSubset(List<Integer> list, int k) {
        if (list.size() == 0)
            return false;
        for (Integer element : list) {
            if (list.contains(element + k)) {
                return false;
            }
        }

        return true;
    }
}
