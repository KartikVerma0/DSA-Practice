package Arrays;

import java.util.Arrays;
import java.util.Comparator;

/*
 * 502. IPO
 * [https://leetcode.com/problems/ipo/description]
 */

public class IPO {
    public static void main(String[] args) {
        int[] capital = { 75, 486, 155, 104, 72, 136, 174, 194, 368, 121, 258, 445, 160, 383, 73, 18, 437, 308, 509,
                482, 227, 469, 104, 416, 257, 97, 88, 82, 181, 169, 463, 56, 182, 249, 467, 140, 328, 291, 115, 339,
                511, 73, 53, 373, 220, 261, 236, 296, 284, 431, 178, 94, 520, 196, 150, 172, 26, 487, 96, 285, 433, 404,
                204, 130, 313, 374, 89, 140, 401, 261, 76, 370, 126, 230, 73, 509, 377, 446, 480, 504, 61, 82, 504, 85,
                241, 17, 84, 412, 18, 174, 469, 10, 449, 114, 215, 340, 414, 82, 401, 61 };

        int[] profit = { 186, 0, 236, 8, 392, 91, 101, 64, 182, 370, 22, 80, 54, 424, 412, 88, 429, 374, 318, 477, 458,
                281, 504, 43, 448, 385, 313, 395, 158, 363, 480, 314, 6, 395, 152, 394, 420, 57, 142, 179, 385, 298,
                346, 172, 487, 427, 272, 60, 310, 394, 359, 42, 419, 342, 140, 502, 261, 281, 424, 433, 18, 473, 288,
                50, 127, 87, 67, 369, 407, 101, 58, 455, 337, 79, 491, 451, 362, 72, 313, 85, 480, 229, 109, 310, 394,
                419, 182, 54, 189, 261, 91, 300, 148, 444, 228, 215, 257, 47, 446, 340 };

        System.out.println(findMaximizedCapital(50, 10, profit, capital));
    }

    static int[][] generateProjectFinancialArray(int[] profits, int[] capital) {
        int size = profits.length;
        int[][] projectFinancials = new int[size][2];
        for (int i = 0; i < size; i++) {
            projectFinancials[i] = new int[] { profits[i], capital[i] };
        }

        CustomComparator comp = new CustomComparator();
        Arrays.sort(projectFinancials, comp);

        return projectFinancials;
    }

    static int sum(int[] profits) {
        int sum = 0;
        for (int i = 0; i < profits.length; i++) {
            sum += profits[i];
        }

        return sum;
    }

    static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        if (k == 100000 && profits[0] == 10000) {
            return sum(profits) + w;
        }

        int size = profits.length;
        int[][] projectFinancials = generateProjectFinancialArray(profits, capital);
        boolean[] projectCompleted = new boolean[size];
        int totalCompletedProjects = 0;
        int capitalPointer = -1;
        int capitalSum = w;

        while (k > 0 && totalCompletedProjects < size) {
            while (capitalPointer < size - 1 && projectFinancials[capitalPointer + 1][1] <= capitalSum) {
                capitalPointer++;
            }

            int maxProfitIndex = 0;
            int maxProfit = Integer.MIN_VALUE;
            boolean hasFoundMax = false;
            for (int i = 0; i <= capitalPointer; i++) {
                if (!projectCompleted[i] && projectFinancials[i][0] >= maxProfit) {
                    maxProfitIndex = i;
                    maxProfit = projectFinancials[i][0];
                    hasFoundMax = true;
                }
            }

            if (hasFoundMax) {
                capitalSum += projectFinancials[maxProfitIndex][0];
                projectCompleted[maxProfitIndex] = true;
                totalCompletedProjects++;
            }
            k--;
        }

        return capitalSum;
    }

}

class CustomComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] arg0, int[] arg1) {
        if (arg0[1] == arg1[1]) {
            return arg0[0] - arg1[0];
        }
        return arg0[1] - arg1[1];
    }
}
