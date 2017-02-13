package com.skyline.leetcode.solution;

/**
 * Target Sum
 * https://leetcode.com/problems/target-sum/
 * Created by chenliang on 2017/1/23.
 */
public class Q494 {

    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int size = nums.length;
        long[] maxs = new long[size];
        maxs[size - 1] = nums[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            maxs[i] = maxs[i + 1] + nums[i];
        }
        return this.findTargetSumWays(nums, 0, S, maxs);
    }

    public int findTargetSumWays(int[] nums, int index, long target, long[] maxs) {
        if (index >= nums.length) {
            return target == 0 ? 1 : 0;
        } else if (target > maxs[index] || target < -maxs[index]) {
            return 0;
        }
        //int cur = nums[index];
        return this.findTargetSumWays(nums, index + 1, target - nums[index], maxs)
                + this.findTargetSumWays(nums, index + 1, target + nums[index], maxs);
    }
}
