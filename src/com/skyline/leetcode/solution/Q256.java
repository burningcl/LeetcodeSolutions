package com.skyline.leetcode.solution;

/**
 * Paint House
 * https://leetcode.com/problems/paint-house/?tab=Description
 * Created by chenliang on 2017/2/26.
 */
public class Q256 {

    public int minCost(int[][] costs) {
        if (costs == null || costs.length <= 0) {
            return 0;
        }
        for (int i = 1; i < costs.length; i++) {
            int i1 = i - 1;
            costs[i][0] = costs[i][0] + Integer.min(costs[i1][1], costs[i1][2]);
            costs[i][1] = costs[i][1] + Integer.min(costs[i1][0], costs[i1][2]);
            costs[i][2] = costs[i][2] + Integer.min(costs[i1][0], costs[i1][1]);
        }
        int end = costs.length - 1;
        return Integer.min(costs[end][0], Integer.min(costs[end][1], costs[end][2]));
    }

}
