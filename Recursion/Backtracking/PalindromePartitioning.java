package Backtracking;

import java.util.LinkedList;
import java.util.List;

/*
 * 131. Palindrome Partitioning
 * [https://leetcode.com/problems/palindrome-partitioning/]
 */

public class PalindromePartitioning {
    public static void main(String[] args) {
        List<List<String>> partitionedSubstrings = partition("aaab");

        for (int i = 0; i < partitionedSubstrings.size(); i++) {
            System.out.println(partitionedSubstrings.get(i).toString());
        }
    }

    static List<List<String>> partition(String s) {
        List<String> processed = new LinkedList<>();
        List<List<String>> palindromePartitions = new LinkedList<>();
        subPartitions(processed, s, palindromePartitions);

        return palindromePartitions;
    }

    static void subPartitions(List<String> processed, String unProcessed, List<List<String>> palindromePartitions) {
        if (unProcessed.length() == 0) {
            if (isPalindromeList(processed)) {
                palindromePartitions.add(processed);
            }
            return;
        }

        for (int i = 1; i <= unProcessed.length(); i++) {
            String newUnprocessed = i < unProcessed.length() ? unProcessed.substring(i) : "";
            List<String> newProcessed = new LinkedList<>(processed);
            newProcessed.add(unProcessed.substring(0, i));
            subPartitions(newProcessed, newUnprocessed, palindromePartitions);
        }
    }

    static boolean isPalindromeList(List<String> list) {
        for (String string : list) {
            if (!isPalindrome(string)) {
                return false;
            }
        }

        return true;
    }

    static boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
