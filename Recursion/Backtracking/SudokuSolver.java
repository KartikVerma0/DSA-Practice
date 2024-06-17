package Backtracking;

/**
 * 37. Sudoku Solver
 * [https://leetcode.com/problems/sudoku-solver/description/]
 */
public class SudokuSolver {

    public static void main(String[] args) {
        char[][] board = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        solveSudoku(board);
    }

    static char[][] resultBoard = new char[9][9];

    static void solveSudoku(char[][] board) {
        solve(board, 0, 0);
        copy(resultBoard, board);
        display(board);
    }

    static void solve(char[][] board, int row, int col) {
        if (row >= board.length) {
            copy(board, resultBoard);
            return;
        }

        if (col == board[row].length) {
            solve(board, row + 1, 0);
            return;
        }

        if (board[row][col] != '.') {
            solve(board, row, col + 1);
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (isValidNumber(board, row, col, (char) (i + 48))) {
                board[row][col] = (char) (i + 48);
                solve(board, row, col + 1);
                board[row][col] = '.';
            }
        }

    }

    static void copy(char[][] board, char[][] targetBoard) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                targetBoard[row][col] = board[row][col];
            }
        }
    }

    static boolean isValidNumber(char[][] board, int row, int col, char targetNumber) {
        // check if the target number is already present in the current row
        for (int c = 0; c < board.length; c++) {
            if (board[row][c] == targetNumber) {
                return false;
            }
            ;
        }

        // check if the target number is already present in the current column
        for (int r = 0; r < board.length; r++) {
            if (board[r][col] == targetNumber) {
                return false;
            }
        }

        // check if the target number is already present in the current square box
        for (int r = (row / 3) * 3; r <= ((row / 3) * 3) + 2; r++) {
            for (int c = (col / 3) * 3; c <= ((col / 3) * 3) + 2; c++) {
                if (board[r][c] == targetNumber) {
                    return false;
                }
            }
        }

        return true;
    }

    static void display(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }
}