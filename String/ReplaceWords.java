package String;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 648. Replace Words
 * [https://leetcode.com/problems/replace-words/description]
 */
public class ReplaceWords {
    public static void main(String[] args) {
        System.out.println(
                replaceWords(Arrays.asList("a", "aa", "aaa", "aaaa"), "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"));
    }

    static String replaceWords(List<String> dictionary, String sentence) {
        LengthComparator comparator = new LengthComparator();
        dictionary.sort(comparator);

        String[] words = sentence.split(" ");

        StringBuilder str = new StringBuilder();
        for (int index = 0; index < words.length; index++) {
            String currentWordToAdd = words[index];
            for (String dictionaryString : dictionary) {
                if (words[index].indexOf(dictionaryString) == 0) {
                    currentWordToAdd = dictionaryString;
                    break;
                }
            }

            str.append(currentWordToAdd + " ");
        }

        return str.toString().trim();
    }
}

class LengthComparator implements Comparator<String> {
    @Override
    public int compare(String arg0, String arg1) {
        return arg0.length() - arg1.length();

    }
}