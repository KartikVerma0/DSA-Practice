package Arrays.BinarySearch;

import java.util.Arrays;

public class BSinMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 28, 29, 37, 49 },
                { 33, 34, 38, 50 }
        };
        int matrixSize = 4;
        int target = 29;
        System.out.println(Arrays.toString(search(matrix, matrixSize, target)));
    }

    static int[] search(int[][] matrix, int matrixSize, int target) {
        int rows = 0;
        int cols = matrixSize - 1;
        while (rows < matrixSize && cols >= 0) {
            int comparator = matrix[rows][cols];
            if (target == comparator) {
                return new int[] { rows, cols };
            } else if (target < comparator) {
                cols--;
            } else {
                rows++;
            }
        }
        return new int[] { -1, -1 };
    }
}
