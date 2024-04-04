package BitwiseOperator;

class IsPowerOf2 {
    public static void main(String[] args) {
        int num = 0;
        System.out.println(isPowerOf2(num));
    }

    static boolean isPowerOf2(int num) {
        if (num == 0)
            return false;
        return (num & (num - 1)) == 0;
    }

    // static boolean isPowerOf2(int num) {
    // if (num == 0)
    // return false;
    // boolean hasFoundOne = false;
    // while (num > 0) {
    // if ((num & 1) == 1 && !hasFoundOne) {
    // hasFoundOne = true;
    // } else if ((num & 1) == 1 && hasFoundOne) {
    // return false;
    // }
    // num = num >> 1;
    // }
    // return true;
    // }
}