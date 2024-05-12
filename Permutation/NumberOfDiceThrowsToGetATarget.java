package Permutation;

/*
 * Number of ways to get a target
 */
public class NumberOfDiceThrowsToGetATarget {
    public static void main(String[] args) {
        int target = 4;
        System.out.println(helper(0, target, target));
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
}
