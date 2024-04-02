package BitwiseOperator;

public class FindRightmostSetBit {
    public static void main(String[] args) {
        System.out.println(findRightmostSetBit(256));
    }

    static int findRightmostSetBit(int num) {
        int position = 1;
        while ((num & 1) != 1) {
            num = num >> 1;
            position++;
        }

        return position;
    }
}
