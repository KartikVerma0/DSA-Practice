import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * 140. Word Break II
 * [https://leetcode.com/problems/word-break-ii/description]
 */

public class WordBreak2 {
    public static void main(String[] args) {
        String s = "pineapplepenapple";
        List<String> wordDict = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
        List<String> res = wordBreak(s, wordDict);

        for (String string : res) {
            System.out.println(string);
        }
    }

    static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new LinkedList<>();
        helper("", s, wordDict, res);
        return res;
    }

    static void helper(String processed, String unProcessed, List<String> wordDict, List<String> res) {
        if (unProcessed.isEmpty()) {
            res.add(processed);
            return;
        }

        for (int i = 0; i <= unProcessed.length(); i++) {
            String subStr = unProcessed.substring(0, i);
            if (wordDict.contains(subStr)) {
                if (processed.equals("")) {
                    helper(processed + subStr, unProcessed.substring(i), wordDict, res);
                } else {
                    helper(processed + " " + subStr, unProcessed.substring(i), wordDict, res);
                }
            }
        }
    }
}
