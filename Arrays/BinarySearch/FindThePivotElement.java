/*
 * 2485. Find the Pivot Integer
 *  [https://leetcode.com/problems/find-the-pivot-integer/]
 */

class FindThePivotElement {
    public static void main(String[] args) {
        System.out.println(pivotInteger(8));
    }

    static int sumStart(int n) {
        int ans = (n * (n + 1)) / 2;
        return ans;
    }

    static int sumEnd(int i, int n) {
        int ans = sumStart(n) - (i * (i + 1)) / 2 + i;
        return ans;
    }

    static int pivotInteger(int n) {
        int start = 1;
        int end = n;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int sumFirstHalf = sumStart(mid);
            int sumSecondHalf = sumEnd(mid, n);
            if (sumFirstHalf == sumSecondHalf) {
                return mid;
            } else if (sumFirstHalf > sumSecondHalf) {
                end = mid - 1;
            } else if (sumFirstHalf < sumSecondHalf) {
                start = mid + 1;
            }
        }
        return -1;
    }
}