/*
 * 3046. Split the Array
 * [https://leetcode.com/problems/split-the-array/description/]
 * 
 * Problem came in: Weekly-Contest-386
 */

package Arrays;

import java.util.HashMap;

public class SplitTheArray {
    public static void main(String[] args) {
        System.out.println(isPossibleToSplit(new int[] { 6, 1, 3, 1, 1, 8, 9, 2 }));
    }

    static boolean isPossibleToSplit(int[] nums) {
        HashMap<Integer, Integer> frequency = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int currNum = nums[i];
            if (!frequency.containsKey(currNum)) {
                frequency.put(currNum, 1);
            } else {
                int currentValue = frequency.get(currNum);
                if (currentValue >= 2)
                    return false;
                frequency.put(currNum, currentValue + 1);
            }
        }
        return true;
    }
}
