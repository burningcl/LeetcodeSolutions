package com.skyline.leetcode.solution.contest21;

import java.util.List;

/**
 * Longest Word in Dictionary through Deleting
 * https://leetcode.com/contest/leetcode-weekly-contest-21/problems/longest-word-in-dictionary-through-deleting/
 * Created by chenliang on 2017/2/26.
 */
public class Q524 {

    public String findLongestWord(String s, List<String> d) {
        if (d == null || d.size() <= 0) {
            return "";
        }
        String ret = "";
        for (int i = 0; i < d.size(); i++) {
            String target = d.get(i);
            if (target.length() < ret.length()) {
                continue;
            }
            if (this.canTransform(s, target)) {
                ret = this.min(target, ret);
            }
        }
        return ret;
    }

    public String min(String str1, String str2) {
        if (str1 == null) {
            return str2;
        } else if (str2 == null) {
            return str1;
        } else if (str1.length() > str2.length()) {
            return str1;
        } else if (str2.length() > str1.length()) {
            return str2;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) > str2.charAt(i)) {
                return str2;
            } else if (str1.charAt(i) < str2.charAt(i)) {
                return str1;
            }
        }
        return str1;
    }

    public boolean canTransform(String test, String target) {
        if (test.length() < target.length()) {
            return false;
        } else if (test.length() == target.length()) {
            return test.equals(target);
        }
        int i = 0;
        int j = 0;
        for (; i < test.length() && j < target.length(); ) {
            if (test.charAt(i) == target.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == target.length();
    }

}
