import java.util.Scanner;

/*
 * Circular Game
 * [https://codeskiller.codingblocks.com/problems/3565]
 */

public class CircularGame {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] charges = new int[n];
        for (int i = 0; i < n; i++) {
            charges[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] costs = new int[m];
        for (int i = 0; i < m; i++) {
            costs[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(helper(charges, costs));

    }

    static int helper(int[] charges, int[] costs) {
        for (int i = 0; i < charges.length; i++) {
            if (canReachStarting(i, i, true, charges, costs, 0))
                return i;
        }

        return -1;
    }

    static boolean canReachStarting(int currentIndex, int startingIndex, boolean isFirstRun, int[] charges, int[] costs,
            int previousCharge) {
        if (currentIndex == startingIndex && !isFirstRun)
            return true;

        int totalCharge = previousCharge + charges[currentIndex];
        int n = costs.length;
        if (totalCharge >= costs[currentIndex]) {
            return canReachStarting((currentIndex + 1) % n, startingIndex, false, charges, costs,
                    totalCharge - costs[currentIndex]);
        } else {
            return false;
        }

    }

}
