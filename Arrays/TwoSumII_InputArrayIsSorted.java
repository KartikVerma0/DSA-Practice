package Arrays;

import java.util.Arrays;

/*
 * 167. Two Sum II - Input Array Is Sorted
 * [https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/]
 */

public class TwoSumII_InputArrayIsSorted {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[] { 2, 7, 11, 15 }, 9)));
    }

    /*
     * Time Complexity - O(NLogN)
     */
    // static int[] twoSum(int[] numbers, int target) {
    // for (int i = 0; i < numbers.length; i++) {
    // int left = i + 1;
    // int right = numbers.length - 1;
    // while (left <= right) {
    // int mid = left + (right - left) / 2;
    // int sum = numbers[i] + numbers[mid];
    // if (sum == target) {
    // return new int[] { i + 1, mid + 1 };
    // } else if (sum < target) {
    // left = mid + 1;
    // } else {
    // right = mid - 1;
    // }
    // }
    // }

    // return new int[] { -1, -1 };
    // }

    /*
     * Time Complexity - O(N)
     */
    static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left <= right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[] { left + 1, right + 1 };
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            }
        }

        return new int[] { -1, -1 };
    }
}
