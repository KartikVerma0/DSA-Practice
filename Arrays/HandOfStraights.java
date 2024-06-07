package Arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * 846. Hand of Straights
 * [https://leetcode.com/problems/hand-of-straights/description]
 */

public class HandOfStraights {
    public static void main(String[] args) {
        System.out.println(isNStraightHand(new int[] { 1, 2, 2, 3, 3, 3, 4, 4, 5 }, 4));
    }

    static boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
        boolean[] hasVisited = new boolean[hand.length];

        int startPosition = 0;
        int indexCounter = 0;
        List<Integer> cardGroup = new LinkedList<>();
        int cardGroupCounter = 0;

        while (indexCounter < hand.length) {
            if (cardGroupCounter == groupSize) {
                cardGroupCounter = 0;
                indexCounter = startPosition;
                cardGroup.removeAll(cardGroup);

            }
            if (!hasVisited[indexCounter] && !cardGroup.contains(hand[indexCounter])) {
                if (cardGroupCounter > 0 && Math.abs(cardGroup.get(cardGroupCounter - 1) - hand[indexCounter]) > 1) {
                    break;
                }
                cardGroup.add(cardGroupCounter, hand[indexCounter]);
                hasVisited[indexCounter] = true;
                cardGroupCounter++;
            } else {
                if (!hasVisited[indexCounter] && hasVisited[startPosition]) {
                    startPosition = indexCounter;
                }
            }
            indexCounter++;
            ;
        }

        if ((cardGroupCounter % groupSize) != 0 || !hasVisited[startPosition]) {
            return false;
        }
        return true;
    }
}
