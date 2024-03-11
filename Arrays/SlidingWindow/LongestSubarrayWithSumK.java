/*
 *  Coding Ninjas Question
 * 
 *  Longest Subarray With Sum K 
 * [https://www.codingninjas.com/studio/problems/longest-subarray-with-sum-k_6682399]
 */

package Arrays.SlidingWindow;

public class LongestSubarrayWithSumK {

    public static void main(String[] args) {
        int[] a = { 1, 2, 1, 3 };
        int k = 2;
        System.out.println(longestSubarrayWithSumK(a, k));
    }

    static int longestSubarrayWithSumK(int[] a, long k) {
        int left = 0;
        int right = 0;
        long sum = a[left];
        int length = a.length;
        int resLength = 0;
        int[] res = new int[length];
        while (right < length && left < length) {
            if (sum <= k) {
                if (sum == k && ((right - left + 1) > resLength)) {
                    int counter = 0;
                    for (int i = left; i <= right; i++) {
                        res[counter++] = a[i];
                    }
                    resLength = right - left + 1; // resLength could also be counter;
                }
                right++;
                if (right >= length)
                    break;
                sum += a[right];
            } else {
                sum -= a[left];
                left++;
            }

            if (left > right && left < length) {
                right = left;
                sum = a[right];
            }
        }
        return resLength;
    }
}
