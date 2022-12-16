package com.dsa.array.usecase.pointer;

public class ShortestWordsDistance {
    private static int shortestDistance(String[] wordsDict, String word1, String word2) {
        int i1 = -1, i2 = -1;
        int minDistance = Integer.MAX_VALUE;

        for (int i=0; i<wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) i1 = i;
            if (wordsDict[i].equals(word2)) i2 = i;

            if (i1 != -1 && i2 != -1) {
                // Found
                minDistance = Math.min(minDistance, Math.abs(i2-i1));
            }
        }
        return minDistance;
    }

    public static void main(String[] args) {
        String[] input = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "makes", word2 = "coding";

        int sol = shortestDistance(input, word1, word2);
        System.out.println("Ans: "+sol);
    }
}
