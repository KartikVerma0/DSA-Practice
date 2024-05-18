package Subsets;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;

/*
 * Given N items, each with its weight and profit, and a bag with a capacity W,
 * the task is to select items to maximize the total profit such that the sum 
 * of weights of selected items is less than or equal to the bag's capacity.
 */

public class MaximizeTheProfit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfItems = sc.nextInt();
        float[][] weightAndProfitArray = new float[numberOfItems][3];
        for (int i = 0; i < numberOfItems; i++) {
            float weight = (float) sc.nextInt();
            float profit = (float) sc.nextInt();
            float profitToWeightRatio = profit / weight;
            weightAndProfitArray[i][0] = weight;
            weightAndProfitArray[i][1] = profit;
            weightAndProfitArray[i][2] = profitToWeightRatio;
        }
        float capacity = (float) sc.nextInt();

        float[][] sortedArrays = getSortedWeightAndProfitArray(weightAndProfitArray);
        float[] weightArr = sortedArrays[0];
        float[] profitArr = sortedArrays[1];

        maximumProfit(0, capacity, 0, new float[] {}, weightArr, new float[] {}, profitArr);
        System.out.println(maxProfit);
        sc.close();
    }

    static int maxProfit = Integer.MIN_VALUE;

    static void maximumProfit(
            float processedWeight, float unprocessedWeight,
            int currentProfit, float[] processedWeightArr,
            float[] unprocessedWeightArr, float[] processedProfitArr,
            float[] unprocessedProfitArr) {

        if (unprocessedWeight < 0) {
            return;
        }
        if (unprocessedWeightArr.length == 0 || unprocessedProfitArr.length == 0) {
            maxProfit = currentProfit > maxProfit ? currentProfit : maxProfit;
            return;
        }

        float[] newProcessedWeightArr = Arrays.copyOf(processedWeightArr, processedWeightArr.length + 1);
        newProcessedWeightArr[newProcessedWeightArr.length - 1] = unprocessedWeightArr[0];

        float[] newProcessedProfitArr = Arrays.copyOf(processedProfitArr, processedProfitArr.length + 1);
        newProcessedProfitArr[newProcessedProfitArr.length - 1] = unprocessedProfitArr[0];

        maximumProfit(processedWeight + unprocessedWeightArr[0], unprocessedWeight - unprocessedWeightArr[0],
                currentProfit + (int) unprocessedProfitArr[0], newProcessedWeightArr,
                Arrays.copyOfRange(unprocessedWeightArr, 1, unprocessedWeightArr.length),
                newProcessedProfitArr, Arrays.copyOfRange(unprocessedProfitArr, 1, unprocessedProfitArr.length));
        maximumProfit(processedWeight, unprocessedWeight, currentProfit, processedWeightArr,
                Arrays.copyOfRange(unprocessedWeightArr, 1, unprocessedWeightArr.length),
                processedProfitArr, Arrays.copyOfRange(unprocessedProfitArr, 1, unprocessedProfitArr.length));
    }

    static class WeightAndProfitComparator implements Comparator<float[]> {
        public int compare(float[] arg0, float[] arg1) {
            return Float.compare(arg1[2], arg0[2]); // Sorting in descending order
        }
    }

    static float[][] getSortedWeightAndProfitArray(float[][] weightAndProfitArray) {
        Arrays.sort(weightAndProfitArray, new WeightAndProfitComparator());

        float[] weightArr = new float[weightAndProfitArray.length];
        float[] profitArr = new float[weightAndProfitArray.length];
        for (int i = 0; i < weightAndProfitArray.length; i++) {
            weightArr[i] = weightAndProfitArray[i][0];
            profitArr[i] = weightAndProfitArray[i][1];
        }

        return new float[][] { weightArr, profitArr };
    }
}
