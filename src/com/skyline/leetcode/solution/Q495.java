package com.skyline.leetcode.solution;

/**
 * Teemo Attacking
 * https://leetcode.com/problems/teemo-attacking/
 * Created by chenliang on 2017/2/6.
 */
public class Q495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length <= 0 || duration <= 0) {
            return 0;
        }
        int sum = 0;
        int curEnd = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            int time = timeSeries[i];
            if (time >= curEnd) {
                sum += duration;
            } else {
                sum += time - curEnd + duration;
            }
            curEnd = time + duration;
        }
        return sum;
    }
}
