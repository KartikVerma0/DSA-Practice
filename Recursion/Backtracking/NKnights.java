package Backtracking;

public class NKnights {
    public static void main(String[] args) {
        int n = 2;
        boolean[][] board = new boolean[n][n];
        System.out.println(nKnights(board, 0, 0, n));
    }

    static int nKnights(boolean[][] board, int row, int col, int target) {
        if (target == 0) {
            display(board);
            System.out.println();
            return 1;
        }

        if (row == board.length) {
            return 0;
        }

        if (col == board.length) {
            return nKnights(board, row + 1, 0, target);
        }

        int count = 0;
        if (isSafe(board, row, col)) {
            board[row][col] = true;
            count += nKnights(board, row, col + 1, target - 1);
            board[row][col] = false;
        }
        count += nKnights(board, row, col + 1, target);

        return count;
    }

    static boolean isSafe(boolean[][] board, int row, int col) {
        if (row >= 2) {
            if (col >= 1) {
                if (board[row - 2][col - 1]) {
                    return false;
                }
            }
            if (board[row].length - col >= 2) {
                if (board[row - 2][col + 1]) {
                    return false;
                }
            }
        }

        if (col >= 2) {
            if (row >= 1) {
                if (board[row - 1][col - 2]) {
                    return false;
                }
            }
        }

        if (board[row].length - col - 1 >= 2) {
            if (row >= 1) {
                if (board[row - 1][col + 2]) {
                    return false;
                }
            }
        }

        return true;
    }

    static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean element : row) {
                if (element) {
                    System.out.print("K ");
                } else {
                    System.out.print("x ");
                }
            }
            System.out.println();
        }
    }
}
