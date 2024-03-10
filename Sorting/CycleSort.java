package Sorting;

import java.util.Arrays;

class CycleSort {
    public static void main(String[] args) {
        int[] nums = { 3, 5, 2, 4, 1 };
        // int[] nums = { 5, 4, 3, 2, 1 };
        // int[] nums = { 1, 2, 3, 4, 5 };
        // int[] nums = {};
        cycleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }

    static void cycleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            // check if value at i is at correct position
            // if not then keep swapping unitil element at i is i+1
            // if yes move forward (i++)
            while (nums[i] != i + 1) {
                int i1 = i;
                int i2 = nums[i] - 1;
                swap(nums, i1, i2);
            }
        }
    }
}
