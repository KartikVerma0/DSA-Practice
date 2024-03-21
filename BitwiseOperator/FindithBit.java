package BitwiseOperator;

public class FindithBit {
    public static void main(String[] args) {
        System.out.println(ithBit(5, 3));
    }

    static int ithBit(int num, int i) {
        int temp = num >> i - 1;
        return temp & 1;
    }
}
