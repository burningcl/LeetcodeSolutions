package com.skyline.leetcode.solution;

import java.util.Arrays;

/**
 * Predict the Winner
 * https://leetcode.com/problems/predict-the-winner/
 * Created by chenliang on 2017/1/24.
 */
public class Q486 {

    public boolean PredictTheWinner(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }

        int[][] map = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(map[i], -1);
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            map[i][i] = nums[i];
        }
        int max = this.PredictTheWinner(nums, map, 0, nums.length - 1);
        return max >= sum - max;
    }

    public int PredictTheWinner(int[] nums, int[][] map, int start, int end) {
        if (map[start][end] >= 0) {
            return map[start][end];
        } else if (start > end) {
            return 0;
        }
        int size = end - start + 1;
        if (size % 2 == nums.length % 2) {
            map[start][end] = Integer.max(this.PredictTheWinner(nums, map, start, end - 1) + nums[end], this.PredictTheWinner(nums, map, start + 1, end) + nums[start]);
        } else {
            map[start][end] = Integer.min(this.PredictTheWinner(nums, map, start, end - 1), this.PredictTheWinner(nums, map, start + 1, end));
        }
        return map[start][end];
    }

}
