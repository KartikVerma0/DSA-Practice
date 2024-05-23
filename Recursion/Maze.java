/*
 * Find total number of paths to reach final destination
 * 
 * Constraints - You can move only right and down
 */

import java.util.LinkedList;
import java.util.List;

public class Maze {
    public static void main(String[] args) {
        System.out.println(totalPathRD(3, 3));
        List<String> paths = new LinkedList<>();
        pathsRD("", 3, 3, paths);

        for (int i = 0; i < paths.size(); i++) {
            System.out.println(paths.get(i));
        }
        System.out.println();

        System.out.println(totalPathRDDiagonal(3, 3));
        List<String> pathsDiagonal = new LinkedList<>();
        pathsRDDiagonal("", 3, 3, pathsDiagonal);

        for (int i = 0; i < pathsDiagonal.size(); i++) {
            System.out.println(pathsDiagonal.get(i));
        }
    }

    static int totalPathRD(int row, int col) {
        if (row == 0 || col == 0) {
            return 0;
        }

        if (row == 1 && col == 1) {
            return 1;
        }

        int paths = 0;
        // move right
        paths += totalPathRD(row, col - 1);

        // move down
        paths += totalPathRD(row - 1, col);

        return paths;
    }

    static void pathsRD(String currentPath, int row, int col, List<String> paths) {
        if (row == 0 || col == 0) {
            return;
        }

        if (row == 1 && col == 1) {
            paths.add(currentPath);
            return;
        }

        // move right
        pathsRD(currentPath + "R", row, col - 1, paths);

        // move down
        pathsRD(currentPath + "D", row - 1, col, paths);

    }

    static int totalPathRDDiagonal(int row, int col) {
        if (row == 0 || col == 0) {
            return 0;
        }

        if (row == 1 && col == 1) {
            return 1;
        }

        int paths = 0;
        // move right
        paths += totalPathRDDiagonal(row, col - 1);

        // move down
        paths += totalPathRDDiagonal(row - 1, col);

        // move Diagonal
        paths += totalPathRDDiagonal(row - 1, col - 1);

        return paths;
    }

    static void pathsRDDiagonal(String currentPath, int row, int col, List<String> paths) {
        if (row == 0 || col == 0) {
            return;
        }

        if (row == 1 && col == 1) {
            paths.add(currentPath);
            return;
        }

        // move right
        pathsRDDiagonal(currentPath + "R", row, col - 1, paths);

        // move down
        pathsRDDiagonal(currentPath + "D", row - 1, col, paths);

        // move diagonal
        pathsRDDiagonal(currentPath + "Di", row - 1, col - 1, paths);

    }
}
