package String;

import java.util.ArrayList;
import java.util.List;

/*
 * 1002. Find Common Characters
 * [https://leetcode.com/problems/find-common-characters]
 */

public class FindCommonCharacters {
    public static void main(String[] args) {
        System.out.println(commonChars(new String[] { "bella", "label", "roller" }).toString());
    }

    static List<String> commonChars(String[] words) {
        List<String> commonChars = new ArrayList<>();

        for (int i = 0; i < words[0].length(); i++) {
            char currentChar = words[0].charAt(i);
            boolean isCommon = true;
            for (int j = 1; j < words.length; j++) {
                if (!words[j].contains(Character.toString(currentChar))) {
                    isCommon = false;
                    break;
                } else {
                    words[j] = words[j].replaceFirst(Character.toString(currentChar), "");
                }
            }

            if (isCommon) {
                commonChars.add(Character.toString(currentChar));
            }
        }

        return commonChars;
    }
}
