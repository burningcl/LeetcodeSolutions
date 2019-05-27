package com.skyline.leetcode.solution;

import java.util.Arrays;

/**
 * Two City Scheduling
 *
 * @author huasong.cl
 */
public class Q1029 {

    public int twoCitySchedCost(int[][] costs) {
        int sum = 0;
        int aCount = 0;
        int bCount = 0;
        for (int i = 0; i < costs.length; i++) {
            int[] cost = costs[i];
            if (cost[0] <= cost[1]) {
                sum += cost[0];
                aCount++;
            } else {
                sum += cost[1];
                bCount++;
            }
        }
        if (aCount != bCount) {
            if (aCount > bCount) {
                for (int i = 0; i < costs.length; i++) {
                    int[] cost = costs[i];
                    cost[0] = cost[1] - cost[0];
                }
            } else {
                for (int i = 0; i < costs.length; i++) {
                    int[] cost = costs[i];
                    cost[0] = cost[0] - cost[1];
                }
            }
            Arrays.sort(costs, (cost0, cost1) -> {
                return cost0[0] - cost1[0];
            });
            int cnt = Math.abs(aCount - bCount);
            for (int i = 0; i < costs.length && cnt > 0; i++) {
                int[] cost = costs[i];
                if (cost[0] > 0 || (aCount > bCount && cost[0] == 0)) {
                    sum += cost[0];
                    cnt -= 2;
                }
            }
        }
        return sum;
    }

}
