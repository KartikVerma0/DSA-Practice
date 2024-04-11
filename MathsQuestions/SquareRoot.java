package MathsQuestions;

public class SquareRoot {
    public static void main(String[] args) {
        System.out.println(sqrt(37));
    }

    static String sqrt(int num) {
        int low = 0;
        int high = num;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int sqr = mid * mid;
            if (sqr == num) {
                return Integer.toString(mid);
            } else if (sqr > num) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        double base = high;

        while (base * base <= num) {
            base = base + 0.1;
        }

        return String.format("%.1f", base);
    }
}
