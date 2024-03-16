/*
 * 287. Find the Duplicate Number
 * [https://leetcode.com/problems/find-the-duplicate-number/description/]
 */

package Arrays.CyclicSort;

public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        int[] nums = { 3, 1, 3, 4, 2 };
        System.out.println(findDuplicate(nums));
    }

    static void swap(int[] nums, int i1, int i2) {
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }

    static int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != (i + 1)) {
                if (nums[i] == nums[nums[i] - 1]) {
                    return nums[i];
                }
                swap(nums, nums[i] - 1, i);
            }
        }
        return -1;
    }
}
