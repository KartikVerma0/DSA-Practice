package Subsets;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/*
 * 1255. Maximum Score Words Formed by Letters
 * [https://leetcode.com/problems/maximum-score-words-formed-by-letters]
 */
public class MaximumScoreWordsFormedByLetters {
    public static void main(String[] args) {
        String[] words = { "xxxz", "ax", "bx", "cx" };
        char[] letters = { 'z', 'a', 'b', 'c', 'x', 'x', 'x' };
        int[] score = { 4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 10 };
        System.out.println(maxScoreWords(words, letters, score));
    }

    static int maxScore = 0;

    static int maxScoreWords(String[] words, char[] letters, int[] score) {
        maxScore = 0;
        HashMap<Character, Integer> frequencies = letterFreq(letters);
        words = eliminateInvalidWords(words, frequencies);
        subsets(new LinkedList<>(), words, score, frequencies);
        return maxScore;
    }

    static HashMap<Character, Integer> letterFreq(char[] letters) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (char character : letters) {
            if (freqMap.containsKey(character)) {
                int characterFrequency = freqMap.get(character);
                freqMap.put(character, characterFrequency + 1);
            } else {
                freqMap.put(character, 1);
            }
        }

        return freqMap;
    }

    static String[] eliminateInvalidWords(String[] words, HashMap<Character, Integer> lettersMapping) {
        LinkedList<String> validWords = new LinkedList<>();

        for (String word : words) {
            boolean isValidWord = true;
            for (int index = 0; index < word.length(); index++) {
                char currentCharacter = word.charAt(index);
                if (!lettersMapping.containsKey(currentCharacter)) {
                    isValidWord = false;
                }
            }

            if (isValidWord) {
                validWords.add(word);
            }
        }

        return validWords.toArray(new String[] {});
    }

    static void subsets(LinkedList<String> processed, String[] unProcessed, int[] scores,
            HashMap<Character, Integer> frequencies) {
        if (unProcessed.length == 0) {
            int currentScore = calculateScoreOfSubset(processed, scores, frequencies);
            if (currentScore > maxScore) {
                maxScore = currentScore;
            }

            return;
        }

        LinkedList<String> newProcessed = new LinkedList<>(processed);
        newProcessed.add(unProcessed[0]);

        String[] newUnprocessed = Arrays.copyOfRange(unProcessed, 1, unProcessed.length);

        subsets(newProcessed, newUnprocessed, scores, frequencies);
        subsets(processed, newUnprocessed, scores, frequencies);
    }

    static int calculateScoreOfSubset(LinkedList<String> subset, int[] scores,
            HashMap<Character, Integer> frequencies) {
        if (subset.isEmpty()) {
            return 0;
        }

        int score = 0;
        HashMap<Character, Integer> frequenciesCopy = new HashMap<>(frequencies);
        for (String word : subset) {
            for (int i = 0; i < word.length(); i++) {
                char currentCharacter = word.charAt(i);
                int characterFrequency = frequenciesCopy.get(currentCharacter);
                if (characterFrequency == 0) {
                    return 0;
                } else if (characterFrequency > 0) {
                    score += scores[(int) currentCharacter - 97];
                    frequenciesCopy.put(word.charAt(i), characterFrequency - 1);
                }
            }
        }

        return score;
    }

}
