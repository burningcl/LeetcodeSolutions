package com.skyline.leetcode.solution;

/**
 * One Edit Distance
 * https://leetcode.com/problems/one-edit-distance/?tab=Description
 * Created by chenliang on 2017/2/24.
 */
public class Q161 {

    public boolean isOneEditDistance(String s, String t) {
        if (s == null || s.length() <= 0) {
            return t.length() == 1;
        } else if (t == null || t.length() <= 0) {
            return s.length() == 1;
        } else if (s.equals(t)) {
            return false;
        }
        if (s.length() == t.length()) {
            return this.isChangeOneChar(s, t);
        } else if (s.length() + 1 == t.length()) {
            return this.isAddOneChar(s, t);
        } else if (s.length() == t.length() + 1) {
            return this.isAddOneChar(t, s);
        } else {
            return false;
        }
    }

    private boolean isChangeOneChar(String s, String t) {
        boolean changed = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (!changed) {
                    changed = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isAddOneChar(String s, String t) {
        int i = 0;
        for (; i < s.length() && s.charAt(i) == t.charAt(i); i++) {
        }
        for (; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

}
