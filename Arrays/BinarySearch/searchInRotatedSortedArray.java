/*
 * 33. Search in Rotated Sorted Array
 * [https://leetcode.com/problems/search-in-rotated-sorted-array/]
 * 
 */

public class searchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        int pivot = pivot(nums);
        System.out.println(pivot);
        int position = -1;
        if (nums[pivot] == target) {
            System.out.println(pivot);
            return;
        }
        position = binarySearch(nums, target, 0, pivot);
        if (position == -1) {
            position = binarySearch(nums, target, pivot + 1, nums.length - 1);
        }
        System.out.println(position);
    }

    static int pivot(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid]>nums[mid+1]){
                return mid;
            }
            if (nums[mid] >= nums[start]) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return start;
    }

    static int binarySearch(int[] nums, int target, int start, int end) {
        if (start <= end && nums[start] < nums[end]) {
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        } else {
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (target < nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}