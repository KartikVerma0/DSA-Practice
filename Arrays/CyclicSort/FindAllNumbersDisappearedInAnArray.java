/*
 * 448. Find All Numbers Disappeared in an Array
 * [https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/]
 */

package Arrays.CyclicSort;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        int[] nums = { 4, 3, 2, 7, 7, 2, 3, 1 };
        List<Integer> list = findDisappearedNumbers(nums);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    static void swap(int[] nums, int i1, int i2) {
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }

    static List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != (i + 1)) {
                if (nums[i] == nums[nums[i] - 1])
                    break;
                swap(nums, nums[i] - 1, i);
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != (i + 1)) {
                list.add(i + 1);
            }
        }

        return list;
    }

}
