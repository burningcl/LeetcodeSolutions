package com.skyline.leetcode.solution;

/**
 * @author huasong.cl
 */
public class Q1024 {

    public int videoStitching(int[][] clips, int T) {
        int[] dp = new int[101];
        for (int[] clip : clips) {
            int start = clip[0];
            int end = clip[1];
            dp[start] = Integer.max(dp[start], end);
        }
        int start = 0;
        int end = dp[0];
        int total = 1;
        while (end < T) {
            int max = Integer.MIN_VALUE;
            for (int i = start + 1; i <= end; i++) {
                max = Integer.max(max, dp[i]);
            }
            if (end >= max) {
                return -1;
            }
            start = end;
            end = max;
            total++;
        }
        return total;
    }


}
