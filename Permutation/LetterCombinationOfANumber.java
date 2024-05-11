package Permutation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * 17. Letter Combinations of a Phone Number
 * [https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/]
 */

public class LetterCombinationOfANumber {
    public static void main(String[] args) {
        System.out.println(letterCombinations("").toString());
    }

    static List<String> letterCombinations(String digits) {
        HashMap<String, char[]> map = new HashMap<>();
        map.put("2", new char[] { 'a', 'b', 'c' });
        map.put("3", new char[] { 'd', 'e', 'f' });
        map.put("4", new char[] { 'g', 'h', 'i' });
        map.put("5", new char[] { 'j', 'k', 'l' });
        map.put("6", new char[] { 'm', 'n', 'o' });
        map.put("7", new char[] { 'p', 'q', 'r', 's' });
        map.put("8", new char[] { 't', 'u', 'v' });
        map.put("9", new char[] { 'w', 'x', 'y', 'z' });
        List<String> list = new ArrayList<>();
        combinations("", digits, map, list);
        return list;
    }

    static void combinations(String processed, String unprocessed, HashMap<String, char[]> map, List<String> list) {

        if (unprocessed.isEmpty()) {
            if (!processed.isEmpty()) {
                list.add(processed);
            }
            return;
        }

        char[] numToCharArr = map.get(unprocessed.charAt(0) + "");
        for (int j = 0; j < numToCharArr.length; j++) {
            combinations(processed + numToCharArr[j], unprocessed.substring(1),
                    map, list);
        }

    }
}
