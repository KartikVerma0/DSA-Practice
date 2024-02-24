/* 
 * Find the Rotation Count in Rotated Sorted array
 * [https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/]
*/

public class RotationCountInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = { 15, 18, 2, 3, 6, 12 };
        System.out.println(rotationCount(arr));
    }

    static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1])
                return mid;
            if (arr[mid] >= arr[start]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    static int rotationCount(int[] arr) {
        return (findPivot(arr) + 1) % arr.length;
    }
}
