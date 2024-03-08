import java.util.Arrays;

class AllCombinations {
    public static void main(String[] args) {
        int outputLen = 3;
        int bCount = 1;
        int cCount = 1;
        int aCount = 1;

        int[] countArr = { bCount, cCount, aCount };
        String[] res = new String[outputLen];
        printAll(countArr, 0, outputLen, res);
    }

    static void printAll(int[] countArr, int counter, int outputLen, String[] res) {
        if (counter >= outputLen) {
            System.out.println(Arrays.toString(res));
            return;
        }

        // choices

        if (countArr[0] > 0) {
            res[counter] = "B";
            counter++;
            countArr[0]--;
            printAll(countArr, counter, outputLen, res);
            countArr[0]++;
            counter--;
            res[counter] = "";
        }

        if (countArr[1] > 0) {
            res[counter] = "C";
            counter++;
            countArr[1]--;
            printAll(countArr, counter, outputLen, res);
            countArr[1]++;
            counter--;
            res[counter] = "";
        }

        if (countArr[2] > 0) {
            res[counter] = "A";
            counter++;
            countArr[2]--;
            printAll(countArr, counter, outputLen, res);
            countArr[2]++;
            counter--;
            res[counter] = "";
        }

        return;
    }
}