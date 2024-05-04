package String;

import java.util.ArrayList;

public class Subsets {
    public static void main(String[] args) {
        String inpString = "abc";
        subsets("", inpString);
        System.out.println();

        ArrayList<String> list = subsetsToList("", inpString);
        System.out.println(list.toString());
    }

    static void subsets(String processed, String unprocessed) {
        if (unprocessed.length() == 0) {
            if (!processed.isEmpty()) {
                System.out.print(processed + " ");
            }
            return;
        }

        subsets(processed + unprocessed.charAt(0), unprocessed.substring(1));
        subsets(processed, unprocessed.substring(1));
    }

    static ArrayList<String> subsetsToList(String processed, String unprocessed) {
        if (unprocessed.length() == 0) {
            ArrayList<String> list = new ArrayList<>();
            if (!processed.isEmpty()) {
                list.add(processed);
            }
            return list;
        }

        ArrayList<String> list1 = subsetsToList(processed + unprocessed.charAt(0), unprocessed.substring(1));
        ArrayList<String> list2 = subsetsToList(processed, unprocessed.substring(1));
        list1.addAll(list2);
        return list1;
    }
}
