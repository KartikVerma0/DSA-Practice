package BitwiseOperator;

public class FindXORfrom0toN {
    public static void main(String[] args) {
        System.out.println(findXOR(2024));
    }

    // 0 -> 0 ,when n % 4 == 0 , result of xor is n;
    // 0^1 -> 1 ,when n % 4 == 1 , result of xor is 1;
    // 0^1^2 -> 3 ,when n % 4 == 2 , result of xor is n+1;
    // 0^1^2^3 -> 0 ,when n % 4 == 3 , result of xor is 0;
    // 0^1^2^3^4 -> 4
    // 0^1^2^3^4^5 -> 1
    // 0^1^2^3^4^5^6 -> 7
    // 0^1^2^3^4^5^6^7 -> 0
    // 0^1^2^3^4^5^6^7^8 -> 8

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
                break;
        }
        return -1;
    }

}
