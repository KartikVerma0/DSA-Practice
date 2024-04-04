package BitwiseOperator;

public class FindXORfromAtoB {
    public static void main(String[] args) {
        System.out.println(findXORfromAtoB(5, 10));
    }

    static int findXORfromAtoB(int a, int b) {
        int xorFrom0TillB = findXOR(b);
        int xorFrom0TillAMinus1 = findXOR(a - 1);

        return xorFrom0TillB ^ xorFrom0TillAMinus1;
    }

    static int findXOR(int n) {
        int remainder = n % 4;
        switch (remainder) {
            case 0:
                return n;
            case 1:
                return 1;
            case 2:
                return n + 1;
            case 3:
                return 0;

            default:
                return 0;
        }
    }
}
