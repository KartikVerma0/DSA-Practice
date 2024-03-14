/*
 * 930. Binary Subarrays With Sum
 * [https://leetcode.com/problems/binary-subarrays-with-sum/]
 */

package Arrays.SlidingWindow;

public class BinarySubarrayWithSum {
    public static void main(String[] args) {
        System.out.println(numSubarraysWithSum(new int[] { 0, 0, 0, 0, 0 }, 0));
    }

    static int numSubarraysWithSum(int[] nums, int goal) {
        int passIndex = 0;
        int left = 0;
        int right = 0;
        int sum = nums[left];
        int count = 0;
        int length = nums.length;
        while (left <= right && passIndex < length) {
            if (!(sum > goal)) {
                if (sum == goal)
                    count++;
                right++;
                if (right == length) {
                    left = ++passIndex;
                    right = passIndex;
                    if (passIndex >= length)
                        break;
                    sum = nums[left];
                    continue;
                }
                sum += nums[right];
            } else {
                left = ++passIndex;
                right = passIndex;
                if (passIndex >= length)
                    break;
                sum = nums[left];
                continue;
            }
        }
        return count;
    }
}
