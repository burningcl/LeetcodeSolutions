package com.skyline.leetcode.solution;

/**
 * Paint House II
 * https://leetcode.com/problems/paint-house-ii/?tab=Description
 * Created by chenliang on 2017/2/26.
 */
public class Q265 {

    public int minCostII(int[][] costs) {
        if (costs == null || costs.length <= 0) {
            return -1;
        }
        int n = costs.length;
        int k = costs[0].length;
        if (k <= 1) {
            return -1;
        }
        for (int i = 1; i < n; i++) {
            int minIndex1 = 0;
            int minIndex2 = 1;
            int i1 = i - 1;
            for (int j = 2; j < k; j++) {
                if (costs[i1][j] < costs[i1][minIndex1] || costs[i1][j] < costs[i1][minIndex2]) {
                    minIndex1 = costs[i1][minIndex1] < costs[i1][minIndex2] ? minIndex1 : minIndex2;
                    minIndex2 = j;
                }
            }
            if (costs[i1][minIndex1] > costs[i1][minIndex2]) {
                int t = minIndex1;
                minIndex1 = minIndex2;
                minIndex2 = t;
            }
            for (int j = 0; j < k; j++) {
                if (j == minIndex1) {
                    costs[i][j] = costs[i][j] + costs[i1][minIndex2];
                } else {
                    costs[i][j] = costs[i][j] + costs[i1][minIndex1];
                }
            }
        }
        int end = n - 1;
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < k; j++) {
            if (costs[end][j] < min) {
                min = costs[end][j];
            }
        }
        return min;
    }

}
