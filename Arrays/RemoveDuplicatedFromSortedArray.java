/*
 * 26. Remove Duplicates from Sorted Array
 * [https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/]
 */

package Arrays;

class RemoveDuplicatedFromSortedArray {
    public static void main(String[] args) {
        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        int count = removeDuplicates(nums);
        for (int i = 0; i < count; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    static int removeDuplicates(int[] nums) {
        int previousNumber = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != previousNumber) {
                count++;
                previousNumber = nums[i];
                nums[count - 1] = nums[i];
            }
        }
        return count;
    }
}