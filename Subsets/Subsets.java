package Subsets;

import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

/*
 *  78. Subsets
 *  [https://leetcode.com/problems/subsets]
 */
public class Subsets {
    public static void main(String[] args) {
        List<List<Integer>> list = subsets(new int[] { 1, 2, 3 });
        for (int i = 0; i < list.size(); i++) {
            List<Integer> tempList = list.get(i);
            System.out.println(tempList.toString());
        }
    }

    static List<List<Integer>> subsets(int[] num) {
        List<List<Integer>> list = new LinkedList<>();

        List<Integer> processed = new LinkedList<>();

        subsetsHelper(processed, num, list);
        return list;
    }

    static void subsetsHelper(List<Integer> processed, int[] unprocessed, List<List<Integer>> list) {
        if (unprocessed.length == 0) {
            list.add(processed);
            return;
        }

        int[] newUnprocessed = Arrays.copyOfRange(unprocessed, 1, unprocessed.length);
        List<Integer> newProcessed = new LinkedList<>(processed);
        newProcessed.add(unprocessed[0]);
        subsetsHelper(newProcessed, newUnprocessed, list);

        subsetsHelper(processed, newUnprocessed, list);

    }
}
