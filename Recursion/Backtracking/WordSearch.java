/*
 * 79. Word Search
 * [https://leetcode.com/problems/word-search/]
 */

class WordSearch {
    public static void main(String[] args) {
        char[][] board = {
                { 'a', 'a', 'a', 'a', 'a', 'a' },
                { 'a', 'a', 'a', 'a', 'a', 'a' },
                { 'a', 'a', 'a', 'a', 'a', 'a' },
                { 'a', 'a', 'a', 'a', 'a', 'a' },
                { 'a', 'a', 'a', 'a', 'a', 'a' },
                { 'a', 'a', 'a', 'a', 'a', 'a' },

        };
        System.out.println(exist(board, "baaaaaaaaaaaaaa"));
    }

    static boolean exist(char[][] board, String word) {
        boolean[][] hasVisited = new boolean[board.length][board[0].length];
        return isAvailable(board, 0, 0, word, 0, hasVisited);
    }

    static boolean isTrueFourDirections(boolean[][] hasVisited, int row, int col) {
        if ((row > 0 && row < hasVisited.length - 1) && (hasVisited[row - 1][col] == true
                || hasVisited[row + 1][col] == true)) {
            return true;
        }
        if (row == hasVisited.length - 1 && hasVisited.length >= 2 && hasVisited[row - 1][col] == true) {
            return true;
        }
        if ((col > 0 && col < hasVisited[0].length - 1) && (hasVisited[row][col - 1] == true
                || hasVisited[row][col + 1] == true)) {
            return true;
        }
        if (col == 0 && hasVisited[0].length >= 2 && hasVisited[row][col + 1] == true) {
            return true;
        }
        if (col == hasVisited[0].length - 1 && hasVisited[0].length >= 2 && hasVisited[row][col - 1] == true) {
            return true;
        }
        if (row == 0 && hasVisited.length >= 2 && hasVisited[row + 1][col] == true) {
            return true;
        }
        return false;
    }

    static boolean isAvailable(char[][] board, int row, int col, String target, int counter, boolean[][] hasVisited) {
        if (row >= board.length || col >= board[0].length || row < 0 || col < 0 || counter >= target.length()) {
            return false;
        }
        hasVisited[row][col] = true;

        if (board[row][col] != target.charAt(counter) && counter != 0) {
            hasVisited[row][col] = false;
            return false;
        } else if (board[row][col] != target.charAt(counter) && counter == 0) {
            hasVisited[row][col] = false;
            if (col < board[0].length - 1) {
                return isAvailable(board, row, col + 1, target, counter, hasVisited);
            }
            return isAvailable(board, row + 1, 0, target, counter, hasVisited);

        } else if (board[row][col] == target.charAt(counter) && counter == target.length() - 1) {
            return true;
        }
        // choices
        // up
        if (row > 0 && !hasVisited[row - 1][col]) {
            if (isAvailable(board, row - 1, col, target, ++counter, hasVisited)) {
                return true;
            }
            counter--;
        }
        // down
        if (row < board.length - 1 && !hasVisited[row + 1][col]) {
            if (isAvailable(board, row + 1, col, target, ++counter, hasVisited)) {
                return true;
            }
            counter--;
        }
        // left
        if (col > 0 && !hasVisited[row][col - 1]) {
            if (isAvailable(board, row, col - 1, target, ++counter, hasVisited)) {
                return true;
            }
            counter--;
        }
        // right
        if (col < board[0].length - 1 && !hasVisited[row][col + 1]) {
            if (isAvailable(board, row, col + 1, target, ++counter, hasVisited)) {
                return true;
            }
            counter--;
        }
        hasVisited[row][col] = false;
        if (isTrueFourDirections(hasVisited, row, col)) {
            return false;
        }
        if (col < board[0].length - 1) {
            return isAvailable(board, row, col + 1, target, counter, hasVisited);
        }
        return isAvailable(board, row + 1, 0, target, counter, hasVisited);
    }
}