/*
 * 832. Flipping an Image
 * [https://leetcode.com/problems/flipping-an-image/]
 */

package BitwiseOperator;

public class FlippingAnImage {
    public static void main(String[] args) {
        // int rowsAndCol = 3;
        int[][] binaryMatrix = {
                { 1, 1, 0, 0 },
                { 1, 0, 0, 1 },
                { 0, 1, 1, 1 },
                { 1, 0, 1, 0 }
        };

        /*
         * 1 0 0
         * 0 1 0
         * 1 1 1
         */

        int[][] flippedImage = flip(binaryMatrix);

        for (int i = 0; i < flippedImage.length; i++) {
            for (int j = 0; j < flippedImage[i].length; j++) {
                System.out.print(flippedImage[i][j] + " ");
            }
            System.out.println();
        }

    }

    static void swap(int[] arr, int ind1, int ind2) {
        arr[ind1] = arr[ind1] + arr[ind2];
        arr[ind2] = arr[ind1] - arr[ind2];
        arr[ind1] = arr[ind1] - arr[ind2];
    }

    static int[][] flip(int[][] binaryMatrix) {
        for (int i = 0; i < binaryMatrix.length; i++) {
            for (int j = 0; j < binaryMatrix[i].length / 2; j++) {
                swap(binaryMatrix[i], j, binaryMatrix[i].length - j - 1);
            }
        }

        for (int i = 0; i < binaryMatrix.length; i++) {
            for (int j = 0; j < binaryMatrix[i].length; j++) {
                binaryMatrix[i][j] = binaryMatrix[i][j] ^ 1;
            }
        }

        return binaryMatrix;
    }

}
