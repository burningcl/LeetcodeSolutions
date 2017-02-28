package com.skyline.leetcode.solution;

/**
 * Find Permutation
 * https://leetcode.com/problems/find-permutation/?tab=Description
 * Created by chenliang on 2017/2/28.
 */
public class Q484 {
    public int[] findPermutation(String s) {
        if (s == null || s.length() <= 0) {
            int[] ret = {1};
            return ret;
        }
        int[] ret = new int[s.length()];
        int curNum = 1;
        int start = 0;
        for (int i = 0; i <= s.length(); i++) {
            if (i == s.length() || s.charAt(i) == 'I') {
                for (int j = i; j >= start; j--) {
                    ret[j] = curNum++;
                }
                start = i;
            } else {
                if (i > 0 && s.charAt(i - 1) == 'I') {
                    curNum--;
                    start--;
                }
            }
        }
        return ret;
    }
}
