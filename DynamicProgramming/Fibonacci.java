package DynamicProgramming;

import java.util.HashMap;

public class Fibonacci {
    public static void main(String[] args) {
        // System.out.println(fib(40));

        HashMap<Integer, Integer> memo = new HashMap<>();
        System.out.println(fibWithMemoization(4, memo));
    }

    /* Iterative approach */

    // static int fib(int pos) {
    // int first = 1;
    // int second = 1;
    // int next = 1;
    // for (int i = 1; i <= pos - 2; i++) {
    // next = first + second;
    // first = second;
    // second = next;
    // }

    // return next;
    // }

    /* Recursive approach */

    static int fib(int pos) {
        if (pos == 1 || pos == 2) {
            return 1;
        }

        return fib(pos - 1) + fib(pos - 2);
    }

    /* Using Memoization */

    static int fibWithMemoization(int pos, HashMap<Integer, Integer> memo) {
        if (pos == 1 || pos == 2) {
            return 1;
        }

        if (memo.containsKey(pos)) {
            return memo.get(pos);
        }

        int res = fibWithMemoization(pos - 1, memo) + fibWithMemoization(pos - 2, memo);
        memo.put(pos, res);
        return res;
    }

}
