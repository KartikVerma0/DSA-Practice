package String;

public class SkipACharacter {
    public static void main(String[] args) {
        String inpStr = "baccad";
        StringBuilder resStrBld = new StringBuilder();
        char characterToSkip = 'c';
        skipACharacter1(inpStr, resStrBld, 0, characterToSkip);
        System.out.println(resStrBld.toString());
    }

    static void skipACharacter1(String inpStr, StringBuilder resStrBld, int index, char characterToSkip) {
        if (index >= inpStr.length()) {
            return;
        }
        if (inpStr.charAt(index) != characterToSkip) {
            resStrBld.append(inpStr.charAt(index));
        }
        skipACharacter1(inpStr, resStrBld, index + 1, characterToSkip);
    }
}
