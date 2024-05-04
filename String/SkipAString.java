package String;

public class SkipAString {
    public static void main(String[] args) {
        String inpString = "abbababbcbapplesanndnsb";
        StringBuilder outString = new StringBuilder();
        String targeString = "ab";
        skipAString(outString, inpString, 0, targeString);
        System.out.println(outString.toString());
    }

    static void skipAString(StringBuilder outString, String inpString, int index, String targetString) {
        if (index >= inpString.length()) {
            return;
        }
        if (inpString.indexOf(targetString, index) == index
                && (targetString == "apple" || inpString.indexOf("apple", index) != index)) {
            skipAString(outString, inpString, index + targetString.length(), targetString);
        } else {
            skipAString(outString.append(inpString.charAt(index)), inpString, index + 1, targetString);
        }
    }
}
