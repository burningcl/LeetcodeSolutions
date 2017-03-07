package com.skyline.leetcode.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * Word Pattern II
 * https://leetcode.com/problems/word-pattern-ii/?tab=Description
 * Created by chenliang on 2017/3/2.
 */
public class Q291 {

    public boolean wordPatternMatch(String pattern, String str) {
        if (pattern == null || pattern.length() <= 0) {
            return str == null || str.length() <= 0;
        }
        if (pattern.length() > str.length()) {
            return false;
        }
        int[][] bijections = new int[128][2];
        for (int i = 0; i < 128; i++) {
            bijections[i][0] = -1;
            bijections[i][1] = -1;
        }
        Set<String> set = new HashSet<>();
        return this.wordPatternMatch(pattern, str, 0, 0, bijections, set);
    }

    public boolean wordPatternMatch(String pattern, String str, int patternIdx, int strIndex, int[][] bijections, Set<String> set) {
        if (patternIdx >= pattern.length() || strIndex >= str.length()) {
            if (patternIdx == pattern.length() && strIndex == str.length()) {
                return true;
            } else {
                return false;
            }
        }

        char cPattern = pattern.charAt(patternIdx);
        int[] bijection = bijections[cPattern];
        if (bijection[0] != -1) {
            int len = bijection[1] - bijection[0] + 1;
            if (strIndex + len > str.length()) {
                return false;
            }
            for (int i = 0; i < len; i++) {
                if (str.charAt(bijection[0] + i) != str.charAt(strIndex + i)) {
                    return false;
                }
            }
            patternIdx++;
            strIndex += len;
            return this.wordPatternMatch(pattern, str, patternIdx, strIndex, bijections, set);
        }

        bijection[0] = strIndex;
        for (int i = strIndex; i < str.length(); i++) {
            String key = str.substring(strIndex, i + 1);
            if (set.contains(key)) {
                continue;
            }
            System.out.println(cPattern+"\t"+key);
            set.add(key);
            bijection[1] = i;
            if (wordPatternMatch(pattern, str, patternIdx + 1, i + 1, bijections, set)) {
                return true;
            }
            set.remove(key);
        }
        return false;
    }

}
