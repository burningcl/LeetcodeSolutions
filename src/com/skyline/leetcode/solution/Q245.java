package com.skyline.leetcode.solution;

/**
 * Shortest Word Distance III
 * https://leetcode.com/problems/shortest-word-distance-iii/?tab=Description
 * Created by chenliang on 2017/2/25.
 */
public class Q245 {

    public int shortestWordDistance(String[] words, String word1, String word2) {
        if (words == null | words.length <= 1) {
            return -1;
        }
        int index1 = -1;
        int index2 = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.equals(word1)) {
                if (word.equals(word2)) {
                    index1 = index2;
                } else {
                    index1 = i;
                }
            }
            if (word.equals(word2)) {
                index2 = i;
            }
            if (index1 >= 0 && index2 >= 0) {
                int len = Math.abs(index2 - index1);
                if (len < min) {
                    min = len;
                }
            }
        }
        return min;
    }

}
