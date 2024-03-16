/*
 * 442. Find All Duplicates in an Array
 * [https://leetcode.com/problems/find-all-duplicates-in-an-array/description/]
 */

package Arrays.CyclicSort;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {
    public static void main(String[] args) {
        int[] nums = { 1 };
        List<Integer> list = findDuplicates(nums);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    static void swap(int[] nums, int i1, int i2) {
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }

    static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != (i + 1)) {
                if (nums[i] == nums[nums[i] - 1]) {
                    break;
                }
                swap(nums, nums[i] - 1, i);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != (i + 1)) {
                list.add(nums[i]);
            }
        }
        return list;
    }

}
