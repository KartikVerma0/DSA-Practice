package Permutation;

import java.util.HashMap;

/*
 * 552. Student Attendance Record II
 * [https://leetcode.com/problems/student-attendance-record-ii/description/]
 */

// Needs optimization using DP

public class StudentAttendanceRecordII {
    public static void main(String[] args) {

        int length = 10;
        int c = checkRecord(length);
        System.out.println(c);
    }

    static int checkRecord(int n) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("L", 0);
        int count = permutations("", n, map);
        return count;
    }

    static int permutations(String processed, int length,
            HashMap<String, Integer> freqMap) {
        if (length == 0) {
            return 1;
        }

        int count = 0;
        int characterLCount = freqMap.get("L");
        int characterAUpperLimit = freqMap.get("A");
        if (characterAUpperLimit >= 1) {
            freqMap.put("A", --characterAUpperLimit);
            freqMap.put("L", 0);
            count += permutations(processed + "A", length - 1, freqMap);
            freqMap.put("A", ++characterAUpperLimit);
            freqMap.put("L", characterLCount);
        }

        if (characterLCount < 2) {
            int size = processed.length();
            if (!processed.equals("") && processed.charAt(size - 1) == 'L') {
                freqMap.put("L", ++characterLCount);
                count += permutations(processed + "L", length - 1, freqMap);
                freqMap.put("L", --characterLCount);
            } else if (processed.equals("") || processed.charAt(size - 1) != 'L') {
                freqMap.put("L", 1);
                count += permutations(processed + "L", length - 1, freqMap);
                freqMap.put("L", 0);
            }
        }

        freqMap.put("L", 0);
        count += permutations(processed + "P", length - 1, freqMap);
        freqMap.put("L", characterLCount);

        return count;

    }
}
