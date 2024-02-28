/*
 * 74. Search a 2D Matrix
 * [https://leetcode.com/problems/search-a-2d-matrix/]
 */

package Arrays.BinarySearch;

public class SearchA2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 3, 5, 7 },
                { 10, 11, 16, 20 },
                { 23, 30, 34, 50 }
        };
        int target = 50;
        System.out.println(searchMatrix(matrix, target));
    }

    static boolean searchMatrix(int[][] matrix, int target) {
        int startX = 0;
        int startY = 0;
        int endX = matrix.length - 1;
        int endY = matrix[0].length - 1;

        while (startX < endX) {
            int midX = startX + (endX - startX) / 2;
            int midY = startY + (endY - startY) / 2;
            if (matrix[midX][midY] == target)
                return true;
            if (target > matrix[midX][midY] && target > matrix[midX][endY]) {
                startX = midX + 1;
            } else {
                endX = midX;
            }
        }
        return search(matrix[startX], target);
    }

    static boolean search(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
