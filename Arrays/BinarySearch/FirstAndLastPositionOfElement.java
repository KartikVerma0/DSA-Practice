/* 
 * 34. Find First and Last Position of Element in Sorted Array
 * [https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/]
 * 
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 * You must write an algorithm with O(log n) runtime complexity.
 *  
 */

import java.util.Arrays;

public class FirstAndLastPositionOfElement {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[] { 1, 1 }, 0)));
    }

    static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0)
            return new int[] { -1, -1 };
        int start = 0;
        int end = nums.length - 1;
        int[] res = new int[2];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (start < nums.length && nums[start] == target) {
            res[0] = start;
        } else {
            res[0] = -1;
        }
        start = 0;
        end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (end >= 0 && nums[end] == target) {
            res[1] = end;
        } else {
            res[1] = -1;
        }

        return res;
    }
}
