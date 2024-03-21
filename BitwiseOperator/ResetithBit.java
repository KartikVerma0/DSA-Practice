package BitwiseOperator;

public class ResetithBit {
    public static void main(String[] args) {
        System.out.println(resetIthBit(5, 3));

    }

    static int resetIthBit(int num, int i) {
        int mask = 1 << (i - 1);
        return num ^ mask;
    }
}
