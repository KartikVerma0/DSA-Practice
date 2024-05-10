/*
 * 3075. Maximize Happiness of Selected Children
 * [https://leetcode.com/problems/maximize-happiness-of-selected-children/]
 */
package PriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaximizeHappiness {
    public static void main(String[] args) {
        long maxSum = maximumHappinessSum(new int[] { 1, 2, 3 }, 2);
        System.out.println(maxSum);
    }

    static long maximumHappinessSum(int[] happiness, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(happiness.length, Collections.reverseOrder());
        for (int value : happiness) {
            queue.add(value);
        }

        long reducer = 0;
        long sum = 0;
        while (k > 0) {
            long topValue = (long) queue.peek();
            if (topValue - reducer > 0) {
                sum += (topValue - reducer);
                reducer++;
            } else {
                break;
            }
            queue.poll();
            k--;
        }
        return sum;
    }
}
