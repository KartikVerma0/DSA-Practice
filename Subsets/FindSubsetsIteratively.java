package Subsets;

import java.util.Arrays;
import java.lang.Math;

public class FindSubsetsIteratively {
    public static void main(String[] args) {
        int[] inputArray = { 1, 2, 3 };
        findSubsets(inputArray);
    }

    static void findSubsets(int[] numS) {
        int[][] resArray = new int[(int) Math.pow(2, numS.length)][];

        for (int j = 0; j < resArray.length; j++) {
            if (resArray[j] == null) {
                resArray[j] = new int[] {};
            }
        }

        int counter = 0;
        for (int i = 0; i < numS.length; i++) {
            int[][] tempArray = Arrays.copyOf(resArray, counter + 1);
            int counterCopy = counter;
            for (int j = 0; j <= counterCopy; j++) {
                int[] tempAnswer = Arrays.copyOf(tempArray[j], tempArray[j].length + 1);
                tempAnswer[tempArray[j].length] = numS[i];
                resArray[counter++] = tempAnswer;
            }
        }

        for (int i = 0; i < resArray.length; i++) {
            System.out.println(Arrays.toString(resArray[i]));
        }

    }
}
