// The 'Miscria Champions League' (MCL) is coming soon, and its preparations have already started.
// ThunderCracker is busy practicing with his team, when suddenly he thinks of an interesting problem.

// ThunderCracker's team consists of 'N' players (including himself). 
// All the players stand in a straight line (numbered from 1 to N), and pass the ball to each others.
//  The maximum power with which any player can hit the ball on the i'th pass is given by an array A[i]. 
// This means that if a player at position 'j' (1<=j<=N) has the ball at the time of the i'th pass,
// he can pass it to any player with a position from (j-A[i]) to (j-1), or from (j+1) to (j+A[i]) (provided that the position exists).

// Now, Thunder Cracker wants to find out the number of ways in which, after exactly M passes, 
// the ball reaches his friend Munkee,given that the first pass is made by ThunderCracker. 
// (Two ways are considered different if there exists atleast one pass which resulted in the ball being 
// passed to a different player.)

// Input:
// The first line of the input consists of 4 space separated integers N (denoting the number of players), M (denoting the number of passes), and X and Y, denoting Thunder Cracker's and Munkee's numbers respectively.
// The next line contains M space separated integers, denoting array A, the power with which passes can be made in the i'th pass (1<=i<=M).

// Output:
// A single integer, that is the number of ways in which the ball can be passed such that the first pass is made by ThunderCracker, and the ball reaches Munkee after M passes.. As the answer can be very large, output it modulo 1000000007.

// Constraints:
// 2 <= N <= 2000
// 1< M <= 2000
// 1 <= Ai <= 1000
// 1 <= X, Y <= N
// It is guaranteed that X and Y are distinct integers.

// Sample Input
// 3 3 2 1
// 1 1 1

// Sample Output
// 2

// Explanation
// ThunderCracker is at pos-2 and munkee at pos-1,
// as all the passes have same intensity, from jth place one can move to [j-A[i], j-1] and [j+1,j+A[i]]
// From pos-2 thunder cracker can move like this in 3 passes.
// 1st way-(2->3,3->2,2->1)
// 2nd way-(2->1,1->2,2->1)

// Sample Input
// 3 2 1 3
// 1 1

// Sample Output
// 1

import java.util.Scanner;

public class MiscriaChampionsLeague {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String firstLine = sc.nextLine();
        String[] firstLineSplit = firstLine.split(" ");
        int n = Integer.valueOf(firstLineSplit[0]);
        int m = Integer.valueOf(firstLineSplit[1]);
        int x = Integer.valueOf(firstLineSplit[2]);
        int y = Integer.valueOf(firstLineSplit[3]);
        String a = sc.nextLine();
        sc.close();

        String[] tempArr = a.split(" ");
        int[] maxPowerArray = new int[tempArr.length];

        for (int i = 0; i < maxPowerArray.length; i++) {
            maxPowerArray[i] = Integer.valueOf(tempArr[i]);
        }

        ballTransferWays(n, m, x, y, maxPowerArray);
    }

    static void ballTransferWays(int n, int m, int thunderCrackerPos, int munkeePos, int[] maxPowerArray) {
        System.out.println(helper(thunderCrackerPos, munkeePos, 0, m, n, maxPowerArray));
    }

    static int helper(int currentPlayer, int finalPlayer, int pass, int m, int n, int[] maxPowerArray) {
        if (pass == m) {
            if (currentPlayer == finalPlayer) {
                return 1;
            } else {
                return 0;
            }
        }

        int leftPlayerBound = currentPlayer - maxPowerArray[pass];
        int rightPlayerBound = currentPlayer + maxPowerArray[pass];

        if (leftPlayerBound < 1) {
            leftPlayerBound = 1;
        }

        if (rightPlayerBound > n) {
            rightPlayerBound = n;
        }

        int ways = 0;
        for (int i = leftPlayerBound; i <= rightPlayerBound; i++) {
            if (i == currentPlayer)
                continue;
            ways += helper(i, finalPlayer, pass + 1, m, n, maxPowerArray);
        }

        return ways;

    }
}
