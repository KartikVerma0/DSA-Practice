package BitwiseOperator;

public class NumberOfSetBits {
    public static void main(String[] args) {
        System.out.println(setBitsCount(10));
    }

    // Brian Kernighan’s Algorithm
    static int setBitsCount(int num) {
        // num & num-1 unset the rightmost set bit
        // so number of time this operation happen in loop means number of times
        // the set bit got unset.
        // Hence number of times loop will run is number of set bits.
        int count = 0;
        while (num > 0) {
            num = num & (num - 1);
            count++;
        }

        return count;
    }
}
