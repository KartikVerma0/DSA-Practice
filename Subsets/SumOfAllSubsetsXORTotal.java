package Subsets;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * 1863. Sum of All Subset XOR Totals
 * [https://leetcode.com/problems/sum-of-all-subset-xor-totals]
 */

public class SumOfAllSubsetsXORTotal {
    public static void main(String[] args) {
        System.out.println(subsetXORSum(new int[] { 5, 1, 6 }));
    }

    static int xorSum = 0;

    static int subsetXORSum(int[] num) {
        xorSum = 0;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        subsets(new int[] {}, num, list);
        return xorSum;
    }

    static void subsets(int[] processed, int[] unprocessed,
            ArrayList<ArrayList<Integer>> list) {

        if (unprocessed.length == 0) {
            xorSum += xor(processed, 0);
            return;
        }
        int[] newProcessed = Arrays.copyOf(processed, processed.length + 1);
        newProcessed[newProcessed.length - 1] = unprocessed[0];
        subsets(newProcessed, Arrays.copyOfRange(unprocessed, 1, unprocessed.length), list);
        subsets(processed, Arrays.copyOfRange(unprocessed, 1, unprocessed.length), list);
    }

    static int xor(int[] num, int index) {
        if (index >= num.length) {
            return 0;
        }

        int currentXor = num[index] ^ xor(num, index + 1);
        return currentXor;
    }

}
