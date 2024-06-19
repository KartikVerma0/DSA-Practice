package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/*
 * 1482. Minimum Number of Days to Make m Bouquets
 * [https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description]
 */

public class MinimumNumberOfDaysToMakeMBouquets {
    public static void main(String[] args) {
        System.out.println(minDays(new int[] { 1, 10, 3, 10, 2 }, 3, 1));
    }

    static int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length)
            return -1;

        ArrayList<Integer> uniqueSortedDays = sortedUniqueBloomDays(bloomDay);

        int low = 0;
        int high = uniqueSortedDays.get(uniqueSortedDays.size() - 1);

        int minimumDays = -1;
        while (low <= high) {
            int day = low + (high - low) / 2;
            boolean canMakeBouquets = false;

            int index = 0;
            int counter = k;
            int bouquetsRequired = m;
            while (index < bloomDay.length) {
                if (bloomDay[index] <= day) {
                    counter--;
                } else if (bloomDay[index] > day && counter != 0) {
                    counter = k;
                }

                if (counter == 0) {
                    bouquetsRequired--;
                    counter = k;
                }

                if (bouquetsRequired == 0) {
                    canMakeBouquets = true;
                }
                index++;
            }

            if (canMakeBouquets) {
                minimumDays = day;
                high = day - 1;
            } else {
                low = day + 1;
            }
        }

        return minimumDays;
    }

    static ArrayList<Integer> sortedUniqueBloomDays(int[] bloomDay) {
        HashSet<Integer> uniqueDays = new HashSet<>();
        for (int days : bloomDay) {
            uniqueDays.add(days);
        }

        ArrayList<Integer> list = new ArrayList<>(uniqueDays);
        Collections.sort(list);

        return list;
    }
}
