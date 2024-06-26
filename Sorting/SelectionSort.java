package Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = { 3, 6, 2, 4, 1, 0, 9 };
        // int[] nums = { 5, 4, 3, 2, 1 };
        // int[] nums = { 1, 2, 3, 4, 5 };
        // int[] nums = { -1, -2, -3, -4, -5 };
        // int[] nums = {};
        // selectionSort(nums);
        selectionSortWithRecursion(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {

            // get the index of max element
            int maxIndex = 0;
            for (int j = 1; j < nums.length - i; j++) {
                maxIndex = nums[j] > nums[maxIndex] ? j : maxIndex;
            }

            // now swap the max element with the last index of unsorted array
            int temp = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = nums[maxIndex];
            nums[maxIndex] = temp;
        }
    }

    static void selectionSortWithRecursion(int[] nums) {
        sortHelper(0, 1, nums, 0);
    }

    static void sortHelper(int i, int j, int[] nums, int maxIndex) {
        if (i >= nums.length - 1) {
            return;
        }

        if (j >= nums.length - i) {
            int temp = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = nums[maxIndex];
            nums[maxIndex] = temp;
            sortHelper(i + 1, 1, nums, 0);
            return;
        }

        if (nums[j] >= nums[maxIndex]) {
            maxIndex = j;
        }
        sortHelper(i, j + 1, nums, maxIndex);

    }
}