package Arrays;

/*
 * Constraints- 1<=N<=10^6
 *              1<=a[i]<=10^4
 */

/*
 * Time Complexity - O(N)
 */

public class FindFrequencyOfElements {
    public static void main(String[] args) {
        freq(new int[] { 1, 7, 7, 2, 3, 6 });
    }

    static void freq(int[] num) {
        int[] freqArr = new int[10000];

        for (int i = 0; i < num.length; i++) {
            freqArr[num[i] - 1]++;
        }

        for (int i = 0; i < freqArr.length; i++) {
            if (freqArr[i] != 0) {
                System.out.print(i + 1 + ":" + freqArr[i] + " , ");
            }
        }
        System.out.println();
    }
}
