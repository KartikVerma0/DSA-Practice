/*
 * 205. Isomorphic Strings
 * [https://leetcode.com/problems/isomorphic-strings/]
 */

package Hashmap;

import java.util.HashMap;
import java.lang.StringBuilder;

class IsomorphicString {
    public static void main(String[] args) {
        String s = "abab";
        String t = "baba";
        System.out.println(isIsomorphic(s, t));
    }

    static String replaceCharacter(String str, char char1, char char2, boolean[] changedCharacters) {
        StringBuilder strBuild = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == char1 && !changedCharacters[i]) {
                strBuild.append(char2);
                changedCharacters[i] = true;
            } else {
                strBuild.append(str.charAt(i));
            }
        }
        return strBuild.toString();
    }

    static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        boolean[] changedCharacters = new boolean[s.length()];
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), s.charAt(i));
        }
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (map.get(tChar) != sChar && !changedCharacters[i]) {
                return false;
            }
            if (sChar != tChar) {
                s = replaceCharacter(s, sChar, tChar, changedCharacters);
            }
        }

        // System.out.print(s + " " + t);

        if (s.equals(t)) {
            return true;
        }

        return false;
    }
}
