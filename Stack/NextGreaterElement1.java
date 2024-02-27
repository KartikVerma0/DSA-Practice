/*
 * 496. Next Greater Element I
 * [https://leetcode.com/problems/next-greater-element-i/]
 */

import java.util.Arrays;
import java.util.HashMap;
// import java.util.Stack;

public class NextGreaterElement1 {

    /* Using Stack */

    // public static void main(String[] args) {
    // int[] arr1 = { 1, 3, 5, 2, 4 };
    // int[] arr2 = { 6, 5, 4, 3, 2, 1, 7 };
    // System.out.println(Arrays.toString(nextGreaterElement(arr1, arr2)));
    // }

    // static int[] nextGreaterElement(int[] nums1, int[] nums2) {
    // Stack<Integer> stk1 = new Stack<>();
    // Stack<Integer> stk2 = new Stack<>();

    // for (int i = nums2.length - 1; i >= 0; i--) {
    // stk1.push(nums2[i]);
    // }
    // int[] res = new int[nums1.length];
    // for (int i = 0; i < nums1.length; i++) {
    // while (stk1.peek() != nums1[i]) {
    // stk2.push(stk1.pop());
    // }
    // stk2.push(stk1.pop());
    // boolean greaterFound = false;
    // while (stk1.size() != 0) {
    // if (stk1.peek() <= nums1[i]) {
    // stk2.push(stk1.pop());
    // } else {
    // res[i] = stk1.peek();
    // stk2.push(stk1.pop());
    // greaterFound = true;
    // break;
    // }
    // }
    // if (!greaterFound) {
    // res[i] = -1;
    // }

    // while (stk2.size() != 0) {
    // stk1.push(stk2.pop());
    // }
    // }
    // return res;
    // }

    /* Using HashMap */

    public static void main(String[] args) {
        int[] arr1 = { 4, 1, 2 };
        int[] arr2 = { 1, 3, 4, 2 };
        System.out.println(Arrays.toString(nextGreaterElement(arr1, arr2)));
    }

    static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int length2 = nums2.length;
        int[] greaterArray = new int[length2];
        int previous = nums2[length2 - 1];
        int greatest = nums2[length2 - 1];
        mp.put(nums2[length2 - 1], length2 - 1);
        greaterArray[length2 - 1] = -1;
        for (int i = length2 - 2; i >= 0; i--) {
            int current = nums2[i];
            for (int j = i + 1; j < nums2.length; j++) {
                if (nums2[j] > nums2[i]) {
                    greatest = nums2[j];
                    break;
                }
            }
            if (previous > current) {
                greaterArray[i] = previous;
            } else if (previous < current && current < greatest) {
                greaterArray[i] = greatest;
            } else if (previous < current && current > greatest) {
                greaterArray[i] = -1;
            }

            previous = current;
            mp.put(nums2[i], i);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = greaterArray[mp.get(nums1[i])];
        }

        return res;
    }
}
