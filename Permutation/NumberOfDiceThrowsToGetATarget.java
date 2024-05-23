package Permutation;

import java.util.ArrayList;

/*
 * Number of ways to get a target
 */
public class NumberOfDiceThrowsToGetATarget {
    public static void main(String[] args) {
        int target = 4;
        // System.out.println(helper(0, target, target));
        System.out.println(helperArrayList(0, target, target, new ArrayList<>()).toString());
    }

    static int helper(int processed, int unprocessed, int target) {
        int ways = 0;
        if (processed == target) {
            return 1;
        }
        if (processed > target) {
            return ways;
        }
        for (int i = 1; i <= 6; i++) {
            ways += helper(processed + i, unprocessed - i, target);
        }
        return ways;
    }

    static ArrayList<Integer> helperArrayList(int processed, int unprocessed, int target,
            ArrayList<Integer> processedList) {
        ArrayList<Integer> list = new ArrayList<>();
        if (processed == target) {
            return processedList;
        }
        if (processed > target) {
            return list;
        }
        for (int i = 1; i <= 6; i++) {
            processedList.add(i);
            list.addAll(helperArrayList(processed + i, unprocessed - i, target, processedList));
            int index = processedList.indexOf(i);
            processedList.remove(index);
        }
        return list;
    }
}
