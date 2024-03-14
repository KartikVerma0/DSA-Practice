/*
 * 268. Missing Number
 * [https://leetcode.com/problems/missing-number/]
 * 
 * Given an array nums containing n distinct numbers in the range [0, n], 
 * return the only number in the range that is missing from the array.
 * 
 */

package Arrays;

public class MissingNumber {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[] { 3, 1, 0 }));
    }

    // static int missingNumber(int[] nums) {
    // boolean[] isPresent = new boolean[nums.length + 1];

    // for (int i = 0; i < nums.length; i++) {
    // isPresent[nums[i]] = true;
    // }
    // int index = 0;
    // for (int i = 0; i < isPresent.length; i++) {
    // if (!isPresent[i]) {
    // index = i;
    // break;
    // }

    // }
    // return index;
    // }

    static void swap(int[] nums, int i1, int i2) {
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }

    static int missingNumber(int[] nums) {
        int pos = nums.length;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums.length) {
                    pos = i;
                    break;
                }
                swap(nums, nums[i], i);
            }
        }
        return pos;
    }
}
