/*
 * 41. First Missing Positive
 * [https://leetcode.com/problems/first-missing-positive/]
 */

package Arrays.CyclicSort;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = { 3, 1 };
        System.out.println(firstMissingPositive(nums));
    }

    static int firstMissingPositive(int[] nums) {
        int minElement = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minElement && nums[i] >= 0) {
                minElement = nums[i];
            }
        }

        if (minElement > 1 || minElement < 0)
            return 1;

        nums = sort(nums, minElement);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != (i + minElement)) {
                return i + minElement;
            }
        }
        return nums.length + minElement;
    }

    static int[] sort(int[] nums, int minElement) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != (i + minElement)) {
                if (nums[i] < 0)
                    break;
                if (nums[i] >= minElement + nums.length)
                    break;
                if (nums[i] == nums[nums[i] - minElement])
                    break;
                swap(nums, i, nums[i] - minElement);
            }
        }

        return nums;
    }

    static void swap(int[] nums, int i1, int i2) {
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }
}
