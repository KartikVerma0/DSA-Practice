/*
 * 217. Contains Duplicate
 * [https://leetcode.com/problems/contains-duplicate/description/]
 */

package Arrays;

import java.util.HashMap;

public class ContainsDuplicate {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 }));
    }

    static boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (mp.get(nums[i]) == null) {
                mp.put(nums[i], 1);
            } else {
                return true;
            }
        }
        return false;
    }
}
