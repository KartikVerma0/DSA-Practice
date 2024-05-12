package Matrix;

import java.util.Arrays;

/**
 * 2373. Largest Local Values in a Matrix
 * [https://leetcode.com/problems/largest-local-values-in-a-matrix/]
 */
public class LargestLocalvalueInAMAtrix {
    public static void main(String[] args) {
        int[][] grid = {
                { 9, 9, 8, 1 },
                { 5, 6, 2, 6 },
                { 8, 2, 6, 4 },
                { 6, 2, 2, 2 }
        };
        int[][] maxLocal = largestLocal(grid);
        for (int i = 0; i < maxLocal.length; i++) {
            System.out.println(Arrays.toString(maxLocal[i]));
        }
    }

    static int[][] largestLocal(int[][] grid) {
        int[][] maxLocal = new int[grid.length - 2][grid.length - 2];
        for (int i = 0; i < maxLocal.length; i++) {
            for (int j = 0; j < maxLocal[i].length; j++) {
                maxLocal[i][j] = findMaxHelper(grid, i + 1, j + 1);
            }
        }
        return maxLocal;
    }

    static int findMaxHelper(int[][] matrix, int x, int y) {
        int max = Integer.MIN_VALUE;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }
        return max;
    }
}