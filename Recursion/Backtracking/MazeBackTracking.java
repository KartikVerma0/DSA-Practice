package Backtracking;

public class MazeBackTracking {
    public static void main(String[] args) {
        // Boolean[]
        int size = 3;
        boolean[][] hasVisited = new boolean[size][size];
        backtracking("", 0, 0, size, hasVisited);
    }

    static void backtracking(String path, int row, int col, int size, boolean[][] hasVisited) {
        // if the coordinate is out of bounds then return
        if (row >= size || col >= size || row < 0 || col < 0) {
            return;
        }

        // if the current cell is already visited in the current path, then also we
        // return
        if (hasVisited[row][col]) {
            return;
        }

        if (row == size - 1 && col == size - 1) {
            System.out.println(path);
            return;
        }

        // marking the current cell visited status as marked
        hasVisited[row][col] = true;

        // making choices for the path
        backtracking(path + "D", row + 1, col, size, hasVisited);
        backtracking(path + "R", row, col + 1, size, hasVisited);
        backtracking(path + "L", row, col - 1, size, hasVisited);
        backtracking(path + "U", row - 1, col, size, hasVisited);

        // restoring the visited status of the cell
        hasVisited[row][col] = false;
    }
}
