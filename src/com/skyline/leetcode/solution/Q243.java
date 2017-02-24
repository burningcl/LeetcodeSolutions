package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Shortest Word Distance
 * https://leetcode.com/problems/shortest-word-distance/?tab=Description
 * Created by chenliang on 2017/2/24.
 */
public class Q243 {

    public int shortestDistance(String[] words, String word1, String word2) {
        if (words == null || words.length <= 1 || word1 == null || word2 == null) {
            return -1;
        } else if (word1.equals(word2)) {
            return 0;
        }
        int index1 = -1;
        int index2 = -2;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.equals(word1)) {
                index1 = i;
                if (index2 >= 0 && index1 - index2 < min) {
                    min = index1 - index2;
                }
            } else if (word.equals(word2)) {
                index2 = i;
                if (index1 >= 0 && index2 - index1 < min) {
                    min = index2 - index1;
                }
            }
        }
        return min;
    }

}
