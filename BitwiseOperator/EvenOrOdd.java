package BitwiseOperator;

public class EvenOrOdd {
    public static void main(String[] args) {
        int num = 99;
        if (isEven(num)) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }
    }

    static boolean isEven(int num) {
        return (num & 1) == 0;
    }
}
