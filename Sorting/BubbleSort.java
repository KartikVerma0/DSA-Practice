package Sorting;

import java.util.Arrays;

class BubbleSort {
    public static void main(String[] args) {
        int[] nums = { 3, 6, 2, 4, 1, 0, 9 };
        // int[] nums = { 5, 4, 3, 2, 1 };
        // int[] nums = { 1, 2, 3, 4, 5 };
        // int[] nums = { -1, -2, -3, -4, -5 };
        // int[] nums = {};
        // bubbleSort(nums);
        bubbleSortWithRecursion(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void bubbleSort(int[] nums) {
        int count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            boolean isSorted = true;
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j - 1] > nums[j]) {
                    isSorted = false;
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
            System.out.println(count++);
            if (isSorted)
                return;
        }
    }

    static void bubbleSortWithRecursion(int[] nums) {
        sortHelper(0, 0, nums, true);
    }

    static void sortHelper(int i, int j, int[] nums, boolean isSorted) {
        if (i >= nums.length - 1) {
            return;
        }

        if (j >= nums.length - i - 1) {
            if (isSorted)
                return;
            sortHelper(i + 1, 0, nums, isSorted);
            return;
        }

        if (nums[j] > nums[j + 1]) {
            isSorted = false;
            int temp = nums[j];
            nums[j] = nums[j + 1];
            nums[j + 1] = temp;
        }
        sortHelper(i, j + 1, nums, isSorted);
    }
}