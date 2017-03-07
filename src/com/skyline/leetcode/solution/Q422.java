package com.skyline.leetcode.solution;

import java.util.List;

/**
 * Valid Word Square
 * https://leetcode.com/problems/valid-word-square/?tab=Description
 * Created by chenliang on 2017/2/28.
 */
public class Q422 {

    public boolean validWordSquare(List<String> words) {
        if (words == null || words.size() <= 0) {
            return true;
        }
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            for (int j = 0; j < word.length(); j++) {
                if (j >= words.size()) {
                    return false;
                }
                String word2 = words.get(j);
                if (i >= word2.length()) {
                    return false;
                }
                if (word.charAt(j) != word2.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
