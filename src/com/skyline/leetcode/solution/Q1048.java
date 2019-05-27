package com.skyline.leetcode.solution;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author huasong.cl
 */
public class Q1048 {

    public int longestStrChain(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        int max = 0;
        int[] dp = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int curMax = 0;
            String curWord = words[i];
            for (int j = i - 1; j >= 0; j--) {
                String preWord = words[j];
                if (preWord.length() == curWord.length() - 1) {
                    if (isPredecessor(curWord, preWord)) {
                        curMax = Integer.max(curMax, dp[j]);
                    }
                } else if (preWord.length() < curWord.length() - 1) {
                    break;
                }
            }
            max = Integer.max(max, dp[i] = ++curMax);
        }
        return max;
    }

    private boolean isPredecessor(String a, String b) {
        //a>b
        boolean add = false;
        for (int i = 0, j = 0; i < a.length() && j < b.length(); ) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            } else {
                if (add) {
                    return false;
                } else {
                    add = true;
                    i++;
                }
            }
        }
        return true;
    }

}
