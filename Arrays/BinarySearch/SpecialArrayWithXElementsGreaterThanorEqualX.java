package Arrays.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

/*
 * 1608. Special Array With X Elements Greater Than or Equal X
 * [https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/description/]
 */
public class SpecialArrayWithXElementsGreaterThanorEqualX {
    public static void main(String[] args) {
        int[] num = { 3, 6, 7, 7, 0 };
        System.out.println(specialArray(num));
    }

    static int specialArray(int[] num) {
        Arrays.sort(num); // first we sort the array so that we can have an idea that elements are present
                          // in ascending order
        HashMap<Integer, Integer> greatMap = greaterThanMap(num);
        Set<Integer> keySet = greatMap.keySet(); // this function return the map which contains values that tells how
                                                 // many elements are greater than equal to that key
        ArrayList<Integer> keyList = new ArrayList<>(keySet); // convert it to list

        Collections.sort(keyList); // sort the key list

        int start = 0;
        int end = num[num.length - 1];

        // now we try to find a number that which is exactly to elements in array
        // greater or equal to
        // the number
        while (start <= end) {
            int mid = start + (end - start) / 2;

            // if key is present in key list, we get its value and check if it's value
            // equal/less/greater than the key
            if (keyList.contains(mid)) {
                int valueOfKey = greatMap.get(mid);
                if (mid == valueOfKey) { // if the key and value are equal then we return the key
                    return mid;
                } else if (mid < valueOfKey) { // if the key is less than value then we reduce the search space to
                                               // second half of array
                    start = mid + 1;
                } else if (mid > valueOfKey) { // if the key is greater than value then we reduce the search space to
                                               // first half of array
                    end = mid - 1;
                }
            } else { // if the key is not present in the key list, then we find the next greater
                     // element,
                     // because if x has m elements greater to itself and y is less than x
                     // then it also has m elements greater to itself,
                     // For Eg: {3:2}, 3 has 2 elements greater or equal to itself
                     // then 1 will also have 2 elements greater or equal to itself
                int nextBigElement = mid + 1;
                for (int index = nextBigElement; index <= num[num.length - 1]; index++) {
                    if (keyList.contains(index)) {
                        nextBigElement = index;
                        break;
                    }
                }

                int valueOfKey = greatMap.get(nextBigElement);
                if (mid == valueOfKey) { // if the value of next greater element is equal to key then we return the key
                    return mid;
                } else if (mid < valueOfKey) { // if the key is less than value of next greater element then we reduce
                                               // the search space to
                                               // second half of array
                    start = mid + 1;
                } else if (mid > valueOfKey) { // if the key is greater than value of next greater element then we
                                               // reduce
                                               // the search space to
                                               // first half of array
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

    static HashMap<Integer, Integer> greaterThanMap(int[] num) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int greaterThanI = 0;
        for (int i = num.length - 1; i >= 0; i--) {
            if (map.containsKey(num[i])) {
                map.put(num[i], map.get(num[i]) + 1);
            } else {
                map.put(num[i], greaterThanI + 1);
            }
            greaterThanI++;
        }
        return map;
    }
}
