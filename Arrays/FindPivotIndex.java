package Arrays;

/*
 * 724. Find Pivot Index
 * [https://leetcode.com/problems/find-pivot-index/description/]
 */

public class FindPivotIndex {
    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[] { 2, 1, -1 }));
    }

    static int pivotIndex(int[] num) {
        int[] prefixArray = prefixArray(num);
        for (int i = 0; i < num.length; i++) {
            int leftSum = 0;
            if (i > 0) {
                leftSum = prefixArray[i - 1];
            }
            int rightSum = 0;
            if (i < num.length - 1) {
                rightSum = prefixArray[num.length - 1] - prefixArray[i];
            }

            if (leftSum == rightSum)
                return i;
        }

        return -1;
    }

    static int[] prefixArray(int[] num) {
        int[] prefixArray = new int[num.length];
        prefixArray[0] = num[0];
        for (int i = 1; i < prefixArray.length; i++) {
            prefixArray[i] = prefixArray[i - 1] + num[i];
        }

        return prefixArray;
    }
}
