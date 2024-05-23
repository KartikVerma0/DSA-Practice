package String;

import java.util.ArrayList;
import java.util.List;

/**
 * Creates subsequences from a string without containing duplicates
 */

public class SubSeqDuplicate {
    public static void main(String[] args) {
        List<String> lst = subSeq("122");
        for (String string : lst) {
            System.out.println(string);
        }
    }

    static List<String> subSeq(String str) {
        List<String> outer = new ArrayList<>();
        outer.add("");

        for (int i = 0; i < str.length(); i++) {
            List<String> inner = new ArrayList<>(outer);
            for (String string : inner) {
                String newStr = string + str.charAt(i);
                if (!outer.contains(newStr)) {
                    outer.add(newStr);
                }
            }
        }

        return outer;
    }
}
