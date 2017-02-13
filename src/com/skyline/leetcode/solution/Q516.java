package com.skyline.leetcode.solution;

/**
 * Longest Palindromic Subsequence
 * https://leetcode.com/problems/longest-palindromic-subsequence/
 * Created by chenliang on 2017/2/10.
 */
public class Q516 {

    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        int[][] cache = new int[s.length()][s.length()];
        return this.longestPalindromeSubseq(s, 0, s.length() - 1, cache);
    }

    public int longestPalindromeSubseq(String s, int low, int high, int[][] cache) {
        if (low > high) {
            return 0;
        } else if (low == high) {
            return 1;
        } else if (cache[low][high] > 0) {
            return cache[low][high];
        }
        char lc = s.charAt(low);
        char hc = s.charAt(high);
        if (lc == hc) {
            return cache[low][high] = 2 + longestPalindromeSubseq(s, low + 1, high - 1, cache);
        } else {
            return cache[low][high] = Integer.max(
                    longestPalindromeSubseq(s, low, high - 1, cache),
                    longestPalindromeSubseq(s, low + 1, high, cache)
            );
        }
    }
}
