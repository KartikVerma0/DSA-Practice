package Sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = { 3, 6, 2, 4, 1, 0, 9 };
        // int[] nums = { 5, 4, 3, 2, 1 };
        // int[] nums = { 1, 2, 3, 4, 5 };
        // int[] nums = { -1, -2, -3, -4, -5 };
        // int[] nums = {};
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void swap(int[] nums, int i1, int i2) {
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }

    static void insertionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            // For Every Index,
            // Put that index element
            // at the correct index of LHS (sorted).
            for (int j = i + 1; j > 0; j--) {
                if (nums[j - 1] > nums[j]) {
                    swap(nums, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }
}
