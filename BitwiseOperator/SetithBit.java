package BitwiseOperator;

public class SetithBit {
    public static void main(String[] args) {
        System.out.println(setithBit(4, 1));
    }

    static int setithBit(int num, int i) {
        int mask = 1 << i - 1;
        return num | mask;
    }
}
