package Sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = { 5, 4, 6, 3, 0, 2, 1 };
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    static void quickSort(int[] nums, int low, int high) {

        if (low >= high) {
            return;
        }

        int start = low;
        int end = high;

        int mid = start + (end - start) / 2;
        int pivot = nums[mid];

        while (start <= end) {
            while (nums[start] < pivot) {
                start++;
            }
            while (nums[end] > pivot) {
                end--;
            }

            if (start <= end) {
                int tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;
                start++;
                end--;
            }
        }

        quickSort(nums, low, end);
        quickSort(nums, start, high);

    }
}
