package com.skyline.leetcode.solution;

/**
 * Valid Word Abbreviation
 * https://leetcode.com/problems/valid-word-abbreviation/?tab=Description
 * Created by chenliang on 2017/3/1.
 */
public class Q408 {

    public boolean validWordAbbreviation(String word, String abbr) {
        if (word == null || word.length() <= 0) {
            return abbr == null || abbr.length() <= 0;
        }
        int i = 0;
        int j = 0;
        int cnt = 0;
        while (i < word.length() && j < abbr.length()) {
            char cAbbr = abbr.charAt(j);
            if (cAbbr >= '0' && cAbbr <= '9') {
                if (cAbbr == '0' && cnt == 0) {
                    return false;
                }
                cnt = cnt * 10 + cAbbr - '0';
                j++;
            } else {
                if (cnt > 0) {
                    i += cnt;
                    cnt = 0;
                } else {
                    if (word.charAt(i) != cAbbr) {
                        return false;
                    }
                    i++;
                    j++;
                }
            }
        }
        return i + cnt == word.length() && j == abbr.length();
    }

}
