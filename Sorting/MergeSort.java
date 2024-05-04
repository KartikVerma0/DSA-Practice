package Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = { 1, 4, 7, 2, 3, 5 };
        nums = mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    static int[] mergeSort(int[] nums) {
        if (nums.length == 1) {
            return nums;
        }
        int mid = nums.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(nums, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(nums, mid, nums.length));

        return merge(left, right);
    }

    static int[] merge(int[] left, int[] right) {
        int i = 0;
        int j = 0;

        int[] sorted = new int[left.length + right.length];
        int k = 0;

        while (i < left.length && j < right.length) {

            if (left[i] < right[j]) {
                sorted[k++] = left[i++];
            } else {
                sorted[k++] = right[j++];
            }
        }

        while (i < left.length) {
            sorted[k++] = left[i++];
        }
        while (j < right.length) {
            sorted[k++] = right[j++];
        }

        return sorted;
    }
}