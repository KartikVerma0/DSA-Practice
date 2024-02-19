package Arrays;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 5, 6, 7, 8, 9 };
        int[] array2 = { 1, 2, 3, 5, 6, 7, 8, 9 };
        System.out.println(Arrays.toString(leftRotate(array, 3)));
        System.out.println(Arrays.toString(rightRotate(array2, 3)));
    }

    // swap function
    static void swap(int[] arr, int index1, int index2) {
        int temp2 = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp2;
    }

    static int[] leftRotate(int[] arr, int n) {
        if (n == 0)
            return arr;
        int temp = arr[0];
        int size = arr.length;
        for (int i = 0; i < size - 1; i++) {
            swap(arr, i, i + 1);
        }
        arr[size - 1] = temp;
        return leftRotate(arr, n - 1);
    }

    static int[] rightRotate(int[] arr, int n) {
        if (n == 0)
            return arr;
        int size = arr.length;
        int temp = arr[size - 1];
        for (int i = size - 1; i > 0; i--) {
            swap(arr, i, i - 1);
        }
        arr[0] = temp;
        return rightRotate(arr, n - 1);
    }
}
