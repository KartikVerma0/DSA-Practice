package Backtracking;

/*
 * 52. N-Queens II
 * [https://leetcode.com/problems/n-queens-ii/description/]
 */

public class NQueens2 {
    public static void main(String[] args) {
        int size = 4;
        System.out.println(totalNQueens(size));
    }

    static int totalNQueens(int size) {
        resultCount = 0;
        boolean[][] hasVisited = new boolean[size][size];

        for (int col = 0; col < size; col++) {
            hasVisited[0][col] = true;
            helper(hasVisited, 0, col);
            hasVisited[0][col] = false;
        }

        return resultCount;
    }

    static int resultCount;

    static void helper(boolean[][] hasVisited, int row, int col) {
        if (canBeEliminated(hasVisited, row, col)) {
            return;
        }

        if (row == hasVisited.length - 1) {
            resultCount++;
            return;
        }

        for (int i = 0; i < hasVisited[row].length; i++) {
            hasVisited[row + 1][i] = true;
            helper(hasVisited, row + 1, i);
            hasVisited[row + 1][i] = false;
        }
    }

    static boolean canBeEliminated(boolean[][] hasVisited, int row, int col) {
        // check if there is any queen in current column
        for (int i = row - 1; i >= 0; i--) {
            if (hasVisited[i][col]) {
                return true;
            }
        }

        // check if there is any queen in left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (hasVisited[i][j]) {
                return true;
            }
        }

        // check if there is any queen in right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < hasVisited[i].length; i--, j++) {
            if (hasVisited[i][j]) {
                return true;
            }
        }

        return false;
    }
}
