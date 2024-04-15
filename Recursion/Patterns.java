public class Patterns {
    public static void main(String[] args) {
        // pattern1(0, 0, 4);
        // pattern1(4, 4);
        pattern2(0, 0, 4);
    }

    static void pattern1(int i, int j, int n) {
        if (i == n) {
            return;
        }
        if (j < n - i) {
            System.out.print("* ");
            pattern1(i, j + 1, n);
        } else {
            System.out.println();
            pattern1(i + 1, 0, n);
        }
    }

    // static void pattern1(int row, int col) {
    // if (row == 0) {
    // return;
    // }

    // if (col == 0) {
    // System.out.println();
    // pattern1(row - 1, row - 1);
    // }

    // if (col > 0) {
    // System.out.print("* ");
    // pattern1(row, col - 1);
    // }

    // }

    static void pattern2(int i, int j, int n) {
        if (i == n) {
            return;
        }

        if (j <= i) {
            System.out.print("* ");
            pattern2(i, j + 1, n);
        } else {
            System.out.println();
            pattern2(i + 1, 0, n);
        }
    }
}
