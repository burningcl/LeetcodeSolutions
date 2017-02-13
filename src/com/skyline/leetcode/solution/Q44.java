package com.skyline.leetcode.solution;

/**
 * Wildcard Matching
 * https://leetcode.com/problems/wildcard-matching/?tab=Description
 * Created by chenliang on 2017/2/10.
 */
public class Q44 {
    public boolean isMatch(String s, String p) {
        Boolean[][] cache = new Boolean[s.length()][p.length()];
        return isMatch(s, p, 0, 0, cache);
    }

    public boolean isMatch(String s, String p, int si, int pi, Boolean[][] cache) {
        if (si >= s.length()) {
            for (; pi < p.length(); pi++) {
                if (p.charAt(pi) != '*') {
                    return false;
                }
            }
            return true;
        } else if (pi >= p.length()) {
            return false;
        }
        if (cache[si][pi] != null) {
            return cache[si][pi];
        }
        char sc = s.charAt(si);
        char pc = p.charAt(pi);
        boolean r = false;
        if (pc == '?') {
            r = isMatch(s, p, si + 1, pi + 1, cache);
        } else if (pc == '*') {
            r = isMatch(s, p, si + 1, pi + 1, cache) || isMatch(s, p, si + 1, pi, cache) || isMatch(s, p, si, pi + 1, cache);
        } else {
            if (pc == sc) {
                r = isMatch(s, p, si + 1, pi + 1, cache);
            } else {
                r = false;
            }
        }
        return cache[si][pi] = r;
    }
}
