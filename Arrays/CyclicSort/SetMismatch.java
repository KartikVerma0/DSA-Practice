/*
 * 645. Set Mismatch
 * [https://leetcode.com/problems/set-mismatch/description/]
 */

package Arrays.CyclicSort;

import java.util.Arrays;

public class SetMismatch {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findErrorNums(new int[] { 1, 2, 2, 4 })));
    }

    static int[] findErrorNums(int[] nums) {
        nums = sort(nums);
        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != (i + 1)) {
                res[0] = nums[i];
                res[1] = i + 1;
                break;
            }
        }

        return res;
    }

    static void swap(int[] nums, int i1, int i2) {
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }

    static int[] sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != (i + 1)) {
                if (nums[i] == nums[nums[i] - 1])
                    break;
                swap(nums, i, nums[i] - 1);
            }
        }
        return nums;
    }
}
