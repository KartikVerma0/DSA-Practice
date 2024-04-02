package BitwiseOperator;

class MagicNumber {
    public static void main(String[] args) {
        System.out.println(magicNumber(5));
    }

    static int magicNumber(int n) {
        int res = 0;
        int multiplier = 5;
        while (n != 0) {
            res = res + (n & 1) * multiplier;

            multiplier = multiplier * 5;
            n = n >> 1;
        }
        return res;
    }
}