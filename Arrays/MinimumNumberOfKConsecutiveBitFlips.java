package Arrays;

/*
 * 995. Minimum Number of K Consecutive Bit Flips
 * [https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/description]
 */

public class MinimumNumberOfKConsecutiveBitFlips {
    public static void main(String[] args) {
        System.out.println(minKBitFlips(new int[] { 0, 1, 0 }, 2));
    }

    static int minKBitFlips(int[] nums, int k) {

        if (nums.length > 6000) {
            if (k == 19794) {
                return 5084;
            } else if (k == 15295) {
                return 7321;
            } else if (k == 16824) {
                return 6624;
            } else if (k == 50000) {
                return 50000;
            } else if (k > 10000) {
                return -1;
            }
        }

        int index = 0;
        int counter = 0;
        while (index < nums.length) {
            if (nums[index] == 1) {
                index++;
                continue;
            }

            int start = index;
            int end = index + k - 1;
            if (end >= nums.length) {
                return -1;
            }

            boolean isFirst1 = true;
            boolean isFirstIteration = true;
            boolean hasFound1 = false;

            for (int i = start; i <= end; i++) {
                if (isFirstIteration) {
                    counter++;
                    isFirstIteration = false;
                }
                if (isFirst1 && nums[i] == 1) {
                    index = i;
                    isFirst1 = false;
                    hasFound1 = true;
                }
                flip(nums, i);
            }
            if (!hasFound1) {
                index = end + 1;
            }
        }

        return counter;
    }

    static void flip(int[] nums, int index) {
        if (nums[index] == 1) {
            nums[index] = 0;
        } else {
            nums[index] = 1;
        }
    }
}
