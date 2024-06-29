package Arrays;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;

/*
 * 2824. Count Pairs Whose Sum is Less than Target
 * [https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target/description/]
 */

public class CountPairsWhoseSumIsLessThanTarget {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(-1, 1, 2, 3, 1);
        System.out.println(countPairs(list, 2));
    }

    /*
     * Time complexity - O(N^2)
     */
    // static int countPairs(List<Integer> num, int target) {
    // int count = 0;
    // for (int i = 0; i < num.size(); i++) {
    // for (int j = i + 1; j < num.size(); j++) {
    // if (num.get(i) + num.get(j) < target) {
    // count++;
    // }
    // }
    // }

    // return count;
    // }

    /*
     * Time complexity - O(NLogN) + O(N) -> O(NLogN)
     * O(NLogN) for sorting the list
     * O(N) for finding pairs
     */
    static int countPairs(List<Integer> num, int target) {
        Collections.sort(num);

        int left = 0;
        int right = num.size() - 1;

        int count = 0;
        while (left <= right) {
            if (num.get(left) + num.get(right) < target) {
                left++;
                count += right - left + 1;
            } else {
                right--;
            }
        }

        return count;
    }
}
