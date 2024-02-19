package Function;

import java.util.Scanner;

public class isPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        System.out.println(isPalindromeFunction(num));
    }

    static boolean isPalindromeFunction(int num) {
        int originalNumber = num;
        int reverse = 0;
        while (num >= 1) {
            int remainder = num % 10;
            reverse = reverse * 10 + remainder;
            num /= 10;
        }
        return originalNumber == reverse;
    }
}
