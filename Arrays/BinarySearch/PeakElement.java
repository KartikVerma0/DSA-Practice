package Arrays.BinarySearch;

/*
 * 852. Peak Index in a Mountain Array
 *  [https://leetcode.com/problems/peak-index-in-a-mountain-array/]
 *  An array arr is a mountain if the following properties hold:
 *  ~ arr.length >= 3
 *  ~ There exists some i with 0 < i < arr.length - 1 such that:
 *       ~ arr[0] < arr[1] < ... < arr[i - 1] < arr[i] 
 *       ~ arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * Given a mountain array arr, return the index i such that arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].
 */

public class PeakElement {
    public static void main(String[] args) {
        int[] mountainArray = { 0, 10, 5, 2 };
        System.out.println(peakIndexInMountainArray(mountainArray));
    }

    static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid + 1] > arr[mid]) {
                start = mid + 1;
            } else if (arr[mid - 1] > arr[mid]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return 0;
    }
}
