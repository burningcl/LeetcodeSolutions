package com.skyline.leetcode.solution;

/**
 * @author huasong.cl
 */
public class Q1049 {

    public int lastStoneWeightII(int[] stones) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < stones.length; i++) {
            max = Integer.max(max, stones[i]);
        }
        boolean[][][] dp = new boolean[stones.length][stones.length][max + 1];
        for (int i = 0; i < stones.length; i++) {
            dp[i][i][stones[i]] = true;
        }
        for (int len = 2; len <= stones.length; len++) {
            for (int i1 = 0; i1 <= stones.length - len; i1++) {
                int j2 = i1 + len - 1;
                boolean[] dpItem = dp[i1][j2];
                for (int j1 = i1; j1 < j2; j1++) {
                    int i2 = j1 + 1;
                    boolean[] dpItem1 = dp[i1][j1];
                    boolean[] dpItem2 = dp[i2][j2];
                    for (int i = 0; i <= max; i++) {
                        if (dpItem1[i]) {
                            for (int j = 0; j <= max; j++) {
                                if (dpItem2[j]) {
                                    dpItem[Math.abs(i - j)] = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        boolean[] dpItem = dp[0][stones.length - 1];
        for (int i = 0; i <= max; i++) {
            if (dpItem[i]) {
                return i;
            }
        }
        return -1;
    }

}
