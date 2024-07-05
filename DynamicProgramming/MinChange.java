package DynamicProgramming;

import java.util.HashMap;
import java.util.List;

/*
 * Min Change
 * [https://structy.net/problems/min-change]
 */

public class MinChange {
    public static void main(String[] args) {
        System.out.println(minChange(23, List.of(2, 5, 7)));
    }

    static int minChange(int amount, List<Integer> coins) {
        return minChange(amount, coins, new HashMap<>());
    }

    static int minChange(int amount, List<Integer> coins, HashMap<Integer, Integer> memo) {
        if (amount == 0)
            return 0;
        if (amount < 0)
            return -1;
        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }

        int minCoins = -1;
        for (int coin : coins) {
            int subAmount = amount - coin;
            int subCoins = minChange(subAmount, coins, memo);
            if (subCoins != -1) {
                if (subCoins < minCoins || minCoins == -1) {
                    minCoins = subCoins + 1;
                }
            }
        }

        memo.put(amount, minCoins);

        return minCoins;
    }
}
