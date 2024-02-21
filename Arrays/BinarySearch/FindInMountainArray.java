/*
 * 1095. Find in Mountain Array
 * [https://leetcode.com/problems/find-in-mountain-array/]
 *  
 */

// /**
//  * // This is MountainArray's API interface.
//  * // You should not implement it, or speculate about its implementation
//  * interface MountainArray {
//  * public int get(int index) {}
//  * public int length() {}
//  * }
//  */

// class Solution {
//     public int findInMountainArray(int target, MountainArray mountainArr) {
//         int peak = peakIndexInMountainArray(mountainArr);
//         int firstPosition = binarySearch(mountainArr, target, 0, peak);
//         int secondPosition = binarySearch(mountainArr, target, peak + 1, mountainArr.length() - 1);
//         if (firstPosition == -1) {
//             return secondPosition;
//         }
//         return firstPosition;
//     }

//     static int binarySearch(MountainArray mountainArr, int target, int start, int end) {
//         if (mountainArr.get(start) < mountainArr.get(end)) {
//             while (start <= end) {
//                 int mid = start + (end - start) / 2;
//                 int midElement = mountainArr.get(mid);
//                 if (midElement == target) {
//                     return mid;
//                 } else if (target > midElement) {
//                     start = mid + 1;
//                 } else {
//                     end = mid - 1;
//                 }
//             }
//         } else {
//             while (start <= end) {
//                 int mid = start + (end - start) / 2;
//                 int midElement = mountainArr.get(mid);
//                 if (midElement == target) {
//                     return mid;
//                 } else if (target < midElement) {
//                     start = mid + 1;
//                 } else {
//                     end = mid - 1;
//                 }
//             }
//         }
//         return -1;
//     }

//     static int peakIndexInMountainArray(MountainArray mountainArr) {
//         int start = 0;
//         int end = mountainArr.length() - 1;

//         while (start <= end) {
//             int mid = start + (end - start) / 2;
//             if (mountainArr.get(mid + 1) > mountainArr.get(mid)) {
//                 start = mid + 1;
//             } else if (mountainArr.get(mid - 1) > mountainArr.get(mid)) {
//                 end = mid - 1;
//             } else {
//                 return mid;
//             }
//         }
//         return 0;
//     }
// }

public class FindInMountainArray {
    public static void main(String[] args) {
        int[] mountainArray = { 1, 6, 11, 16, 21, 26, 31, 36, 41, 46, 51, 56, 61, 66, 71, 76, 81, 86, 91, 96, 101, 96,
                91, 86, 81, 76, 71, 66, 61, 56, 51, 46, 41, 36, 31, 26, 21, 16, 11, 6 };
        int target = 81;
        System.out.println(findInMountainArray(mountainArray, target));
    }

    static int findInMountainArray(int[] arr, int target) {
        int peak = peakIndexInMountainArray(arr);
        int firstPosition = binarySearch(arr, target, 0, peak);
        int secondPosition = binarySearch(arr, target, peak + 1, arr.length - 1);
        if (firstPosition == -1) {
            return secondPosition;
        }
        return firstPosition;
    }

    static int binarySearch(int[] nums, int target, int start, int end) {
        if (nums[start] < nums[end]) {
            while (start <= end) {
                int mid = start + (end - start) / 2;
                int midElement = nums[mid];
                if (midElement == target) {
                    return mid;
                } else if (target > midElement) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        } else {
            while (start <= end) {
                int mid = start + (end - start) / 2;
                int midElement = nums[mid];
                if (midElement == target) {
                    return mid;
                } else if (target < midElement) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
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
