/*
 * 503. Next Greater Element II
 * [https://leetcode.com/problems/next-greater-element-ii/]
 */

import java.util.Arrays;

public class NextGreaterElement2 {

    public static void main(String[] args) {
        int[] arr = { 100, 1, 11, 1, 120, 111, 123, 1, -1, -100 };
        System.out.println(Arrays.toString(nextGreaterElements(arr)));
    }

    /* Using Loops */
    static int[] nextGreaterElements(int[] nums) {
        int count = 0;
        int index = count + 1;
        int[] res = new int[nums.length];
        while (count < nums.length) {
            index = index >= nums.length ? index % nums.length : index;
            if (index == count) {
                res[count] = -1;
                count++;
                index = count + 1;
                continue;
            }
            if (nums[index] > nums[count]) {
                res[count] = nums[index];
                count++;
                index = count + 1;
                continue;
            }
            index++;
        }
        return res;

    }
}
