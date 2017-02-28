package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Generalized Abbreviation
 * https://leetcode.com/problems/generalized-abbreviation/?tab=Description
 * Created by chenliang on 2017/2/28.
 */
public class Q320 {
    public List<String> generateAbbreviations(String word) {
        List<String> list = new ArrayList<>();
        if (word == null || word.length() <= 0) {
            list.add("");
            return list;
        }
        this.generateAbbreviations(word.toCharArray(), new boolean[word.length()], list, 0);
        return list;
    }

    public void generateAbbreviations(char[] word, boolean[] bits, List<String> list, int index) {
        if (index >= word.length) {
            StringBuilder builder = new StringBuilder();
            int cnt = 0;
            for (int i = 0; i < word.length; i++) {
                if (!bits[i]) {
                    if (cnt > 0) {
                        builder.append(cnt);
                    }
                    builder.append(word[i]);
                    cnt = 0;
                } else {
                    cnt++;
                }
            }
            if (cnt > 0) {
                builder.append(cnt);
            }
            list.add(builder.toString());
            return;
        }
        bits[index] = false;
        this.generateAbbreviations(word, bits, list, index + 1);
        bits[index] = true;
        this.generateAbbreviations(word, bits, list, index + 1);
    }


}
