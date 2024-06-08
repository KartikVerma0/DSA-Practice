package Arrays;

/**
 * 523. Continuous Subarray Sum
 * [https://leetcode.com/problems/continuous-subarray-sum/description]
 */
public class ContinuousSubarraySum {

    public static void main(String[] args) {
        int[] nums = { 23, 2, 4, 6, 7 };
        int k = 6;
        System.out.println(checkSubarraySum(nums, k));
    }

    static boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            int counter = 0;
            for (int j = i; j < nums.length; j++) {
                sum = (sum + nums[j]) % k;
                counter++;
                if (counter >= 2 && sum == 0) {
                    return true;
                }
            }
        }

        return false;
    }
}