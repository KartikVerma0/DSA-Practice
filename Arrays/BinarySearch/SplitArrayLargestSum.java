package Arrays.BinarySearch;

/*
 * 410. Split Array Largest Sum
 * [https://leetcode.com/problems/split-array-largest-sum/description/]
 * 
 */

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        System.out.println(splitArray(new int[] { 7, 2, 5, 10, 8 }, 2));
    }

    static int splitArray(int[] nums, int k) {
        int[] limits = limits(nums);
        int start = limits[0];
        int end = limits[1];

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (start == end)
                return mid;
            if (isSufficient(nums, mid, k)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return 1;
    }

    static boolean isSufficient(int[] nums, int mid, int k) {
        int count = 1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > mid) {
                count++;
                i--;
                sum = 0;
            }
        }
        if (count <= k) {
            return true;
        }
        return false;
    }

    static int[] limits(int[] nums) {
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            sum += nums[i];
        }
        return new int[] { max, sum };
    }
}
