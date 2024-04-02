package BitwiseOperator;

public class FindSumOfnthRowInPascalTriangle {
    public static void main(String[] args) {
        int row = 6;
        System.out.println(findSum(row));
    }

    static int findSum(int row) {
        return 1 << row - 1;
    }
}
