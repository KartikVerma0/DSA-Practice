package Arrays;

/*
 * 53. Maximum Subarray
 * [https://leetcode.com/problems/maximum-subarray/description/]
 */

public class MaximumSubarray {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
    }

    static int maxSubArray(int[] nums) {
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] >= 0) {
                sum += nums[i];
                ans = Math.max(ans, sum);
            } else {
                sum = 0;
                ans = Math.max(ans, nums[i]);
            }
        }

        return ans;
    }
}
