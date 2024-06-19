package Backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * 51. N-Queens
 * [https://leetcode.com/problems/n-queens/description/]
 * 
 * Note: Remove print statements while using on LeetCode to reduce time
 */
public class NQueens {
    public static void main(String[] args) {
        int size = 4;
        System.out.println(solveNQueens(size).toString());
    }

    static List<List<String>> solveNQueens(int size) {
        resultList = new LinkedList<>();
        boolean[][] hasVisited = new boolean[size][size];

        for (int col = 0; col < size; col++) {
            hasVisited[0][col] = true;
            helper(hasVisited, 0, col);
            hasVisited[0][col] = false;
        }

        return resultList;
    }

    static List<List<String>> resultList;

    static void helper(boolean[][] hasVisited, int row, int col) {
        if (canBeEliminated(hasVisited, row, col)) {
            return;
        }

        if (row == hasVisited.length - 1) {
            List<String> currentResult = new LinkedList<>();
            for (int i = 0; i < hasVisited.length; i++) {
                String currentRow = "";
                for (int j = 0; j < hasVisited[i].length; j++) {
                    if (hasVisited[i][j]) {
                        System.out.print("Q ");
                        currentRow += "Q";
                    } else {
                        System.out.print("x ");
                        currentRow += ".";
                    }
                }
                currentResult.add(currentRow);
                System.out.println();
            }
            System.out.println();
            resultList.add(currentResult);
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