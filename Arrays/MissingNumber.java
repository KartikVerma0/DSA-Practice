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
        System.out.println(missingNumber(new int[] { 3, 0, 1 }));
    }

    static int missingNumber(int[] nums) {
        boolean[] isPresent = new boolean[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            isPresent[nums[i]] = true;
        }
        int index = 0;
        for (int i = 0; i < isPresent.length; i++) {
            if (!isPresent[i]) {
                index = i;
                break;
            }

        }
        return index;
    }
}
