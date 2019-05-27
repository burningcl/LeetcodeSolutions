package com.skyline.leetcode.solution;

/**
 * @author huasong.cl
 */
public class Q1035 {

    public int maxUncrossedLines(int[] A, int[] B) {
        int[][] dp = new int[A.length][B.length];
        dp[0][0] = A[0] == B[0] ? 1 : 0;
        int max = dp[0][0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] == B[0]) {
                dp[i][0] = 1;
                max = 1;
            } else {
                dp[i][0] = dp[i - 1][0];
            }
        }
        for (int j = 1; j < B.length; j++) {
            if (A[0] == B[j]) {
                dp[0][j] = 1;
                max = 1;
            } else {
                dp[0][j] = dp[0][j - 1];
            }
        }

        for (int i = 1; i < A.length; i++) {
            int a = A[i];
            for (int j = 1; j < B.length; j++) {
                dp[i][j] = Integer.max(
                        dp[i][j - 1],
                        dp[i - 1][j]
                );
                if (a == B[j]) {
                    dp[i][j] = Integer.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
                max = Integer.max(max, dp[i][j]);
            }
        }
        return max;
    }

}
