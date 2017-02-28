package com.skyline.leetcode.solution;

/**
 * Paint Fence
 * https://leetcode.com/problems/paint-fence/?tab=Description
 * Created by chenliang on 2017/2/24.
 */
public class Q276 {

    public int numWays(int n, int k) {
        if (n <= 0 || k <= 0) {
            return 0;
        }
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        dp1[0] = k; // must change
        dp2[0] = 0;
        int k1 = k - 1;
        for (int i = 1; i < n; i++) {
            dp1[i] = (dp1[i - 1] + dp2[i - 1]) * k1;
            dp2[i] = dp1[i - 1];
        }
        return dp1[n - 1] + dp2[n - 1];
    }
}
